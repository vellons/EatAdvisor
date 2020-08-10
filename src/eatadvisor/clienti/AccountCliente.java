package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AccountCliente {
    public JPanel panelAccountCliente;
    private JPanel panelLogo;
    private JLabel lblNickname;
    private JTextField tfNickname;
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
    private JButton btnChangeAccount;
    private JButton btnChangePsw;
    IOUtenti aggiornaUtenti = null;

    public AccountCliente() {
        setAllTextField(); //"settaggio" dei campi
        btnChangeAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnChangeAccount.setText("Conferma modifiche");
                setTrueEditable();
                btnChangeAccount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            aggiornaUtenti = new IOUtenti();
                            if (!checkAllInputs()){
                                JOptionPane.showMessageDialog(null, "Attenzione, tutti i " +
                                        "campi devono essere completati!", "Errore", JOptionPane.ERROR_MESSAGE);
                            }
                            else{
                                if (JOptionPane.showOptionDialog(null, "Confermi di voler modificare il tuo account?",
                                        "Conferma modifica", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                        null, null, null) == JOptionPane.YES_OPTION){
                                    aggiornaUtenti.aggiornaUtenteById(Global.utenteLoggato.getId(), tfNome.getText(),
                                            tfCognome.getText(), tfComune.getText(), tfSiglaProvincia.getText());

                                    Global.utenteLoggato.setNome(tfNome.getText());
                                    Global.utenteLoggato.setCognome(tfCognome.getText());
                                    Global.utenteLoggato.setComune(tfComune.getText());
                                    Global.utenteLoggato.setSiglaProvincia(tfSiglaProvincia.getText());

                                    JOptionPane.showMessageDialog(null, "Modifica account eseguto con " +
                                            "successo", "Modifica eseguita", JOptionPane.PLAIN_MESSAGE);
                                    clienti.closePreviousWindow(MenuListener.mofidyAccount);
                                }

                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                });
            }
        });
    }



    private void setTrueEditable() {
        tfNome.setEditable(true);  // impostando a true, ho la possibilità di modificare il campo di testo
        tfCognome.setEditable(true);
        tfComune.setEditable(true);
        tfSiglaProvincia.setEditable(true);
    }

    private void setAllTextField() {
        tfNome.setText(Global.utenteLoggato.getNome()); //prelevo il nome dell utemte loggato
        tfNome.setEditable(false);  // impostando a false, non ho la possibilità di modificare il campo di testo
        tfNome.setVisible(true);    // impostando a true, posso visualizzare il testo presente nel textfield

        tfCognome.setText(Global.utenteLoggato.getCognome());
        tfCognome.setEditable(false);
        tfCognome.setVisible(true);

        tfComune.setText(Global.utenteLoggato.getComune());
        tfComune.setEditable(false);
        tfComune.setVisible(true);

        tfSiglaProvincia.setText(Global.utenteLoggato.getSiglaProvincia());
        tfSiglaProvincia.setEditable(false);
        tfSiglaProvincia.setVisible(true);

        tfEmail.setText(Global.utenteLoggato.getEmail());
        tfEmail.setEditable(false);
        tfEmail.setVisible(true);

        tfNickname.setText(Global.utenteLoggato.getNickname());
        tfNickname.setEditable(false);
        tfNickname.setVisible(true);
    }
    private boolean checkAllInputs() {
        boolean allFieldsValid = true;  // Tramite una variabile booleana, verifico se tutti i campi siano completi

        allFieldsValid &= checkInput(tfNome.getText()); // Per ogni TextField, verifico se è diverso da vuoto
        allFieldsValid &= checkInput(tfCognome.getText());
        allFieldsValid &= checkInput(tfComune.getText());
        allFieldsValid &= checkInput(tfSiglaProvincia.getText());

        return allFieldsValid; // Restituisco il risultato booleano proveniente da CheckInput
    }

    private boolean checkInput(String input) { // Funzione per la verifica del textfield
        boolean res;
        String tmp = "";
        tmp += input;
        if (tmp.equals("")) { // Se il campo e vuoto, visualizzo una scritta
            res = false;
        } else {
            res = true;
        }
        return res;
    }


    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoClienti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}


