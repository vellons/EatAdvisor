package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * La classe clienti permette
 *
 * @author
 */
public class clienti {
    public static JFrame mainFrame = new JFrame("EatAdvisor Clienti - Login");

    /**
     * Main della classe
     *
     * @param args &egrave; nome dell'array di stringhe
     * @throws IOException &egrave; un eccezione che viene lanciata quando il programma non trova il file che si vuole utilizzare
     */
    public static void main(String[] args) throws Exception {
        mainFrame.setContentPane(new StartClienti().panelStartClienti);
        initUI(mainFrame);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null); // Mette la finestra al centro (da richiamare dopo .pack())
        mainFrame.setVisible(true);
    }

    /**
     * @param frame contiene il riferimento della finestra principale
     * @throws ClassNotFoundException          ???
     * @throws UnsupportedLookAndFeelException ???
     * @throws InstantiationException          ???
     * @throws IllegalAccessException          ???
     */
    public static void initUI(JFrame frame) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        // Queste impostazioni vengo applicate al frame passato
        ImageIcon imageIcon = new ImageIcon("media/EatAdvisorIcon.png");
        Image image = imageIcon.getImage();
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce il comportamento della finestra

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.awt.brushMetalLook", "true");
            // use the mac system menu bar
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            // set the "About" menu item name
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "EatAdvisor Clienti");
            // use smoother fonts
            System.setProperty("apple.awt.textantialiasing", "true");
            // ref: http://developer.apple.com/releasenotes/Java/Java142RNTiger/1_NewFeatures/chapter_2_section_3.html
            System.setProperty("apple.awt.graphics.EnableQ2DX", "true");
            // use the system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }

        JMenuBar myBar = new JMenuBar();
        frame.setJMenuBar(myBar);
        if (Global.utenteLoggato != null) {
            setMenuAccount(myBar);
        }
        setMenuInfo(myBar);
    }

    /**
     * @param myMenuBar contiene il riferimento a un JMenuBar
     */
    private static void setMenuAccount(JMenuBar myMenuBar) { // Creazione del JMenu account
        MenuListener mL = new MenuListener();
        JMenu f = new JMenu("Account");
        JMenuItem f1 = new JMenuItem("Modifica account");
        JMenuItem f2 = new JMenuItem("Logout");
        f1.addActionListener(mL);
        f2.addActionListener(mL);
        f.add(f1);
        f.add(f2);
        myMenuBar.add(f);
    }

    /**
     * @param myMenuBar contiene il riferimento a un JMenuBar
     */
    private static void setMenuInfo(JMenuBar myMenuBar) { // Creazione del JMenu info
        MenuListener ml = new MenuListener();
        JMenu f = new JMenu("Info");
        JMenuItem f1 = new JMenuItem("Versione");
        f1.addActionListener(ml);
        f.add(f1);
        myMenuBar.add(f);
    }

    /**
     * @param finestra contiene il riferimento alla finestra principale
     */
    public static void closePreviousWindow(JFrame finestra) {
        finestra.setVisible(false);
        finestra.dispose();
    }

    /**
     * @param dashboardFrame  &egrave; la dashboard che contiene i filtri
     * @param filtroNome      &egrave; il filtro per il nome del ristorante
     * @param filtroComune    &egrave; il filtro per il comune del risorante
     * @param filtroTipologia &egrave; il filtro per la tipologia del ristorante
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */
    public static void reloadDashBoardConFiltri(JFrame dashboardFrame, String filtroNome, String filtroComune, String filtroTipologia) throws Exception {
        dashboardFrame.setVisible(false);
        dashboardFrame.dispose();
        dashboardFrame.invalidate();
        dashboardFrame.setContentPane(new DashboardRistoranti(filtroNome, filtroComune, filtroTipologia).panelDashboardRistoranti);
        initUI(dashboardFrame);
        dashboardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dashboardFrame.pack();
        dashboardFrame.setLocationRelativeTo(null);
        dashboardFrame.setVisible(true);
    }

    /**
     * @param dettaglioFrame ???
     * @param rist           rappresenta un ristorante
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */
    public static void reloadDettaglioRistorante(JFrame dettaglioFrame, Ristorante rist) throws Exception {
        dettaglioFrame.setVisible(false);
        dettaglioFrame.dispose();
        dettaglioFrame.invalidate();
        dettaglioFrame.setContentPane(new DettaglioRistorante(rist).panelDettaglioRistorante);
        initUI(dettaglioFrame);
        dettaglioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dettaglioFrame.pack();
        dettaglioFrame.setLocationRelativeTo(null);
        dettaglioFrame.setVisible(true);
    }
}
