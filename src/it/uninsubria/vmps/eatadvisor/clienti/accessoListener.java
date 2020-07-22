package it.uninsubria.vmps.eatadvisor.clienti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class accessoListener implements ActionListener {
    private String user;
    private String pass;

    public accessoListener(String nick, String psw){
        user = nick.toString();
        pass = String.valueOf(psw);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       /* //System.out.println("Hai cliccato il bottone");
        if (user.equals("Manuel")){
            if (pass.equals("abcd")){
                System.out.println("Email e password corretti");
            }
            else{
                System.out.println("Email e/o password errati secondo else");
            }
        }
        else{
            System.out.println("Email e/o password errati primo else");
        }*/
        // funzione per la verifica della login
    }
}
