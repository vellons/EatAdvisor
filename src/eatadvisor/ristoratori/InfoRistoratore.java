package eatadvisor.ristoratori;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * La classe InfoRistoratore permette di visualizzare una finestra contente le informazioni relative alla versione e
 * agli sviluppatori che hanno lavorato al progetto EatAdvisor.
 *
 * @author Silvio Pazienza
 */

public class InfoRistoratore {
    /**
     * <code>panelInfo</code> rappresenta un pannello.
     * <p>
     * &egrave; dichiarato <strong>public</strong> cos&igrave; da poter essere visibile anche alle altre classi
     */
    public JPanel panelInfo;
    /**
     * <code>panelLogo</code> rappresenta un pannello.
     * <p>
     * &egrave; dichiarato <strong>private</strong> cos&igrave; da non poter essere visibile all'esterno della classe
     */
    private JPanel panelLogo;
    /**
     * <code>lbVersione</code> rappresenta un etichetta.
     * <p>
     * &egrave; dichiarato <strong>private</strong> cos&igrave; da non poter essere visibile all'esterno della classe
     */
    private JLabel lbVersione;

    /**
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */
    private void createUIComponents() throws Exception {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratori.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}
