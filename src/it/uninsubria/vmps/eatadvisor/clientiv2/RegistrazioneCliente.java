package it.uninsubria.vmps.eatadvisor.clientiv2;

import it.uninsubria.vmps.eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RegistrazioneCliente {
    private IOUtenti ioUtenti = null;
    public JPanel panelRegistrazioneCliente;
    private JButton btnIscriviti;
    private JTextField tfNickname;
    private JPasswordField tfPassword;
    private JLabel lblPassword;
    private JLabel lblNickname;
    private JPanel panelLogo;
    private JLabel lblNome;
    private JLabel lblCognome;
    private JLabel lblComune;
    private JLabel lblSiglaProvincia;
    private JLabel lblEmail;
    private JLabel lblErrors;
    private JTextField tfNome;
    private JTextField tfCognome;
    private JTextField tfComune;
    private JTextField tfSiglaProvincia;
    private JTextField tfEmail;


    public RegistrazioneCliente() throws Exception {

    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}
