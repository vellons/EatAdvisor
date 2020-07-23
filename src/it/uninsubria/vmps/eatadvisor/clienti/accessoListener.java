package it.uninsubria.vmps.eatadvisor.clienti;
import it.uninsubria.vmps.eatadvisor.ioutenti.IOUtenti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class accessoListener implements ActionListener {
    private String user;
    private String pass;
    private  IOUtenti verifyUser = new IOUtenti();

    public accessoListener(String nick, String psw) throws Exception {
        user = String.valueOf(nick);
        pass = String.valueOf(psw);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // funzione per la verifica della login
        verifyUser.filtraPerNickname(user);
        

    }
}
