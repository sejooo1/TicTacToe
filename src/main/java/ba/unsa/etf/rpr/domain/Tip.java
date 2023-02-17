package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Tip implements Idable{
    private int id;
    private String opis;

    public Tip(int id, String opis) {
        this.id = id;
        this.opis = opis;
    }

    public Tip() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tip tip)) return false;
        return getId() == tip.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Tip{" +
                "id=" + id +
                ", opis='" + opis + '\'' +
                '}';
    }
}
