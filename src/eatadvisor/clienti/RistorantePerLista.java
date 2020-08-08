package eatadvisor.clienti;

import javax.swing.*;

public class RistorantePerLista extends JPanel{
    public JPanel panelRistorantePerLista;
    private JLabel lblNome;
    private JLabel lblIndirizzo;

    public RistorantePerLista(String nome, String indirizzo) {
        lblNome.setText(nome);
        lblIndirizzo.setText(indirizzo);
    }
}
