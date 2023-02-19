package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Mec;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;

/**
 * DAO interface for Mec JavaBean class.
 */
public interface MecDAO extends DAO<Mec>{

    /**
     * Daj pobjede igraca list.
     *
     * @param id the id
     * @return the list
     * @throws MojException the moj exception
     */
    List<Mec> dajPobjedeIgraca(int id) throws MojException;
}
