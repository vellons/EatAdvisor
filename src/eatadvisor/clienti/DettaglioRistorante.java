package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Ristorante;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class DettaglioRistorante {
    private Ristorante ristorante;
    public JPanel panelDettaglioRistorante;
    private JPanel panelLogo;
    private JLabel lbNomeRistorante;
    private JLabel lbIndirizzo;
    private JLabel lbValutazioni;
    private JPanel panelPicRistorante;
    private JLabel lbNumeroRecensioni;
    private JLabel lbDescrizione;
    private JPanel panelRecensioni;
    private JTextArea txtDescrizione;

    public DettaglioRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
        setLabels(this.ristorante);
    }

    private void setLabels(Ristorante ristorante) {
        DecimalFormat dec = new DecimalFormat("#0.00");
        lbNomeRistorante.setText(ristorante.getNomeRistorante());
        lbIndirizzo.setText(String.valueOf(ristorante.getIndirizzo()));
        lbValutazioni.setText("Valutazione media: " + dec.format(ristorante.getRecensioniValutazioneMedia()));
        lbNumeroRecensioni.setText(ristorante.getRecensioni().size() + " valutazioni");

        setTextAreaDescr();
        txtDescrizione.setText(ristorante.getDescrizione());
    }

    private void setTextAreaDescr() {
        txtDescrizione.setEditable(false); // impostando a false, non posso scrivere nella textarea
        //txtDescrizione.setCursor(null); //
        txtDescrizione.setOpaque(true);
        //txtDescrizione.setOpaque(false);
        txtDescrizione.setFocusable(false);
        txtDescrizione.setLineWrap(true);
        txtDescrizione.setWrapStyleWord(true);
    }

    private void createUIComponents() throws Exception {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoClientiDettaglio.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        panelRecensioni = new JPanel();
        panelRecensioni.add(new ListaRecensioniPanel(this.ristorante)); // Aggiungo la lista dei ristoranti
    }
}
