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

/**
 * La classe ModificaRistorante permette la modifica di
 * un ristoratore sull'applicazione
 *
 * @author Mahdi Said
 */

public class ModificaRistorante {

    /**
     * <code>ioEatAdvisor</code> è un'istanza della classe IOEatAdvisor che
     * permette di usare le funzionalità per la gestione dei ristoranti e dei ristoratori.
     * @see IOEatAdvisor
     * <p>
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private IOEatAdvisor ioEatAdvisor = null;

    /**
     * <code>ristorante</code> è un'istanza della classe Ristorante che descrive
     * il comportamento dell'oggetto ristorante
     * @see Ristorante
     * <p>
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private Ristorante ristorante;

    /**
     * <code>tipologia</code> è un array di stringhe che contiene i tre
     * possibili valori per la tipologia di un ristorante
     */

    String[] tipologia = new String[]{"ITALIANO", "ETNICO", "FUSION"};

    /**
     * <code>panelModificaRistorante</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di modifica di
     * un ristorante
     * <p>
     * è dichiarato <strong>public</strong> in quanto l'attributo è utilizzabile all'esterno della classe
     */

    public JPanel panelModificaRistorante;

    /**
     * <code>panelLogo</code> è un pannello Swing che contiene la parte
     * della finestra dedicata alla descrizione del ristorante
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPanel panelLogo;

    /**
     * <code>lblErrors</code> è un'etichetta Swing dedicata al campo di controllo errori
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JLabel lblErrors;

    /**
     * <code>btnModifica</code> è un bottone Swing che attiva la procedura
     * di modifica del ristorante
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JButton btnModifica;

    /**
     * <code>panelDescrizione</code> è un pannello Swing che contiene la parte
     * della finestra dedicata alla descrizione del ristorante
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPanel panelDescrizione;

    /**
     * <code>lblTipologia</code> è un'etichetta Swing dedicata al campo tipologia
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblNomeRistorante</code> è un'etichetta Swing dedicata al campo nome ristorante
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblVia</code> è un'etichetta Swing dedicata al campo via
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblCivico</code> è un'etichetta Swing dedicata al campo numero civico
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblCitta</code> è un'etichetta Swing dedicata al campo città
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblProvincia</code> è un'etichetta Swing dedicata al campo sigla provincia
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblCap</code> è un'etichetta Swing dedicata al campo cap
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblTelefono</code> è un'etichetta Swing dedicata al campo numero di telefono
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblSitoWeb</code> è un'etichetta Swing dedicata al campo sito web
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblDescrizione</code> è un'etichetta Swing dedicata al campo descrizione
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

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

    /**
     * <code>cboxTipologia</code> è una combobox Swing usata per la selezione della
     * tipologia del ristorante
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    public JComboBox<String> cboxTipologia;

    /**
     * <code>tfNomeRistorante</code> è un campo di testo Swing dedicato al nome ristorante
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfVia</code> è un campo di testo Swing dedicato al campo via
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfCivico</code> è un campo di testo Swing dedicato al campo numero civico
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfCitta</code> è un campo di testo Swing dedicato al campo città
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfProvincia</code> è un campo di testo Swing dedicato al campo sigla provincia
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfCap</code> è un campo di testo Swing dedicato al campo cap
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfTelefono</code> è un campo di testo Swing dedicata al campo numero di telefono
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfSitoWeb</code> è un'etichetta Swing dedicata al campo sito web
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tareaDescrizione</code> è un'area di testo Swing dedicata al campo descrizione
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JTextField tfNomeRistorante;
    private JTextField tfVia;
    private JTextField tfCivico;
    private JTextField tfCitta;
    private JTextField tfProvincia;
    private JTextField tfUrlImmagine;
    private JTextField tfSitoWeb;
    private JTextField tfCap;
    private JTextField tfTelefono;

    /**
     * <code>indirizzo</code> è un'istanza della classe Indirizzo che
     * è utizizzata per salvare i dati dell'indirizzo completo sull'applicazione
     * @see Indirizzo
     * <p>
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
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
     * <code>setLabels</code> è una procedura per impostare i valori delle etichette del frame
     * è dichiarato <strong>private</strong> in quanto il metodo è utilizzabile all'interno della classe
     * @param ristorante è l'insieme di dati relativi al ristorante da modificare
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
     * <code>setTextAreaDescr</code> è una procedura per impostare la descrizione
     * del ristorante quando viene caricato il frame
     * è dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     */

    private void setTextAreaDescr() {
        tareaDescrizione.setEditable(true);
        tareaDescrizione.setOpaque(true);
        tareaDescrizione.setFocusable(true);
        tareaDescrizione.setLineWrap(true);
        tareaDescrizione.setWrapStyleWord(true);
    }


    // Metodi GETTERS

    /**
     * <code>getTfNomeRistorante</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     * @return il valore del nome del ristorante dal campo di testo
     */

    public String getTfNomeRistorante() {
        return tfNomeRistorante.getText();
    }

    /**
     * <code>getTareaDescrizione</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     * @return il valore della descrizione dall'area di testo
     */

    public String getTareaDescrizione() {
        return tareaDescrizione.getText();
    }

    /**
     * <code>getTfVia</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     * @return il valore della via dal campo di testo
     */

    public String getTfVia() {
        return tfVia.getText();
    }

    /**
     * <code>getTfCivico</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     * @return il valore del numero civico dal campo di testo
     */

    public String getTfCivico() {
        return tfCivico.getText();
    }

    /**
     * <code>getTfCitta</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     * @return il valore della città dal campo di testo
     */

    public String getTfCitta() {
        return tfCitta.getText();
    }

    /**
     * <code>getTfProvincia</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     * @return il valore della provincia dal campo di testo
     */

    public String getTfProvincia() {
        return tfProvincia.getText();
    }

    /**
     * <code>getTfCap</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     * @return il valore del cap dal campo di testo
     */

    public String getTfCap() {
        return tfCap.getText();
    }

    /**
     * <code>getTfTelefono</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     * @return il valore del numero di telefono dal campo di testo
     */

    public String getTfTelefono() {
        return tfTelefono.getText();
    }

    /**
     * <code>getTfSito</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     * @return il valore del sito web dal campo di testo
     */

    public String getTfSito() {
        return tfSitoWeb.getText();
    }

    /**
     * <code>checkAllInputs</code> è un metodo per controllare il contenuto dei textfield
     * è dichiarato <strong>private</strong> in quanto il metodo è utilizzabile all'interno della classe
     * @return valore booleano che indica se sono stati inseriti i dati in tutti i textfield
     */

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

    /**
     * <code>checkInput</code> è un metodo per controllare l'input di un textfield
     * è dichiarato <strong>private</strong> in quanto il metodo è utilizzabile all'interno della classe
     * @param input è una stringa rappresentante il contenuto del campo da analizzare
     * @param textField è il textfield di riferimento dell'input
     * @return valore booleano che indica se il dato è inserito nel textfield
     */

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

    /**
     * <code>createUIComponents</code> è una procedura per impostare la grafica
     * quando viene caricato il frame
     * è dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *
     * @throws IOException è un eccezione che viene lanciata quando il programma non trova il file che si vuole utilizzare
     */

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratoriModificaRistorante.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        cboxTipologia = new JComboBox<String>(tipologia);
    }
}
