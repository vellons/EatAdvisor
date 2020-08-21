package eatadvisor.ioeatadvisor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * La classe BatchCreaRistoranti permette la creazione dei ristoranti, aggiungendo anche le
 * relative recensioni
 *
 * @author Alex Vellone
 */
public class BatchCreaRistoranti {

    /**
     * <code>TEST_RISTORANTI</code> è un valore che rappresenta il numero di ristoranti.
     * <p>
     * è dichiarato <strong>final</strong> perchè difatto rappresenta una costante
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * è dichiarato <strong>static</strong> così da non doverlo istanziare creando un oggetto
     */
    final private static int TEST_RISTORANTI = 10;
    /**
     * <code>TEST_RECENSIONI_PER_RISTORANTE</code> è un valore che rappresenta il numero di recensioni
     * per ristorante.
     * <p>
     * è dichiarato <strong>final</strong> perchè difatto rappresenta una costante
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * è dichiarato <strong>static</strong> così da non doverlo istanziare creando un oggetto
     */
    final private static int TEST_RECENSIONI_PER_RISTORANTE = 8;

    /**
     * Main della classe
     *
     * @param args è nome dell'array di stringhe
     * @throws IOException è un eccezione che viene lanciata quando il programma non trova il file che si vuole utilizzare
     */
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
                    "Ristorante " + i,
                    "La fantasia dei nostri chef non vi annoierà mai proponendo piatti sempre diversi e sfiziosi.\\nLa cura e la scelta degli ingredienti nostrani e genuini vi delizierà.\\nIl servizio accurato, l'eleganza delle nostre sale vi faranno sentire a vostro agio.\\nLa disponibilità e la cordialità del personale vi coccoleranno.\\n\\nAvrete sempre a disposizione un'ampia scelta di verdure sul nostro buffet da condire con il rinomato olio della nostra terra.\\n\\nPotrete sempre scegliere tra un piatto di terra, di mare o uno dei nostri terzi piatti sfiziosi, una minestra o un piatto freddo.\\n\\nCome ultima portata avrete sempre la scelta tra la frutta di stagione, una macedonia di frutta fresca condita, un gelato o uno dei dessert preparati dal nostro chef pasticcere.",
                    new Indirizzo("Via le dita dal Naso", String.valueOf(i), "Verbania", "VB", "28922"),
                    "333333333" + i,
                    "https://pizzabuona.it"
            );
            for (int j = 0; j < TEST_RECENSIONI_PER_RISTORANTE; j++) {
                rist.aggiungiRecensione(new Recensione(TEST_RISTORANTI + 1  + j, recensioneValutazione[(i + j) % 6], recensioneTesto[(i + j) % 6]));
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
