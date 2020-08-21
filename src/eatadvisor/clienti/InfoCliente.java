package eatadvisor.clienti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class InfoCliente {
    public JPanel panelInfo;
    private JPanel panelLogo;
    private JLabel lbVersione;

    private void createUIComponents() throws Exception{
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoClienti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}
