package it.uninsubria.vmps.eatadvisor.ioutenti;

import java.io.*;
import java.util.ArrayList;

public class BatchLeggiUtenti {

    public static void main(String[] args) throws IOException {
        File f = new File(IOUtenti.FILE_UTENTI);
        if (!f.exists()) {
            System.err.println("File " + IOUtenti.FILE_UTENTI + " non trovato");
            System.exit(-1);
        }

        ArrayList<Utente> utenti = new ArrayList<>();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        try {
            utenti = (ArrayList) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Error during deserialization");
            e.printStackTrace();
            in.close();
            System.exit(-1);
        }

        for (Utente u : utenti) {
            System.out.println(u.toString());
        }
        System.out.println("Sono presenti " + utenti.size() + " utenti.");
    }
}
