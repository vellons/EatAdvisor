package eatadvisor.ristoratori;

import eatadvisor.clienti.clienti;
import eatadvisor.global.Global;
import eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartRistoratore {
    public static JFrame modifyAccount = new JFrame("EatAdvisor Ristoratori - Login"); //Frame per verifica funzionamento modifica account (da Manuel, questo è da cancellare)

    private IOUtenti ioUtenti = null;
    public JPanel panelStartRistoratore;
    private JButton btnAccedi;
    private JButton btnIscriviti;
    private JLabel lblEmail;
    private JTextField tfEmail;
    private JLabel lblPassword;
    private JPasswordField tfPassword;
    private JPanel panelLogo;
    private JButton btnCreaRistorante;

    public StartRistoratore() {
        btnAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Global.utenteLoggato = null;
                    ioUtenti = new IOUtenti();
                    System.out.println("Email: " + tfEmail.getText());
                    //System.out.println("Password: " + String.valueOf(tfPassword.getPassword()));
                    ioUtenti.filtraPerTipo("RIST");
                    ioUtenti.filtraPerEmail(tfEmail.getText());
                    ioUtenti.filtraPerPassword(String.valueOf(tfPassword.getPassword()));
                    if (ioUtenti.getListaUtenti().size() == 1) {
                        Global.utenteLoggato = ioUtenti.getListaUtenti().get(0); // prendo l'unico utente nella lista
                        //System.out.println(Global.utenteLoggato);
                        openModificaAccount();
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
                try {
                    JFrame registrazioneFrame = new JFrame("EatAdvisor Ristoratori - Registrazione");
                    registrazioneFrame.setContentPane(new RegistrazioneRistoratore().panelRegistrazioneRistoratore);
                    ristoratori.initUI(registrazioneFrame);
                    registrazioneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                    registrazioneFrame.pack();
                    registrazioneFrame.setLocationRelativeTo(null);
                    registrazioneFrame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        btnCreaRistorante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame registrazioneFrame = new JFrame("EatAdvisor Ristoratori - Registrazione Ristorante");
                    registrazioneFrame.setContentPane(new RegistrazioneRistorante().panelRegistrazioneRistorante);
                    ristoratori.initUI(registrazioneFrame);
                    registrazioneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                    registrazioneFrame.pack();
                    registrazioneFrame.setLocationRelativeTo(null);
                    registrazioneFrame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

    }
    private void openModificaAccount(){ //questa parte è da cancellare: serve solo per verificare se funziona il modifica account
        try{
            modifyAccount.setContentPane(new AccountRistoratore().panelAccountRistoratore);
            clienti.initUI(modifyAccount);
            modifyAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
            modifyAccount.pack();
            modifyAccount.setLocationRelativeTo(null);
            modifyAccount.setVisible(true);
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoRistoratori.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}

