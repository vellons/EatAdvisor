package eatadvisor.ristoratori;

import eatadvisor.clienti.ListaRecensioniPanel;
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

/**
 * La classe DettaglioMioRistorante permette di visualizzare
 * le informazioni dettagliate di un ristorante di
 * propriet&agrave; del ristoratore loggato
 * @author Mahdi Said
 */

public class DettaglioMioRistorante {

    /**
     * <code>modificaFrame</code> &egrave; una cornice Swing attivata nel momento nel
     * quale &egrave; richiesta la modifica di un ristoratore
     * @see ModificaRistorante
     * <p>
     * &egrave; dichiarata <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     * &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */

    public static JFrame modificaFrame = new JFrame("EatAdvisor Ristoratori - Modifica Ristorante");

    /**
     * <code>ristorante</code> &egrave; un'istanza della classe Ristorante che descrive
     * il comportamento dell'oggetto ristorante
     * @see Ristorante
     * <p>
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private Ristorante ristorante;

    /**
     * <code>panelDettaglioRistoratore</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di dettaglio di
     * un ristorante di propriet&agrave; del ristoratore loggato
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */

    public JPanel panelDettaglioRistorante;

    /**
     * <code>panelLogo</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il logo dell'appicazione.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel panelLogo;

    /**
     * <code>lbIndirizzo</code> &egrave; un'etichetta Swing dedicata al campo indirizzo
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lbNomeRistorante</code> &egrave; un'etichetta Swing dedicata al campo nome ristorante
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lbValutazioni</code> &egrave; un'etichetta Swing dedicata al campo valutazioni
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lbNumeroRecensioni</code> &egrave; un'etichetta Swing dedicata al campo numero di recensioni
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lb5Stelle</code> &egrave; un'etichetta Swing dedicata al campo 5 stelle
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lb4Stelle</code> &egrave; un'etichetta Swing dedicata al campo 4 stelle
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lb3Stelle</code> &egrave; un'etichetta Swing dedicata al campo 3 stelle
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lb2Stelle</code> &egrave; un'etichetta Swing dedicata al campo 2 stelle
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lb1Stella</code> &egrave; un'etichetta Swing dedicata al campo 1 stella
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lbDescrizione</code> &egrave; un'etichetta Swing dedicata al campo descrizione
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lblSitoWeb</code> &egrave; un'etichetta Swing dedicata al campo sito web
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     * <p>
     * <code>lblTipologia</code> &egrave; un'etichetta Swing dedicata al campo tipologia
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lbNomeRistorante;
    private JLabel lbIndirizzo;
    private JLabel lbValutazioni;
    private JLabel lbNumeroRecensioni;
    private JLabel lbDescrizione;

    /**
     * <code>panelRecensioni</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie le recensione per lo
     * specifico ristoranti
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel panelRecensioni;

    /**
     * <code>txtDescrizione</code> &egrave; un'area di testo Swing dedicata al campo descrizione
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
    */

    private JTextArea txtDescrizione;

    /**
     * <code>btnModificaRistorante</code> &egrave; un bottone Swing che attiva la procedura
     * di modifica di un ristoratore
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
    */

    private JButton btnModificaRistorante;
    private JLabel lb5Stelle;
    private JLabel lb4Stelle;
    private JLabel lb3Stelle;
    private JLabel lb2Stelle;
    private JLabel lb1Stella;

    /**
     * <code>panelNumValutazioni</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il numero di valutazioni
     * per una specifico valore
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel panelNumValutazioni;
    private JLabel lblTipologia;

    /**
     * <code>panelLeft</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la parte sinistra del frame.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel JPanelLeft;

    /**
     * <code>panelRight</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la parte destra del frame.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPanel JPanelRight;
    private JLabel lblSitoWeb;


    /**
     * Main della classe
     *
     * @param ristorante insieme di dati relativi al ristorante da visualizzare
     */

    public DettaglioMioRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
        setLabels(this.ristorante);
        btnModificaRistorante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modificaFrame.setContentPane(new ModificaRistorante(ristorante).panelModificaRistorante); //niente cast
                    ristoratori.initUI(modificaFrame);
                    modificaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestra
                    modificaFrame.pack();
                    modificaFrame.setLocationRelativeTo(null);
                    modificaFrame.setVisible(true);
                    ristoratori.closePreviousWindow(MioRistorantePerLista.dettaglioFrame);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    /**
     * <code>setLabels</code> &egrave; una procedura per impostare i valori delle etichette del frame
     * &egrave; dichiarato <strong>private</strong> in quanto il metodo &egrave; utilizzabile all'interno della classe
     * @param ristorante &egrave; l'insieme di dati relativi al ristorante da visualizzare
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
                try {
                    Desktop.getDesktop().browse(new URI(lblSitoWeb.getText()));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    /**
     * <code>setTextAreaDescr</code> &egrave; una procedura per impostare la descrizione
     * del ristorante quando viene caricato il frame
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     */

    private void setTextAreaDescr() {
        txtDescrizione.setEditable(false); // impostando a false, non posso scrivere nella textarea
        txtDescrizione.setOpaque(true);
        txtDescrizione.setFocusable(false);
        txtDescrizione.setLineWrap(true);
        txtDescrizione.setWrapStyleWord(true);
    }

    /**
     * <code>setPanelNumValutazioni</code> &egrave; una procedura per impostare
     * il pannello sulle valutazoni e sul loro numero quando
     * viene caricato il frame
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     */

    private void setPanelNumValutazioni() {
        DecimalFormat dec = new DecimalFormat("#0.00");

        lbValutazioni.setText("Valutazione media: " + dec.format(ristorante.getRecensioniValutazioneMedia()));
        lbNumeroRecensioni.setText("Totale valutazioni:  " + ristorante.getRecensioni().size());

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
     * <code>createUIComponents</code> &egrave; una procedura per impostare la grafica
     * quando viene caricato il frame
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     * essere sollevata durante l'esecuzione del programma
     */

    private void createUIComponents() throws Exception {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratoriDettaglio.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        panelRecensioni = new JPanel();
        // Tutte le informazioni del ristorante mi sono già state passate,
        // però se la pagina &egrave; stata refreshata dopo l'aggiunta di un commento devo aggiornare le info (recensioni)
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
