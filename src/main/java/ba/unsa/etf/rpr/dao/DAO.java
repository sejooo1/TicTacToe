package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;

public interface DAO<T>{
    T getById(int id) throws MojException;

    T add(T item) throws MojException;

    T update(T item) throws MojException;

    void delete(int id) throws MojException;

    List<T> getAll() throws MojException;
}
