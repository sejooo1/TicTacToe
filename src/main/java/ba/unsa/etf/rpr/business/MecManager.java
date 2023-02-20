package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.FactoryDAO;

import ba.unsa.etf.rpr.domain.Mec;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;

/**
 * Business Logic Layer for management of Mec.
 */
public class MecManager {
    /**
     * Gets all.
     *
     * @return the all
     * @throws MojException the moj exception
     */
    public List<Mec> getAll() throws MojException {
        return FactoryDAO.mecDAO().getAll();
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws MojException the moj exception
     */
    public void delete(int id) throws MojException{
        FactoryDAO.mecDAO().delete(id);
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     * @throws MojException the moj exception
     */
    public Mec getById(int id) throws MojException{
        return FactoryDAO.mecDAO().getById(id);
    }

    /**
     * Update.
     *
     * @param m the m
     * @throws MojException the moj exception
     */
    public void update(Mec m) throws MojException{
        FactoryDAO.mecDAO().update(m);
    }

    /**
     * Add mec.
     *
     * @param m the m
     * @return the mec
     * @throws MojException the moj exception
     */
    public Mec add(Mec m) throws MojException{
        return FactoryDAO.mecDAO().add(m);
    }

    /**
     * Daj pobjede igraca list.
     *
     * @param id the id
     * @return the list
     * @throws MojException the moj exception
     */
    public List<Mec> dajPobjedeIgraca(int id) throws MojException {
        return FactoryDAO.mecDAO().dajPobjedeIgraca(id);
    }
}
