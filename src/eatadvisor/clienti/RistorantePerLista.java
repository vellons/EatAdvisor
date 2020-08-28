package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Ristorante;
import eatadvisor.ristoratori.DettaglioMioRistorante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * La classe RistorantePerLista permette il caricamento dei singoli ristoranti
 * da caricare sulla dashboard
 *
 * @author Manuel Macaj
 */

public class RistorantePerLista extends JPanel {

    /**
     * <code>dettaglioFrame</code> è una cornice Swing attivata nel momento nel
     * quale si vuole visualizzare le informazioni dettagliate di un singolo
     * ristorante
     * @see DettaglioRistorante
     * <p>
     * è dichiarata <strong>public</strong> in quanto l'attributo è utilizzabile all'esterno della classe
     * è dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */

    public static JFrame dettaglioFrame = new JFrame("EatAdvisor Cliente - Dettaglio ristorante");

    /**
     * <code>panelRistorantePerLista</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie uno dei singoli ristoranti
     * caricati sulla dashboard
     * <p>
     * è dichiarato <strong>public</strong> in quanto l'attributo è utilizzabile all'esterno della classe
     */

    public JPanel panelRistorantePerLista;

    /**
     * <code>lblNome</code> è un'etichetta Swing dedicata al campo nome
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblIndirizzo</code> è un'etichetta Swing dedicata al campo indirizzo
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblStella</code> è un'etichetta Swing dedicata al campo stelle
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblValutazioni</code> è un'etichetta Swing dedicata al campo valutazioni
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JLabel lblNome;
    private JLabel lblIndirizzo;
    private JLabel lblStelle;
    private JLabel lblValutazioni;

    /**
     * <code>btnDettaglio</code> è un bottone Swing che attiva visualizzazione
     * delle informazioni dettagliate di un ristorante a scelta
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JButton btnDettaglio;

    /**
     * <code>lblTipologia</code> è un'etichetta Swing dedicata al campo tipologia
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JLabel lblTipologia;

    /**
     * Main della classe
     *
     * @param ristorante insieme di dati relativi al ristorante da visualizzare
     */

    public RistorantePerLista(Ristorante ristorante) {
        DecimalFormat dec = new DecimalFormat("#0.00");
        lblNome.setText(ristorante.getNomeRistorante().substring(0, Math.min(ristorante.getNomeRistorante().length(), 30)));
        lblIndirizzo.setText(ristorante.getIndirizzo().toString().substring(0, Math.min(ristorante.getIndirizzo().toString().length(), 45)));
        lblStelle.setText(String.valueOf(dec.format(ristorante.getRecensioniValutazioneMedia())));
        lblValutazioni.setText(String.valueOf(ristorante.getRecensioni().size()) + " valutazioni");
        lblTipologia.setText("Tipologia: " + ristorante.getTipologia());

        btnDettaglio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dettaglioFrame.setContentPane(new DettaglioRistorante(ristorante).panelDettaglioRistorante);
                    clienti.initUI(dettaglioFrame);;
                    dettaglioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                    dettaglioFrame.pack();
                    dettaglioFrame.setLocationRelativeTo(null);
                    dettaglioFrame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
