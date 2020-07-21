package it.uninsubria.vmps.eatadvisor.ioeatadvisor;

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

    public Ristorante creaNuovoRistorante(int proprietarioId, String tipologia, String nomeRistorante, Indirizzo indirizzo,
                                      String numeroTelefono, String sitoWeb, String urlImmagine) throws Exception {
        prelevaDaFile(); // Mi assicuro di avere nell'ArrayList tutti i ristoranti
        int idSuccessivo = ristoranti.size() + 1;
        Ristorante nuovo = new Ristorante(idSuccessivo, proprietarioId, tipologia, nomeRistorante, indirizzo,
                numeroTelefono, sitoWeb, urlImmagine);
        ristoranti.add(nuovo); // Aggiungo nuovo ristorante alla lista
        aggiornaSuFile();
        System.out.println("Creazione ristorante avvenuta con successo. Assegnato Id: " + nuovo.getId() + ", " +
                "con proprietario: " + proprietarioId + ".");
        return nuovo;
    }

    // TODO: modifica ristorante

    // TODO: filtri ristorante
}
