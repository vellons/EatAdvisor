package eatadvisor.ioeatadvisor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BatchCreaRistoranti {

    final private static int TEST_RISTORANTI = 3;
    final private static int TEST_RECENSIONI_PER_RISTORANTE = 6;

    public static void main(String[] args) throws IOException {
        ArrayList<Ristorante> ristoranti = new ArrayList<>();
        String[] tipologia = new String[]{"ITALIANO", "ETNICO", "FUSION"};
        int[] recensioneValutazione = new int[]{4, 1, 5, 3, 4, 5};
        String[] recensioneTesto = new String[]{
                "Buono ma non eccellente, ho dato 4 stelle",
                "Uno schifo... sicuramente non ci tornerò. Prezzi carissimi e personale scortese",
                "Cena fantastica, ristorante TOP! Sicuramente ci tornerò",
                "Nel complesso il cibo era ok, però ho dato 3 stelle perchè ci hanno servito dopo più di un'ora...",
                "Ristorante carino ma forse un pelo caro. Comunque lo consiglio",
                "Ristorante bellissimo, camerieri top e prezzi onesti!"
        };

        // Creo utenti "ristoratori"
        for (int i = 1; i <= TEST_RISTORANTI; i++) {
            Ristorante rist = new Ristorante(
                    i,
                    i,
                    tipologia[i % 3], // Creo ristoranti in tutte le categorie
                    "Pizza Buona " + i,
                    "Piccola descrizione di Pizza Buona " + i + ".\n.Ottima pizzeria con forno a legna",
                    new Indirizzo("Via le dita dal Naso", String.valueOf(i), "Verbania", "VB", "28922"),
                    "333333333" + i,
                    "https://pizzabuona.it",
                    "https://i2.wp.com/www.pizzerialapacesancarlo.it/wp-content/uploads/2015/12/slideshow-1.jpg?resize=480%2C280"
            );
            for (int j = 0; j < TEST_RECENSIONI_PER_RISTORANTE; j++) {
                rist.aggiungiRecensione(new Recensione(5, recensioneValutazione[(i + j) % 6], recensioneTesto[(i + j) % 6]));
            }
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
