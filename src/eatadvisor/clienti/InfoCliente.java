package eatadvisor.clienti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * La classe InfoClienti permette la gestione della parte della
 * barra superiore dedicata alla versione dell'applicazione
 * @author Silvio Pazienza
 */

public class InfoCliente {

    /**
     * <code>panelInfo</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di
     * informazioni sull'applicazione
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */

    public JPanel panelInfo;

    /**
     * <code>panelLogo</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il logo dell'appicazione.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel panelLogo;

    /**
     * <code>lblVersione</code> &egrave; un'etichetta Swing dedicata al campo versione
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
    */

    private JLabel lbVersione;

    /**
     * <code>createUIComponents</code> &egrave; una procedura per impostare la grafica
     * quando viene caricato il frame
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     * essere sollevata durante l'esecuzione del programma
     */

    private void createUIComponents() throws Exception{
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoClienti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}
