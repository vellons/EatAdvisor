package eatadvisor.ristoratori;

import eatadvisor.global.Global;
import eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class StartRistoratore {
    private IOUtenti ioUtenti = null;
    public JPanel panelStartRistoratore;
    private JButton btnAccedi;
    private JButton btnIscriviti;
    private JLabel lblEmail;
    private JTextField tfEmail;
    private JLabel lblPassword;
    private JPasswordField tfPassword;
    private JPanel panelLogo;

    public StartRistoratore() {
        btnAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Global.utenteLoggato = null;
                    ioUtenti = new IOUtenti();
                    System.out.println("Email: " + tfEmail.getText());
                    //System.out.println("Password: " + String.valueOf(tfPassword.getPassword()));
                    ioUtenti.filtraPerEmail(tfEmail.getText());
                    ioUtenti.filtraPerPassword(String.valueOf(tfPassword.getPassword()));
                    if (ioUtenti.getListaUtenti().size() == 1) {
                        Global.utenteLoggato = ioUtenti.getListaUtenti().get(0); // prendo l'unico utente nella lista
                        //System.out.println(Global.utenteLoggato);
                        JOptionPane.showMessageDialog(null, "Benvenuto/a " + Global.utenteLoggato.getNickname(),
                                "Accesso eseguito", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username e/o password errati",
                                "Attenzione", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception exception) {
                    System.err.println("IOUTENTI: File " + IOUtenti.FILE_UTENTI + " non trovato.");
                }
            }
        });

        btnIscriviti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*try {
                    JFrame registrazioneFrame = new JFrame("EatAdvisor Ristoratori - Registrazione");
                    registrazioneFrame.setContentPane(new RegistrazioneRistorante().panelRegistrazioneRistoratore);
                    ristoratori.initUI(registrazioneFrame);
                    registrazioneFrame.setSize(500, 450);
                    registrazioneFrame.setLocationRelativeTo(null);
                    registrazioneFrame.pack();
                    registrazioneFrame.setVisible(true);
                    registrazioneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                } catch (Exception exception) {
                    exception.printStackTrace();
                }*/
            }
        });
    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoRistoratori.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}

