package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Ristorante;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

public class RistorantePerLista extends JPanel {
    public static JFrame dettaglioFrame = new JFrame();
    public JPanel panelRistorantePerLista;
    private JLabel lblNome;
    private JLabel lblIndirizzo;
    private JLabel lblStelle;
    private JLabel lblValutazioni;
    private JButton btnDettaglio;
    private JPanel panelRistImage;


    public RistorantePerLista(Ristorante ristorante) {
        DecimalFormat dec = new DecimalFormat("#0.00");
        lblNome.setText(ristorante.getNomeRistorante().substring(0, Math.min(ristorante.getNomeRistorante().length(), 30)));
        lblIndirizzo.setText(ristorante.getIndirizzo().toString().substring(0, Math.min(ristorante.getIndirizzo().toString().length(), 45)));
        lblStelle.setText(String.valueOf(dec.format(ristorante.getRecensioniValutazioneMedia())));
        lblValutazioni.setText(String.valueOf(ristorante.getRecensioni().size()) + " valutazioni");

        btnDettaglio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dettaglioFrame.setContentPane(new DettaglioRistorante(ristorante).panelDettaglioRistorante);
                    clienti.initUI(dettaglioFrame);
                    dettaglioFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    dettaglioFrame.setUndecorated(false);
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

    private void createUIComponents() {
        panelRistImage = new JPanel();
        Image image = null;
        URL url = null;
        JLabel label = new JLabel("Impossibile caricare l'immagine");
        try {
            url = new URL("https://www.itagnol.com/wp-content/uploads/2019/01/CIAO.jpg");
            image = ImageIO.read(url);
            image = image.getScaledInstance(147, 110,  java.awt.Image.SCALE_SMOOTH); // Scalo immagine in 4/3
            label = new JLabel(new ImageIcon(image));
        } catch (MalformedURLException ex) {
            System.out.println("Indirizzo non corretto");
        } catch (IOException iox) {
            System.out.println("Caricamento immagine fallito");
        }
        panelRistImage.add(label, BorderLayout.CENTER);
    }
}
