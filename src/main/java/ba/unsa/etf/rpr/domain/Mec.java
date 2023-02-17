package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Mec implements Idable{
    private int idMeca;
    private int idX;
    private int idO;
    private int idTipa;

    public Mec(int idMeca, int idX, int idO, int idTipa) {
        this.idMeca = idMeca;
        this.idX = idX;
        this.idO = idO;
        this.idTipa = idTipa;
    }

    public Mec() {

    }

    public int getId() {
        return idMeca;
    }

    public void setId(int idMeca) {
        this.idMeca = idMeca;
    }

    public int getIdX() {
        return idX;
    }

    public void setIdX(int idX) {
        this.idX = idX;
    }

    public int getIdO() {
        return idO;
    }

    public void setIdO(int idO) {
        this.idO = idO;
    }

    public int getIdTipa() {
        return idTipa;
    }

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
