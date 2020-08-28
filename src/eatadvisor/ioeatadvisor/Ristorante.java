package eatadvisor.ioeatadvisor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La classe Ristorante permette di settare/prelevare le informazioni inerenti
 * a un ristorante
 *
 * @author Alex Vellone
 */
public class Ristorante implements Serializable {

    /**
     * <code>serialVersionUID</code> &egrave; utlizzare per identificare l'oggetto nella classe Serializable.
     * <p>
     * &egrave; dichiarato <strong>final</strong> perch&egrave; difatto rappresenta una costante
     * &egrave; dichiarato <strong>static</strong> cos&igrave; da poterlo utlizzare senza istanziare l'oggetto
     * &egrave; dichiarato <strong>long</strong> permette di scrivere dati di lunghezza fino a 64 bit
     */
    private static final long serialVersionUID = -5595856615790298488L;

    /**
     * <code>id</code> &egrave; l'id univoco del ristorante
     * <p>
     * &egrave; dichiarato <strong>int</strong> permette di scrivere dati di lunghezza fino a 32 bit
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private int id;

    /**
     * <code>proprietarioId</code> &egrave; l'id dell'utentet ristorantore a cui appartiene questo ristorante
     * <p>
     * &egrave; dichiarato <strong>int</strong> permette di scrivere dati di lunghezza fino a 32 bit
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private int proprietarioId;

    /**
     * <code>tipologia</code> &egrave; la tipologia del ristorante
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String tipologia;

    /**
     * <code>nomeRistorante</code> &egrave; il nome del ristorante
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String nomeRistorante;

    /**
     * <code>descrizione</code> &egrave; la descrizione del ristorante
     * <p>
     * &egrave; dichiarato <strong>String</strong> permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String descrizione;

    /**
     * <code>indirizzo</code> &egrave; l'indirizzo del ristorante
     * <p>
     * &egrave; dichiarato <strong>Indirizzo</strong> per poter salvare in modo ottimale le informazioni del ristorante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private Indirizzo indirizzo;

    /**
     * <code>numeroTelefono</code> &egrave; il numero di telefono del ristorante
     * <p>
     * &egrave; dichiarato <strong>String</strong> permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String numeroTelefono;

    /**
     * <code>sitoWeb</code> &egrave; il sito web del ristorante
     * <p>
     * &egrave; dichiarato <strong>String</strong> permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String sitoWeb;

    /**
     * <code>recensioni</code> &egrave; la lista delle recensioni, espresse dai clienti, del ristorante
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private ArrayList<Recensione> recensioni;

    /**
     * Costrutore della classe
     *
     * @param id             &egrave; l'id del ristorante
     * @param proprietarioId &egrave; l'id del proprietario del ristorante
     * @param tipologia      &egrave; la tipologia del ristorante
     * @param nomeRistorante &egrave; il nome del ristorante
     * @param descrizione    &egrave; la descrizione del ristorante
     * @param indirizzo      &egrave; l'indirizzo del ristorante
     * @param numeroTelefono &egrave; il numero di telefono del ristorante
     * @param sitoWeb        &egrave; il sito web del ristorante
     */
    public Ristorante(int id, int proprietarioId, String tipologia, String nomeRistorante, String descrizione,
                      Indirizzo indirizzo, String numeroTelefono, String sitoWeb) {
        this.id = id;
        this.proprietarioId = proprietarioId;
        this.tipologia = tipologia;
        this.nomeRistorante = nomeRistorante;
        this.descrizione = descrizione;
        this.indirizzo = indirizzo;
        this.numeroTelefono = numeroTelefono;
        this.sitoWeb = sitoWeb;
        this.recensioni = new ArrayList<Recensione>(); // Nuovo ArrayList di recensioni vuoto
    }


    /**
     * @return l'id univoco del ristorante
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id &egrave; l'id del risotante
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return &egrave; l'id del proprietario di questo ristorante
     */
    public int getProprietarioId() {
        return this.proprietarioId;
    }

    /**
     * @param proprietarioId &egrave; l'id del proprietario del ristorante
     */
    public void setProprietarioId(int proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    /**
     * @return tipologia del ristorante
     */
    public String getTipologia() {
        return this.tipologia;
    }

    /**
     * @param tipologia &egrave; la tipologia del ristorante
     */
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    /**
     * @return nome del ristorante
     */
    public String getNomeRistorante() {
        return this.nomeRistorante;
    }

    /**
     * @param nomeRistorante &egrave; il nome del ristorante
     */
    public void setNomeRistorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
    }

    /**
     * @return descrizione del ristorante
     */
    public String getDescrizione() {
        return this.descrizione;
    }

    /**
     * @param descrizione &egrave; la descrizione del ristorante
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return l'indirizzo del ristorante
     */
    public Indirizzo getIndirizzo() {
        return this.indirizzo;
    }

    /**
     * @param indirizzo &egrave; l'indirizzo del ristorante
     */
    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * @return numero di telefono del ristorante
     */
    public String getNumeroTelefono() {
        return this.numeroTelefono;
    }

    /**
     * @param numeroTelefono &egrave; il numero di telefono del ristorante
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * @return sito web del ristorante
     */
    public String getSitoWeb() {
        return this.sitoWeb;
    }

    /**
     * @param sitoWeb &egrave; il sito web del ristorante
     */
    public void setSitoWeb(String sitoWeb) {
        this.sitoWeb = sitoWeb;
    }

    /**
     * @return l'elenco delle recensioni ricevuto dal ristorante
     */
    public ArrayList<Recensione> getRecensioni() {
        return this.recensioni;
    }

    /**
     * @param recensioni &egrave; l'elenco delle recensioni ricevuto dal ristorante
     */
    public void setRecensioni(ArrayList<Recensione> recensioni) {
        this.recensioni = recensioni;
    }

    /**
     * @return la valutazione media delle recensioni
     */
    public double getRecensioniValutazioneMedia() {
        double media = 0.0;
        for (Recensione r : recensioni) {
            media += r.getValutazione();
        }
        if (recensioni.size() > 0) return media / recensioni.size();
        else return 0;
    }

    /**
     * @param valore &egrave; il valore delle recensioni che si vogliono contare
     * @return il conteggio delle valutazioni con un determinato valore
     */
    public int contaValutazioniConValore(int valore) {
        int cont = 0;
        for (Recensione r : recensioni) {
            if (r.getValutazione() == valore) cont++;
        }
        return cont;
    }

    /**
     * @param recensione &egrave; la nuova recensione che andr&agrave; inserita nell'ArrayList delle recensioni del ristorante
     */
    public void aggiungiRecensione(Recensione recensione) {
        if (recensione.getValutazione() >= 1 && recensione.getValutazione() <= 5)
            this.recensioni.add(recensione);
    }

    /**
     * @return le informazioni relative a un ristorante in formato striga
     */
    @Override
    public String toString() {
        return "Ristorante<" + id + ", proprietario: " + proprietarioId + ">: nome=" + nomeRistorante
                + ", tipologia=" + tipologia + ", numero valutazioni: " + recensioni.size()
                + ", media valutazioni: " + getRecensioniValutazioneMedia();
    }
}
