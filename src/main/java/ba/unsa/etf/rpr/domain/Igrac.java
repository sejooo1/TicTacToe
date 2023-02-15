package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Igrac implements Idable{
    private int id;
    private String ime;
    private int brojPobjeda;
    private int brojPoraza;
    private int brojNerijesenih;
    private String kojiJeIgrac;

    public Igrac(int id, String ime, int brojPobjeda, int brojPoraza, int brojNerijesenih, String kojiJeIgrac) {
        this.id = id;
        this.ime = ime;
        this.brojPobjeda = brojPobjeda;
        this.brojPoraza = brojPoraza;
        this.brojNerijesenih = brojNerijesenih;
        this.kojiJeIgrac = kojiJeIgrac;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getBrojPobjeda() {
        return brojPobjeda;
    }

    public void setBrojPobjeda(int brojPobjeda) {
        this.brojPobjeda = brojPobjeda;
    }

    public int getBrojPoraza() {
        return brojPoraza;
    }

    public void setBrojPoraza(int brojPoraza) {
        this.brojPoraza = brojPoraza;
    }

    public int getBrojNerijesenih() {
        return brojNerijesenih;
    }

    public void setBrojNerijesenih(int brojNerijesenih) {
        this.brojNerijesenih = brojNerijesenih;
    }

    public String getKojiJeIgrac() {
        return kojiJeIgrac;
    }

    public void setKojiJeIgrac(String kojiJeIgrac) {
        this.kojiJeIgrac = kojiJeIgrac;
    }

    @Override
    public String toString() {
        return "Igrac{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", brojPobjeda=" + brojPobjeda +
                ", brojPoraza=" + brojPoraza +
                ", brojNerijesenih=" + brojNerijesenih +
                ", kojiJeIgrac='" + kojiJeIgrac + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Igrac igrac)) return false;
        return getId() == igrac.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
