package eatadvisor.ristoratori;

import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MioRistorantePerLista {
    public JPanel panelMioRistorantePerLista;
    private JLabel lblNome;
    private JPanel panelRistImage;
    private JLabel lblIndirizzo;
    private JLabel lblStelle;
    private JLabel lblValutazioni;
    private JButton btnDettaglio;

    public MioRistorantePerLista(Ristorante ristorante) {
        DecimalFormat dec = new DecimalFormat("#0.00");
        lblNome.setText(ristorante.getNomeRistorante());
        lblIndirizzo.setText(ristorante.getIndirizzo().toString());
        lblStelle.setText(String.valueOf(dec.format(ristorante.getRecensioniValutazioneMedia())));
        lblValutazioni.setText(String.valueOf(ristorante.getRecensioni().size()) + " valutazioni");

        btnDettaglio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
