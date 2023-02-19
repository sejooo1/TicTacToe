package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;


/**
 * DAO interface for Igrac JavaBean class.
 */
public interface IgracDAO extends DAO<Igrac>{

    /**
     * Daj po imenu list.
     *
     * @param ime the ime
     * @return the list
     * @throws MojException the moj exception
     */
    List<Igrac> dajPoImenu(String ime) throws MojException;
}
