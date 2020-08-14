package eatadvisor.ristoratori;

import eatadvisor.clienti.AccountCliente;
import eatadvisor.clienti.clienti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListenerRistoratori implements ActionListener {

    public static JFrame modifyAccount = new JFrame("EatAdvisor Clienti - Il mio account");

    @Override
    public void actionPerformed(ActionEvent e) { //Listener che serve quando premo sui Menu Item
        //Codice che reagisce all'azione eseguita dall'utente. L'oggetto ActionEvent fornisce informazioni sull'evento e sulla sua origine
        String scelta = ((JMenuItem) e.getSource()).getText();

        if (scelta.equals("Modifica account")) {
            try {
                //Vogliamo settare il panel (contenuto interno) del frame.
                modifyAccount.setContentPane(new AccountRistoratore().panelAccountRistoratore); //niente cast
                //mofidyAccount.setContentPane(new AccountCliente().panelAccountCliente);
                clienti.initUI(modifyAccount);
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