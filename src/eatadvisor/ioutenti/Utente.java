package eatadvisor.ioutenti;

import java.io.Serializable;

/**
 * La classe Utente permette di settare/prelevare le informazioni inerenti a un utente
 *
 * @author Alex Vellone
 */
public class Utente implements Serializable {

    /**
     * <code>serialVersionUID</code> &egrave; utlizzare per identificare l'oggetto nella classe Serializable.
     * <p>
     * &egrave; dichiarato <strong>final</strong> perch&egrave; difatto rappresenta una costante
     * &egrave; dichiarato <strong>static</strong> cos&igrave; da poterlo utlizzare senza istanziare l'oggetto
     * &egrave; dichiarato <strong>long</strong> permette di scrivere dati di lunghezza fino a 64 bit
     */
    private static final long serialVersionUID = -489957051202126151L;

    /**
     * <code>id</code> &egrave; l'id univoco dell'utente
     * <p>
     * &egrave; dichiarato <strong>int</strong> permette di scrivere dati di lunghezza fino a 32 bit
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private int id;

    /**
     * <code>tipo</code> &egrave; la tipologia dell'utente.
     * Pu&ograve; essere "CLIE" o "RIST"
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String tipo;

    /**
     * <code>email</code> &egrave; l'email
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String email;

    /**
     * <code>nickname</code> &egrave; il nickname
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String nickname;

    /**
     * <code>hashPassword</code> &egrave; la firma univoca di 40 carattedi della password
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String hashPassword;

    /**
     * <code>nome</code> &egrave; il nome
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String nome;

    /**
     * <code>cognome</code> &egrave; il cognome
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String cognome;

    /**
     * <code>comune</code> &egrave; il comune di residenza dell'utente
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String comune;

    /**
     * <code>siglaProvincia</code> &egrave; la sigla della provincia di residenza dell'utente
     * <p>
     * &egrave; dichiarato <strong>String</strong> in quanto permette di scrivere stringhe
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private String siglaProvincia;

    /**
     * Costrutore della classe
     *
     * @param id                &egrave; l'id univoco dell'utente
     * @param tipo              &egrave; il tipo di utente
     * @param email             &egrave; l'email dell'utente
     * @param nickname          &egrave; il nickname dell'utente
     * @param plaintextPassword &egrave; la password dell'utente
     * @param nome              &egrave; il nome dell'utente
     * @param cognome           &egrave; il cognome dell'utente
     * @param comune            &egrave; il comune dell'utente
     * @param siglaProvincia    &egrave; la sigla della provincia dell'utente
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
     * @param id &egrave; l'id dell'utente
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
     * @param tipo &egrave; il tipo di utente
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
     * @param email &egrave; l'email dell'utente
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
     * @param nickname &egrave; il nickname dell'utente
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
     * @param plaintextPassword &egrave; la password in chiaro dell'utente
     */
    public void setPasswordAndHash(String plaintextPassword) {
        this.hashPassword = Sha1.sha1(plaintextPassword); // Calcola la firma della password in chiaro
    }

    /**
     * @return il nome dell'utente
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param nome &egrave; il nome dell'utente
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
     * @param cognome &egrave; il cognome dell'utente
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
     * @param comune &egrave; il comune dell'utente
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
     * @param siglaProvincia &egrave; la sigla della provincia dell'utente
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
