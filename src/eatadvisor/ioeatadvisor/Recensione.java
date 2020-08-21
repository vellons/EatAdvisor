package eatadvisor.ioeatadvisor;

import java.io.Serializable;

/**
 * La classe Recensione permette...
 *
 * @author Alex Vellone
 */
public class Recensione implements Serializable {

    /**
     * <code>serialVersionUID</code> &egrave;.
     * <p>
     * &Egrave; dichiarato <strong>final</strong> perchè difatto rappresenta una costante
     * &Egrave; dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * &Egrave; dichiarato <strong>static</strong> così da non doverlo istanziare creando un oggetto
     * &Egrave; dichiarato <strong>long</strong> permette di scrivere dati di lunghezza fino a 64 bit
     */
    private static final long serialVersionUID = 5702291095524603496L;
    /**
     * <code>utenteId</code> &egrave; l'id dell'utente
     * <p>
     * &Egrave; dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * &Egrave; dichiarato <strong>int</strong> permette di scrivere dati di lunghezza fino a 32 bit
     */
    private int utenteId;
    /**
     * <code>valutazione</code> &egrave; la valutazione dell'utente
     * <p>
     * &Egrave; dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * &Egrave; dichiarato <strong>int</strong> permette di scrivere dati di lunghezza fino a 32 bit
     */
    private int valutazione; // 1:5
    /**
     * <code>commento</code> &egrave; l'id dell'utente
     * <p>
     * &Egrave; dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * &Egrave; dichiarato <strong>String</strong> permette di scrivere stringhe
     */
    private String commento;

    /**
     * Costrutore della classe
     *
     * @param utenteId    &grave; l'id dell'utente
     * @param valutazione &grave; la valutazione lasciata dall'utente
     * @param commento    &grave; il commento lasciato dall'utente
     */
    public Recensione(int utenteId, int valutazione, String commento) {
        this.utenteId = utenteId;
        this.valutazione = valutazione;
        this.commento = commento;
    }

    /**
     * @return l'id dell'utente
     */
    public int getUtenteId() {
        return this.utenteId;
    }

    /**
     * @param utenteId &grave; l'id dell'utente
     */
    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    /**
     * @return la valutazione dell'utente
     */
    public int getValutazione() {
        return this.valutazione;
    }

    /**
     * @param valutazione &grave; la valutazione dell'utente
     */
    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    /**
     * @return il commento dell'utente
     */
    public String getCommento() {
        return this.commento;
    }

    /**
     * @param commento &grave; il commento dell'utente
     */
    public void setCommento(String commento) {
        this.commento = commento;
    }

    @Override
    /**
     * @return la recensione e l'id dell'utente in formato stringa
     */
    public String toString() {
        return "Recensione<" + valutazione + ", utente id: " + utenteId + ">: " + commento;
    }
}
