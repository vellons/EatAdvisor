package eatadvisor.ioeatadvisor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BatchCreaRistoranti {

    final private static int TEST_RISTORANTI = 3;

    public static void main(String[] args) throws IOException {
        ArrayList<Ristorante> ristoranti = new ArrayList<>();

        // Creo utenti "ristoratori"
        for (int i = 1; i <= TEST_RISTORANTI; i++) {
            Ristorante rist = new Ristorante(
                    i,
                    i,
                    "ITALIANO",
                    "Pizza Buona " + i,
                    "Piccola descrizione di Pizza Buona " + i + ".\n.Ottima pizzeria con forno a legna",
                    new Indirizzo("Via le dita dal Naso", String.valueOf(i), "Verbania", "VB", "28922"),
                    "333333333" + i,
                    "https://pizzabuona.it",
                    "https://i2.wp.com/www.pizzerialapacesancarlo.it/wp-content/uploads/2015/12/slideshow-1.jpg?resize=480%2C280"
            );
            ristoranti.add(rist);
            System.out.println(rist.toString());
        }


        // Sovrascrivo nuovi utenti
        File f = new File(IOEatAdvisor.FILE_EAT_ADVISOR);
        if (f.exists()) {
            f.delete();
            f.createNewFile();
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(ristoranti);
        out.close();
        System.err.println("File " + IOEatAdvisor.FILE_EAT_ADVISOR + " ricreato con " +
                TEST_RISTORANTI + " test ristoranti.");
    }
}
