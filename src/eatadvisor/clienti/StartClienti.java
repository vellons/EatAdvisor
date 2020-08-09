package eatadvisor.clienti;

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
import java.lang.reflect.Method;

public class StartClienti {
    private IOUtenti ioUtenti = null;
    public JPanel panelStartClienti;
    private JButton btnAccedi;
    private JButton btnIscriviti;
    private JButton btnNoLogin;
    private JTextField tfNickname;
    private JPasswordField tfPassword;
    private JLabel lblPassword;
    private JLabel lblNickname;
    private JPanel panelLogo;

    public static JFrame registrazioneFrame = new JFrame("EatAdvisor Clienti - Registrazione");


    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    public StartClienti() throws Exception {
        btnAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Global.utenteLoggato = null; // Logout utente
                    ioUtenti = new IOUtenti();
                    System.out.println("Nickname: " + tfNickname.getText());
                    //System.out.println("Password: " + String.valueOf(tfPassword.getPassword()));
                    ioUtenti.filtraPerTipo("CLIE");
                    ioUtenti.filtraPerNickname(tfNickname.getText());
                    ioUtenti.filtraPerPassword(String.valueOf(tfPassword.getPassword()));
                    if (ioUtenti.getListaUtenti().size() == 1) {
                        Global.utenteLoggato = ioUtenti.getListaUtenti().get(0); // prendo l'unico utente nella lista
                        System.out.println(Global.utenteLoggato);
                        //JOptionPane.showMessageDialog(null, "Benvenuto/a " + Global.utenteLoggato.getNickname(),
                        //        "Accesso eseguito", JOptionPane.PLAIN_MESSAGE);
                        openDashBoardClienti();
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
                    Global.utenteLoggato = null; // Logout utente
                    registrazioneFrame.setContentPane(new RegistrazioneCliente().panelRegistrazioneCliente);
                    clienti.initUI(registrazioneFrame);
                    registrazioneFrame.setLocationRelativeTo(null);
                    registrazioneFrame.pack();
                    registrazioneFrame.setVisible(true);
                    registrazioneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        btnNoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Global.utenteLoggato = null; // Logout utente
                openDashBoardClienti();
            }
        });
    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoClienti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }

    private void openDashBoardClienti() {
        try {
            clienti.closePreviousWindow(clienti.mainFrame);
            JFrame listaRistoranti = new JFrame("EatAdvisor Clienti - Lista ristoranti");
            listaRistoranti.setContentPane(new DashboardRistoranti().panelDashboardRistoranti);
            clienti.initUI(listaRistoranti);
            listaRistoranti.setLocationRelativeTo(null);
            listaRistoranti.pack();
            listaRistoranti.setVisible(true);
            listaRistoranti.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
            //device.setFullScreenWindow(listaRistoranti); // Imposto la pagina a tutto schermo
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
