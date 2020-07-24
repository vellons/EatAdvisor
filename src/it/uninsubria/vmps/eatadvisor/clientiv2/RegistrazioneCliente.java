package it.uninsubria.vmps.eatadvisor.clientiv2;

import it.uninsubria.vmps.eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class RegistrazioneCliente {
    private IOUtenti ioUtenti = null;
    public JPanel panelRegistrazioneCliente;
    private JButton btnIscriviti;
    private JTextField tfNickname;
    private JPasswordField tfPassword;
    private JLabel lblPassword;
    private JLabel lblNickname;
    private JPanel panelLogo;
    private JLabel lblNome;
    private JLabel lblCognome;
    private JLabel lblComune;
    private JLabel lblSiglaProvincia;
    private JLabel lblEmail;
    private JLabel lblErrors;
    private JTextField tfNome;
    private JTextField tfCognome;
    private JTextField tfComune;
    private JTextField tfSiglaProvincia;
    private JTextField tfEmail;

    public RegistrazioneCliente() throws Exception {

        btnIscriviti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkAllInputs()) {
                    try {
                        ioUtenti = new IOUtenti();
                        ioUtenti.creaNuovoUtente("CLIE", getTfEmail(), getTfNickname(),
                                getTfPassword(), getTfNome(), getTfCognome(),
                                getTfComune(), getTfSiglaProvincia());
                        JOptionPane.showMessageDialog(null, "Account creato! Adesso effettua " +
                                "l'accesso", "Evviva", JOptionPane.PLAIN_MESSAGE);

                    } catch (Exception exception) {
                        if (Objects.equals(exception.getMessage(), "Email già utilizzata.")) {
                            JOptionPane.showMessageDialog(null, "Questa email è già stata utilizzata",
                                    "Attenzione", JOptionPane.PLAIN_MESSAGE);
                        }
                        if (Objects.equals(exception.getMessage(), "Nickanme già utilizzato.")) {
                            JOptionPane.showMessageDialog(null, "Questo nickname è già stato utilizzato",
                                    "Attenzione", JOptionPane.PLAIN_MESSAGE);
                        }
                    }

                }
                else{
                    //lblErrors.setFont(new Font("Default",Font.BOLD, 14 ));
                    lblErrors.setForeground(Color.RED);
                    lblErrors.setVisible(true);
                }
            }
        });
    }

    public String getTfNickname() {
        return tfNickname.getText();
    }

    public String getTfPassword() {
        return String.valueOf(tfPassword.getPassword());
    }

    public String getTfNome() {
        return tfNome.getText();
    }

    public String getTfCognome() {
        return tfCognome.getText();
    }

    public String getTfComune() {
        return tfComune.getText();
    }

    public String getTfSiglaProvincia() {
        return tfSiglaProvincia.getText();
    }

    public String getTfEmail() {
        return tfEmail.getText();
    }

    private boolean checkAllInputs() {
        boolean allFieldsValid = true;  // Tramite una variabile booleana, verifico se tutti i campi siano completi

        allFieldsValid &= checkInput(getTfNome(), tfNome); // Per ogni TextField, verifico se è diverso da vuoto
        allFieldsValid &= checkInput(getTfCognome(), tfCognome);
        allFieldsValid &= checkInput(getTfComune(), tfComune);
        allFieldsValid &= checkInput(getTfSiglaProvincia(), tfSiglaProvincia);
        allFieldsValid &= checkInput(getTfEmail(), tfEmail);
        allFieldsValid &= checkInput(getTfNickname(), tfNickname);
        allFieldsValid &= checkInput(getTfPassword(), tfPassword);

        return allFieldsValid; // Restituisco il risultato booleano proveniente da CheckInput
    }

    /*protected static void updateErrorLabel(JTextField ErrorField, String ErrorTextField, boolean vis) {
        ErrorField.setText(ErrorTextField); // Inserisco la scritta "Inserire i dati richiesti" a destra del text Field
        ErrorField.setFont(new Font("Arial", Font.BOLD, 14));
        ErrorField.setForeground(Color.RED);
        ErrorField.setVisible(vis);    // Abilito la label qualora l'utente non avesse inserito nessun dato
    }*/

    private boolean checkInput(String input, JTextField textField) { // Funzione per la verifica del textfield
        boolean res;
        String tmp = "";
        tmp += input;
        if (tmp.equals("")) { // Se il campo e vuoto, visualizzo una scritta
            //lblErrors.setForeground(Color.RED);
            //lblErrors.setVisible(true);
            //updateErrorLabel(textField, "Inserire un dato valido", true);
            res = false;
        } else {
            res = true;
        }
        return res;
    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}
