package it.uninsubria.vmps.eatadvisor.clienti;

import it.uninsubria.vmps.eatadvisor.clientiv2.StartClienti;

import javax.swing.*;
import java.awt.*;

public class clienti {

    public static void main(String[] args) throws Exception {
        //Accesso myFrame = new Accesso("Accedi");
        //myFrame.setVisible(true);
        //ClientiLogin cli = new ClientiLogin();
        //cli.setVisible(true);
        JFrame mainFrame = new JFrame("EatAdvisor Clienti - Login");
        mainFrame.setContentPane(new StartClienti().panelStartClienti);
        initUI(mainFrame);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void initUI(JFrame frame) {
        ImageIcon imageIcon = new ImageIcon("media/EatAdvisroIcon.png");
        Image image = imageIcon.getImage();
        frame.setIconImage(image);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce il comportamento della finestra
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true"); // Posiziona il menu bar in stile macOS
        }
        JMenuBar myBar = new JMenuBar();
        frame.setJMenuBar(myBar);
        //setMenuAccount(myBar); // TODO: mostrare solo se l'utente è loggato
        setMenuInfo(myBar);
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
