package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RistorantePerLista extends JPanel {
    private Ristorante ristorante;
    public static JFrame dettaglioFrame = new JFrame();
    public JPanel panelRistorantePerLista;
    private JLabel lblNome;
    private JLabel lblIndirizzo;
    private JLabel lblStelle;
    private JLabel lblValutazioni;
    private JButton btnDettaglio;
    private JPanel panelRistImage;


    public RistorantePerLista(Ristorante ristorante) {
        //this.ristorante = ristorante;
        DecimalFormat dec = new DecimalFormat("#0.00");
        lblNome.setText(ristorante.getNomeRistorante());
        lblIndirizzo.setText(ristorante.getIndirizzo().toString());
        lblStelle.setText(String.valueOf(dec.format(ristorante.getRecensioniValutazioneMedia())));
        lblValutazioni.setText(String.valueOf(ristorante.getRecensioni().size()) + " valutazioni");

        btnDettaglio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dettaglioFrame.setContentPane(new DettaglioRistorante(ristorante).panelDettaglioRistorante);
                    clienti.initUI(dettaglioFrame);
                    dettaglioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce il comportamento della finestra
                    dettaglioFrame.pack();
                    dettaglioFrame.setLocationRelativeTo(null);
                    dettaglioFrame.setVisible(true);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
    }
}
