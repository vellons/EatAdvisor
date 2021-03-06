package eatadvisor.clienti;

import eatadvisor.global.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe MenuListener definisce un listener per gli eventi di menu
 *
 * @author Manuel Macaj
 */

public class MenuListener implements ActionListener {


    public static JFrame mofidyAccount = new JFrame("EatAdvisor Clienti - Il mio account");

    /**
     * @param e &egrave; l'evento che deve essere processato
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String scelta = ((JMenuItem) e.getSource()).getText();
        if (scelta.equals("Modifica account")) {
            try {
                mofidyAccount.setContentPane(new AccountCliente().panelAccountCliente);
                clienti.initUI(mofidyAccount);
                mofidyAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                mofidyAccount.pack();
                mofidyAccount.setLocationRelativeTo(null);
                mofidyAccount.setVisible(true);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (scelta.equals("Logout")) {
            if (JOptionPane.showOptionDialog(null, "Sei sicuro di voler effettuare il logout?",
                    "Effettuare Logout?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, null, null) == JOptionPane.YES_OPTION) {

                Global.utenteLoggato = null;
                System.exit(0);
            }
        } else if (scelta.equals("Versione")) {
            JFrame infoFrame = new JFrame("EatAdvisor clienti - Versione");
            ImageIcon imageIcon = new ImageIcon("media/EatAdvisorIcon.png");
            Image image = imageIcon.getImage();
            infoFrame.setIconImage(image);
            infoFrame.setContentPane(new InfoCliente().panelInfo);
            infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
            infoFrame.pack();
            infoFrame.setLocationRelativeTo(null);
            infoFrame.setVisible(true);
        }
    }
}
