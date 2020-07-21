package it.uninsubria.vmps.eatadvisor.ioutenti;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BatchCreaUtenti {

    final private static int TEST_RIST = 3;
    final private static int TEST_CLIE = 7;

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
        System.out.println("File ricreato con " + TEST_RIST + " test ristoratori e " + TEST_CLIE + " test clienti.");
    }
}
