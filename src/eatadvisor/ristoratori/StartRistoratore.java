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

/**
 * La classe StartRistoratore permette l'inizializzazione dell'account di
 * un utente impostato come ristoratore
 *
 * @author Mahdi Said
 */


public class StartRistoratore {

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
     * <code>panelStartRistoratore</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di benvenuto
     * del lato ristoratore dell'applicazione
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */

    public JPanel panelStartRistoratore;

    /**
     * <code>btnAccedi</code> &egrave; un bottone Swing che attiva la procedura
     * di inizializzazione di un ristoratore
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JButton btnAccedi;

    /**
     * <code>btnIscriviti</code> &egrave; un bottone Swing che attiva la procedura
     * di iscrizione alla piattaforma come ristoratore
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JButton btnIscriviti;

    /**
     * <code>lblEmail</code> &egrave; un'etichetta Swing dedicata al campo email
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblEmail;

    /**
     * <code>tfEmail</code> &egrave; un campo di testo Swing dedicato al campo email
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JTextField tfEmail;

    /**
     * <code>lblPassword</code> &egrave; un'etichetta Swing dedicata al campo password
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblPassword;

    /**
     * <code>tfPassword</code> &egrave; un campo di testo Swing dedicato al campo password
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPasswordField tfPassword;

    /**
     * <code>panelLogo</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il logo dell'appicazione.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel panelLogo;

    /**
     * <code>registrazioneFrame</code> &egrave; una cornice Swing attivata nel momento nel
     * quale &egrave; richiesta la registrazione di un ristoratore
     *
     * @see RegistrazioneRistoratore
     * <p>
     * &egrave; dichiarata <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     * &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */

    public static JFrame registrazioneFrame = new JFrame("EatAdvisor Ristoratori - Registrazione");

    /**
     * <code>dashboardRistoratore</code> &egrave; una cornice Swing attivata nel momento nel
     * quale un ristoratore effettua l'accesso
     *
     * @see DashboardRistoratori
     * <p>
     * &egrave; dichiarata <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     * &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */

    public static JFrame dashboardRistoratore = new JFrame("EatAdvisor Ristoratori - I miei ristoranti");

    /**
     * <code>GraphicsDevice</code> &egrave; un oggetto grafico utilizzato per
     * impostare lo schermo intero
     * <p>
     * &egrave; dichiarato <strong>static</strong> così da poterlo utlizzare senza istanziare l'oggetto
     */

    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    /**
     * Main della classe
     *
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */

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

    /**
     * <code>createUIComponents</code> &egrave; una procedura per impostare la grafica
     * quando viene caricato il frame
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *
     * @throws IOException &egrave; un eccezione che viene lanciata quando il programma non trova il file che si vuole utilizzare
     */
    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratori.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }

    /**
     * <code>openDashBoardRistoratori</code> &egrave; una procedura aprire il pannello
     * dashboard quando un ristoratore effettua l'accesso
     *
     * @see DashboardRistoratori
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore*
     */

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

