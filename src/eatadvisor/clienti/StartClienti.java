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

/**
 * La classe StartClienti permette l'inizializzazione dell'account di
 * un utente impostato come cliente
 *
 * @author Manuel Macaj
 */

public class StartClienti {

    /**
     * <code>ioUtenti</code> &egrave; un'istanza della classe IOUtenti che
     * permette di usare le funzionalit&agrave; per la gestione degli utenti.
     *
     * @see IOUtenti
     * <p>
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private IOUtenti ioUtenti = null;

    /**
     * <code>panelStartClienti</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di benvenuto
     * del lato cliente dell'applicazione
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */

    public JPanel panelStartClienti;

    /**
     * <code>btnAccedi</code> &egrave; un bottone Swing che attiva la procedura
     * di inizializzazione di un cliente
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>btnIscriviti</code> &egrave; un bottone Swing che attiva la procedura
     * di iscrizione alla piattaforma come cliente
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>btnNoLogin</code> &egrave; un bottone Swing che attiva la procedura
     * di iscrizione alla piattaforma come utente non registrato
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JButton btnAccedi;
    private JButton btnIscriviti;
    private JButton btnNoLogin;

    /**
     * <code>tfNickname</code> &egrave; un campo di testo Swing dedicato al campo nickname
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>tfPassword</code> &egrave; un campo di testo Swing dedicato al campo password
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JTextField tfNickname;
    private JPasswordField tfPassword;

    /**
     * <code>lblNickname</code> &egrave; un'etichetta Swing dedicata al campo nickname
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lblPassword</code> &egrave; un'etichetta Swing dedicata al campo password
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblPassword;
    private JLabel lblNickname;

    /**
     * <code>panelLogo</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il logo dell'appicazione.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel panelLogo;

    /**
     * <code>registrazioneFrame</code> &egrave; una cornice Swing attivata nel momento nel
     * quale &egrave; richiesta la registrazione di un cliente
     *
     * @see RegistrazioneCliente
     * <p>
     * &egrave; dichiarata <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     * &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */

    public static JFrame registrazioneFrame = new JFrame("EatAdvisor Clienti - Registrazione");

    /**
     * <code>dashboardRistoranti</code> &egrave; una cornice Swing attivata nel momento nel
     * quale un cliente effettua l'accesso
     *
     * @see DashboardRistoranti
     * <p>
     * &egrave; dichiarata <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     * &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */

    public static JFrame dashboardRistoranti = new JFrame("EatAdvisor Clienti - Lista ristoranti");

    /**
     * <code>GraphicsDevice</code> &egrave; un oggetto grafico utilizzato per
     * impostare lo schermo intero
     * <p>
     * &egrave; dichiarato <strong>static</strong> così da poterlo utlizzare senza istanziare l'oggetto
     */

    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0]; // Usato per mettere a tutto schermo

    /**
     * Main della classe
     *
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */

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
                    registrazioneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                    registrazioneFrame.pack();
                    registrazioneFrame.setLocationRelativeTo(null);
                    registrazioneFrame.setVisible(true);
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

    /**
     * <code>createUIComponents</code> &egrave; una procedura per impostare la grafica
     * quando viene caricato il frame
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *
     * @throws IOException &egrave; un eccezione che viene lanciata quando il programma non trova il file che si vuole utilizzare
     */

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoClienti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }

    /**
     * <code>openDashBoardClienti</code> &egrave; una procedura aprire il pannello
     * dashboard quando un cliente effettua l'accesso
     *
     * @see DashboardRistoranti
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore*
     */

    private void openDashBoardClienti() {
        try {
            clienti.closePreviousWindow(clienti.mainFrame);
            dashboardRistoranti.setContentPane(new DashboardRistoranti("", "", "").panelDashboardRistoranti);
            clienti.initUI(dashboardRistoranti);
            dashboardRistoranti.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
            dashboardRistoranti.pack();
            dashboardRistoranti.setLocationRelativeTo(null);
            dashboardRistoranti.setVisible(true);
            //device.setFullScreenWindow(dashboardRistoranti); // Imposto la pagina a tutto schermo
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
