package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.MojException;

import java.util.List;

/**
 * The interface Dao.
 *
 * @param <T> the type parameter
 */
public interface DAO<T>{
    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     * @throws MojException the moj exception
     */
    T getById(int id) throws MojException;

    /**
     * Add t.
     *
     * @param item the item
     * @return the t
     * @throws MojException the moj exception
     */
    T add(T item) throws MojException;

    /**
     * Update t.
     *
     * @param item the item
     * @return the t
     * @throws MojException the moj exception
     */
    T update(T item) throws MojException;

    /**
     * Delete.
     *
     * @param id the id
     * @throws MojException the moj exception
     */
    void delete(int id) throws MojException;

    /**
     * Gets all.
     *
     * @return the all
     * @throws MojException the moj exception
     */
    List<T> getAll() throws MojException;
}
