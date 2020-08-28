package eatadvisor.ioutenti;

import java.io.*;
import java.util.ArrayList;

/**
 * La classe IOUtenti permette di creare un middleware tra database e applicazioni
 * per gestire le informazioni degli utenti.
 *
 * @author Alex Vellone
 */
public class IOUtenti {

    /**
     * <code>FILE_UTENTI</code> &egrave; il percorso relativo del file sul quale sono salvate le informazioni degli utenti
     * <p>
     * &egrave; dichiarato <strong>final</strong> perch&egrave; difatto rappresenta una costante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * &egrave; dichiarato <strong>static</strong> cos&igrave; da poterlo utlizzare senza istanziare l'oggetto
     */
    public static final String FILE_UTENTI = "data/Utenti.dati";

    /**
     * <code>utenti</code> &egrave; un ArrayList nel quale la classe esegue le operazioni base per
     * manipolare la lista degli utenti
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private ArrayList<Utente> utenti = new ArrayList<>();

    /**
     * Costrutore della classe, che una volta istanziata preleva automaticamente tutte le informazioni dal file
     *
     * @throws Exception &egrave; sollevara quando si verificano problemi di lettura sul file
     */
    public IOUtenti() throws Exception {
        prelevaDaFile();
    }

    /**
     * @return la lista degli utenti
     */
    public ArrayList<Utente> getListaUtenti() {
        return utenti;
    }

    /**
     * @param id &egrave; l'id dell'utente da cercaare
     * @return l'oggetto utente trovato
     * @throws Exception &egrave; sollevata per informare che l'utente cercato non &egrave; stato trovato
     */
    public Utente getUtenteById(int id) throws Exception {
        prelevaDaFile();
        for (int i = 0; i < utenti.size(); i++) { // Scorro la lista degli utenti
            if (utenti.get(i).getId() == id) {
                return utenti.get(i);
            }
        }
        throw new Exception("IOUTENTI: utente non trovato.");
    }

    /**
     * Preleva tutte le informazioni salvate sui file e le salva nell'ArrayList interno
     *
     * @throws Exception &egrave; sollevara quando si verificano problemi di lettura sul file
     */
    public void prelevaDaFile() throws Exception {
        // Prendo tutti gli utenti salvati nel file e li carico all'interno di ArrayList<Utente>
        File f = new File(FILE_UTENTI);
        if (!f.exists()) {
            throw new Exception("IOUTENTI: File " + FILE_UTENTI + " non trovato.");
        }

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        try {
            this.utenti = (ArrayList) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
            throw new Exception("IOUTENTI: File " + FILE_UTENTI + " corrotto, serializzazione non riuscita.");
        }
    }

    /**
     * Salva le informazini presenti nell'ArrayList interno sul file, sovrascrivendolo
     *
     * @throws Exception &egrave; sollevara quando si verificano problemi di accesso sul file
     */
    private void aggiornaSuFile() throws Exception {
        // Sovrascrive gli utenti esistenti nel file con quelli all'interno di ArrayList<Utente>
        File f = new File(FILE_UTENTI);
        if (f.exists()) {
            f.delete();
            f.createNewFile();
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(utenti);
        out.close();
        System.out.println("File " + FILE_UTENTI + " aggiornato con " + utenti.size() + " utenti.");
    }

    /**
     * Crea un nuovo utente con le informazioni date
     *
     * @param tipo              &egrave; il tipo di utente
     * @param email             &egrave; l'email dell'utente
     * @param nickname          &egrave; il nickname dell'utente
     * @param plaintextPassword &egrave; la password in chiaro dell'utente, verr&agrave; calcolata la firma prima di salvarla
     * @param nome              &egrave; il nome dell'utente
     * @param cognome           &egrave; il cognome dell'utente
     * @param comune            &egrave; il comune dell'utente
     * @param siglaProvincia    &egrave; la sigla della provincia dell'utente
     * @return l'oggetto Utente creato
     * @throws Exception &egrave; sollevara quando si verificano problemi di accesso sul file o
     *                   alcune informazioni non sono univoche: tipo email o nickname
     */
    public Utente creaNuovoUtente(String tipo, String email, String nickname, String plaintextPassword,
                                  String nome, String cognome, String comune, String siglaProvincia) throws Exception {
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti gli utenti
        filtraPerEmail(email); // Controllo se la email &egrave; già stata utilizzata
        if (utenti.size() > 0) {
            throw new Exception("Email già utilizzata.");
        }
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti gli utenti
        filtraPerNickname(nickname); // Controllo se il nickname &egrave; già stato utilizzato
        if (utenti.size() > 0) {
            throw new Exception("Nickanme già utilizzato.");
        }
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti gli utenti
        int idSuccessivo = utenti.size() + 1;
        Utente nuovo = new Utente(idSuccessivo, tipo, email, nickname, plaintextPassword, nome, cognome,
                comune, siglaProvincia);
        utenti.add(nuovo); // Aggiungo nuovo utente alla lista
        aggiornaSuFile();
        System.out.println("Creazione utente avvenuta con successo. Assegnato Id: " + nuovo.getId() + ".");
        return nuovo;
    }

    /**
     * Aggiorna le informazioni base di un utente
     *
     * @param id             &egrave; l'id dell'utente su cui voglio modificare le informazioni
     * @param nome           &egrave; il nome dell'utente
     * @param cognome        &egrave; il cognome dell'utente
     * @param comune         &egrave; il comune dell'utente
     * @param siglaProvincia &egrave; la sigla della provincia dell'utente
     * @return l'oggetto utente aggiornato
     * @throws Exception &egrave; sollevara quando si verificano problemi di accesso sul file o
     *                   l'utente da aggiornare non &egrave; stato torvato
     */
    public Utente aggiornaUtenteById(int id, String nome, String cognome, String comune, String siglaProvincia)
            throws Exception {
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti gli utenti
        Utente utenteDaAggiornare = null;
        boolean aggiornato = false;
        for (int i = 0; i < utenti.size(); i++) { // Scorro la lista degli utenti
            if (utenti.get(i).getId() == id) {
                utenteDaAggiornare = utenti.get(i);
                utenteDaAggiornare.setNome(nome);
                utenteDaAggiornare.setCognome(cognome);
                utenteDaAggiornare.setComune(comune);
                utenteDaAggiornare.setSiglaProvincia(siglaProvincia);
                utenti.set(i, utenteDaAggiornare); // Aggiorno l'utente sulla lista
                aggiornato = true;
            }
        }
        if (!aggiornato) {
            throw new Exception("IOUTENTI: utente da aggiornare non trovato.");
        }
        aggiornaSuFile();
        System.out.println("Aggiornamento eseguito per l'utente con Id: " + utenteDaAggiornare.getId() + ".");
        return utenteDaAggiornare;
    }

    /**
     * Aggiorna la password di un utente
     *
     * @param id          &egrave; l'id dell'utente su cui voglio cambiare la password
     * @param oldPassword &egrave; la vecchia password utilizzata dall'utente
     * @param newPassword &egrave; la nuova password utilizzata dall'utente
     * @return l'oggetto utente aggiornato
     * @throws Exception &egrave; sollevara quando si verificano problemi di accesso sul file o
     *                   l'utente non ha inserito la vecchia password correttamente o
     *                   le due password inserite sono uguali
     */
    public Utente aggiornaPasswordById(int id, String oldPassword, String newPassword) throws Exception {
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti gli utenti
        Utente utenteDaAggiornare = null;
        boolean aggiornato = false;
        for (int i = 0; i < utenti.size(); i++) { // Scorro la lista degli utenti
            if (utenti.get(i).getId() == id) { // Ho trovato l'utente
                utenteDaAggiornare = utenti.get(i);
                if (oldPassword.equals(newPassword)) {
                    throw new Exception("Le due password risultano uguali.");
                }
                if (Sha1.sha1(oldPassword).equals(utenteDaAggiornare.getHashPassword())) {
                    utenteDaAggiornare.setPasswordAndHash(newPassword); // Imposto nuova password
                    utenti.set(i, utenteDaAggiornare); // Aggiorno l'utente sulla lista
                    aggiornato = true;
                } else {
                    throw new Exception("La vecchia password non corrisponde.");
                }

            }
        }
        if (!aggiornato) {
            throw new Exception("IOUTENTI: utente da aggiornare non trovato.");
        }
        aggiornaSuFile();
        System.out.println("Aggiornamento password completato per utente con Id: " + utenteDaAggiornare.getId() + ".");
        return utenteDaAggiornare;
    }


    /**
     * Metodo per rimuovere dall'ArrayList intero gli utenti con tipo utente diverso da quello specificato
     *
     * @param filter filtro da applicare
     */
    public void filtraPerTipo(String filter) {
        utenti.removeIf(utente -> !utente.getTipo().equals(filter));
    }

    /**
     * Metodo per rimuovere dall'ArrayList intero gli utenti con email diversa da quello specificata
     *
     * @param filter filtro da applicare
     */
    public void filtraPerEmail(String filter) {
        utenti.removeIf(utente -> !utente.getEmail().equalsIgnoreCase(filter));
    }

    /**
     * Metodo per rimuovere dall'ArrayList intero gli utenti con password diversa da quello specificata
     *
     * @param filter filtro da applicare
     */
    public void filtraPerPassword(String filter) {
        utenti.removeIf(utente -> !utente.getHashPassword().equals(Sha1.sha1(filter)));
    }

    /**
     * Metodo per rimuovere dall'ArrayList intero gli utenti con nickname diverso da quello specificato
     *
     * @param filter filtro da applicare
     */
    public void filtraPerNickname(String filter) {
        utenti.removeIf(utente -> !utente.getNickname().equals(filter));
    }
}
