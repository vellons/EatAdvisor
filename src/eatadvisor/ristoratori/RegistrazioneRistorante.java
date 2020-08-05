package eatadvisor.ristoratori;

import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Indirizzo;

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
    String[] tipologia = new String []{ "Italiano", "Etnico", "Fusion"};
    public JPanel panelRegistrazioneRistorante;
    private JLabel lblErrors;
    private JLabel lblTipologia;
    private JLabel lblNomeRistorante;
    private JTextField tfNomeRistorante;
    private JLabel lblVia;
    private JTextField tfVia;
    private JLabel lblTelefono;
    private JTextField tfTelefono;
    private JLabel lblSitoWeb;
    private JTextField tfSitoWeb;
    private JLabel lblUrlImmagine;
    private JTextField tfUrlImmagine;
    public JComboBox<String> cboxTipologia = new JComboBox<String>(tipologia);
    private JPanel panelLogo;
    private JButton btnIscriviti;
    private JTextField tfCivico;
    private JTextField tfCitta;
    private JTextField tfProvincia;
    private JTextField tfCap;
    private JLabel lblCivico;
    private JLabel lblCitta;
    private JLabel lblProvincia;
    private JLabel lblCap;
    private Indirizzo indirizzo=new Indirizzo(getTfVia(),getTfCivico(),getTfCitta(),getTfProvincia(),getTfCap());



    public RegistrazioneRistorante() throws Exception {

        btnIscriviti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (checkAllInputs()) {
                        try {
                            ioEatAdvisor = new IOEatAdvisor();
                            ioEatAdvisor.creaNuovoRistorante(1,cboxTipologia.getSelectedItem().toString(), getTfNomeRistorante(),
                                    indirizzo, getTfTelefono(), getTfSito(), getTfImmagine());
                            JOptionPane.showMessageDialog(null, "Account creato! Adesso effettua " +
                                    "l'accesso", "Evviva", JOptionPane.PLAIN_MESSAGE);
                        } catch (Exception exception) {/*
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
                        */}
                    } else {
                        lblErrors.setFont(new Font("Default", Font.BOLD, 14));
                        lblErrors.setForeground(Color.RED);
                        lblErrors.setVisible(true);
                    }

            }
        });
    }

    // Metodi GETTERS

    public String getTfNomeRistorante() {
        return tfNomeRistorante.getText();
    }

    public String getTfVia() {
        return tfVia.getText();
    }

    public String getTfCivico() {
        return tfCivico.getText();
    }

    public String getTfCitta() {
        return tfCitta.getText();
    }

    public String getTfProvincia() {
        return tfProvincia.getText();
    }

    public String getTfCap() {
        return tfCap.getText();
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
        allFieldsValid &= checkInput(getTfVia(), tfVia);
        allFieldsValid &= checkInput(getTfCivico(), tfCivico);
        allFieldsValid &= checkInput(getTfCitta(), tfCitta);
        allFieldsValid &= checkInput(getTfProvincia(), tfProvincia);
        allFieldsValid &= checkInput(getTfCap(), tfCap);
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


}
