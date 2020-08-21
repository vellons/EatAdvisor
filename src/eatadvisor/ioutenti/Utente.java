package eatadvisor.ioutenti;

import java.io.Serializable;

/**
 * La classe Utente permette di settare/prelevare le informazioni inerenti a un utente
 *
 * @author Alex Vellone
 */
public class Utente implements Serializable {

    private static final long serialVersionUID = -489957051202126151L;
    private int id;
    private String tipo; // CLIE/RIST/NULL
    private String email;
    private String nickname;
    private String hashPassword;
    private String nome;
    private String cognome;
    private String comune;
    private String siglaProvincia;

    /**
     * Costrutore della classe
     *
     * @param id                è l'id dell'utente
     * @param tipo              è il tipo di utente
     * @param email             è l'email dell'utente
     * @param nickname          è il nickname dell'utente
     * @param plaintextPassword è la password dell'utente
     * @param nome              è il nome dell'utente
     * @param cognome           è il cognome dell'utente
     * @param comune            è il comune dell'utente
     * @param siglaProvincia    è la sigla della provincia dell'utente
     */
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

    /**
     * @return l'id dell'utente
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id &grave; l'id dell'utente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return il tipo di utente
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * @param tipo &grave; il tipo di utente
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return l'email dell'utente
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email &grave; l'email dell'utente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return il nickname dell'utente
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * @param nickname &grave; il nickname dell'utente
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return la password dell'utente crittografata
     */
    public String getHashPassword() {
        return this.hashPassword;
    }

    /**
     * @param plaintextPassword &grave; la password in chiaro dell'utente
     */
    public void setPasswordAndHash(String plaintextPassword) {
        this.hashPassword = Sha1.sha1(plaintextPassword);
    }

    /**
     * @return il nome dell'utente
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param nome &grave; il nome dell'utente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return il cognome dell'utente
     */
    public String getCognome() {
        return this.cognome;
    }

    /**
     * @param cognome &grave; il cognome dell'utente
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return il comune dell'utente
     */
    public String getComune() {
        return this.comune;
    }

    /**
     * @param comune &grave; il comune dell'utente
     */
    public void setComune(String comune) {
        this.comune = comune;
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
     * @return le informazioni relative a un utente in formato stringa
     */
    @Override
    public String toString() {
        return "Utente<" + id + ", " + tipo + ">: email=" + email + ", nickname=" + nickname
                + ", cognome=" + cognome + ", nome=" + nome + ", pass=" + hashPassword;
    }
}
