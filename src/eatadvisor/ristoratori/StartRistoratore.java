package eatadvisor.ristoratori;

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

    private IOUtenti ioUtenti = null;
    public JPanel panelStartRistoratore;
    private JButton btnAccedi;
    private JButton btnIscriviti;
    private JLabel lblEmail;
    private JTextField tfEmail;
    private JLabel lblPassword;
    private JPasswordField tfPassword;
    private JPanel panelLogo;

    public static JFrame registrazioneFrame = new JFrame("EatAdvisor Ristoratori - Registrazione");
    public static JFrame dashboardRistoratore = new JFrame("EatAdvisor Ristoratori - I tuoi ristoranti");

    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0]; // Usato per mettere a tutto schermo

    public StartRistoratore() throws Exception {
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
                        System.out.println(Global.utenteLoggato);
                        openDashBoardRistoratori();
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
                    Global.utenteLoggato = null;
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
    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratori.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }

    private void openDashBoardRistoratori() {

        try {
            ristoratori.closePreviousWindow(ristoratori.mainFrame);
            dashboardRistoratore.setContentPane(new DashboardRistoratori().panelDashboardRistoratori);
            ristoratori.initUI(dashboardRistoratore);
            dashboardRistoratore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dashboardRistoratore.pack();
            dashboardRistoratore.setLocationRelativeTo(null);
            dashboardRistoratore.setVisible(true);
            //device.setFullScreenWindow(listaRistoranti); // Imposto la pagina a tutto schermo
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}

