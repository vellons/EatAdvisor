package it.uninsubria.vmps.eatadvisor.ioutenti;

import java.io.Serializable;

public class Utente implements Serializable {

    private static final long serialVersionUID = 8328061987053697424L;
    public int id;
    public String email;
    public String nickname;
    public String hashPassword;
    public String nome;
    public String cognome;
    public String comune;
    public String siglaProvincia;

    public Utente() {
        this.id = -1;
        this.email = "";
        this.nickname = "";
        this.hashPassword = "";
        this.nome = "";
        this.cognome = "";
        this.comune = "";
        this.siglaProvincia = "";
    }

    public Utente(int id, String email, String nickname, String plaintextPassword, String nome, String cognome,
                  String comune, String siglaProvincia) {
        this.id = id;
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
        return "Utente<" + id + ">: email=" + email + ", nickname=" + nickname + ", password=" + hashPassword;
    }
}
