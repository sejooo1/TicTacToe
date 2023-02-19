package ba.unsa.etf.rpr.domain;

/**
 * The interface Idable used for forcing all classes to have id field.
 */
public interface Idable {

    /**
     * Sets id.
     *
     * @param id the id
     */
    void setId(int id);

    /**
     * Gets id.
     *
     * @return the id
     */
    int getId();
}
