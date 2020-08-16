package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Recensione;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ListaRecensioniPanel extends JPanel {
    public JPanel mainList;

    public ListaRecensioniPanel(Ristorante ristorante) throws Exception {
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
        if (ristorante.getRecensioni().size() > 0) {
            for (Recensione rec : ristorante.getRecensioni()) {
                aggiungiRecensione(rec);
            }
        } else {
            JPanel panel = new JPanel();
            panel.add(new JLabel("<html><center>Non ci sono ancora recensioni per questo ristorante.<br/>Aggiungi la prima!!</center></html>"));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            mainList.add(panel, gbc, 0);
            validate();
            repaint();
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(365, 365);
    }

    private void resetMainList() {
        mainList.removeAll();
        revalidate();
        repaint();
    }

    private void aggiungiRecensione(Recensione rec) throws Exception {
        JPanel panel = new JPanel();
        panel.add(new RecensioniPerRistorante(rec).panelRecensionePerRistorante);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainList.add(panel, gbc, 0);
        validate();
        repaint();
    }
}
