package it.uninsubria.vmps.eatadvisor.ioutenti;

import java.io.Serializable;

public class Utente implements Serializable {

    //private static final long serialVersionUID = 1L;
    // TODO: change to protected and add SETTER AND GETTERS
    public String nome;
    public String cognome;
    public String comune;

    public Utente() {
    }

    public Utente(String nome, String cognome, String comune) {
        this.nome = nome;
        this.cognome = cognome;
        this.comune = comune;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
