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
     * <code>serialVersionUID</code> è.
     * <p>
     * è dichiarato <strong>final</strong> perchè difatto rappresenta una costante
     * è dichiarato <strong>static</strong> così da non doverlo istanziare creando un oggetto
     * è dichiarato <strong>long</strong> permette di scrivere dati di lunghezza fino a 64 bit
     */
    private static final long serialVersionUID = -5595856615790298488L;
    /**
     * <code>id</code> è l'id dell'utente
     * <p>
     * è dichiarato <strong>int</strong> permette di scrivere dati di lunghezza fino a 32 bit
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private int id;
    /**
     * <code>proprietarioId</code> è il propritario dell'id
     * <p>
     * è dichiarato <strong>int</strong> permette di scrivere dati di lunghezza fino a 32 bit
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private int proprietarioId;
    /**
     * <code>tipologia</code> è la tipologia del ristorante
     * <p>
     * è dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String tipologia;
    /**
     * <code>nomeRistorante</code> è il nome del ristorante
     * <p>
     * è dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String nomeRistorante;
    /**
     * <code>descrizione</code> è la descrizione del ristorante
     * <p>
     * è dichiarato <strong>String</strong> permette di scrivere stringhe
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String descrizione;
    /**
     * <code>indirizzo</code> è l'indirizzo del ristorante
     * <p>
     * è dichiarato <strong>Indirizzo</strong> ???
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private Indirizzo indirizzo;
    /**
     * <code>numeroTelefono</code> è il numero di telefono del ristorante
     * <p>
     * è dichiarato <strong>String</strong> permette di scrivere stringhe
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String numeroTelefono;
    /**
     * <code>sitoWeb</code> è il sito web del ristorante
     * <p>
     * è dichiarato <strong>String</strong> permette di scrivere stringhe
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String sitoWeb;
    /**
     * <code>recensioni</code> è la recensione del ristorante
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private ArrayList<Recensione> recensioni;

    /**
     * Costrutore della classe
     *
     * @param id             è l'id del ristorante
     * @param proprietarioId è l'id del proprietario del ristorante
     * @param tipologia      è la tipologia del ristorante
     * @param nomeRistorante è il nome del ristorante
     * @param descrizione    è la descrizione del ristorante
     * @param indirizzo      è l'indirizzo del ristorante
     * @param numeroTelefono è il numero di telefono del ristorante
     * @param sitoWeb        è il sito web del ristorante
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
        this.recensioni = new ArrayList<Recensione>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProprietarioId() {
        return this.proprietarioId;
    }

    public void setProprietarioId(int proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public String getTipologia() {
        return this.tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getNomeRistorante() {
        return this.nomeRistorante;
    }

    public void setNomeRistorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Indirizzo getIndirizzo() {
        return this.indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNumeroTelefono() {
        return this.numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getSitoWeb() {
        return this.sitoWeb;
    }

    public void setSitoWeb(String sitoWeb) {
        this.sitoWeb = sitoWeb;
    }

    public ArrayList<Recensione> getRecensioni() {
        return this.recensioni;
    }

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
     * @param valore è ???
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
     * @param recensione è la nuova recensione che andrà inserita nell'arraylist delle recensioni del ristorante
     * @return una recensione, che viene aggiunta alle altre
     */
    public void aggiungiRecensione(Recensione recensione) {
        if (recensione.getValutazione() >= 1 && recensione.getValutazione() <= 5)
            this.recensioni.add(recensione);
    }

    @Override
    /**
     * @return le informazioni di un ristorante, sotto forma di stringa
     */
    public String toString() {
        return "Ristorante<" + id + ", proprietario: " + proprietarioId + ">: nome=" + nomeRistorante
                + ", tipologia=" + tipologia + ", numero valutazioni: " + recensioni.size()
                + ", media valutazioni: " + getRecensioniValutazioneMedia();
    }
}
