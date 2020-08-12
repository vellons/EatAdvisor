package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Recensione;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ListaRecensioniPanel extends JPanel{
    public JPanel mainList;

    public ListaRecensioniPanel(Ristorante ristorante) throws Exception{
        //ArrayList<Recensione> recensioni = ristorante.getRecensioni();
        setLayout(new BorderLayout());

        mainList = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        mainList.add(new JPanel(), gridBagConstraints);
        JScrollPane jScrollPane = new JScrollPane(mainList);
        jScrollPane.setBorder(createEmptyBorder());
        add(jScrollPane);
        validate();
        repaint();

        //caricamento recensioni

        for (Recensione rec: ristorante.getRecensioni()){
            aggiungiRecensione(rec);
        }





    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }

    private void resetMainList() {
        mainList.removeAll();
        revalidate();
        repaint();
    }

    private void aggiungiRecensione(Recensione rec) {
        JPanel panel = new JPanel();
        //panel.add(new (rec).);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainList.add(panel, gbc, 0);
        validate();
        repaint();
    }
}