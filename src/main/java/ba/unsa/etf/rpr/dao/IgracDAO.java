package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.exceptions.MojException;


public interface IgracDAO extends DAO<Igrac>{

    Igrac dajPoImenu(String ime) throws MojException;
}
