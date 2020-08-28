package eatadvisor.ioutenti;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Questa classe viene usata esclusivamente per test o per ripristinare il contenuto del database.
 * La classe BatchCreaUtenti permette la creazione di due tipologie di utenti: ristoratori e clienti.
 *
 * @author Alex Vellone
 */
public class BatchCreaUtenti {

    /**
     * <code>TEST_RIST</code> &egrave; un valore che rappresenta il numero di utenti di tipo ristoratore da creare.
     * <p>
     * &egrave; dichiarato <strong>final</strong> perch&egrave; difatto rappresenta una costante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * &egrave; dichiarato <strong>static</strong> così da poterlo utlizzare senza istanziare l'oggetto
     */
    final private static int TEST_RIST = 10;

    /**
     * <code>TEST_CLIE</code> &egrave; un valore che rappresenta il numero di utenti di tipo cliente da creare.
     * <p>
     * &egrave; dichiarato <strong>final</strong> perch&egrave; difatto rappresenta una costante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * &egrave; dichiarato <strong>static</strong> così da poterlo utlizzare senza istanziare l'oggetto
     */
    final private static int TEST_CLIE = 20;

    /**
     * Main della classe
     *
     * @param args &egrave; l'array di parametri passati durante l'avvio del programma
     * @throws IOException &egrave; un eccezione che viene lanciata quando il programma non trova il file che si vuole utilizzare
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Utente> utenti = new ArrayList<>();

        // Creo utenti "ristoratori"
        for (int i = 1; i <= TEST_RIST; i++) {
            Utente utente = new Utente(
                    i,
                    "RIST",
                    "ristoratore" + i + "@eat.it",
                    "ristoratore" + i,
                    "Password" + i + "!",
                    "Nome" + i,
                    "Cognome" + i,
                    "Verbania",
                    "VB"
            );
            utenti.add(utente);
            System.out.println(utente.toString());
        }

        // Creo utenti clienti "utenti"
        for (int i = 1; i <= TEST_CLIE; i++) {
            Utente utente = new Utente(
                    TEST_RIST + i,
                    "CLIE",
                    "cliente" + i + "@eat.it",
                    "cliente" + i,
                    "Password" + i + "!",
                    "Nome" + i,
                    "Cognome" + i,
                    "Verbania",
                    "VB"
            );
            utenti.add(utente);
            System.out.println(utente.toString());
        }

        // Sovrascrivo nuovi utenti
        File f = new File(IOUtenti.FILE_UTENTI);
        if (f.exists()) {
            f.delete();
            f.createNewFile();
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(utenti);
        out.close();
        System.err.println("File " + IOUtenti.FILE_UTENTI + " ricreato con " + TEST_RIST + " test ristoratori e " + TEST_CLIE + " test clienti.");
    }
}
