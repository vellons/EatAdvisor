package eatadvisor.ristoratori;

import javax.swing.*;
import java.awt.*;

public class ristoratori {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("EatAdvisor Ristoratori - Login");
        mainFrame.setContentPane(new StartRistoratore().panelStartRistoratore);
        initUI(mainFrame);

        JMenuBar myBar = new JMenuBar();
        mainFrame.setJMenuBar(myBar);
        //setMenuAccount(myBar); // TODO: mostrare solo se l'utente è loggato
        setMenuInfo(myBar);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void initUI(JFrame frame) {
        ImageIcon imageIcon = new ImageIcon("media/EatAdvisroIcon.png");
        Image image = imageIcon.getImage();
        frame.setIconImage(image);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce il comportamento della finestra
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true"); // Posiziona il menu bar in stile macOS
        }
    }

    private static void setMenuAccount(JMenuBar myMenuBar) { // Creazione del JMenu account
        JMenu f = new JMenu("Account");
        JMenuItem f1 = new JMenuItem("Login");
        JMenuItem f2 = new JMenuItem("Logout");
        JMenuItem f3 = new JMenuItem("Modifica account");
        f.add(f1);
        f.add(f2);
        f.add(f3);
        myMenuBar.add(f);
    }

    private static void setMenuInfo(JMenuBar myMenuBar) { // Creazione del JMenu info
        JMenu f = new JMenu("Info");
        JMenuItem f1 = new JMenuItem("Versione");
        f.add(f1);
        myMenuBar.add(f);
    }
}
