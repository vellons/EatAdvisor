package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Ristorante;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    private JLabel lbDescrizioneRist;
    private JPanel panelRecensioni;

    public DettaglioRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
        setLabels(this.ristorante);

    }

    private void setLabels(Ristorante ristorante){
        lbNomeRistorante.setText(ristorante.getNomeRistorante());
        lbIndirizzo.setText(String.valueOf(ristorante.getIndirizzo()));
        lbValutazioni.setText("Valutazione media: "+String.valueOf(ristorante.getRecensioniValutazioneMedia()));
        lbNumeroRecensioni.setText(String.valueOf(ristorante.getRecensioni().size())+" valutazioni");
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