package eatadvisor.ristoratori;

import eatadvisor.clienti.MenuListener;
import eatadvisor.clienti.clienti;
import eatadvisor.global.Global;
import eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AccountRistoratore {
    public Object panelAccountRistoratore; //Mostro informazioni ristoratore
    private JLabel lblNome;
    private JLabel lblCognome;
    private JLabel lblComune;
    private JLabel lblSiglaProvincia;
    private JLabel lblEmail;
    private JTextField tfNome;
    private JTextField tfCognome;
    private JTextField tfComune;
    private JTextField tfSiglaProvincia;
    private JTextField tfEmail;
    private JButton btnChangeAccountRistoratore;
    private JButton btnChangePswRistoratore;
    private JPanel panelLogo;
    IOUtenti aggiornaRistoratori = null;

    public AccountRistoratore(){ //Modifica

        btnChangeAccountRistoratore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    aggiornaRistoratori = new IOUtenti();
                    if (!checkAllInputs()) { // Verifico che tutti i campi siano completi
                        JOptionPane.showMessageDialog(null, "Attenzione, tutti i " +
                                "campi devono essere completati!", "Errore", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (JOptionPane.showOptionDialog(null, "Confermi di voler modificare modificare i tuoi dati?\n" +
                                        "(Qualora non volessi effetuare, modifiche la pagina si chiuderà e i dati non " +
                                        "validati, saranno ripristinati).",
                                "Conferma modifica", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, null, null) == JOptionPane.YES_OPTION) { // chiedo all'utente se vuole aggiornare i dati inseriti
                            //Se conferma, invoco il metodo aggiornaUtenteById
                            Global.utenteLoggato = aggiornaRistoratori.aggiornaUtenteById(Global.utenteLoggato.getId(), tfNome.getText(),
                                    tfCognome.getText(), tfComune.getText(), tfSiglaProvincia.getText());

                            JOptionPane.showMessageDialog(null, "Modifica account eseguta con " +
                                    "successo", "Modifica eseguita", JOptionPane.PLAIN_MESSAGE);
                            clienti.closePreviousWindow(MenuListener.mofidyAccount); //Chiusura della finestra di modifica
                        } else { //Se l'utente non conferma le modifiche
                            clienti.closePreviousWindow(MenuListener.mofidyAccount); //Chiusura della finestra
                        }
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            /*
            btnChangePswRistoratore.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) { //Funzione da implementare
                    JOptionPane.showMessageDialog(null, "Funzione non ancora disponibile",
                            "", JOptionPane.PLAIN_MESSAGE);
                }
            });
            */

            private boolean checkAllInputs() { //Metodo per la verifica di tutti i campi

                boolean allFieldsValid = true; //Tramite una variabile booleana, verifico se tutti i campi siano stati completati

                allFieldsValid &= checkInput(tfNome.getText()); //Per ogni TextField, verifico se è diverso da vuoto
                allFieldsValid &= checkInput(tfCognome.getText());
                allFieldsValid &= checkInput((tfComune.getText()));
                allFieldsValid &= checkInput(tfSiglaProvincia.getText());

                return allFieldsValid; //Restituisco il risultato booleano proveniente da CheckInput
            }

            private boolean checkInput(String input) { //Metodo per la verifica del textfield
                boolean res;
                String tmp = "";
                tmp += input;
                if (tmp.equals("")) { //Se il campo è vuoto, visualizzo una scritta
                    res = false;
                } else {
                    res = true;
                }

                return res;
            }
        });
    }

    private void createUIComponents() throws IOException { //Logo
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoClientiIlMioAccount.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}