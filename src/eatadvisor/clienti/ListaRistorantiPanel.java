package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ListaRistorantiPanel extends JPanel {
    public JPanel mainList;

    public ListaRistorantiPanel(String filtroNome, String filtroComune, String filtroTipologia) throws Exception {
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

        // Caricamento ristoranti, se i filtri sono presenti li applico
        IOEatAdvisor ioEatAdvisor = new IOEatAdvisor();
        if (!filtroNome.equals("")) {
            System.out.println("Applico filtro per nome: " + filtroNome);
            ioEatAdvisor.filtraPerNomeRistorante(filtroNome);
        }
        if (!filtroComune.equals("")) {
            System.out.println("Applico filtro per comune: " + filtroComune);
            ioEatAdvisor.filtraPerCitta(filtroComune);
        }
        if (!filtroTipologia.equals("") && !filtroTipologia.equals("TUTTI")) {
            System.out.println("Applico filtro per tipologia: " + filtroTipologia);
            ioEatAdvisor.filtraPerTipo(filtroTipologia);
        }

        // Controllo se dopo aver applicato i filtri ci sono ancora ristoranti
        if (ioEatAdvisor.getListaRistoranti().size() > 0) {
            // Scorro la lista rimasta dei ristoranti
            for (Ristorante rist : ioEatAdvisor.getListaRistoranti()) {
                aggiungiRistorante(rist);
            }
        } else {
            JPanel panel = new JPanel();
            panel.add(new JLabel("<html><center>Non ci sono ristoranti corrispondenti a questi criteri di recerca." +
                    "<br/>Prova rimuovere i filtri e schiaccia il tasto \"Applica filtri\"</center></html>"));
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

    private void aggiungiRistorante(Ristorante rist) {
        JPanel panel = new JPanel();
        panel.add(new RistorantePerLista(rist).panelRistorantePerLista);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainList.add(panel, gbc, 0);
        validate();
        repaint();
    }
}
