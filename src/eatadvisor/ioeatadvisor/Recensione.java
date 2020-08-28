package eatadvisor.ioeatadvisor;

import java.io.Serializable;

/**
 * La classe Recensione permette di di salvare in modo corretto le informazioni di una recensione
 *
 * @author Alex Vellone
 */
public class Recensione implements Serializable {

    /**
     * <code>serialVersionUID</code> &egrave; utlizzare per identificare l'oggetto nella classe Serializable.
     * <p>
     * &egrave; dichiarato <strong>final</strong> perch&egrave; difatto rappresenta una costante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * &egrave; dichiarato <strong>static</strong> cos&igrave; da poterlo utlizzare senza istanziare l'oggetto
     * &egrave; dichiarato <strong>long</strong> permette di scrivere dati di lunghezza fino a 64 bit
     */
    private static final long serialVersionUID = 5702291095524603496L;

    /**
     * <code>utenteId</code> &egrave; l'id dell'utente che ha creato la recensione
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * &egrave; dichiarato <strong>int</strong> permette di scrivere dati di lunghezza fino a 32 bit
     */
    private int utenteId;

    /**
     * <code>valutazione</code> &egrave; la valutazione numerica dell'utente, da un minimo di 1 ad un massimo di 5
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * &egrave; dichiarato <strong>int</strong> permette di scrivere dati di lunghezza fino a 32 bit
     */
    private int valutazione; // 1:5

    /**
     * <code>commento</code> &egrave; il commento inserito insieme alla valutazione dell'utente
     * Pu&ograve; essere di massimo 256 caratteri
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * &egrave; dichiarato <strong>String</strong> permette di scrivere stringhe
     */
    private String commento;

    /**
     * Costrutore della classe
     *
     * @param utenteId    &egrave; l'id dell'utente che ha creato la recensione
     * @param valutazione &egrave; la valutazione numerica lasciata dall'utente
     * @param commento    &egrave; il commento lasciato dall'utente
     */
    public Recensione(int utenteId, int valutazione, String commento) {
        this.utenteId = utenteId;
        this.valutazione = valutazione;
        this.commento = commento;
    }

    /**
     * @return l'id dell'utente che ha creato la recensione
     */
    public int getUtenteId() {
        return this.utenteId;
    }

    /**
     * @param utenteId &egrave; l'id dell'utente che ha creato la recensione
     */
    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    /**
     * @return la valutazione numerica dell'utente
     */
    public int getValutazione() {
        return this.valutazione;
    }

    /**
     * @param valutazione &egrave; la valutazione numerica  dell'utente
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
     * @param commento &egrave; il commento dell'utente
     */
    public void setCommento(String commento) {
        this.commento = commento;
    }

    /**
     * @return le informazioni relative ad una recensione in formato stringa
     */
    @Override
    public String toString() {
        return "Recensione<" + valutazione + ", utente id: " + utenteId + ">: " + commento;
    }
}
