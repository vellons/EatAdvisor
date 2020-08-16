package eatadvisor.ristoratori;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;


public class ListaMieiRistorantiPanel extends JPanel {

    public JPanel mainList;

    public ListaMieiRistorantiPanel() throws Exception {
        setLayout(new BorderLayout());

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
        int id = Global.utenteLoggato.getId();
        ioEatAdvisor.filtraPerProprietarioId(id);
        if (ioEatAdvisor.getListaRistoranti().size() > 0) {
            for (Ristorante rist : ioEatAdvisor.getListaRistoranti()) {
                aggiungiRistorante(rist);
            }
        } else {
            JPanel panel = new JPanel();
            panel.add(new JLabel("<html><center>Non hai ancora ristoranti.<br/>Aggiungi il primo!!</center></html>"));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            mainList.add(panel, gbc, 0);
            validate();
            repaint();
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

    private void aggiungiRistorante(Ristorante rist) {
        JPanel panel = new JPanel();
        panel.add(new MioRistorantePerLista(rist).panelMioRistorantePerLista);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainList.add(panel, gbc, 0);
        validate();
        repaint();
    }
}
