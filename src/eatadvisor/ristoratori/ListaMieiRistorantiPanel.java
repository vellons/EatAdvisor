package eatadvisor.ristoratori;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

/**
 * La classe ListaMieiRistorantiPanel funge da contenitore per i ristoranti
 * visibili sulla dashboard
 *
 * @author Mahdi Said
 */

public class ListaMieiRistorantiPanel extends JPanel {

    /**
     * <code>mainList</code> &egrave; un pannello Swing che contiene l'elenco dei ristoranti
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */
    public JPanel mainList;

    /**
     * Costrutore della classe
     *
     * @throws Exception &egrave; un eccezione che viene lanciata quando il programma
     *                   non trova il file che si vuole utilizzare
     */
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

    /**
     * @return oggetto Dimension con le dimensioni della finestra
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }

    /**
     * @param rist &egrave; il ristorante che viene passato
     */
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
