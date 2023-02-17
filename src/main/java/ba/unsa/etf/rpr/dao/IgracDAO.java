package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;

public interface IgracDAO extends DAO<Igrac>{

    List<Igrac> dajPoImenu(String ime) throws MojException;
}
