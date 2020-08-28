package eatadvisor.ioeatadvisor;

import java.io.*;
import java.util.ArrayList;

/**
 * La classe IOEatAdvisor permette di creare un middleware tra database e applicazioni
 * per gestire le informazioni dei ristoranti e delle loro recensioni.
 *
 * @author Alex Vellone
 */
public class IOEatAdvisor {

    /**
     * <code>FILE_UTENTI</code> &egrave; il percorso relativo del file sul quale sono salvate le informazioni sui ristoranti
     * e le loro recensioni
     * <p>
     * &egrave; dichiarato <strong>final</strong> perch&egrave; difatto rappresenta una costante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * &egrave; dichiarato <strong>static</strong> cos&igrave; da poterlo utlizzare senza istanziare l'oggetto
     */
    public static final String FILE_EAT_ADVISOR = "data/EatAdvisor.dati";

    /**
     * <code>ristoranti</code> &egrave; un ArrayList nel quale la classe esegue le operazioni base per
     * manipolare la lista dei ristoranti
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private ArrayList<Ristorante> ristoranti = new ArrayList<>();

    /**
     * Costrutore della classe, che una volta istanziata preleva automaticamente tutte le informazioni dal file
     *
     * @throws Exception &egrave; sollevara quando si verificano problemi di lettura sul file
     */
    public IOEatAdvisor() throws Exception {
        prelevaDaFile();
    }

    /**
     * @return la lista dei ristoranti
     */
    public ArrayList<Ristorante> getListaRistoranti() {
        return ristoranti;
    }

    /**
     * @param id &egrave; l'id del ristorante da cercaare
     * @return l'oggetto ristorante trovato
     * @throws Exception &egrave; utilizzata per informare che il ristorante cercato non &egrave; stato trovato
     */
    public Ristorante getRistoranteById(int id) throws Exception {
        prelevaDaFile();
        for (int i = 0; i < ristoranti.size(); i++) { // Scorro la lista dei ristoranti
            if (ristoranti.get(i).getId() == id) {
                return ristoranti.get(i);
            }
        }
        throw new Exception("IOEATADVISOR: ristorante non trovato.");
    }

    /**
     * Preleva tutte le informazioni salvate sui file e le salva nell'ArrayList interno
     *
     * @throws Exception &egrave; sollevara quando si verificano problemi di lettura sul file
     */
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

    /**
     * Salva le informazini presenti nell'ArrayList interno sul file, sovrascrivendolo
     *
     * @throws Exception &egrave; sollevara quando si verificano problemi di accesso sul file
     */
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

    /**
     * Crea un nuovo ristorante con le informazioni date
     *
     * @param proprietarioId &egrave; l'id dell'utente ristoratore a cui appartiene il ristorante
     * @param tipologia      &egrave; la tipologia del ristorante
     * @param nomeRistorante &egrave; il nome del ristorante
     * @param descrizione    &egrave; la descrizione del ristorante
     * @param indirizzo      &egrave; l'indirizzo del ristorante
     * @param numeroTelefono &egrave; il numero di telefono del ristorante
     * @param sitoWeb        &egrave; il sito web del ristorante
     * @return l'oggetto ristorante creato
     * @throws Exception &egrave; sollevara quando si verificano problemi di accesso sul file
     */
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

    /**
     * Aggiorna le informazini nase di un ristorante
     *
     * @param id             &egrave; l'id del risotante su cui voglio modificare le informazioni
     * @param tipologia      &egrave; la tipologia del ristorante
     * @param nomeRistorante &egrave; il nome del ristorante
     * @param descrizione    &egrave; la descrizione del ristorante
     * @param indirizzo      &egrave; l'indirizzo del ristorante
     * @param numeroTelefono &egrave; il numero di telefono del ristorante
     * @param sitoWeb        &egrave; il sito web del ristorante
     * @return l'oggetto ristorante aggiornato
     * @throws Exception &egrave; sollevara quando si verificano problemi di accesso sul file o
     *                   il ristorante da aggiornare non &egrave; stato torvato
     */
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

    /**
     * Aggiunge una recensione alla lista delle recensioni del ristorante
     *
     * @param id         &egrave; l'id del ristorante sul quale aggiungere le recensione
     * @param recensione &egrave; l'oggetto contenente le informazioni sulla recensione
     * @return l'oggetto ristorante aggiornato
     * @throws Exception &egrave; sollevara quando si verificano problemi di accesso sul file o
     *                   il ristorante da aggiornare non &egrave; stato torvato
     */
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

    /**
     * Metodo per rimuovere dall'ArrayList intero i ristoranti con tipo ristorante diverso da quello specificato
     *
     * @param filter filtro da applicare
     */
    public void filtraPerTipo(String filter) {
        ristoranti.removeIf(rist -> !rist.getTipologia().equals(filter));
    }

    /**
     * Metodo per rimuovere dall'ArrayList intero i ristoranti con nome ristorante diverso da quello specificato
     *
     * @param filter filtro da applicare
     */
    public void filtraPerNomeRistorante(String filter) {
        ristoranti.removeIf(rist -> !rist.getNomeRistorante().toLowerCase().contains(filter.toLowerCase()));
    }

    /**
     * Metodo per rimuovere dall'ArrayList intero i ristoranti con citt&agrave; diverso da quello specificato
     *
     * @param filter filtro da applicare
     */
    public void filtraPerCitta(String filter) {
        ristoranti.removeIf(rist -> !rist.getIndirizzo().getCitta().toLowerCase().contains(filter.toLowerCase()));
    }

    /**
     * Metodo per rimuovere dall'ArrayList intero i ristoranti con sigla della provincia diverso da quello specificato
     *
     * @param filter filtro da applicare
     */
    public void filtraPerSiglaProvincia(String filter) {
        ristoranti.removeIf(rist -> !rist.getIndirizzo().getSiglaProvincia().equalsIgnoreCase(filter));
    }

    /**
     * Metodo per rimuovere dall'ArrayList intero i ristoranti con cap diverso da quello specificato
     *
     * @param filter filtro da applicare
     */
    public void filtraPerCap(String filter) {
        ristoranti.removeIf(rist -> !rist.getIndirizzo().getCap().equalsIgnoreCase(filter));
    }

    /**
     * Metodo per rimuovere dall'ArrayList intero i ristoranti con media recensione diversa da quello specificata
     *
     * @param filter filtro da applicare
     */
    public void filtraPerMediaRecensioniMaggioreOUguale(double filter) {
        ristoranti.removeIf(rist -> rist.getRecensioniValutazioneMedia() < filter);
    }

    /**
     * Metodo per rimuovere dall'ArrayList intero i ristoranti con id proprietario diverso da quello specificato
     *
     * @param filter filtro da applicare
     */
    public void filtraPerProprietarioId(int filter) {
        ristoranti.removeIf(rist -> rist.getProprietarioId() != filter);
    }
}
