package it.uninsubria.vmps.eatadvisor.ioeatadvisor;

import java.io.Serializable;

public class Indirizzo implements Serializable {

    private static final long serialVersionUID = -7527859265672246970L;
    private String via;
    private String civico;
    private String citta;
    private String siglaProvincia;
    private String cap;

    public Indirizzo(String via, String civico, String citta, String siglaProvincia, String cap) {
        this.via = via;
        this.civico = civico;
        this.citta = citta;
        this.siglaProvincia = siglaProvincia;
        this.cap = cap;
    }

    public String getVia() {
        return this.via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return this.civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getCitta() {
        return this.citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getSiglaProvincia() {
        return this.siglaProvincia;
    }

    public void setSiglaProvincia(String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }

    public String getCap() {
        return this.cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return via + ", " + civico + ", " + citta + ", (" + siglaProvincia + "), " + cap;
    }
}
