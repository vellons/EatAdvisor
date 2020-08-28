package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Ristorante;

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
     * <code>dettaglioFrame</code> &egrave; una cornice Swing attivata nel momento nel
     * quale si vuole visualizzare le informazioni dettagliate di un singolo
     * ristorante
     *
     * @see DettaglioRistorante
     * <p>
     * &egrave; dichiarata <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     * &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */

    public static JFrame dettaglioFrame = new JFrame("EatAdvisor Cliente - Dettaglio ristorante");

    /**
     * <code>panelRistorantePerLista</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie uno dei singoli ristoranti
     * caricati sulla dashboard
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */

    public JPanel panelRistorantePerLista;

    /**
     * <code>lblNome</code> &egrave; un'etichetta Swing dedicata al campo nome
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblNome;

    /**
     * <code>lblIndirizzo</code> &egrave; un'etichetta Swing dedicata al campo indirizzo
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblIndirizzo;

    /**
     * <code>lblStelle</code> &egrave; un'etichetta Swing dedicata al campo stelle
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblStelle;

    /**
     * <code>lblValutazioni</code> &egrave; un'etichetta Swing dedicata al campo valutazioni
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblValutazioni;

    /**
     * <code>btnDettaglio</code> &egrave; un bottone Swing che attiva visualizzazione
     * delle informazioni dettagliate di un ristorante a scelta
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JButton btnDettaglio;

    /**
     * <code>lblTipologia</code> &egrave; un'etichetta Swing dedicata al campo tipologia
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
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
        lblValutazioni.setText(ristorante.getRecensioni().size() + " valutazioni");
        lblTipologia.setText("Tipologia: " + ristorante.getTipologia());

        btnDettaglio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dettaglioFrame.setContentPane(new DettaglioRistorante(ristorante).panelDettaglioRistorante);
                    clienti.initUI(dettaglioFrame);
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
