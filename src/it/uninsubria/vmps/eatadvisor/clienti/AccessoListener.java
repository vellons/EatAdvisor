package it.uninsubria.vmps.eatadvisor.clienti;

import it.uninsubria.vmps.eatadvisor.ioutenti.IOUtenti;
import it.uninsubria.vmps.eatadvisor.ioutenti.Utente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccessoListener implements ActionListener {
    private String nick;
    private String pass;
    private IOUtenti verifyUser = new IOUtenti();
    private Utente utenteLoggato = null;

    public AccessoListener(String nick, String psw) throws Exception {
        nick = String.valueOf(nick);
        pass = String.valueOf(psw);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // funzione per la verifica della login
        utenteLoggato = null;
        try {
            verifyUser.prelevaDaFile();
        } catch (Exception exception) {
             System.err.println("IOUTENTI: File " + IOUtenti.FILE_UTENTI + " non trovato.");
        }
        System.out.println(verifyUser.getListaUtenti());
        System.out.println("Nickname: " + nick);
        System.out.println("Password: " + pass);
        verifyUser.filtraPerNickname(nick);
        verifyUser.filtraPerPassword(pass);
        System.out.println(verifyUser.getListaUtenti());
        if (verifyUser.getListaUtenti().size() == 1) {
            utenteLoggato = verifyUser.getListaUtenti().get(0); // prendo l'unico utente nella lista
            System.out.println(utenteLoggato);
        } else {
            System.out.println("Username o password sbagliati");
            // TODO: mostrare attraverso una label il messaggio di errore
        }
    }
}
