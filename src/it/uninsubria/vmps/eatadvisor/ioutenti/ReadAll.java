package it.uninsubria.vmps.eatadvisor.ioutenti;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ReadAll {
    public static void main(String[] args) throws IOException {
        Utente[] utenti = new Utente[3];

        for (int i = 0; i < 3; i++) {
            utenti[i] = new Utente();
            utenti[i].setNome("Nome");
            utenti[i].cognome = "cognome";
            //utenti[i].comune = "comune";
        }

        File f = new File("data/EatAdvisor.dati");
        if (f.exists()) {
            f.delete();
            f.createNewFile();
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(utenti);
        out.close();
    }
}
