package it.uninsubria.vmps.eatadvisor.ioeatadvisor;

import java.io.Serializable;
import java.util.ArrayList;

public class Ristorante implements Serializable {

    private static final long serialVersionUID = -5595856615790298488L;
    private int id;
    private int proprietarioId;
    private String tipologia;
    private String nomeRistorante;
    private Indirizzo indirizzo;
    private String numeroTelefono;
    private String sitoWeb;
    ArrayList<Recensione> recensioni;

    public Ristorante(int id, int proprietarioId, String tipologia, String nomeRistorante, Indirizzo indirizzo,
                      String numeroTelefono, String sitoWeb, ArrayList<Recensione> recensioni) {
        this.id = id;
        this.proprietarioId = proprietarioId;
        this.tipologia = tipologia;
        this.nomeRistorante = nomeRistorante;
        this.indirizzo = indirizzo;
        this.numeroTelefono = numeroTelefono;
        this.sitoWeb = sitoWeb;
        this.recensioni = recensioni;
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

    public double getRecensioniValutazioneMedia() {
        double media = 0.0;
        for (Recensione r : recensioni) {
            media += r.getValutazione();
        }
        return media / recensioni.size();
    }

    public void aggiungiRecensione(Recensione recensione) {
        if (recensione.getValutazione() >= 1 || recensione.getValutazione() <= 5)
            this.recensioni.add(recensione);
    }

    @Override
    public String toString() {
        return "Ristorante<" + id + ", proprietario: " + proprietarioId + ">: nome=" + nomeRistorante
                + ", tipologia=" + tipologia + ", media valurazioni: " + getRecensioniValutazioneMedia();
    }
}
