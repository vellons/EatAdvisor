package it.uninsubria.vmps.eatadvisor.clienti;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.*;

public class Accesso extends JFrame {

    private static String OS = System.getProperty("os.name").toLowerCase(); //Salvo nella variabile il nome del sistema operativo

    public Accesso(String str) throws Exception {
        super(str);
        initUI();
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0xf4f4f4));
        panel.setOpaque(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //definisce il comportamento della finestra
        if (isMac()) {
            System.setProperty("apple.laf.useScreenMenuBar", "true"); //posiziona il menu bar in stile macOS
        }

        JMenuBar myBar = new JMenuBar();
        this.setJMenuBar(myBar);
        this.creaMenu(myBar);
        panel.setLayout(null);
        this.add(panel);

        JLabel label = new JLabel("Nickname");
        label.setBounds(40, 70, 80, 25);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label);
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 70, 165, 30);
        panel.add(userText);


        JLabel label2 = new JLabel("Password");
        label2.setBounds(40, 120, 80, 25);
        label2.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label2);
        JTextField passText = new JTextField(20);
        passText.setBounds(150, 120, 165, 30);
        panel.add(passText);

        accessoListener aL = new accessoListener(userText.getText(), passText.getText());
        signUpListener rL = new signUpListener();

        JButton button = new JButton("Accedi");

        button.setBounds(30, 200, 130, 30);
        button.setBorder(new RoundedBorder(10));
        button.setBackground(new Color(0xC71E23));
        button.setOpaque(true);

        panel.add(button);

        JButton button2 = new JButton("Iscriviti");
        button2.setBounds(250, 200, 130, 30);
        button2.setBorder(new RoundedBorder(10));
        panel.add(button2);
        button2.setBackground(new Color(0xC71E23));
        button2.setOpaque(true);

        button.addActionListener(aL);
        button2.addActionListener(rL);

    }

    private void initUI() {
        ImageIcon webIcon = new ImageIcon("jetbrains://idea/navigate/reference?project=EatAdvisor&path=media/EatAdvisroLogo.png");
        setIconImage(webIcon.getImage());
        setSize(450, 300); //dimensione della finestra
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void creaMenu(JMenuBar myMenuBar) { //Creazione del JMenuBar
        JMenu f = new JMenu("Account");
        JMenuItem f1 = new JMenuItem("Login");
        JMenuItem f2 = new JMenuItem("Logout");
        JMenuItem f3 = new JMenuItem("Modifica account");
        f.add(f1);
        f.add(f2);
        f.add(f3);
        myMenuBar.add(f);
        menuBarInfo(myMenuBar);
    }

    private void menuBarInfo(JMenuBar menuInfo) { //Metodo per l'aggiunta del menu info
        this.setJMenuBar(menuInfo);
        JMenu f = new JMenu("Info");
        JMenuItem f1 = new JMenuItem("Versione");
        f.add(f1);
        menuInfo.add(f);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }
}

