package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.print.attribute.standard.JobStateReason;
import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ListaRistorantiPanel extends JPanel {

    public JPanel mainList;

    public ListaRistorantiPanel() throws Exception {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#ff0000"));
        setForeground(Color.decode("#ff0000"));

        // Inizializzazione panel
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

        // Caricamento ristoranti
        IOEatAdvisor ioEatAdvisor = new IOEatAdvisor();
        for (Ristorante r : ioEatAdvisor.getListaRistoranti()) {
            aggiungiRistorante(r.getId(), r.getNomeRistorante(), r.getIndirizzo().toString());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }

    private void resetMainList() {
        mainList.removeAll();
        revalidate();
        repaint();
    }

    private void aggiungiRistorante(int id, String nome, String indirizzo) {
        JPanel panel = new JPanel();
        panel.add(new RistorantePerLista(nome, indirizzo).panelRistorantePerLista);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainList.add(panel, gbc, 0);
        validate();
        repaint();
    }
}