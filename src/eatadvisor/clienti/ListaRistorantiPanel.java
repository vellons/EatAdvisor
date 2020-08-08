package eatadvisor.clienti;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaRistorantiPanel extends JPanel {

    public JPanel mainList;

    public ListaRistorantiPanel() {
        setLayout(new BorderLayout());

        mainList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainList.add(new JPanel(), gbc);

        add(new JScrollPane(mainList));

        JButton add = new JButton("Add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                //panel.add(new JLabel("Hello"));
                panel.add(new RistorantePerLista("Ristorante1", "Via le dita dal Naso, 2, Verbania, 28922").panelRistorantePerLista);
                panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.weightx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                mainList.add(panel, gbc, 0);

                validate();
                repaint();
            }
        });

        add(add, BorderLayout.SOUTH);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}