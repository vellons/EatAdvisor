package it.uninsubria.vmps.eatadvisor.ioeatadvisor;


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
        //ioUtenti.prelevaDaFile(); // Rilegge dal file, i filtri non sono più validi

        // Blocco di codice per stampare gli utenti
        for (Ristorante r : ioEatAdvisor.getListaRistoranti()) {
            System.out.println(r.toString());
        }
        System.out.println("Filtrati " + ioEatAdvisor.getListaRistoranti().size() + " ristoranti su un totale di " +
                totaleRistoranti + ".");


        // Blocco di codice per creare un ristorante
        try {
            ioEatAdvisor.creaNuovoRistorante(1, "ITALIANO", "Pizza Buona 4",
                    new Indirizzo("Via le dita dal Naso", "4", "Verbania", "VB", "28922"),
                    "3333333334", "https://pizzabuona.it",
                    "https://i2.wp.com/www.pizzerialapacesancarlo.it/wp-content/uploads/2015/12/slideshow-1.jpg?resize=480%2C280");
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante la creazione del ristorante.");
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }


        // TODO: Blocco di codice per modificare un ristorante

    }
}
