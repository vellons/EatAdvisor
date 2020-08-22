package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Recensione;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class CreaRecensione {
    public JPanel panelCreaRecensione;
    private JSlider sliValutazione;
    private JLabel lbSliderValutazione;
    private JLabel lbScriviCommento;
    private JTextArea txtCommento;
    private JPanel panelLogo;
    private JButton btnAddCommento;
    private JLabel lbCounterCharacter;

    public CreaRecensione(Ristorante rist) throws Exception {
        lbCounterCharacter.setText("Caratteri: 0/256");

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
        txtCommento.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }

            public void update() {
                lbCounterCharacter.setText("Caratteri: " + txtCommento.getText().length() + "/256");
            }
        });
    }

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
