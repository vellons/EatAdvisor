package eatadvisor.ristoratori;

import eatadvisor.global.Global;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * La classe ristoratori permette... ???
 *
 * @author Alex Vellone
 */

public class ristoratori {
    public static JFrame mainFrame = new JFrame("EatAdvisor Ristoratori - Login");

    /**
     * Main della classe
     *
     * @param args è nome dell'array di stringhe
     * @throws IOException è un eccezione che viene lanciata quando il programma non trova il file che si vuole utilizzare
     */
    public static void main(String[] args) throws Exception {
        mainFrame.setContentPane(new StartRistoratore().panelStartRistoratore);
        initUI(mainFrame);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
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
        ImageIcon imageIcon = new ImageIcon("media/EatAdvisorIcon.png");
        Image image = imageIcon.getImage();
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce il comportamento della finestra

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.awt.brushMetalLook", "true");
            // use the mac system menu bar
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            // set the "About" menu item name
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "EatAdvisor Ristoratori");
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
        MenuListener mLR = new MenuListener();
        JMenu f = new JMenu("Account");
        JMenuItem f1 = new JMenuItem("Modifica account");
        JMenuItem f2 = new JMenuItem("Logout");
        f1.addActionListener(mLR);
        f2.addActionListener(mLR);
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
     * @param finestra contiene il riferimento alla finestra principale
     * @throws Exception è utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */
    public static void reloadDashboardRistoranti(JFrame finestra) throws Exception {
        finestra.setVisible(false);
        finestra.dispose();
        finestra.invalidate();
        finestra.setContentPane(new DashboardRistoratori().panelDashboardRistoratori);
        initUI(finestra);
        finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        finestra.pack();
        finestra.setLocationRelativeTo(null);
        finestra.setVisible(true);
    }
}
