package eatadvisor.ioeatadvisor;

import java.io.*;
import java.util.ArrayList;

public class IOEatAdvisor {

    public static final String FILE_EAT_ADVISOR = "data/EatAdvisor.dati";
    private ArrayList<Ristorante> ristoranti = new ArrayList<>();

    public IOEatAdvisor() throws Exception {
        prelevaDaFile();
    }

    public ArrayList<Ristorante> getListaRistoranti() {
        return ristoranti;
    }

    public Ristorante getRistoranteById(int id) throws Exception {
        prelevaDaFile();
        for (int i = 0; i < ristoranti.size(); i++) { // Scorro la lista dei ristoranti
            if (ristoranti.get(i).getId() == id) {
                return ristoranti.get(i);
            }
        }
        throw new Exception("IOEATADVISOR: ristorante non trovato.");
    }

    public void prelevaDaFile() throws Exception {
        // Prendo tutti i ristoranti salvati nel file e li carico all'interno di ArrayList<Ristorante>
        File f = new File(FILE_EAT_ADVISOR);
        if (!f.exists()) {
            throw new Exception("IOEATADVISOR: File " + FILE_EAT_ADVISOR + " non trovato.");
        }

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        try {
            this.ristoranti = (ArrayList) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
            throw new Exception("IOEATADVISOR: File " + FILE_EAT_ADVISOR + " corrotto, serializzazione non riuscita.");
        }
    }

    private void aggiornaSuFile() throws Exception {
        // Sovrascrive i ristoranti esistenti nel file con quelli all'interno di ArrayList<Ristorante>
        File f = new File(FILE_EAT_ADVISOR);
        if (f.exists()) {
            f.delete();
            f.createNewFile();
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(ristoranti);
        out.close();
        System.out.println("File " + FILE_EAT_ADVISOR + " aggiornato con " + ristoranti.size() + " ristoranti.");
    }

    public Ristorante creaNuovoRistorante(int proprietarioId, String tipologia, String nomeRistorante,
                                          String descrizione, Indirizzo indirizzo, String numeroTelefono,
                                          String sitoWeb) throws Exception {
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti i ristoranti
        int idSuccessivo = ristoranti.size() + 1;
        Ristorante nuovo = new Ristorante(idSuccessivo, proprietarioId, tipologia, nomeRistorante, descrizione,
                indirizzo, numeroTelefono, sitoWeb);
        ristoranti.add(nuovo); // Aggiungo nuovo ristorante alla lista
        aggiornaSuFile();
        System.out.println("Creazione ristorante avvenuta con successo. Assegnato Id: " + nuovo.getId() + ", " +
                "con proprietario: " + proprietarioId + ".");
        return nuovo;
    }

    public Ristorante aggiornaRistoranteById(int id, String tipologia, String nomeRistorante, String descrizione,
                                             Indirizzo indirizzo, String numeroTelefono, String sitoWeb) throws Exception {
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti i ristoranti
        Ristorante ristoranteDaAggiornare = null;
        boolean aggiornato = false;
        for (int i = 0; i < ristoranti.size(); i++) { // Scorro la lista dei ristoranti
            if (ristoranti.get(i).getId() == id) {
                ristoranteDaAggiornare = ristoranti.get(i);
                ristoranteDaAggiornare.setTipologia(tipologia);
                ristoranteDaAggiornare.setNomeRistorante(nomeRistorante);
                ristoranteDaAggiornare.setDescrizione(descrizione);
                ristoranteDaAggiornare.setIndirizzo(indirizzo);
                ristoranteDaAggiornare.setNumeroTelefono(numeroTelefono);
                ristoranteDaAggiornare.setSitoWeb(sitoWeb);
                ristoranti.set(i, ristoranteDaAggiornare); // Aggiorno il ristorante sulla lista
                aggiornato = true;
            }
        }
        if (!aggiornato) {
            throw new Exception("IOEATADVISOR: ristorante da aggiornare non trovato.");
        }
        aggiornaSuFile();
        System.out.println("Aggiornamento eseguito per il ristorante con Id: " + ristoranteDaAggiornare.getId() + ".");
        return ristoranteDaAggiornare;
    }

    public Ristorante aggiungiRecensioneByIdRistorante(int id, Recensione recensione) throws Exception {
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti i ristoranti
        Ristorante ristoranteDaAggiornare = null;
        boolean aggiornato = false;
        for (int i = 0; i < ristoranti.size(); i++) { // Scorro la lista dei ristoranti
            if (ristoranti.get(i).getId() == id) {
                ristoranteDaAggiornare = ristoranti.get(i);
                ristoranteDaAggiornare.aggiungiRecensione(recensione);
                ristoranti.set(i, ristoranteDaAggiornare); // Aggiorno il ristorante sulla lista
                aggiornato = true;
            }
        }
        if (!aggiornato) {
            throw new Exception("IOEATADVISOR: ristorante su cui aggiungere la recensione non trovato.");
        }
        aggiornaSuFile();
        System.out.println("Recensione aggiunta per il ristorante con Id: " + ristoranteDaAggiornare.getId() + ".");
        return ristoranteDaAggiornare;
    }


    public void filtraPerTipo(String filter) {
        ristoranti.removeIf(rist -> !rist.getTipologia().equals(filter));
    }

    public void filtraPerNomeRistorante(String filter) {
        ristoranti.removeIf(rist -> !rist.getNomeRistorante().toLowerCase().contains(filter.toLowerCase()));
    }

    public void filtraPerCitta(String filter) {
        ristoranti.removeIf(rist -> !rist.getIndirizzo().getCitta().toLowerCase().contains(filter.toLowerCase()));
    }

    public void filtraPerSiglaProvincia(String filter) {
        ristoranti.removeIf(rist -> !rist.getIndirizzo().getSiglaProvincia().equalsIgnoreCase(filter));
    }

    public void filtraPerCap(String filter) {
        ristoranti.removeIf(rist -> !rist.getIndirizzo().getCap().equalsIgnoreCase(filter));
    }

    public void filtraPerMediaRecensioniMaggioreOUguale(double filter) {
        ristoranti.removeIf(rist -> rist.getRecensioniValutazioneMedia() < filter);
    }

    public void filtraPerProprietarioId(int filter) {
        ristoranti.removeIf(rist -> rist.getProprietarioId() != filter);
    }
}
