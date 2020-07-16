package it.uninsubria.vmps.eatadvisor.ioutenti;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BatchCreaUtenti {

    final private static int TEST_CLIE = 7;
    final private static int TEST_RIST = 3;

    public static void main(String[] args) throws IOException {
        ArrayList<Utente> utenti = new ArrayList<>();

        for (int i = 1; i <= TEST_CLIE; i++) {
            Utente utente = new Utente();
            utente.setId(i);
            utente.setTipo("CLIE");
            utente.setEmail("cliente" + i + "@eat.it");
            utente.setNickname("cliente" + i);
            utente.setPasswordAndHash("Password" + i + "!");
            utente.setNome("Nome" + i);
            utente.setCognome("Cognome" + i);
            utente.setComune("Verbania");
            utente.setSiglaProvincia("VB");
            utenti.add(utente);
            System.out.println(utente.toString());
        }

        for (int i = 1; i <= TEST_RIST; i++) {
            Utente utente = new Utente();
            utente.setId(TEST_CLIE + i);
            utente.setTipo("RIST");
            utente.setEmail("ristoratore" + i + "@eat.it");
            utente.setNickname("ristoratore" + i);
            utente.setPasswordAndHash("Password" + i + "!");
            utente.setNome("Nome" + i);
            utente.setCognome("Cognome" + i);
            utente.setComune("Verbania");
            utente.setSiglaProvincia("VB");
            utenti.add(utente);
            System.out.println(utente.toString());
        }

        File f = new File(IOUtenti.FILE_UTENTI);
        if (f.exists()) {
            f.delete();
            f.createNewFile();
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(utenti);
        out.close();
        System.out.println("File ricreato con " + TEST_CLIE + " test clienti e " + TEST_RIST + " test ristoratori.");
    }
}
