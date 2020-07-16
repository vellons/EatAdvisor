package it.uninsubria.vmps.eatadvisor.ioutenti;

public class BatchLeggiUtenti {

    public static void main(String[] args) {
        IOUtenti ioUtenti = null;
        try {
            ioUtenti = new IOUtenti();
        } catch (Exception e) {
            System.err.println("Si sono verificati problemi durante la lettura del file");
            System.err.print(e.toString());
            System.exit(-1);
        }

        int totaleUtenti = ioUtenti.utenti.size();

        // To test filters
        //ioUtenti.getUtentiDaFile();
        //ioUtenti.filtraPerId(3);
        //ioUtenti.filtraPerEmail("cliente3@eat.it");
        //ioUtenti.filtraPerPassword("Password3!");
        //ioUtenti.filtraPerNickname("cliente3");
        //ioUtenti.filtraPerNome("Nome3");
        //ioUtenti.filtraPerCognome("Cognome3");
        //ioUtenti.filtraPerTipo("CLIE");
        //ioUtenti.filtraPerComune("Verbania");
        //ioUtenti.filtraPerSiglaProvincia("VB");

        for (Utente u : ioUtenti.utenti) {
            System.out.println(u.toString());
        }

        System.out.println("Filtrati " + ioUtenti.utenti.size() + " utenti su un totale di " + totaleUtenti + ".");
    }
}
