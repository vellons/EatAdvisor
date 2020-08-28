package eatadvisor.ioeatadvisor;

import java.io.Serializable;

/**
 * La classe Indirizzo permette di salvare in modo corretto le informazioni di un indirizzo
 *
 * @author Alex Vellone
 */
public class Indirizzo implements Serializable {

    /**
     * <code>serialVersionUID</code> &egrave; utlizzare per identificare l'oggetto nella classe Serializable.
     * <p>
     * &egrave; dichiarato <strong>final</strong> perch&egrave; difatto rappresenta una costante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * &egrave; dichiarato <strong>static</strong> così da poterlo utlizzare senza istanziare l'oggetto
     * &egrave; dichiarato <strong>long</strong> permette di scrivere dati di lunghezza fino a 64 bit
     */
    private static final long serialVersionUID = -7527859265672246970L;

    /**
     * <code>via</code> &egrave; la via
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String via;

    /**
     * <code>civico</code> &egrave; il numero civico
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String civico;

    /**
     * <code>citta</code> &egrave; la citt&agrave;
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String citta;

    /**
     * <code>siglaProvincia</code> &egrave; la sigla di due catatteri della provincia
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String siglaProvincia;

    /**
     * <code>cap</code> &egrave; il CAP
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String cap;

    /**
     * Costrutore della classe
     *
     * @param via            &egrave; la via
     * @param civico         &egrave; il numero civico
     * @param citta          &egrave; la citta
     * @param siglaProvincia &egrave; la sigla della provincia
     * @param cap            &egrave; il cap
     */
    public Indirizzo(String via, String civico, String citta, String siglaProvincia, String cap) {
        this.via = via;
        this.civico = civico;
        this.citta = citta;
        this.siglaProvincia = siglaProvincia;
        this.cap = cap;
    }

    /**
     * @return la via
     */
    public String getVia() {
        return this.via;
    }

    /**
     * @param via &egrave; la via
     */
    public void setVia(String via) {
        this.via = via;
    }

    /**
     * @return il numero civico
     */
    public String getCivico() {
        return this.civico;
    }

    /**
     * @param civico &egrave; il numero civico
     */
    public void setCivico(String civico) {
        this.civico = civico;
    }

    /**
     * @return la citt&agrave;
     */
    public String getCitta() {
        return this.citta;
    }

    /**
     * @param citta &egrave; la citt&agrave;
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }

    /**
     * @return la sigla della provincia
     */
    public String getSiglaProvincia() {
        return this.siglaProvincia;
    }

    /**
     * @param siglaProvincia &egrave; la sigla della provincia
     */
    public void setSiglaProvincia(String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }

    /**
     * @return il cap
     */
    public String getCap() {
        return this.cap;
    }

    /**
     * @param cap &egrave; il cap
     */
    public void setCap(String cap) {
        this.cap = cap;
    }


    /**
     * @return le informazioni relative ad un indirizzo in formato stringa
     */
    @Override
    public String toString() {
        return via + ", " + civico + ", " + citta + ", (" + siglaProvincia + "), " + cap;
    }
}
