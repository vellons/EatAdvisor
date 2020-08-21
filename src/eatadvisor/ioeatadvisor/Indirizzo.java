package eatadvisor.ioeatadvisor;

import java.io.Serializable;

/**
 * La classe Indirizzo permette
 *
 * @author Alex Vellone
 */
public class Indirizzo implements Serializable {

    /**
     * <code>serialVersionUID</code> è .
     * <p>
     * è dichiarato <strong>final</strong> perchè difatto rappresenta una costante
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * è dichiarato <strong>static</strong> così da non doverlo istanziare creando un oggetto
     * è dichiarato <strong>long</strong> permette di scrivere dati di lunghezza fino a 64 bit
     */
    private static final long serialVersionUID = -7527859265672246970L;
    /**
     * <code>via</code> è .
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String via;
    /**
     * <code>civico</code> è .
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String civico;
    /**
     * <code>citta</code> è .
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String citta;
    /**
     * <code>siglaProvincia</code> è .
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String siglaProvincia;
    /**
     * <code>cap</code> è .
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String cap;

    /**
     * Costrutore della classe
     *
     * @param via            &grave; la via in cui abita l'utente
     * @param civico         &grave; il numero civico
     * @param citta          &grave; la citta dell'utente
     * @param siglaProvincia &grave; la sigla della provincia dell'utente
     * @param cap            &grave; il cap dell'utente
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
     * @param via &grave; la via dell'utente
     */
    public void setVia(String via) {
        this.via = via;
    }

    /**
     * @return il numero civico dell'utente
     */
    public String getCivico() {
        return this.civico;
    }

    /**
     * @param civico &grave; il numero civico dell'utente
     */
    public void setCivico(String civico) {
        this.civico = civico;
    }

    /**
     * @return la città dell'utente
     */
    public String getCitta() {
        return this.citta;
    }

    /**
     * @param citta &grave; la citta dell'utente
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }

    /**
     * @return la sigla della provincia dell'utente
     */
    public String getSiglaProvincia() {
        return this.siglaProvincia;
    }

    /**
     * @param siglaProvincia &grave; la sigla della provincia dell'utente
     */
    public void setSiglaProvincia(String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }

    /**
     * @return il cap dell'utente
     */
    public String getCap() {
        return this.cap;
    }

    /**
     * @param cap &grave; il cap dell'utente
     */
    public void setCap(String cap) {
        this.cap = cap;
    }

    @Override
    /**
     * @return la via, il civico, la citta, la sigla della provincia e il cap dell'utente, in formato stringa
     */
    public String toString() {
        return via + ", " + civico + ", " + citta + ", (" + siglaProvincia + "), " + cap;
    }
}
