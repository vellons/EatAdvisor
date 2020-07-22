package it.uninsubria.vmps.eatadvisor.clienti;

import javax.swing.*;
import java.awt.*;

public class Accesso extends JFrame {

    private static String OS = System.getProperty("os.name").toLowerCase(); //Salvo nella variabile il nome del sistema operativo

    public Accesso(String str) {
        super(str);
        JPanel panel = new JPanel();
        this.setSize(300, 150); //dimensione della finestra
        //this.setResizable(false); //metodo booleano che dà la possibilità di ridimensionare la finestra o meno
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //definisce il comportamento della finestra
        if (isMac()){
            System.setProperty("apple.laf.useScreenMenuBar", "true"); //posiziona il menu bar in stile macOS
        }
        JMenuBar myBar = new JMenuBar();
        this.setJMenuBar(myBar);
        this.creaMenu(myBar);
        panel.setLayout(null);
        this.add(panel);

        JLabel label = new JLabel("Nickname");
        label.setBounds(10,20,80,25);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label);
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,26);
        panel.add(userText);


        JLabel label2 = new JLabel("Password");
        label2.setBounds(10,50,80,25);
        label2.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label2);
        JTextField passText = new JTextField(20);
        passText.setBounds(100,50,165,26);
        panel.add(passText);

        accessoListener aL = new accessoListener(userText.getText(), passText.getText());
        signUpListener rL = new signUpListener();
        JButton button = new JButton("Accedi");
        button.setBounds(10, 80, 80,25);
        panel.add(button);

        JButton button2 = new JButton("Registrati");
        button2.setBounds(120, 80, 120,25);
        panel.add(button2);


        button.addActionListener(aL);
        button2.addActionListener(rL);

    }

    private void creaMenu(JMenuBar myMenuBar){ //Creazione del JMenuBar
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

    private void menuBarInfo(JMenuBar menuInfo){ //Metodo per l'aggiunta del menu info
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

