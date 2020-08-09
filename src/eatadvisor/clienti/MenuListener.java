package eatadvisor.clienti;

import eatadvisor.global.Global;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String scelta = ((JMenuItem) e.getSource()).getText();
        if (scelta.equals("Logout")){
            if (JOptionPane.showOptionDialog(null, "Sei sicuro di voler effettuare il logout?",
                    "Effettuare Logout?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, null, null)== JOptionPane.YES_OPTION){

                Global.utenteLoggato = null;
                System.exit(0);
            }
        }

        else if (scelta.equals("Modifica account")){

        }


    }
}
