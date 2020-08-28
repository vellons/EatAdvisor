package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Recensione;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

/**
 * La classe ListaRecensioniPanel permette di visualizzare la lista delle recensioni lasciate dagli utenti
 *
 * @author Manuel Macaj
 */
public class ListaRecensioniPanel extends JPanel {
    public JPanel mainList;

    /**
     * Costrutore della classe
     *
     * @param ristorante &egrave; un ristorante che viene passato al costruttore
     * @throws Exception &egrave; un eccezione che viene lanciata quando il programma
     *                   non trova il file che si vuole utilizzare
     */
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

    /**
     * @return oggetto Dimension con le dimensioni della finestra
     */
    public Dimension getPreferredSize() {
        return new Dimension(365, 475);
    }

    /**
     * @param rec &egrave; la recensione che viene passata
     * @throws Exception &egrave; un eccezione che viene lanciata quando il programma
     *                   non trova il file che si vuole utilizzare
     */
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
