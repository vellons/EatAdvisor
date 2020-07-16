package it.uninsubria.vmps.eatadvisor.ioutenti;

import java.io.Serializable;

public class Utente implements Serializable {

    private static final long serialVersionUID = 8328061987053697424L;
    private int id;
    private String tipo; // CLIE/RIST/NULL
    private String email;
    private String nickname;
    private String hashPassword;
    private String nome;
    private String cognome;
    private String comune;
    private String siglaProvincia;

    public Utente() {
        this.id = -1;
        this.tipo = "NULL";
        this.email = "";
        this.nickname = "";
        this.hashPassword = "";
        this.nome = "";
        this.cognome = "";
        this.comune = "";
        this.siglaProvincia = "";
    }

    public Utente(int id, String tipo, String email, String nickname, String plaintextPassword, String nome,
                  String cognome, String comune, String siglaProvincia) {
        this.id = id;
        this.tipo = tipo;
        this.email = email;
        this.nickname = nickname;
        this.nome = nome;
        this.cognome = cognome;
        this.comune = comune;
        this.siglaProvincia = siglaProvincia;
        this.setPasswordAndHash(plaintextPassword);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHashPassword() {
        return this.hashPassword;
    }

    public void setPasswordAndHash(String plaintextPassword) {
        this.hashPassword = Sha1.sha1(plaintextPassword);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getComune() {
        return this.comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getSiglaProvincia() {
        return this.siglaProvincia;
    }

    public void setSiglaProvincia(String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }

    @Override
    public String toString() {
        return "Utente<" + id + ", " + tipo + ">: email=" + email + ", nickname=" + nickname
                + ", password=" + hashPassword;
    }
}
