package eatadvisor.ristoratori;

import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * La classe MioRistorantePerLista permette il caricamento dei singoli risrotanti
 * da caricare sulla dashboard
 *
 * @author Mahdi Said
 */

public class MioRistorantePerLista {

    /**
     * <code>dettaglioFrame</code> &egrave; una cornice Swing attivata nel momento nel
     * quale si vuole visualizzare le informazioni dettagliate di un singolo
     * ristorante
     * @see DettaglioMioRistorante
     * <p>
     * &egrave; dichiarata <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     * &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */

    public static JFrame dettaglioFrame = new JFrame("EatAdvisor Ristoratore - Dettaglio mio ristorante");

    /**
     * <code>panelMioRistorantePerLista</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie uno dei singoli ristoranti
     * caricati sulla dashboard
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */

    public JPanel panelMioRistorantePerLista;

    /**
     * <code>lblNome</code> &egrave; un'etichetta Swing dedicata al campo nome
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lblIndirizzo</code> &egrave; un'etichetta Swing dedicata al campo indirizzo
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lblStella</code> &egrave; un'etichetta Swing dedicata al campo stelle
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lblValutazioni</code> &egrave; un'etichetta Swing dedicata al campo valutazioni
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblNome;
    private JLabel lblIndirizzo;
    private JLabel lblStelle;
    private JLabel lblValutazioni;

    /**
     * <code>btnDettaglio</code> &egrave; un bottone Swing che attiva visualizzazione
     * delle informazioni dettagliate di un proprio ristorante a scelta
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JButton btnDettaglio;

    /**
     * Main della classe
     *
     * @param ristorante insieme di dati relativi al ristorante da visualizzare
     */

    public MioRistorantePerLista(Ristorante ristorante) {
        DecimalFormat dec = new DecimalFormat("#0.00");
        lblNome.setText(ristorante.getNomeRistorante().substring(0, Math.min(ristorante.getNomeRistorante().length(), 30)));
        lblIndirizzo.setText(ristorante.getIndirizzo().toString().substring(0, Math.min(ristorante.getIndirizzo().toString().length(), 45)));
        lblStelle.setText(String.valueOf(dec.format(ristorante.getRecensioniValutazioneMedia())));
        lblValutazioni.setText(String.valueOf(ristorante.getRecensioni().size()) + " valutazioni");

        btnDettaglio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dettaglioFrame.setContentPane(new DettaglioMioRistorante(ristorante).panelDettaglioRistorante);
                    ristoratori.initUI(dettaglioFrame);;
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
