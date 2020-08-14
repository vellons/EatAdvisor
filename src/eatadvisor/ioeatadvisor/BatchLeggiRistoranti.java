package eatadvisor.ioeatadvisor;

public class BatchLeggiRistoranti {

    public static void main(String[] args) {
        // Blocco di codice per leggere gli utenti
        IOEatAdvisor ioEatAdvisor = null;
        try {
            ioEatAdvisor = new IOEatAdvisor();
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante la lettura del file.");
            e.printStackTrace();
            System.exit(-1);
        }

        int totaleRistoranti = ioEatAdvisor.getListaRistoranti().size();

        // Blocco di codice per applicare i filtri
        //ioEatAdvisor.prelevaDaFile(); // Rilegge dal file, i filtri non sono più validi
        //ioEatAdvisor.filtraPerTipo("ITALIANO");
        //ioEatAdvisor.filtraPerNomeRistorante("PiZzA BuOnA");
        //ioEatAdvisor.filtraPerCitta("Verb");
        //ioEatAdvisor.filtraPerSiglaProvincia("VB");
        //ioEatAdvisor.filtraPerCap("28922");
        //ioEatAdvisor.filtraPerMediaRecensioniMaggioreOUguale(4);

        // Blocco di codice per stampare i ristoranti
        for (Ristorante r : ioEatAdvisor.getListaRistoranti()) {
            System.out.println(r.toString());
            for (Recensione rec : r.getRecensioni()) {
                System.out.println("\t -> " + rec.toString());
            }
        }
        System.out.println("Filtrati " + ioEatAdvisor.getListaRistoranti().size() + " ristoranti su un totale di " +
                totaleRistoranti + ".");


        // Blocco di codice per creare un ristorante
        /*try {
            ioEatAdvisor.creaNuovoRistorante(1, "ITALIANO", "Pizza Buona 4", "Breve descrizione",
                    new Indirizzo("Via le dita dal Naso", "4", "Verbania", "VB", "28922"),
                    "3333333334", "https://pizzabuona.it",
                    "https://i2.wp.com/www.pizzerialapacesancarlo.it/wp-content/uploads/2015/12/slideshow-1.jpg?resize=480%2C280");
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante la creazione del ristorante.");
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }*/


        // Blocco di codice per modificare un ristorante
        /*try {
            Ristorante daAggiornare = ioEatAdvisor.getRistoranteById(4);
            Ristorante aggiornato = ioEatAdvisor.aggiornaRistoranteById(4, "ITALIANO",
                    "Pizza MOLTO Buona 4", "Nuova descrizione", daAggiornare.getIndirizzo(),
                    daAggiornare.getNumeroTelefono(), daAggiornare.getSitoWeb(), daAggiornare.getUrlImmagine());
            System.out.println(aggiornato);
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante l'aggiornamento del ristorante.");
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }*/


        // Blocco di codice per aggiungere una recensione
        /*try {
            Ristorante aggiornato = ioEatAdvisor.aggiungiRecensioneByIdRistorante(4,
                    new Recensione(1, 4, "Bello ma ho dato 4. Test"));
            System.out.println(aggiornato);
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante l'aggiunta della recensione.");
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }*/
    }
}
