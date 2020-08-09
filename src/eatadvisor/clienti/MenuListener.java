package eatadvisor.clienti;

import eatadvisor.global.Global;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
    public static JFrame mofidyAccount = new JFrame("Il mio account - cliente");
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
            //System.out.println("Funzione ancora non disponibile");
            try {

                mofidyAccount.setContentPane(new AccountCliente().panelAccountCliente);
                clienti.initUI(mofidyAccount);
                mofidyAccount.setLocationRelativeTo(null);
                mofidyAccount.pack();
                mofidyAccount.setVisible(true);
                mofidyAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }


    }
}
