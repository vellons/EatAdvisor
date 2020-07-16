package it.uninsubria.vmps.eatadvisor.ioutenti;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IOUtenti {

    public static final String FILE_UTENTI = "data/Utenti.dati";
    public ArrayList<Utente> utenti = new ArrayList<>();

    public IOUtenti() throws Exception {
        getUtentiDaFile();
    }

    public void getUtentiDaFile() throws Exception {
        File f = new File(FILE_UTENTI);
        if (!f.exists()) {
            throw new Exception("IOUTENTI: File " + FILE_UTENTI + " non trovato");
        }

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        try {
            this.utenti = (ArrayList) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
            throw new Exception("IOUTENTI: File " + FILE_UTENTI + " corrotto, serializzazione non riuscita");
        }
    }

    public void filtraPerId(int filter) {
        utenti.removeIf(utente -> utente.getId() != filter);
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
        utenti.removeIf(utente -> !utente.getNome().equalsIgnoreCase(filter));
    }

    public void filtraPerCognome(String filter) {
        utenti.removeIf(utente -> !utente.getCognome().equalsIgnoreCase(filter));
    }

    public void filtraPerComune(String filter) {
        utenti.removeIf(utente -> !utente.getComune().equalsIgnoreCase(filter));
    }

    public void filtraPerSiglaProvincia(String filter) {
        utenti.removeIf(utente -> !utente.getSiglaProvincia().equalsIgnoreCase(filter));
    }
}
