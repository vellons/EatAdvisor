package eatadvisor.ristoratori;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * La classe DashboardRistoratori permette l'aggiunta di un ristorante
 *
 * @author Alex Vellone
 */

public class DashboardRistoratori extends JFrame {
    /**
     * <code>panelDashboardRistoratori</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>public</strong> così da poter essere visibile anche alle altre classi
     */
    public JPanel panelDashboardRistoratori;
    /**
     * <code>panelLogo</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>private</strong> così da non poter essere visibile dall'esterno della classe
     */
    private JPanel panelLogo;
    /**
     * <code>panelListaRistoranti</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>private</strong> così da non poter essere visibile dall'esterno della classe
     */
    private JPanel panelListaRistoranti;
    /**
     * <code>panelFunzioni</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>private</strong> così da non poter essere visibile dall'esterno della classe
     */
    private JPanel panelFunzioni;
    /**
     * <code>btnAggiungi</code> rappresenta un bottone.
     * <p>
     * è dichiarato <strong>private</strong> così da non poter essere visibile dall'esterno della classe
     */
    private JButton btnAggiungi;
    /**
     * <code>registrazioneFrame</code> rappresenta una finestra.
     * <p>
     * è dichiarato <strong>public</strong> così da poter essere visibile anche alle altre classi
     * è dichiarato <strong>static</strong> così da non doverlo istanziare creando un oggetto
     */
    public static JFrame registrazioneFrame = new JFrame("EatAdvisor Ristoratori - Registrazione Ristorante");

    /**
     * Costrutore della classe
     *
     * @throws Exception è un eccezione che viene lanciata quando il programma
     *                   non trova il file che si vuole utilizzare
     */
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

    /**
     * @throws Exception è utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */
    private void createUIComponents() throws Exception {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratoriImieiRistoranti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        panelListaRistoranti = new JPanel();
        panelListaRistoranti.add(new ListaMieiRistorantiPanel());
    }
}
