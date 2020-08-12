package eatadvisor.ristoratori;

import eatadvisor.clienti.AccountCliente;
import eatadvisor.clienti.clienti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListenerRistoratori implements ActionListener{

    public static JFrame modifyAccount = new JFrame("EatAdvisor Clienti - Il mio account");

    @Override
    public void actionPerformed(ActionEvent e) {

        String scelta = ((JMenuItem)e.getSource()).getText();

        if (scelta.equals("Modifica account")){
            try {
                modifyAccount.setContentPane((Container) new AccountRistoratore().panelAccountRistoratore);
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