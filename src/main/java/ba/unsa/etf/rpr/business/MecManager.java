package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.FactoryDAO;

import ba.unsa.etf.rpr.domain.Mec;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;

public class MecManager {
    public List<Mec> getAll() throws MojException {
        return FactoryDAO.mecDAO().getAll();
    }

    public void delete(int id) throws MojException{
        FactoryDAO.mecDAO().delete(id);
    }

    public Mec getById(int id) throws MojException{
        return FactoryDAO.mecDAO().getById(id);
    }

    public void update(Mec m) throws MojException{
        FactoryDAO.mecDAO().update(m);
    }

    public Mec add(Mec m) throws MojException{
        return FactoryDAO.mecDAO().add(m);
    }
    public List<Mec> dajPobjedeIgraca(int id) throws MojException {
        return FactoryDAO.mecDAO().dajPobjedeIgraca(id);
    }
}
