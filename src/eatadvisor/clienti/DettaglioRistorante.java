package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;

public class DettaglioRistorante {
    private Ristorante ristorante;
    public JPanel panelDettaglioRistorante;
    private JPanel panelLogo;
    private JLabel lbNomeRistorante;
    private JLabel lbIndirizzo;
    private JLabel lbValutazioni;
    private JPanel panelPicRistorante;
    private JLabel lbNumeroRecensioni;
    private JLabel lbDescrizione;
    private JPanel panelRecensioni;
    private JTextArea txtDescrizione;
    private JButton btnCreaRecensione;

    public static JFrame frameRewiew = new JFrame("EatAdvisor Cliente - Nuova recensione");

    public DettaglioRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
        setLabels(this.ristorante);
        btnCreaRecensione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Global.utenteLoggato == null) {
                    JOptionPane.showMessageDialog(null, "" +
                                    "Funzionalità non disponibile per gli utenti non loggati.\n" +
                                    "Per commentare, accedi ad EatAvisor.",
                            "Funzione commento non disponibile", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        frameRewiew.setContentPane(new CreaRecensione(ristorante).panelCreaRecensione);
                        frameRewiew.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                        frameRewiew.pack();
                        frameRewiew.setLocationRelativeTo(null);
                        frameRewiew.setVisible(true);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
    }

    private void setLabels(Ristorante ristorante) {
        DecimalFormat dec = new DecimalFormat("#0.00");
        lbNomeRistorante.setText(ristorante.getNomeRistorante());
        lbIndirizzo.setText(String.valueOf(ristorante.getIndirizzo()));
        lbValutazioni.setText("Valutazione media: " + dec.format(ristorante.getRecensioniValutazioneMedia()));
        lbNumeroRecensioni.setText(ristorante.getRecensioni().size() + " valutazioni");

        setTextAreaDescr();
        txtDescrizione.setText(ristorante.getDescrizione());
    }

    private void setTextAreaDescr() {
        txtDescrizione.setEditable(false); // impostando a false, non posso scrivere nella textarea
        txtDescrizione.setOpaque(true);
        txtDescrizione.setFocusable(false);
        txtDescrizione.setLineWrap(true);
        txtDescrizione.setWrapStyleWord(true);
    }

    private void createUIComponents() throws Exception {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoClientiDettaglio.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        panelRecensioni = new JPanel();
        // Tutte le informazioni del ristorante mi sono già state passate,
        // però se la pagina è stata refreshata dopo l'aggiunta di un commento devo aggiornare le info (recensioni)
        // del ristorante che sto visualizzando nella schermata!
        IOEatAdvisor ioEatAdvisor = new IOEatAdvisor();
        this.ristorante = ioEatAdvisor.getRistoranteById(this.ristorante.getId());
        panelRecensioni.add(new ListaRecensioniPanel(this.ristorante)); // Aggiungo la lista dei ristoranti
    }
}
