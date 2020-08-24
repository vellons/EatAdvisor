package eatadvisor.ristoratori;

import eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * La classe RegistrazioneRistoratore permette la registrazione di
 * un utente impostato come ristoratore
 *
 * @author Mahdi Said
 */

public class RegistrazioneRistoratore {

    /**
     * <code>ioUtenti</code> è un'istanza della classe IOUtenti che
     * permette di usare le funzionalità per la gestione degli utenti.
     * @see IOUtenti
     * <p>
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private IOUtenti ioUtenti = null;

    /**
     * <code>panelRegistrazioneRistoratore</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di registrazione di
     * un utente ristoratore
     * <p>
     * è dichiarato <strong>public</strong> in quanto l'attributo è utilizzabile all'esterno della classe
     */

    public JPanel panelRegistrazioneRistoratore;

    /**
     * <code>btnIscriviti</code> è un bottone Swing che attiva la procedura
     * di registrazione come ristoratore
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
    */

    private JButton btnIscriviti;

    /**
     * <code>lblNome</code> è un'etichetta Swing dedicata al campo nome
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblPassword</code> è un'etichetta Swing dedicata al campo password
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <code>lblCognome</code> è un'etichetta Swing dedicata al campo cognome
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblComune</code> è un'etichetta Swing dedicata al campo comune
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lblSiglaProvincia</code> è un'etichetta Swing dedicata al campo sigla provincia
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <code>lblEmail</code> è un'etichetta Swing dedicata al campo email
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JLabel lblPassword;

    /**
     * <code>tfEmail</code> è un campo di testo Swing dedicato al campo email
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfPassword</code> è un campo di testo Swing dedicato al campo password
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfNome</code> è un campo di testo Swing dedicato al campo nome
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfCognome</code> è un campo di testo Swing dedicato al campo cognome
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfComune</code> è un campo di testo Swing dedicato al campo comune
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfSiglaProvincia</code> è un campo di testo Swing dedicato al campo sigla provincia
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPasswordField tfPassword;
    private JLabel lblNome;
    private JLabel lblCognome;
    private JLabel lblComune;
    private JLabel lblSiglaProvincia;
    private JLabel lblEmail;
    private JTextField tfNome;
    private JTextField tfCognome;
    private JTextField tfComune;
    private JTextField tfSiglaProvincia;
    private JTextField tfEmail;

    /**
     * <code>panelLogo</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di benvenuto
     * del lato ristoratore dell'applicazione.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPanel panelLogo;

    /**
    <code>lblErrors</code> è un'etichetta Swing dedicata al campo di controllo errori
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JLabel lblErrors;

    /**
     * Main della classe
     *
     * @throws Exception è utilizzata quando non si sa che tipo di eccezione potrebbe
     * essere sollevata durante l'esecuzione del programma
     */

    public RegistrazioneRistoratore() throws Exception {

        btnIscriviti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                if (!getTfEmail().matches(EMAIL_REGEX)) {
                    JOptionPane.showMessageDialog(null, "L'email inserita non è valida." +
                            "\nRiprovare", "Attenzione", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (checkAllInputs()) {
                        try {
                            if (JOptionPane.showOptionDialog(null, "Confermi di voler creare un account?",
                                    "Conferma iscrizione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                    null, null, null) == JOptionPane.YES_OPTION) {
                                ioUtenti = new IOUtenti();
                                ioUtenti.creaNuovoUtente("RIST", getTfEmail(), getTfEmail(),
                                        getTfPassword(), getTfNome(), getTfCognome(),
                                        getTfComune(), getTfSiglaProvincia());
                                ristoratori.closePreviousWindow(StartRistoratore.registrazioneFrame);
                                JOptionPane.showMessageDialog(null, "Account creato! Adesso effettua " +
                                        "l'accesso", "Registrazione effettuate", JOptionPane.PLAIN_MESSAGE);
                            }
                        } catch (Exception exception) {
                            if (Objects.equals(exception.getMessage(), "Email già utilizzata.")) {
                                JOptionPane.showMessageDialog(null, "Questa email è già stata utilizzata",
                                        "Attenzione", JOptionPane.PLAIN_MESSAGE);
                                tfEmail.setText("");
                            }
                            else if (Objects.equals(exception.getMessage(), "Nickanme già utilizzato.")) { // Impossibile per il risotratore in teoria
                                JOptionPane.showMessageDialog(null, "Questo nickname è già stato utilizzato",
                                        "Attenzione", JOptionPane.PLAIN_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "C'è stato un problema. Prova a riavviare l'app",
                                        "Attenzione", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                    } else {
                        lblErrors.setFont(new Font("Default", Font.BOLD, 14));
                        lblErrors.setForeground(Color.RED);
                        lblErrors.setVisible(true);
                    }
                }
            }
        });
    }

    // Metodi GETTERS

    /**
     * <code>getTfPassword</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     @return il valore della password dal campo di testo
     */

    public String getTfPassword() {
        return String.valueOf(tfPassword.getPassword());
    }

    /**
     * <code>getTfNome</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     @return il valore del nome dal campo di testo
     */

    public String getTfNome() {
        return tfNome.getText();
    }

    /**
     * <code>getTfCognome</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     @return il valore del cognome dal campo di testo
     */

    public String getTfCognome() {
        return tfCognome.getText();
    }

    /**
     * <code>getTfComune</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     @return il valore del comune dal campo di testo
     */

    public String getTfComune() {
        return tfComune.getText();
    }

    /**
     * <code>getTfSiglaProvincia</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     @return il valore della sigla provincia dal campo di testo
     */

    public String getTfSiglaProvincia() {
        return tfSiglaProvincia.getText();
    }

    /**
     * <code>getTfPassword</code> è un metodo getter
     * è dichiarato <strong>public</strong> in quanto il metodo è utilizzabile all'esterno della classe
     @return il valore dell'email dal campo di testo
     */

    public String getTfEmail() {
        return tfEmail.getText();
    }

    /**
     * <code>checkAllInputs</code> è un metodo per controllare il contenuto dei textfield
     * è dichiarato <strong>private</strong> in quanto il metodo è utilizzabile all'interno della classe
     @return valore booleano che indica se sono stati inseriti i dati in tutti i textfield
     */

    private boolean checkAllInputs() {
        boolean allFieldsValid = true;  // Tramite una variabile booleana, verifico se tutti i campi siano completi

        allFieldsValid &= checkInput(getTfNome(), tfNome); // Per ogni TextField, verifico se è diverso da vuoto
        allFieldsValid &= checkInput(getTfCognome(), tfCognome);
        allFieldsValid &= checkInput(getTfComune(), tfComune);
        allFieldsValid &= checkInput(getTfSiglaProvincia(), tfSiglaProvincia);
        allFieldsValid &= checkInput(getTfEmail(), tfEmail);
        allFieldsValid &= checkInput(getTfPassword(), tfPassword);

        return allFieldsValid; // Restituisco il risultato booleano proveniente da CheckInput
    }

    /**
     * <code>checkInput</code> è un metodo per controllare l'input di un textfield
     * è dichiarato <strong>private</strong> in quanto il metodo è utilizzabile all'interno della classe
     * @param input è una stringa rappresentante il contenuto del campo da analizzare
     * @param textField è il textfield di riferimento dell'input
     @return valore booleano che indica se il dato è inserito nel textfield
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
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratori.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}
