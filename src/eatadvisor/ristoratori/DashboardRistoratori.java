package eatadvisor.ristoratori;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class DashboardRistoratori extends JFrame {
    public JPanel panelDashboardRistoratori;
    private JPanel panelLogo;
    private JPanel panelListaRistoranti;
    private JPanel panelFunzioni;
    private JButton btnAggiungi;
    public static JFrame registrazioneFrame = new JFrame("EatAdvisor Ristoratori - Registrazione Ristorante");

    public DashboardRistoratori() throws Exception {
        btnAggiungi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registrazioneFrame.setContentPane(new RegistrazioneRistorante().panelRegistrazioneRistorante);
                    ristoratori.initUI(registrazioneFrame);
                    registrazioneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                    registrazioneFrame.pack();
                    registrazioneFrame.setLocationRelativeTo(null);
                    registrazioneFrame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    private void createUIComponents() throws Exception {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratoriImieiRistoranti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        panelListaRistoranti = new JPanel();
        panelListaRistoranti.add(new ListaMieiRistorantiPanel());
    }
}
