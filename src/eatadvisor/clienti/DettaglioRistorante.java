package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Recensione;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;

public class DettaglioRistorante {
    private Ristorante ristorante;
    public JPanel panelDettaglioRistorante;
    private JPanel panelLogo;
    private JLabel lbNomeRistorante;
    private JLabel lbIndirizzo;
    private JLabel lbValutazioni;
    private JLabel lbNumeroRecensioni;
    private JLabel lbDescrizione;
    private JPanel panelRecensioni;
    private JTextArea txtDescrizione;
    private JButton btnCreaRecensione;
    private JLabel lb5Stelle;
    private JLabel lb4Stelle;
    private JLabel lb3Stelle;
    private JLabel lb2Stelle;
    private JLabel lb1Stella;
    private JPanel panelNumValutazioni;
    private JLabel lblTipologia;
    private JPanel JPanelLeft;
    private JPanel JPanelRight;
    private JLabel lblSitoWeb;

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
        lbNomeRistorante.setText(ristorante.getNomeRistorante().substring(0, Math.min(ristorante.getNomeRistorante().length(), 40)));
        lbIndirizzo.setText(ristorante.getIndirizzo().toString().substring(0, Math.min(ristorante.getIndirizzo().toString().length(), 60)));
        lblTipologia.setText("Tipologia: " + ristorante.getTipologia());
        setPanelNumValutazioni();
        setTextAreaDescr();
        txtDescrizione.setText(ristorante.getDescrizione());

        lblSitoWeb.setText(ristorante.getSitoWeb());
        lblSitoWeb.setForeground(Color.BLUE.darker());
        lblSitoWeb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblSitoWeb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {        //Imposto la label per farla diventare un link cliccabile
                super.mouseClicked(e);
                try{
                    Desktop.getDesktop().browse(new URI(lblSitoWeb.getText()));
                }catch(IOException | URISyntaxException e1){
                    e1.printStackTrace();
                }
            }
        });

    }

    private void setTextAreaDescr() {
        txtDescrizione.setEditable(false); // impostando a false, non posso scrivere nella textarea
        txtDescrizione.setOpaque(true);
        txtDescrizione.setFocusable(false);
        txtDescrizione.setLineWrap(true);
        txtDescrizione.setWrapStyleWord(true);
    }

    private void setPanelNumValutazioni() {
        DecimalFormat dec = new DecimalFormat("#0.00");

        lbValutazioni.setText("Valutazione media: " + dec.format(ristorante.getRecensioniValutazioneMedia()));
        lbNumeroRecensioni.setText("Totale valutazioni:  "+ ristorante.getRecensioni().size());

        int fiveStars = 0;
        int fourStars = 0;
        int threeStars = 0;
        int twoStars = 0;
        int oneStar = 0;

        if (ristorante.getRecensioni().size() > 0) { //se son presenti delle recensioni
            for (Recensione rec : ristorante.getRecensioni()) { //avvio il conteggio delle valutazioni
                if (rec.getValutazione() == 5) {
                    fiveStars++;
                    lb5Stelle.setText("Valutazioni 5 stelle: " + fiveStars);
                } else if (rec.getValutazione() == 4) {
                    fourStars++;
                    lb4Stelle.setText("Valutazioni 4 stelle: " + fourStars);
                } else if (rec.getValutazione() == 3) {
                    threeStars++;
                    lb3Stelle.setText("Valutazioni 3 stelle: " + threeStars);
                } else if (rec.getValutazione() == 2) {
                    twoStars++;
                    lb2Stelle.setText("Valutazioni 2 stelle: " + twoStars);
                } else {
                    oneStar++;
                    lb1Stella.setText("Valutazioni 1 stella: " + oneStar);
                }
            }
        } else { // se le recensioni non sono presenti, le label non le mostro
            panelNumValutazioni.setVisible(false);
        }
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

        panelNumValutazioni = new JPanel();
        lb2Stelle = new JLabel();
        lb4Stelle = new JLabel();
        lb1Stella = new JLabel();
        lb5Stelle = new JLabel();
        lb3Stelle = new JLabel();

        lbValutazioni = new JLabel();
        lbNumeroRecensioni = new JLabel();

        setPanelNumValutazioni(); // Reimposto il valore delle valutazioni
    }
}
