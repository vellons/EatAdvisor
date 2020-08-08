package eatadvisor.clienti;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DashboardRistoranti extends JFrame {
    public JPanel panelDashboardRistoranti;
    private JPanel panelLogo;
    private JPanel panelListaRistoranti;
    private JLabel lblFiltri;


    public DashboardRistoranti() throws Exception {

    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoClientiListaRistoranti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        panelListaRistoranti = new JPanel();
        panelListaRistoranti.add(new ListaRistorantiPanel()); // Aggiungo la lista dei ristoranti
    }
}
