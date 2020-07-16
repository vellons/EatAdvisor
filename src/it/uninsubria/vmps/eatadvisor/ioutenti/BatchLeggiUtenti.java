package it.uninsubria.vmps.eatadvisor.ioutenti;

public class BatchLeggiUtenti {

    public static void main(String[] args) {
        IOUtenti ioUtenti = null;
        try {
            ioUtenti = new IOUtenti();
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante la lettura del file.");
            e.printStackTrace();
            System.exit(-1);
        }

        int totaleUtenti = ioUtenti.getListaUtenti().size();

        // Test filters
        //ioUtenti.filtraPerId(3);
        //ioUtenti.filtraPerEmail("cliente3@eat.it");
        //ioUtenti.filtraPerPassword("Password3!");
        //ioUtenti.filtraPerNickname("cliente3");
        //ioUtenti.filtraPerNome("Nome3");
        //ioUtenti.filtraPerCognome("Cognome3");
        //ioUtenti.filtraPerTipo("CLIE");
        //ioUtenti.filtraPerComune("Verbania");
        //ioUtenti.filtraPerSiglaProvincia("VB");
        //ioUtenti.prelevaDaFile(); // Rilegge dal file, i filtri non sono più validi

        for (Utente u : ioUtenti.getListaUtenti()) {
            System.out.println(u.toString());
        }

        System.out.println("Filtrati " + ioUtenti.getListaUtenti().size() + " utenti su un totale di " + totaleUtenti + ".");


        // Test creazione utente
        /*try {
            ioUtenti.creaNuovoUtente("CLIE", "cliente8@eat.it", "cliente8",
                    "Password8!","Nome", "Cognome", "Verbania", "VB");
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante la creazione dell'utente.");
            e.printStackTrace();
            System.exit(-1);
        }*/

        // Test aggiornamento utente
        /*try {
            Utente aggiornato = ioUtenti.aggiornaUtenteById(11, "NomeNuovo", "Cognome", "Milano", "MI");
            System.out.println(aggiornato.getSiglaProvincia());
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante l'aggiornamento dell'utente.");
            e.printStackTrace();
            System.exit(-1);
        }*/
    }
}
