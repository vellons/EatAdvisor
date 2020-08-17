package eatadvisor.ioutenti;

import java.io.*;
import java.util.ArrayList;

public class IOUtenti {

    public static final String FILE_UTENTI = "data/Utenti.dati";
    private ArrayList<Utente> utenti = new ArrayList<>();

    public IOUtenti() throws Exception {
        prelevaDaFile();
    }

    public ArrayList<Utente> getListaUtenti() {
        return utenti;
    }

    public Utente getUtenteById(int id) throws Exception {
        prelevaDaFile();
        for (int i = 0; i < utenti.size(); i++) { // Scorro la lista degli utenti
            if (utenti.get(i).getId() == id) {
                return utenti.get(i);
            }
        }
        throw new Exception("IOUTENTI: utente non trovato.");
    }

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

    public Utente creaNuovoUtente(String tipo, String email, String nickname, String plaintextPassword,
                                  String nome, String cognome, String comune, String siglaProvincia) throws Exception {
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti gli utenti
        filtraPerEmail(email); // Controllo se la email è già stata utilizzata
        if (utenti.size() > 0) {
            throw new Exception("Email già utilizzata.");
        }
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti gli utenti
        filtraPerNickname(nickname); // Controllo se il nickname è già stato utilizzato
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

    public Utente aggiornaPasswordById(int id, String oldPassword, String newPassword) throws Exception {
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti gli utenti
        Utente utenteDaAggiornare = null;
        boolean aggiornato = false;
        for (int i = 0; i < utenti.size(); i++) { // Scorro la lista degli utenti
            if (utenti.get(i).getId() == id) { // Ho trovato l'utente
                utenteDaAggiornare = utenti.get(i);
                if (oldPassword.toLowerCase().equals(newPassword.toLowerCase())) {
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


    public void filtraPerTipo(String filter) {
        utenti.removeIf(utente -> !utente.getTipo().equals(filter));
    }

    public void filtraPerEmail(String filter) {
        utenti.removeIf(utente -> !utente.getEmail().equalsIgnoreCase(filter));
    }

    public void filtraPerPassword(String filter) {
        utenti.removeIf(utente -> !utente.getHashPassword().equals(Sha1.sha1(filter)));
    }

    public void filtraPerNickname(String filter) {
        utenti.removeIf(utente -> !utente.getNickname().equals(filter));
    }

    public void filtraPerNome(String filter) {
        utenti.removeIf(utente -> !utente.getNome().toLowerCase().contains(filter.toLowerCase()));
    }

    public void filtraPerCognome(String filter) {
        utenti.removeIf(utente -> !utente.getCognome().toLowerCase().contains(filter.toLowerCase()));
    }

    public void filtraPerComune(String filter) {
        utenti.removeIf(utente -> !utente.getComune().equalsIgnoreCase(filter));
    }

    public void filtraPerSiglaProvincia(String filter) {
        utenti.removeIf(utente -> !utente.getSiglaProvincia().equalsIgnoreCase(filter));
    }
}
