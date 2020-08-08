package eatadvisor.clienti;

import eatadvisor.global.Global;

import javax.swing.*;
import java.awt.*;

public class clienti {

    public static void main(String[] args) throws Exception {
        JFrame mainFrame = new JFrame("EatAdvisor Clienti - Login");
        mainFrame.setContentPane(new StartClienti().panelStartClienti);
        initUI(mainFrame);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void initUI(JFrame frame) {
        // Queste impostazioni vengo applicate al frame passato
        ImageIcon imageIcon = new ImageIcon("media/EatAdvisroIcon.png");
        Image image = imageIcon.getImage();
        frame.setIconImage(image);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce il comportamento della finestra
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true"); // Posiziona il menu bar in stile macOS
        }

        JMenuBar myBar = new JMenuBar();
        frame.setJMenuBar(myBar);
        if (Global.utenteLoggato != null) {
            setMenuAccount(myBar);
        }
        setMenuInfo(myBar);
    }

    private static void setMenuAccount(JMenuBar myMenuBar) { // Creazione del JMenu account
        JMenu f = new JMenu("Account");
        JMenuItem f1 = new JMenuItem("Modifica account");
        JMenuItem f2 = new JMenuItem("Logout");
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
}
