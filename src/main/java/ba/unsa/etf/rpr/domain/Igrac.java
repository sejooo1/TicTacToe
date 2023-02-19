package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * JavaBean Class Igrac.
 */
public class Igrac implements Idable{
    private int id;
    private String ime;
    private int brojPobjeda;
    private int brojPoraza;
    private int brojNerijesenih;
    private String kojiJeIgrac;

    /**
     * Instantiates a new Igrac.
     *
     * @param id              the id
     * @param ime             the ime
     * @param brojPobjeda     the broj pobjeda
     * @param brojPoraza      the broj poraza
     * @param brojNerijesenih the broj nerijesenih
     * @param kojiJeIgrac     the koji je igrac
     */
    public Igrac(int id, String ime, int brojPobjeda, int brojPoraza, int brojNerijesenih, String kojiJeIgrac) {
        this.id = id;
        this.ime = ime;
        this.brojPobjeda = brojPobjeda;
        this.brojPoraza = brojPoraza;
        this.brojNerijesenih = brojNerijesenih;
        this.kojiJeIgrac = kojiJeIgrac;
    }

    /**
     * Instantiates a new Igrac.
     */
    public Igrac() {

    }

    /**
     * Instantiates a new Igrac.
     *
     * @param ime the ime
     */
    public Igrac(String ime) {
        this.ime = ime;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets ime.
     *
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets ime.
     *
     * @param ime the ime
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Gets broj pobjeda.
     *
     * @return the broj pobjeda
     */
    public int getBrojPobjeda() {
        return brojPobjeda;
    }

    /**
     * Sets broj pobjeda.
     *
     * @param brojPobjeda the broj pobjeda
     */
    public void setBrojPobjeda(int brojPobjeda) {
        this.brojPobjeda = brojPobjeda;
    }

    /**
     * Gets broj poraza.
     *
     * @return the broj poraza
     */
    public int getBrojPoraza() {
        return brojPoraza;
    }

    /**
     * Sets broj poraza.
     *
     * @param brojPoraza the broj poraza
     */
    public void setBrojPoraza(int brojPoraza) {
        this.brojPoraza = brojPoraza;
    }

    /**
     * Gets broj nerijesenih.
     *
     * @return the broj nerijesenih
     */
    public int getBrojNerijesenih() {
        return brojNerijesenih;
    }

    /**
     * Sets broj nerijesenih.
     *
     * @param brojNerijesenih the broj nerijesenih
     */
    public void setBrojNerijesenih(int brojNerijesenih) {
        this.brojNerijesenih = brojNerijesenih;
    }

    /**
     * Gets koji je igrac.
     *
     * @return the koji je igrac
     */
    public String getKojiJeIgrac() {
        return kojiJeIgrac;
    }

    /**
     * Sets koji je igrac.
     *
     * @param kojiJeIgrac the koji je igrac
     */
    public void setKojiJeIgrac(String kojiJeIgrac) {
        this.kojiJeIgrac = kojiJeIgrac;
    }

    /**
     * Incrementing wins.
     */
    public void uvecajPobjedu(){
        brojPobjeda++;
    }

    /**
     * Incrementing losses.
     */
    public void uvecajPoraz(){
        brojPoraza++;
    }

    /**
     * Incrementing draws.
     */
    public void uvecajNerijesene(){
        brojNerijesenih++;
    }

    @Override
    public String toString() {
        return ime;
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
