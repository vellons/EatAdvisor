package eatadvisor.ristoratori;

import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Indirizzo;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ModificaRistorante {
    private IOEatAdvisor ioEatAdvisor = null;
    private Ristorante ristorante;
    String[] tipologia = new String[]{"ITALIANO", "ETNICO", "FUSION"};
    public JPanel panelModificaRistorante;
    private JPanel panelLogo;
    private JLabel lblErrors;
    private JButton btnModifica;
    private JPanel panelDescrizione;
    private JLabel lblTipologia;
    private JLabel lblNomeRistorante;
    private JLabel lblVia;
    private JLabel lblCivico;
    private JLabel lblCitta;
    private JLabel lblProvincia;
    private JLabel lblCap;
    private JLabel lblTelefono;
    private JLabel lblSitoWeb;
    private JLabel lblDescrizione;
    private JTextArea tareaDescrizione;
    public JComboBox<String> cboxTipologia;
    private JTextField tfNomeRistorante;
    private JTextField tfVia;
    private JTextField tfCivico;
    private JTextField tfCitta;
    private JTextField tfProvincia;
    private JTextField tfUrlImmagine;
    private JTextField tfSitoWeb;
    private JTextField tfCap;
    private JTextField tfTelefono;
    private Indirizzo indirizzo;

    public ModificaRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
        setLabels(this.ristorante);
        btnModifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkAllInputs()) {
                    try {
                        int id = ristorante.getId();
                        indirizzo = new Indirizzo(getTfVia(), getTfCivico(), getTfCitta(), getTfProvincia(), getTfCap());
                        ioEatAdvisor = new IOEatAdvisor();
                        ioEatAdvisor.aggiornaRistoranteById(id, Objects.requireNonNull(cboxTipologia.getSelectedItem()).toString(), getTfNomeRistorante(),
                                getTareaDescrizione(), indirizzo, getTfTelefono(), getTfSito());
                        ristoratori.closePreviousWindow(DettaglioMioRistorante.modificaFrame);

                        JOptionPane.showMessageDialog(null, "Informazioni ristorante aggiornate\n" +
                                "La dashboard verrà ricaricata per mostrarti le modifiche effettuate", "Ristorante modificato", JOptionPane.PLAIN_MESSAGE);

                        ristoratori.reloadDashboardRistoranti(StartRistoratore.dashboardRistoratore);
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Abbiamo riscontrato problemi durante la fase di modifica, prova a riavviare l'app",
                                "Attenzione", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    lblErrors.setFont(new Font("Default", Font.BOLD, 14));
                    lblErrors.setForeground(Color.RED);
                    lblErrors.setVisible(true);
                }

            }
        });
    }

    private void setLabels(Ristorante ristorante) {
        cboxTipologia.setSelectedItem(ristorante.getTipologia());
        tfNomeRistorante.setText(ristorante.getNomeRistorante());
        tfVia.setText(String.valueOf(ristorante.getIndirizzo().getVia()));
        tfCivico.setText(String.valueOf(ristorante.getIndirizzo().getCivico()));
        tfCitta.setText(String.valueOf(ristorante.getIndirizzo().getCitta()));
        tfProvincia.setText(String.valueOf(ristorante.getIndirizzo().getSiglaProvincia()));
        tfCap.setText(String.valueOf(ristorante.getIndirizzo().getCap()));
        tfTelefono.setText(String.valueOf(ristorante.getNumeroTelefono()));
        tfSitoWeb.setText(String.valueOf(ristorante.getSitoWeb()));
        setTextAreaDescr();
        tareaDescrizione.setText(ristorante.getDescrizione());
    }

    private void setTextAreaDescr() {
        tareaDescrizione.setEditable(true);
        tareaDescrizione.setOpaque(true);
        tareaDescrizione.setFocusable(true);
        tareaDescrizione.setLineWrap(true);
        tareaDescrizione.setWrapStyleWord(true);
    }


    // Metodi GETTERS

    public String getTfNomeRistorante() {
        return tfNomeRistorante.getText();
    }

    public String getTareaDescrizione() {
        return tareaDescrizione.getText();
    }

    public String getTfVia() {
        return tfVia.getText();
    }

    public String getTfCivico() {
        return tfCivico.getText();
    }

    public String getTfCitta() {
        return tfCitta.getText();
    }

    public String getTfProvincia() {
        return tfProvincia.getText();
    }

    public String getTfCap() {
        return tfCap.getText();
    }

    public String getTfTelefono() {
        return tfTelefono.getText();
    }

    public String getTfSito() {
        return tfSitoWeb.getText();
    }

    private boolean checkAllInputs() {
        boolean allFieldsValid = true;  // Tramite una variabile booleana, verifico se tutti i campi siano completi

        //  allFieldsValid &= checkInput(getTfNome(), tfNome); // Per ogni TextField, verifico se è diverso da vuoto
        allFieldsValid &= checkInput(getTfNomeRistorante(), tfNomeRistorante);
        allFieldsValid &= checkInput(getTfVia(), tfVia);
        allFieldsValid &= checkInput(getTfCivico(), tfCivico);
        allFieldsValid &= checkInput(getTfCitta(), tfCitta);
        allFieldsValid &= checkInput(getTfProvincia(), tfProvincia);
        allFieldsValid &= checkInput(getTfCap(), tfCap);
        allFieldsValid &= checkInput(getTfTelefono(), tfTelefono);
        allFieldsValid &= checkInput(getTfSito(), tfSitoWeb);
        allFieldsValid &= !getTareaDescrizione().equals("");

        return allFieldsValid; // Restituisco il risultato booleano proveniente da CheckInput
    }

    private boolean checkInput(String input, JTextField textField) { // Funzione per la verifica del textfield
        boolean res;
        String tmp = "";
        tmp += input;
        if (tmp.equals("")) { // Se il campo e vuoto, visualizzo una scritta
            res = false;
        } else {
            res = true;
        }
        return res;
    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratoriModificaRistorante.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        cboxTipologia = new JComboBox<String>(tipologia);
    }
}
