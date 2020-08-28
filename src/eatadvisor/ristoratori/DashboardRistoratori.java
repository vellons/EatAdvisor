package eatadvisor.ristoratori;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * La classe DashboardRistoratori permette il caricamento della dashboard per il
 * lato del ristoratore insieme alle sue relative funzioni
 *
 * @author Mahdi Said
 */

public class DashboardRistoratori extends JFrame {

    /**
     * <code>panelDashboardRistoratori</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la dahboard per i ristoratori
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */

    public JPanel panelDashboardRistoratori;

    /**
     * <code>panelLogo</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il logo dell'appicazione.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel panelLogo;

    /**
     * <code>panelListaRistoranti</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la parte che si occupa di
     * ricevere dati dai ristoranti
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel panelListaRistoranti;

    /**
     * <code>panelFunzioni</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la parte con il bottone di aggiunta.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel panelFunzioni;

    /**
     * <code>btnAggiungi</code> &egrave; un bottone Swing che attiva la procedura
     * di aggiunta di un ristorante di propriet&agrave; del ristoratore loggato
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JButton btnAggiungi;

    /**
     * <code>registrazioneFrame</code> &egrave; una cornice Swing attivata nel momento nel
     * quale un nuovo ristorante viene creato
     * @see RegistrazioneRistorante
     * <p>
     * &egrave; dichiarata <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     * &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */


    public static JFrame registrazioneFrame = new JFrame("EatAdvisor Ristoratori - Registrazione Ristorante");

    /**
     * Main della classe
     *
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     * essere sollevata durante l'esecuzione del programma
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
     * <code>createUIComponents</code> &egrave; una procedura per impostare la grafica
     * quando viene caricato il frame
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     * essere sollevata durante l'esecuzione del programma
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
