package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Recensione;
import eatadvisor.ioeatadvisor.Ristorante;
import eatadvisor.ristoratori.ModificaRistorante;

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

/**
 * La classe DettaglioRistorante permette di visualizzare
 * le informazioni dettagliate di un ristorante
 * @author Manuel Macaj
 */

public class DettaglioRistorante {

    /**
     * <code>ristorante</code> è un'istanza della classe Ristorante che descrive
     * il comportamento dell'oggetto ristorante
     * @see Ristorante
     * <p>
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private Ristorante ristorante;

    /**
     * <code>panelDettaglioRistoratore</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di dettaglio di
     * un ristorante a scelta
     * <p>
     * è dichiarato <strong>public</strong> in quanto l'attributo è utilizzabile all'esterno della classe
     */

    public JPanel panelDettaglioRistorante;

    /**
     * <code>panelLogo</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il logo dell'appicazione.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPanel panelLogo;

    /**
     * <code>lbIndirizzo</code> è un'etichetta Swing dedicata al campo indirizzo
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lbNomeRistorante</code> è un'etichetta Swing dedicata al campo nome ristorante
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lbValutazioni</code> è un'etichetta Swing dedicata al campo valutazioni
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lbNumeroRecensioni</code> è un'etichetta Swing dedicata al campo numero di recensioni
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lb5Stelle</code> è un'etichetta Swing dedicata al campo 5 stelle
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lb4Stelle</code> è un'etichetta Swing dedicata al campo 4 stelle
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lb3Stelle</code> è un'etichetta Swing dedicata al campo 3 stelle
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lb2Stelle</code> è un'etichetta Swing dedicata al campo 2 stelle
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lb1Stella</code> è un'etichetta Swing dedicata al campo 1 stella
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lbDescrizione</code> è un'etichetta Swing dedicata al campo descrizione
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblSitoWeb</code> è un'etichetta Swing dedicata al campo sito web
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblTipologia</code> è un'etichetta Swing dedicata al campo tipologia
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JLabel lbNomeRistorante;
    private JLabel lbIndirizzo;
    private JLabel lbValutazioni;
    private JLabel lbNumeroRecensioni;
    private JLabel lbDescrizione;

    /**
     * <code>panelRecensioni</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la parte dedicata alle recensioni
     * per una specifico valore
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPanel panelRecensioni;
    private JTextArea txtDescrizione;

    /**
     * <code>btnCreaRecensione</code> è un bottone Swing che attiva la procedura
     * di creazione di una nuova recensione
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     */

    private JButton btnCreaRecensione;
    private JLabel lb5Stelle;
    private JLabel lb4Stelle;
    private JLabel lb3Stelle;
    private JLabel lb2Stelle;
    private JLabel lb1Stella;

    /**
     * <code>panelNumValutazioni</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il numero di valutazioni
     * per una specifico valore
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPanel panelNumValutazioni;
    private JLabel lblTipologia;

    /**
     * <code>panelLeft</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la parte sinistra del frame.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPanel JPanelLeft;

    /**
     * <code>panelRight</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la parte destra del frame.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPanel JPanelRight;
    private JLabel lblSitoWeb;

    /**
     * <code>frameRewiew</code> è una cornice Swing attivata nel momento nel
     * quale è richiesta l'aggiunta di una nuova recensione
     * @see CreaRecensione
     * <p>
     * è dichiarata <strong>public</strong> in quanto l'attributo è utilizzabile all'esterno della classe
     * è dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */

    public static JFrame frameReview = new JFrame("EatAdvisor Cliente - Nuova recensione");

    /**
     * Main della classe
     *
     * @param ristorante insieme di dati relativi al ristorante da visualizzare
     */

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
                        frameReview.setContentPane(new CreaRecensione(ristorante).panelCreaRecensione);
                        frameReview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                        frameReview.pack();
                        frameReview.setLocationRelativeTo(null);
                        frameReview.setVisible(true);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * <code>setLabels</code> è una procedura per impostare i valori delle etichette del frame
     * è dichiarato <strong>private</strong> in quanto il metodo è utilizzabile all'interno della classe
     * @param ristorante è l'insieme di dati relativi al ristorante da visualizzare
     */

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

    /**
     * <code>setTextAreaDescr</code> è una procedura per impostare la descrizione
     * del ristorante quando viene caricato il frame
     * è dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     */

    private void setTextAreaDescr() {
        txtDescrizione.setEditable(false); // impostando a false, non posso scrivere nella textarea
        txtDescrizione.setOpaque(true);
        txtDescrizione.setFocusable(false);
        txtDescrizione.setLineWrap(true);
        txtDescrizione.setWrapStyleWord(true);
    }

    /**
     * <code>setPanelNumValutazioni</code> è una procedura per impostare
     * il pannello sulle valutazoni e sul loro numero quando
     * viene caricato il frame
     * è dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     */

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

    /**
     * <code>createUIComponents</code> è una procedura per impostare la grafica
     * quando viene caricato il frame
     * è dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *
     * @throws Exception è utilizzata quando non si sa che tipo di eccezione potrebbe
     * essere sollevata durante l'esecuzione del programma
     */

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
