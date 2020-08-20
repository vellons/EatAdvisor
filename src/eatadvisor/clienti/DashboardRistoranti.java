package eatadvisor.clienti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class DashboardRistoranti extends JFrame {
    public JPanel panelDashboardRistoranti;
    private JPanel panelLogo;
    private JPanel panelListaRistoranti;
    private JButton btnApplicaFiltri;
    private JComboBox cboxTipologia;
    private JTextField tfFiltroNomeRistorante;
    private JTextField tfFiltroComune;
    private String[] tipologia = new String[]{"TUTTI", "ITALIANO", "ETNICO", "FUSION"};

    private String initialFiltroNome = "";
    private String initialFiltroComune = "verb";
    private String initialFiltroTipologia = "";

    public DashboardRistoranti(String filtroNome, String filtroComune, String filtroTipologia) throws Exception {
        // Prendo i valori dei 3 filtri precedenti e li popolo all'interno dei filtri
        // Questo succede perchè faccio il reload di questo oggetto
        initialFiltroNome = filtroNome;
        initialFiltroComune = filtroComune;
        initialFiltroTipologia = filtroTipologia;

        btnApplicaFiltri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    clienti.reloadDashBoardConFiltri(
                            StartClienti.dashboardRistoranti,
                            tfFiltroNomeRistorante.getText(),
                            tfFiltroComune.getText(),
                            cboxTipologia.getSelectedItem().toString());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

//                panelListaRistoranti.removeAll();
//                panelListaRistoranti.validate();
//                panelListaRistoranti.repaint();
//                validate();
//                repaint();
//
//                panelListaRistoranti = new JPanel();
//                try {
//                    panelListaRistoranti.add(new ListaRistorantiPanel(filtroTipologia)); // Aggiungo la lista dei ristoranti
//                } catch (Exception exception) {
//                    exception.printStackTrace();
//                }
//
//                validate();
//                repaint();
//                panelListaRistoranti.updateUI();
//                panelListaRistoranti.setVisible(true);
//                setVisible(true);

            }
        });
    }

    private void createUIComponents() throws Exception {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoClientiListaRistoranti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        // Creo la lista dei ristoranti passando i 3 filtri
        panelListaRistoranti = new JPanel();
        panelListaRistoranti.add(new ListaRistorantiPanel(initialFiltroNome, initialFiltroComune, initialFiltroTipologia));



        tfFiltroNomeRistorante = new JTextField();
        tfFiltroComune = new JTextField();

        tfFiltroNomeRistorante.setText(initialFiltroNome);
        tfFiltroComune.setText(initialFiltroComune);

        cboxTipologia = new JComboBox<String>(tipologia);
        cboxTipologia.setSelectedItem(initialFiltroTipologia);
    }
}
