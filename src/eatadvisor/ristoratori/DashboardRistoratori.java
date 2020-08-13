package eatadvisor.ristoratori;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class DashboardRistoratori extends JFrame{
    public JPanel panelDashboardRistoratori;
    private JPanel panelLogo;
    private JPanel panelListaRistoranti;
    private JPanel panelFunzioni;
    private JButton btnAggiungi;
    private JButton btnElimina;

    public DashboardRistoratori() throws Exception{
/*        btnAggiungi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnElimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });*/
    }

    private void createUIComponents() throws Exception{
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoRistoratoriImieiRistoranti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        panelListaRistoranti = new JPanel();
 //       panelListaRistoranti.add(new ListaMieiRistorantiPanel());

    }
}
