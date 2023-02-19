package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * JavaBean Class Mec.
 */
public class Mec implements Idable{
    private int idMeca;
    private int idX;
    private int idO;
    private int idTipa;

    /**
     * Instantiates a new Mec.
     *
     * @param idMeca the id meca
     * @param idX    the id x
     * @param idO    the id o
     * @param idTipa the id tipa
     */
    public Mec(int idMeca, int idX, int idO, int idTipa) {
        this.idMeca = idMeca;
        this.idX = idX;
        this.idO = idO;
        this.idTipa = idTipa;
    }

    /**
     * Instantiates a new Mec.
     */
    public Mec() {

    }

    public int getId() {
        return idMeca;
    }

    public void setId(int idMeca) {
        this.idMeca = idMeca;
    }

    /**
     * Gets id x.
     *
     * @return the id x
     */
    public int getIdX() {
        return idX;
    }

    /**
     * Sets id x.
     *
     * @param idX the id x
     */
    public void setIdX(int idX) {
        this.idX = idX;
    }

    /**
     * Gets id o.
     *
     * @return the id o
     */
    public int getIdO() {
        return idO;
    }

    /**
     * Sets id o.
     *
     * @param idO the id o
     */
    public void setIdO(int idO) {
        this.idO = idO;
    }

    /**
     * Gets id tipa.
     *
     * @return the id tipa
     */
    public int getIdTipa() {
        return idTipa;
    }

    /**
     * Sets id tipa.
     *
     * @param idTipa the id tipa
     */
    public void setIdTipa(int idTipa) {
        this.idTipa = idTipa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mec mec)) return false;
        return getId() == mec.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Mec{" +
                "idMeca=" + idMeca +
                ", idX=" + idX +
                ", idO=" + idO +
                ", idTipa=" + idTipa +
                '}';
    }
}
