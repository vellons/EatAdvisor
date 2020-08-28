package eatadvisor.ristoratori;

import eatadvisor.global.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe MenuListener definisce un listener per gli eventi di menu
 *
 * @author Alex Vellone
 */

public class MenuListener implements ActionListener {

    public static JFrame modifyAccount = new JFrame("EatAdvisor Ristoratori - Il mio account");

    @Override
    public void actionPerformed(ActionEvent e) { //Listener che serve quando premo sui Menu Item
        //Codice che reagisce all'azione eseguita dall'utente. L'oggetto ActionEvent fornisce informazioni sull'evento e sulla sua origine
        String scelta = ((JMenuItem) e.getSource()).getText();

        if (scelta.equals("Modifica account")) {
            try {
                modifyAccount.setContentPane(new AccountRistoratore().panelAccountRistoratore); //niente cast
                ristoratori.initUI(modifyAccount);
                modifyAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                modifyAccount.pack();
                modifyAccount.setLocationRelativeTo(null);
                modifyAccount.setVisible(true);
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
            JFrame infoFrame = new JFrame("EatAdvisor ristoratori - Versione");
            ImageIcon imageIcon = new ImageIcon("media/EatAdvisorIcon.png");
            Image image = imageIcon.getImage();
            infoFrame.setIconImage(image);
            infoFrame.setContentPane(new InfoRistoratore().panelInfo);
            infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
            infoFrame.pack();
            infoFrame.setLocationRelativeTo(null);
            infoFrame.setVisible(true);
        }
    }
}