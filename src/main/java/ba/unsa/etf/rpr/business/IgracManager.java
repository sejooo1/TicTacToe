package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.FactoryDAO;
import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;

public class IgracManager {
    public List<Igrac> getAll() throws MojException {
        return FactoryDAO.igracDAO().getAll();
    }

    public List<Igrac> searchQuotes(String ime) throws MojException {
        return FactoryDAO.igracDAO().dajPoImenu(ime);
    }

    public void delete(int id) throws MojException{
        FactoryDAO.igracDAO().delete(id);
    }

    public Igrac getById(int id) throws MojException{
        return FactoryDAO.igracDAO().getById(id);
    }

    public void update(Igrac i) throws MojException{
        FactoryDAO.igracDAO().update(i);
    }

    public Igrac add(Igrac i) throws MojException{
        return FactoryDAO.igracDAO().add(i);
    }

}
