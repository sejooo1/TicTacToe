package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Mec;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySql implementation of DAO.
 */
public class MecDAOSql extends AbstractDAO<Mec> implements MecDAO{

    private static MecDAOSql instance = null;
    private MecDAOSql() {
        super("mecevi");
    }

    /**
     * Get instance mec dao sql.
     *
     * @return the mec dao sql
     */
    public static MecDAOSql getInstance(){
        if(instance==null)
            instance = new MecDAOSql();
        return instance;
    }

    /**
     * Remove instance.
     */
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }
    @Override
    public Mec getById(int id) throws MojException {
        return executeQueryUnique("SELECT * FROM mecevi WHERE idMeca = ?", new Object[]{id});
    }

    @Override
    public Mec dajIzResultSeta(ResultSet rs) throws MojException {
        try {
        Mec q = new Mec();
        q.setId(rs.getInt("idMeca"));
        q.setIdX(rs.getInt("idX"));
        q.setIdO(rs.getInt("idO"));
        q.setIdTipa(rs.getInt("idTipa"));
        return q;
        } catch (Exception e) {
            throw new MojException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> dajUTabelu(Mec object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("idMeca", object.getId());
        item.put("idX", object.getIdX());
        item.put("idO", object.getIdO());
        item.put("idTipa", object.getIdTipa());
        return item;
    }

    @Override
    public List<Mec> dajPobjedeIgraca(int id) throws MojException {
        return executeQuery("SELECT * FROM mecevi WHERE (idTipa = 1 AND idX = ?) OR (idTipa = 2 AND idO = ?)", new Object[]{id, id});
    }
}
