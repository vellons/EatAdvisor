package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.*;

public class clienti {
    public static JFrame mainFrame = new JFrame("EatAdvisor Clienti - Login");

    public static void main(String[] args) throws Exception {
        mainFrame.setContentPane(new StartClienti().panelStartClienti);
        initUI(mainFrame);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null); // Mette la finestra al centro (da richiamare dopo .pack())
        mainFrame.setVisible(true);
    }

    public static void initUI(JFrame frame) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        // Queste impostazioni vengo applicate al frame passato
        ImageIcon imageIcon = new ImageIcon("media/EatAdvisorIcon.png");
        Image image = imageIcon.getImage();
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce il comportamento della finestra

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            if (clienti.exists("com.apple.eawt.Application")) {
                com.apple.eawt.Application.getApplication().setDockIconImage(image); //tramite questa funzione, posso inserire l'icona nella dock di MacOS, non dovrebbe interferire con Windows
            }
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

    private static void setMenuInfo(JMenuBar myMenuBar) { // Creazione del JMenu info
        JMenu f = new JMenu("Info");
        JMenuItem f1 = new JMenuItem("Versione");
        f.add(f1);
        myMenuBar.add(f);
    }

    public static boolean exists(String className) {
        try {
            Class.forName(className, false, null);
            return true;
        } catch (ClassNotFoundException exception) {
            return false;
        }
    }

    public static void closePreviousWindow(JFrame finestra) {
        finestra.setVisible(false);
        finestra.dispose();
    }

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
