package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.FactoryDAO;
import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;

/**
 * Business Logic Layer for management of Igrac.
 */
public class IgracManager {
    /**
     * Gets all.
     *
     * @return the all
     * @throws MojException the moj exception
     */
    public List<Igrac> getAll() throws MojException {
        return FactoryDAO.igracDAO().getAll();
    }

    /**
     * Daj po imenu list.
     *
     * @param ime the ime
     * @return the list
     * @throws MojException the moj exception
     */
    public List<Igrac> dajPoImenu(String ime) throws MojException {
        return FactoryDAO.igracDAO().dajPoImenu(ime);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws MojException the moj exception
     */
    public void delete(int id) throws MojException{
        FactoryDAO.igracDAO().delete(id);
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     * @throws MojException the moj exception
     */
    public Igrac getById(int id) throws MojException{
        return FactoryDAO.igracDAO().getById(id);
    }

    /**
     * Update.
     *
     * @param i the
     * @throws MojException the moj exception
     */
    public void update(Igrac i) throws MojException{
        FactoryDAO.igracDAO().update(i);
    }

    /**
     * Add igrac.
     *
     * @param i the
     * @return the igrac
     * @throws MojException the moj exception
     */
    public Igrac add(Igrac i) throws MojException{
        return FactoryDAO.igracDAO().add(i);
    }

}
