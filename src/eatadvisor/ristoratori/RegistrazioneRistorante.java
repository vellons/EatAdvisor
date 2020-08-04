/*package eatadvisor.ristoratori;

import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class RegistrazioneRistorante {
    private IOEatAdvisor ioEatAdvisor = null;
    String[] tipologia = { "Italiano", "Etnico", "Fusion"};
    public JPanel panelRegistrazioneRistorante;
    private JLabel lblErrors;
    private JLabel lblTipologia;
    private JLabel lblNomeRistorante;
    private JTextField tfNomeRistorante;
    private JLabel lblIndirizzo;
    private JTextField tfIndirizzo;
    private JLabel lblTelefono;
    private JTextField tfTelefono;
    private JLabel lblSitoWeb;
    private JTextField tfSitoWeb;
    private JLabel lblUrlImmagine;
    private JTextField tfUrlImmagine;
    private JComboBox cboxTipologia;
    private JPanel panelLogo;
    private JButton btnIscriviti;

    public RegistrazioneRistorante() throws Exception {

        btnIscriviti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!getTfEmail().matches(EMAIL_REGEX)) {
                    JOptionPane.showMessageDialog(null, "L'email inserita non è valida." +
                            "\nRiprovare", "Attenzione", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (checkAllInputs()) {
                        try {
                            ioEatAdvisor = new IOEatAdvisor();
                            ioUtenti.creaNuovoUtente("CLIE", getTfEmail(), getTfNickname(),
                                    getTfPassword(), getTfNome(), getTfCognome(),
                                    getTfComune(), getTfSiglaProvincia());
                            JOptionPane.showMessageDialog(null, "Account creato! Adesso effettua " +
                                    "l'accesso", "Evviva", JOptionPane.PLAIN_MESSAGE);
                        } catch (Exception exception) {
                            if (Objects.equals(exception.getMessage(), "Email già utilizzata.")) {
                                JOptionPane.showMessageDialog(null, "Questa email è già stata utilizzata",
                                        "Attenzione", JOptionPane.PLAIN_MESSAGE);
                                tfEmail.setText("");
                                tfEmail.setVisible(true);
                            }
                            if (Objects.equals(exception.getMessage(), "Nickanme già utilizzato.")) {
                                JOptionPane.showMessageDialog(null, "Questo nickname è già stato utilizzato",
                                        "Attenzione", JOptionPane.PLAIN_MESSAGE);
                                tfNickname.setText("");
                                tfNickname.setVisible(true);
                            }
                        }
                    } else {
                        lblErrors.setFont(new Font("Default", Font.BOLD, 14));
                        lblErrors.setForeground(Color.RED);
                        lblErrors.setVisible(true);
                    }
                }
            }
        });
    }

    // Metodi GETTERS
    /*public String getTfNickname() {
        return tfNickname.getText();
    }*/

/*

    public String getTfNomeRistorante() {
        return tfNomeRistorante.getText();
    }

    public String getTfIndirizzo() {
        return tfIndirizzo.getText();
    }

    public String getTfTelefono() {
        return tfTelefono.getText();
    }

    public String getTfSito() {
        return tfSitoWeb.getText();
    }

    public String getTfImmagine() {
        return tfUrlImmagine.getText();
    }


    private boolean checkAllInputs() {
        boolean allFieldsValid = true;  // Tramite una variabile booleana, verifico se tutti i campi siano completi

      //  allFieldsValid &= checkInput(getTfNome(), tfNome); // Per ogni TextField, verifico se è diverso da vuoto
        allFieldsValid &= checkInput(getTfNomeRistorante(), tfNomeRistorante);
        allFieldsValid &= checkInput(getTfIndirizzo(), tfIndirizzo);
        allFieldsValid &= checkInput(getTfTelefono(), tfTelefono);
        allFieldsValid &= checkInput(getTfSito(), tfSitoWeb);
        allFieldsValid &= checkInput(getTfImmagine(), tfUrlImmagine);

        return allFieldsValid; // Restituisco il risultato booleano proveniente da CheckInput
    }

    private boolean checkInput(String input, JTextField textField) { // Funzione per la verifica del textfield
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
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoRistoratori.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}*/
