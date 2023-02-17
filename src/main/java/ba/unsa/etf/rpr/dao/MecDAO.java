package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Mec;
import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;

public interface MecDAO extends DAO<Mec>{

    List<Mec> dajPobjedeIgraca(int id) throws MojException;
}
