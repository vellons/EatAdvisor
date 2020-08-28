package eatadvisor.ristoratori;

import eatadvisor.ioeatadvisor.IOEatAdvisor;
import eatadvisor.ioeatadvisor.Indirizzo;
import eatadvisor.ioeatadvisor.Ristorante;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * La classe ModificaRistorante permette la modifica di
 * un ristoratore sull'applicazione
 *
 * @author Mahdi Said
 */

public class ModificaRistorante {

    /**
     * <code>ioEatAdvisor</code> &egrave; un'istanza della classe IOEatAdvisor che
     * permette di usare le funzionalit&agrave; per la gestione dei ristoranti e dei ristoratori.
     *
     * @see IOEatAdvisor
     * <p>
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private IOEatAdvisor ioEatAdvisor = null;

    /**
     * <code>ristorante</code> &egrave; un'istanza della classe Ristorante che descrive
     * il comportamento dell'oggetto ristorante
     *
     * @see Ristorante
     * <p>
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private final Ristorante ristorante;

    /**
     * <code>tipologia</code> &egrave; un array di stringhe che contiene i tre
     * possibili valori per la tipologia di un ristorante
     */
    String[] tipologia = new String[]{"ITALIANO", "ETNICO", "FUSION"};

    /**
     * <code>panelModificaRistorante</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di modifica di
     * un ristorante
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */
    public JPanel panelModificaRistorante;

    /**
     * <code>panelLogo</code> &egrave; un pannello Swing che contiene la parte
     * della finestra dedicata alla descrizione del ristorante
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JPanel panelLogo;

    /**
     * <code>lblErrors</code> &egrave; un'etichetta Swing dedicata al campo di controllo errori
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblErrors;

    /**
     * <code>btnModifica</code> &egrave; un bottone Swing che attiva la procedura
     * di modifica del ristorante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JButton btnModifica;

    /**
     * <code>panelDescrizione</code> &egrave; un pannello Swing che contiene la parte
     * della finestra dedicata alla descrizione del ristorante
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JPanel panelDescrizione;

    /**
     * <code>lblTipologia</code> &egrave; un'etichetta Swing dedicata al campo tipologia
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblTipologia;

    /**
     * <code>lblNomeRistorante</code> &egrave; un'etichetta Swing dedicata al campo nome ristoratore
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblNomeRistorante;

    /**
     * <code>lblVia</code> &egrave; un'etichetta Swing dedicata al campo via
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblVia;

    /**
     * <code>lblCivico</code> &egrave; un'etichetta Swing dedicata al campo numero civico
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblCivico;

    /**
     * <code>lblCitta</code> &egrave; un'etichetta Swing dedicata al campo citta
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblCitta;

    /**
     * <code>lblProvincia</code> &egrave; un'etichetta Swing dedicata al campo provincia
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblProvincia;

    /**
     * <code>lblCap</code> &egrave; un'etichetta Swing dedicata al campo cap
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblCap;

    /**
     * <code>lblTelefono</code> &egrave; un'etichetta Swing dedicata al campo numero di telefono
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblTelefono;

    /**
     * <code>lblSitoWeb</code> &egrave; un'etichetta Swing dedicata al campo sito web
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblSitoWeb;

    /**
     * <code>lblDescrizione</code> &egrave; un'etichetta Swing dedicata al campo descrizione
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblDescrizione;

    /**
     * <code>tareaDescrizione</code> &egrave; un'etichetta Swing dedicata al campo area descrizione
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextArea tareaDescrizione;

    /**
     * <code>cboxTipologia</code> &egrave; una combobox Swing usata per la selezione della
     * tipologia del ristorante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    public JComboBox<String> cboxTipologia;

    /**
     * <code>tfNomeRistorante</code> &egrave; un campo di testo Swing dedicato al nome ristorante
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfNomeRistorante;

    /**
     * <code>tfVia</code> &egrave; un campo di testo Swing dedicato alla via
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfVia;

    /**
     * <code>tfCivico</code> &egrave; un campo di testo Swing dedicato al numero civico
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfCivico;

    /**
     * <code>tfCitta</code> &egrave; un campo di testo Swing dedicato alla citta
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfCitta;


    /**
     * <code>tfProvincia</code> &egrave; un campo di testo Swing dedicato alla provincia
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfProvincia;

    /**
     * <code>tfUrlImmagine</code> &egrave; un campo di testo Swing dedicato all'url immagine
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfUrlImmagine;

    /**
     * <code>tfSitoWeb</code> &egrave; un campo di testo Swing dedicato al sito web
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfSitoWeb;


    /**
     * <code>tfCap</code> &egrave; un campo di testo Swing dedicato al cap
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfCap;

    /**
     * <code>tfTelefono</code> &egrave; un campo di testo Swing dedicato al numero di telefono
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfTelefono;

    /**
     * <code>indirizzo</code> &egrave; un'istanza della classe Indirizzo che
     * &egrave; utizizzata per salvare i dati dell'indirizzo completo sull'applicazione
     *
     * @see Indirizzo
     * <p>
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private Indirizzo indirizzo;

    /**
     * Main della classe
     *
     * @param ristorante insieme di dati relativi al ristorante da modificare
     */
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

    /**
     * <code>setLabels</code> &egrave; una procedura per impostare i valori delle etichette del frame
     * &egrave; dichiarato <strong>private</strong> in quanto il metodo &egrave; utilizzabile all'interno della classe
     *
     * @param ristorante &egrave; l'insieme di dati relativi al ristorante da modificare
     */
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

    /**
     * <code>setTextAreaDescr</code> &egrave; una procedura per impostare la descrizione
     * del ristorante quando viene caricato il frame
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     */
    private void setTextAreaDescr() {
        tareaDescrizione.setEditable(true);
        tareaDescrizione.setOpaque(true);
        tareaDescrizione.setFocusable(true);
        tareaDescrizione.setLineWrap(true);
        tareaDescrizione.setWrapStyleWord(true);
    }


    /**
     * <code>getTfNomeRistorante</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore del nome del ristorante dal campo di testo
     */
    public String getTfNomeRistorante() {
        return tfNomeRistorante.getText();
    }

    /**
     * <code>getTareaDescrizione</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore della descrizione dall'area di testo
     */
    public String getTareaDescrizione() {
        return tareaDescrizione.getText();
    }

    /**
     * <code>getTfVia</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore della via dal campo di testo
     */
    public String getTfVia() {
        return tfVia.getText();
    }

    /**
     * <code>getTfCivico</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore del numero civico dal campo di testo
     */
    public String getTfCivico() {
        return tfCivico.getText();
    }

    /**
     * <code>getTfCitta</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore della citt&agrave; dal campo di testo
     */
    public String getTfCitta() {
        return tfCitta.getText();
    }

    /**
     * <code>getTfProvincia</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore della provincia dal campo di testo
     */
    public String getTfProvincia() {
        return tfProvincia.getText();
    }

    /**
     * <code>getTfCap</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore del cap dal campo di testo
     */
    public String getTfCap() {
        return tfCap.getText();
    }

    /**
     * <code>getTfTelefono</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore del numero di telefono dal campo di testo
     */
    public String getTfTelefono() {
        return tfTelefono.getText();
    }

    /**
     * <code>getTfSito</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore del sito web dal campo di testo
     */
    public String getTfSito() {
        return tfSitoWeb.getText();
    }

    /**
     * <code>checkAllInputs</code> &egrave; un metodo per controllare il contenuto dei textfield
     * &egrave; dichiarato <strong>private</strong> in quanto il metodo &egrave; utilizzabile all'interno della classe
     *
     * @return valore booleano che indica se sono stati inseriti i dati in tutti i textfield
     */
    private boolean checkAllInputs() {
        boolean allFieldsValid = true;  // Tramite una variabile booleana, verifico se tutti i campi siano completi

        //  allFieldsValid &= checkInput(getTfNome(), tfNome); // Per ogni TextField, verifico se &egrave; diverso da vuoto
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

    /**
     * <code>checkInput</code> &egrave; un metodo per controllare l'input di un textfield
     * &egrave; dichiarato <strong>private</strong> in quanto il metodo &egrave; utilizzabile all'interno della classe
     *
     * @param input     &egrave; una stringa rappresentante il contenuto del campo da analizzare
     * @param textField &egrave; il textfield di riferimento dell'input
     * @return valore booleano che indica se il dato &egrave; inserito nel textfield
     */
    private boolean checkInput(String input, JTextField textField) { // Funzione per la verifica del textfield
        boolean res;
        String tmp = "";
        tmp += input;
        // Se il campo e vuoto, visualizzo una scritta
        res = !tmp.equals("");
        return res;
    }

    /**
     * <code>createUIComponents</code> &egrave; una procedura per impostare la grafica
     * quando viene caricato il frame
     * &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *
     * @throws IOException &egrave; un eccezione che viene lanciata quando il programma non trova il file che si vuole utilizzare
     */
    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratoriModificaRistorante.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        cboxTipologia = new JComboBox<String>(tipologia);
    }
}
