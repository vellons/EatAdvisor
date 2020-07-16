package it.uninsubria.vmps.eatadvisor.ioutenti;

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

    public void prelevaDaFile() throws Exception {
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

    private void aggiornaUtentiSuFile() throws IOException {
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
        prelevaDaFile(); // Mi assicuro di averre nell'ArrayList tutti gli utenti
        // TODO: controllare unicità email e nickname
        int idSuccessivo = utenti.size() + 1;
        Utente nuovo = new Utente(idSuccessivo, tipo, email, nickname, plaintextPassword, nome, cognome,
                comune, siglaProvincia);
        utenti.add(nuovo); // Aggiorno nuovo utente alla lista
        aggiornaUtentiSuFile();
        System.out.println("Creazione utente avvenuta con successo");
        return nuovo;
    }

    public Utente aggiornaUtenteById(int id, String nome, String cognome, String comune, String siglaProvincia) throws Exception {
        prelevaDaFile(); // Mi assicuro di averre nell'ArrayList tutti gli utenti
        Utente utenteDaAggiornare = new Utente();
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
            throw new Exception("IOUTENTI: utente da aggiornare non trovato");
        }
        aggiornaUtentiSuFile();
        System.out.println("Aggiornamento utente avvenuta con successo");
        return utenteDaAggiornare;
    }

    // TODO: creare metodo modifica password

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
