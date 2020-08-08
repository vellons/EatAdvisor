package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;

public class RistorantePerLista extends JPanel {
    public JPanel panelRistorantePerLista;
    private JLabel lblNome;
    private JLabel lblIndirizzo;
    private JLabel lblStelle;
    private JLabel lblValutazioni;


    public RistorantePerLista(Ristorante ristorante) {
        lblNome.setText(ristorante.getNomeRistorante());
        lblIndirizzo.setText(ristorante.getIndirizzo().toString());
        lblStelle.setText(String.valueOf(ristorante.getRecensioniValutazioneMedia()));
        lblValutazioni.setText(String.valueOf(ristorante.getRecensioni().size()) + " valutazioni");
    }
}
