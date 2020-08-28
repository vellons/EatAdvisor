package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Recensione;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * La classe CreaRecensione permette la creazione di una recensione
 *
 * @author Alex Vellone
 */

public class CreaRecensione {
    /**
     * <code>panelCreaRecensione</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>public</strong> così da poter essere visibile anche alle altre classi
     */
    public JPanel panelCreaRecensione;
    /**
     * <code>sliValutazione</code> rappresenta una barra scorrevole.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JSlider sliValutazione;
    /**
     * <code>lbSliderValutazione</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lbSliderValutazione;
    /**
     * <code>lbScriviCommento</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lbScriviCommento;
    /**
     * <code>txtCommento</code> rappresenta un area di testo.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JTextArea txtCommento;
    /**
     * <code>panelLogo</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JPanel panelLogo;
    /**
     * <code>btnAddCommento</code> rappresenta un bottone.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JButton btnAddCommento;
    /**
     * <code>lbCounterCharacter</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lbCounterCharacter;
    /**
     * <code>count</code> è un valore intero.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * è dichiarato <strong>int</strong>
     */
    private int count = 0;

    /**
     * Costrutore della classe
     *
     * @param rist è un ristorante che viene passato al costruttore
     * @throws Exception è un eccezione che viene lanciata quando il programma
     *                   non trova il file che si vuole utilizzare
     */
    public CreaRecensione(Ristorante rist) throws Exception {
        lbCounterCharacter.setText("Caratteri: " + count + "/256");

        btnAddCommento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    IOEatAdvisor ioEatAdvisor = new IOEatAdvisor();
                    if (txtCommento.getText().length() != 0) {
                        if (txtCommento.getText().length() > 256) {
                            JOptionPane.showMessageDialog(null, "Non è stato possibile inviare il " +
                                            "commento perché hai superato il limite massimo di caratteri.",
                                    "Commento troppo lungo", JOptionPane.ERROR_MESSAGE);

                        } else {
                            ioEatAdvisor.aggiungiRecensioneByIdRistorante(rist.getId(),
                                    new Recensione(Global.utenteLoggato.getId(), sliValutazione.getValue(),
                                            txtCommento.getText()));
                            JOptionPane.showMessageDialog(null, "Il commento è stato " +
                                    "inviato correttamente.\nLa finestra del dettaglio verrà  ricaricata per mostrare " +
                                    "il commento", "Commento e giudizio inviato", JOptionPane.PLAIN_MESSAGE);
                            clienti.closePreviousWindow(DettaglioRistorante.frameRewiew);
                            clienti.reloadDettaglioRistorante(RistorantePerLista.dettaglioFrame, rist);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Non è stato possibile inviare il " +
                                        "commento perché l'area di testo è vuoto.",
                                "Commento non presente", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        txtCommento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) { // se pigio il tasto backspace, entro nell'if
                    if (txtCommento.getText() == "") { //qualora un utente decidesse di selezionare tutto il commento e cancellarlo tamite il backspace, azzeero il contatore
                        count = 0;
                        lbCounterCharacter.setText("Caratteri: " + count + "/256");
                    } else { //se seleziono una parte del testo
                        count = txtCommento.getText().length();
                        lbCounterCharacter.setText("Caratteri: " + count + "/256");
                    }
                } else {
                    count = txtCommento.getText().length() + 1; // incremento il contatore, da momento che sto aggiungendo caratteri
                    lbCounterCharacter.setText("Caratteri: " + count + "/256");
                }
            }
        });
    }

    /**
     * @throws IOException un eccezione che viene lanciata quando il programma non
     *                     trova il file che si vuole utilizzare
     */
    private void createUIComponents() throws IOException {
        // TODO: place custom component creation code here
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoClientiValutazione.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
        //creazione slider
        sliValutazione = new JSlider(1, 5, 1);

        sliValutazione.setMajorTickSpacing(1);
        sliValutazione.setPaintTrack(true);
        sliValutazione.setPaintTicks(true);
        sliValutazione.setPaintLabels(true);

        // Add positions label in the slider
        Hashtable position = new Hashtable();
        position.put(1, new JLabel("1"));
        position.put(2, new JLabel("2"));
        position.put(3, new JLabel("3"));
        position.put(4, new JLabel("4"));
        position.put(5, new JLabel("5"));
        // Set the label to be drawn
        sliValutazione.setLabelTable(position);

    }
}
