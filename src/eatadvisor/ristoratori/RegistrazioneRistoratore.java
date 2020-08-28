package eatadvisor.ristoratori;

import eatadvisor.ioutenti.IOUtenti;

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
 * La classe RegistrazioneRistoratore permette la registrazione di
 * un utente impostato come ristoratore
 *
 * @author Mahdi Said
 */

public class RegistrazioneRistoratore {

    /**
     * <code>ioUtenti</code> &egrave; un'istanza della classe IOUtenti che
     * permette di usare le funzionalit&agrave; per la gestione degli utenti.
     *
     * @see IOUtenti
     * <p>
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private IOUtenti ioUtenti = null;

    /**
     * <code>panelRegistrazioneRistoratore</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di registrazione di
     * un utente ristoratore
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     */

    public JPanel panelRegistrazioneRistoratore;

    /**
     * <code>btnIscriviti</code> &egrave; un bottone Swing che attiva la procedura
     * di registrazione come ristoratore
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JButton btnIscriviti;

    /**
     * <code>lblPassword</code> &egrave; un'etichetta Swing dedicata al campo password
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
    */

    private JLabel lblPassword;

    /**
     * <code>tfPassword</code> &egrave; un campo di testo Swing dedicato al campo password
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JPasswordField tfPassword;

    /**
     * <code>lblNome</code> &egrave; un'etichetta Swing dedicata al campo nome
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblNome;

    /**
     * <code>lblCognome</code> &egrave; un'etichetta Swing dedicata al campo cognome
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblCognome;

    /**
     * <code>lblComune</code> &egrave; un'etichetta Swing dedicata al campo comune
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblComune;

    /**
     * <code>lblSiglaProvincia</code> &egrave; un'etichetta Swing dedicata al campo sigla provincia
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblSiglaProvincia;

    /**
     * <code>lblEmail</code> &egrave; un'etichetta Swing dedicata al campo email
     * &egrave; dichiarata <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JLabel lblEmail;

    /**
     * <code>tfNome</code> &egrave; un campo di testo Swing dedicato al campo nome
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JTextField tfNome;

    /**
     * <code>tfCognome</code> &egrave; un campo di testo Swing dedicato al campo cognome
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JTextField tfCognome;

    /**
     * <code>tfComune</code> &egrave; un campo di testo Swing dedicato al campo comune
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JTextField tfComune;


    /**
     * <code>tfSiglaProvincia</code> &egrave; un campo di testo Swing dedicato al campo sigla provincia
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
    */

    private JTextField tfSiglaProvincia;

    /**
     * <code>tfEmail</code> &egrave; un campo di testo Swing dedicato al campo email
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */

    private JTextField tfEmail;

    /**
     * <code>panelLogo</code> &egrave; un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il logo dell'applicazione
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
     * Main della classe
     *
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */

    public RegistrazioneRistoratore() throws Exception {

        btnIscriviti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                if (!getTfEmail().matches(EMAIL_REGEX)) {
                    JOptionPane.showMessageDialog(null, "L'email inserita non &egrave; valida." +
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
                                JOptionPane.showMessageDialog(null, "Questa email &egrave; già stata utilizzata",
                                        "Attenzione", JOptionPane.PLAIN_MESSAGE);
                                tfEmail.setText("");
                            } else if (Objects.equals(exception.getMessage(), "Nickanme già utilizzato.")) { // Impossibile per il risotratore in teoria
                                JOptionPane.showMessageDialog(null, "Questo nickname &egrave; già stato utilizzato",
                                        "Attenzione", JOptionPane.PLAIN_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "C'&egrave; stato un problema. Prova a riavviare l'app",
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
     * <code>getTfPassword</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore della password dal campo di testo
     */

    public String getTfPassword() {
        return String.valueOf(tfPassword.getPassword());
    }

    /**
     * <code>getTfNome</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore del nome dal campo di testo
     */

    public String getTfNome() {
        return tfNome.getText();
    }

    /**
     * <code>getTfCognome</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore del cognome dal campo di testo
     */

    public String getTfCognome() {
        return tfCognome.getText();
    }

    /**
     * <code>getTfComune</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore del comune dal campo di testo
     */

    public String getTfComune() {
        return tfComune.getText();
    }

    /**
     * <code>getTfSiglaProvincia</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore della sigla provincia dal campo di testo
     */

    public String getTfSiglaProvincia() {
        return tfSiglaProvincia.getText();
    }

    /**
     * <code>getTfPassword</code> &egrave; un metodo getter
     * &egrave; dichiarato <strong>public</strong> in quanto il metodo &egrave; utilizzabile all'esterno della classe
     *
     * @return il valore dell'email dal campo di testo
     */

    public String getTfEmail() {
        return tfEmail.getText();
    }

    /**
     * <code>checkAllInputs</code> &egrave; un metodo per controllare il contenuto dei textfield
     * &egrave; dichiarato <strong>private</strong> in quanto il metodo &egrave; utilizzabile all'interno della classe
     *
     * @return valore booleano che indica se sono stati inseriti i dati in tutti i textfield
     */

    private boolean checkAllInputs() {
        boolean allFieldsValid = true;  // Tramite una variabile booleana, verifico se tutti i campi siano completi

        allFieldsValid &= checkInput(getTfNome(), tfNome); // Per ogni TextField, verifico se &egrave; diverso da vuoto
        allFieldsValid &= checkInput(getTfCognome(), tfCognome);
        allFieldsValid &= checkInput(getTfComune(), tfComune);
        allFieldsValid &= checkInput(getTfSiglaProvincia(), tfSiglaProvincia);
        allFieldsValid &= checkInput(getTfEmail(), tfEmail);
        allFieldsValid &= checkInput(getTfPassword(), tfPassword);

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
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratori.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}
