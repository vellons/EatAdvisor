package it.uninsubria.vmps.eatadvisor.ioutenti;

public class BatchLeggiUtenti {

    public static void main(String[] args) {
        // Blocco di codice per leggere gli utenti
        IOUtenti ioUtenti = null;
        try {
            ioUtenti = new IOUtenti();
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante la lettura del file.");
            e.printStackTrace();
            System.exit(-1);
        }

        int totaleUtenti = ioUtenti.getListaUtenti().size();

        // Blocco di codice per applicare i filtri
        //ioUtenti.filtraPerEmail("cliente3@eat.it");
        //ioUtenti.filtraPerPassword("Password3!");
        //ioUtenti.filtraPerNickname("cliente3");
        //ioUtenti.filtraPerNome("Nome3");
        //ioUtenti.filtraPerCognome("Cognome3");
        //ioUtenti.filtraPerTipo("CLIE");
        //ioUtenti.filtraPerComune("Verbania");
        //ioUtenti.filtraPerSiglaProvincia("VB");
        //ioUtenti.prelevaDaFile(); // Rilegge dal file, i filtri non sono più validi

        // Blocco di codice per stampare gli utenti
        for (Utente u : ioUtenti.getListaUtenti()) {
            System.out.println(u.toString());
        }
        System.out.println("Filtrati " + ioUtenti.getListaUtenti().size() + " utenti su un totale di " + totaleUtenti + ".");


        // Blocco di codice per creare un utente
        /*try {
            ioUtenti.creaNuovoUtente("CLIE", "cliente8@eat.it", "cliente8",
                    "Password8!","Nome", "Cognome", "Verbania", "VB");
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante la creazione dell'utente.");
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }*/


        // Blocco di codice per modificare un utente
        /*try {
            Utente aggiornato = ioUtenti.aggiornaUtenteById(11, "NomeNuovo", "CognomeNuovo", "Milano", "MI");
            System.out.println(aggiornato);
            System.out.println(aggiornato.getSiglaProvincia());
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante l'aggiornamento dell'utente.");
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }*/


        // Blocco di codice per modificare la password di un utente
        /*try {
            System.out.println(ioUtenti.getListaUtenti().get(10).getHashPassword());
            Utente aggiornato = ioUtenti.aggiornaPasswordById(11, "Password8!", "Password888!");
            System.out.println(ioUtenti.getListaUtenti().get(10).getHashPassword());
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante l'aggiornamento della password dell'utente.");
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }*/
    }
}
