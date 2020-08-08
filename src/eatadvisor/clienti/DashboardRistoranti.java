package eatadvisor.clienti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DashboardRistoranti extends JFrame {
    public JPanel panelDashboardRistoranti;
    private JPanel panelLogo;
    private JPanel panelListaRistoranti;
    private JLabel lblFiltri;

    public DashboardRistoranti() throws Exception {

    }

    private void createUIComponents() throws Exception {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoClientiListaRistoranti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        panelListaRistoranti = new JPanel();
        panelListaRistoranti.add(new ListaRistorantiPanel()); // Aggiungo la lista dei ristoranti
    }
}
