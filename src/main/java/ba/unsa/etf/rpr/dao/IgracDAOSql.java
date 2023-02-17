package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IgracDAOSql extends AbstractDAO<Igrac> implements IgracDAO{
    private static IgracDAOSql instance = null;
    private IgracDAOSql() {
        super("igraci");
    }

    public static IgracDAOSql getInstance(){
        if(instance==null)
            instance = new IgracDAOSql();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }
    @Override
    public Igrac dajIzResultSeta(ResultSet rs) throws MojException {
        try {
            Igrac q = new Igrac();
            q.setId(rs.getInt("id"));
            q.setIme(rs.getString("ime"));
            q.setBrojPobjeda(rs.getInt("brojPobjeda"));
            q.setBrojPoraza(rs.getInt("brojPoraza"));
            q.setBrojNerijesenih(rs.getInt("brojNerijesenih"));
            q.setKojiJeIgrac(rs.getString("kojiJeIgrac"));
            return q;
        } catch (Exception e) {
            throw new MojException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> dajUTabelu(Igrac object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("ime", object.getIme());
        item.put("brojPobjeda", object.getBrojPobjeda());
        item.put("brojPoraza", object.getBrojPoraza());
        item.put("brojNerijesenih", object.getBrojNerijesenih());
        item.put("kojiJeIgrac", object.getKojiJeIgrac());
        return item;
    }

    @Override
    public List<Igrac> dajPoImenu(String ime) throws MojException {
        return executeQuery("SELECT * FROM igraci WHERE ime LIKE concat('%', ?, '%')", new Object[]{ime});
    }
}
