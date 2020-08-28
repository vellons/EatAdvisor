package eatadvisor.clienti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * La classe DashboardRistoranti permette l'utilizzo dei filtri sui ristoranti
 *
 * @author Manuel Macaj
 */
public class DashboardRistoranti extends JFrame {
    /**
     * <code>panelDashboardRistoranti</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>public</strong> così da poter essere visibile anche alle altre classi
     */
    public JPanel panelDashboardRistoranti;
    /**
     * <code>panelLogo</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JPanel panelLogo;
    /**
     * <code>panelListaRistoranti</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JPanel panelListaRistoranti;
    /**
     * <code>btnApplicaFiltri</code> rappresenta un bottone.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JButton btnApplicaFiltri;
    /**
     * <code>cboxTipologia</code> rappresenta un combo box.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JComboBox cboxTipologia;
    /**
     * <code>tfFiltroNomeRistorante</code> rappresenta un campo di testo.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JTextField tfFiltroNomeRistorante;
    /**
     * <code>tfFiltroComune</code> rappresenta un campo di testo.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JTextField tfFiltroComune;
    /**
     * <code>JPanelFiltri</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JPanel JPanelFiltri;
    /**
     * <code>lblNomeRistorante</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lblNomeRistorante;
    /**
     * <code>lblComune</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lblComune;
    /**
     * <code>lblTipologia</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lblTipologia;
    /**
     * <code>tipologia</code> rappresenta un vettore di stringhe.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private final String[] tipologia = new String[]{"TUTTI", "ITALIANO", "ETNICO", "FUSION"};
    /**
     * <code>initialFiltroNome</code> rappresenta il filtro per il nome del ristorante.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String initialFiltroNome = "";
    /**
     * <code>initialFiltroComune</code> rappresenta il filtro per il comune del ristorante.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String initialFiltroComune = "";
    /**
     * <code>initialFiltroTipologia</code> rappresenta il filtro per la tipologia del ristorante.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private String initialFiltroTipologia = "";

    /**
     * Costrutore della classe
     *
     * @param filtroNome      è un filtro che viene applicato a un nome di un ristorante, escludendo gli altri
     * @param filtroComune    è un filtro che viene applicato a un comune di un ristorante, escludendo gli altri
     * @param filtroTipologia è un filtro che viene applicato a una tipologia di un ristorante, escludendo gli altri
     * @throws Exception è utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */
    public DashboardRistoranti(String filtroNome, String filtroComune, String filtroTipologia) throws Exception {
        // Prendo i valori dei 3 filtri precedenti e li popolo all'interno dei filtri
        // Questo succede perch&egrave; faccio il reload di questo oggetto
        initialFiltroNome = filtroNome;
        initialFiltroComune = filtroComune;
        initialFiltroTipologia = filtroTipologia;

        btnApplicaFiltri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ricarico la dashboard dei ristoranti passando i 3 filtri
                try {
                    clienti.reloadDashBoardConFiltri(
                            StartClienti.dashboardRistoranti,
                            tfFiltroNomeRistorante.getText(),
                            tfFiltroComune.getText(),
                            cboxTipologia.getSelectedItem().toString());
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
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoClientiListaRistoranti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        // Creo la lista dei ristoranti passando i 3 filtri
        panelListaRistoranti = new JPanel();
        panelListaRistoranti.add(new ListaRistorantiPanel(initialFiltroNome, initialFiltroComune, initialFiltroTipologia));

        // Inizialitto e popolo i valori dei 3 filtri
        tfFiltroNomeRistorante = new JTextField();
        tfFiltroComune = new JTextField();

        tfFiltroNomeRistorante.setText(initialFiltroNome);
        tfFiltroComune.setText(initialFiltroComune);

        cboxTipologia = new JComboBox<String>(tipologia);
        cboxTipologia.setSelectedItem(initialFiltroTipologia);
    }
}
