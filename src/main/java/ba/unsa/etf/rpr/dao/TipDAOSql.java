package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Tip;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class TipDAOSql  extends AbstractDAO<Tip> implements TipDAO{
    private static  TipDAOSql instance = null;
    private TipDAOSql() {
        super("tipovi");
    }

    public static TipDAOSql getInstance(){
        if(instance==null)
            instance = new TipDAOSql();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Tip dajIzResultSeta(ResultSet rs) throws MojException {
        try {
            Tip t = new Tip();
            t.setId(rs.getInt("id"));
            t.setOpis(rs.getString("opis"));
            return t;
        } catch (SQLException e) {
            throw new MojException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> dajUTabelu(Tip object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("opis", object.getOpis());
        return row;
    }
}
