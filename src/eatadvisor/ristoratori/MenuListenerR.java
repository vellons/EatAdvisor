package eatadvisor.ristoratori;

import eatadvisor.global.Global;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListenerR implements ActionListener {
    public static JFrame modifyAccount = new JFrame("EatAdvisor Ristoratori - Il mio account");

    @Override
    public void actionPerformed(ActionEvent e) {
        String scelta = ((JMenuItem) e.getSource()).getText();
        if (scelta.equals("Logout")) {
            if (JOptionPane.showOptionDialog(null, "Sei sicuro di voler effettuare il logout?",
                    "Effettuare Logout?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, null, null) == JOptionPane.YES_OPTION) {

                Global.utenteLoggato = null;
                System.exit(0);
            }
        } else if (scelta.equals("Modifica account")) {
            try {
    //            modifyAccount.setContentPane(new AccountRistoratore().panelAccountCliente);
                ristoratori.initUI(modifyAccount);
                modifyAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                modifyAccount.pack();
                modifyAccount.setLocationRelativeTo(null);
                modifyAccount.setVisible(true);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
