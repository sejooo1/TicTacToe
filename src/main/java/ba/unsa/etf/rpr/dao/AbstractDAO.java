package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.sql.*;
import java.util.*;

/**
 * Abstract class that implements core DAO CRUD methods for every entity.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractDAO <T extends Idable> implements DAO<T> {
    private static Connection connection = null;
    private String imeTabele;

    /**
     * Instantiates a new Abstract dao.
     *
     * @param imeTabele the ime tabele
     */
    public AbstractDAO(String imeTabele) {
        this.imeTabele = imeTabele;
        createConnection();
    }

    private static void createConnection(){
        if(AbstractDAO.connection==null) {
            try {
                Properties p = new Properties();
                p.load(ClassLoader.getSystemResource("application.properties").openStream());
                String url = p.getProperty("db.connection_string");
                String username = p.getProperty("db.username");
                String password = p.getProperty("db.password");
                AbstractDAO.connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                Runtime.getRuntime().addShutdownHook(new Thread(){
                    @Override
                    public void run(){
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /**
     * Get connection connection.
     *
     * @return the connection
     */
    public static Connection getConnection(){
        return AbstractDAO.connection;
    }

    /**
     * Daj iz result seta t.
     *
     * @param rs the rs
     * @return the t
     * @throws MojException the moj exception
     */
    public abstract T dajIzResultSeta(ResultSet rs) throws MojException;

    /**
     * Daj u tabelu map.
     *
     * @param object the object
     * @return the map
     */
    public abstract Map<String, Object> dajUTabelu(T object);

    public T getById(int id) throws MojException {
        return executeQueryUnique("SELECT * FROM "+this.imeTabele+" WHERE id = ?", new Object[]{id});
    }

    public List<T> getAll() throws MojException {
        return executeQuery("SELECT * FROM "+ imeTabele, null);
    }

    public void delete(int id) throws MojException {
        String sql = "DELETE FROM "+imeTabele+" WHERE id = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new MojException(e.getMessage(), e);
        }
    }

    public T add(T item) throws MojException{
        Map<String, Object> row = dajUTabelu(item);
        Map.Entry<String, String> columns = prepareInsertParts(row);

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ").append(imeTabele);
        builder.append(" (").append(columns.getKey()).append(") ");
        builder.append("VALUES (").append(columns.getValue()).append(")");

        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue;
                stmt.setObject(counter, entry.getValue());
                counter++;
            }
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            item.setId(rs.getInt(1));

            return item;
        }catch (SQLException e){
            throw new MojException(e.getMessage(), e);
        }
    }

    public T update(T item) throws MojException{
        Map<String, Object> row = dajUTabelu(item);
        String updateColumns = prepareUpdateParts(row);
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE ")
                .append(imeTabele)
                .append(" SET ")
                .append(updateColumns)
                .append(" WHERE id = ?");

        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString());
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue;
                stmt.setObject(counter, entry.getValue());
                counter++;
            }
            stmt.setObject(counter, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            throw new MojException(e.getMessage(), e);
        }
    }

    /**
     * Execute query list.
     *
     * @param query  the query
     * @param params the params
     * @return the list
     * @throws MojException the moj exception
     */
    public List<T> executeQuery(String query, Object[] params) throws MojException{
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            if (params != null){
                for(int i = 1; i <= params.length; i++){
                    stmt.setObject(i, params[i-1]);
                }
            }
            ResultSet rs = stmt.executeQuery();
            ArrayList<T> resultList = new ArrayList<>();
            while (rs.next()) {
                resultList.add(dajIzResultSeta(rs));
            }
            return resultList;
        } catch (SQLException e) {
            throw new MojException(e.getMessage(), e);
        }
    }

    /**
     * Execute query unique t.
     *
     * @param query  the query
     * @param params the params
     * @return the t
     * @throws MojException the moj exception
     */
    public T executeQueryUnique(String query, Object[] params) throws MojException{
        List<T> result = executeQuery(query, params);
        if (result != null && result.size() == 1){
            return result.get(0);
        }else{
            throw new MojException("Object not found");
        }
    }

    private Map.Entry<String, String> prepareInsertParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();
        StringBuilder questions = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue;
            columns.append(entry.getKey());
            questions.append("?");
            if (row.size() != counter) {
                columns.append(",");
                questions.append(",");
            }
        }
        return new AbstractMap.SimpleEntry<>(columns.toString(), questions.toString());
    }

    private String prepareUpdateParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue;
            columns.append(entry.getKey()).append("= ?");
            if (row.size() != counter) {
                columns.append(",");
            }
        }
        return columns.toString();
    }
}
