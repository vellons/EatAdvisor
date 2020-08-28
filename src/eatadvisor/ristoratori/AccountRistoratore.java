package eatadvisor.ristoratori;

import eatadvisor.global.Global;
import eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * La classe AccountRistoratore permette la visualizzazione delle informazioni relative al
 * ristoratore, oltre alla possibilit di modificare le informazioni del proprio account e
 * la propria password d'accesso
 *
 * @author Mahdi Said
 */
public class AccountRistoratore { //Contiene il JPanel principale
    /**
     * <code>modifyPassword</code> rappresenta una finestra.
     * <p>
     * &egrave; dichiarato <strong>public</strong> cos&igrave; da poter essere visibile anche alle altre classi
     * &egrave; dichiarato <strong>static</strong> cos&igrave; da non doverlo istanziare creando un oggetto
     */
    public static JFrame modifyPassword = new JFrame("Cambio Password"); //Creazione della finestra
    /**
     * <code>panelAccountRistoratore</code> rappresenta un pannello.
     * <p>
     * &egrave; dichiarato <strong>public</strong> cos&igrave; da poter essere visibile anche alle altre classi
     */
    public JPanel panelAccountRistoratore; //Mostro informazioni ristoratore.
    /**
     * <code>lblNome</code> rappresenta un etichetta.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblNome;
    /**
     * <code>lblCognome</code> rappresenta un etichetta.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblCognome;
    /**
     * <code>lblComune</code> rappresenta un etichetta.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblComune;
    /**
     * <code>lblSiglaProvincia</code> rappresenta un etichetta.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblSiglaProvincia;
    /**
     * <code>lblEmail</code> rappresenta un etichetta.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JLabel lblEmail;
    /**
     * <code>tfNome</code> rappresenta un campo di testo.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfNome;
    /**
     * <code>tfCognome</code> rappresenta un campo di testo.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfCognome;
    /**
     * <code>tfComune</code> rappresenta un campo di testo.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfComune;
    /**
     * <code>tfSiglaProvincia</code> rappresenta un campo di testo.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfSiglaProvincia;
    /**
     * <code>tfEmail</code> rappresenta un campo di testo.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JTextField tfEmail;
    /**
     * <code>btnChangeAccountRistoratore</code> rappresenta un bottone.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JButton btnChangeAccountRistoratore;
    /**
     * <code>btnChangePswRistoratore</code> rappresenta un bottone.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JButton btnChangePswRistoratore;
    /**
     * <code>panelLogo</code> rappresenta un pannello.
     * <p>
     * &egrave; dichiarato <strong>private</strong> in quanto l'attributo &egrave; utilizzabile all'interno della classe
     */
    private JPanel panelLogo;
    /**
     * <code>aggiornaRistoratori</code> rappresenta una variabile di tipo IOUtenti.
     */
    IOUtenti aggiornaRistoratori = null;

    /**
     * Costrutore della classe
     */
    public AccountRistoratore() { //Modifica
        setAllTextField(); // "settaggio" iniziale dei textfield (da Manuel questo &egrave; fondamentale!!)
        btnChangeAccountRistoratore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnChangeAccountRistoratore.setText("Conferma modifiche"); // cambio il nome del bottone. (da Manuel: questa parte permette di cambiare il nome del bottone durante la visualizzazione)
                setTrueEditable(); // cambio la proprietà dei textfield (da Manuel: se non metti questo, non puoi modificare niente!!!).
                btnChangeAccountRistoratore.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (!checkAllInputs()) { // Verifico che tutti i campi siano completi
                                JOptionPane.showMessageDialog(null, "Attenzione, tutti i " +
                                        "campi devono essere completati!", "Errore", JOptionPane.ERROR_MESSAGE);
                            } else {
                                if (JOptionPane.showOptionDialog(null, "Confermi di voler modificare modificare i tuoi dati?",
                                        "Conferma modifica", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                        null, null, null) == JOptionPane.YES_OPTION) { // chiedo all'utente se vuole aggiornare i dati inseriti
                                    //Se conferma, invoco il metodo aggiornaUtenteById
                                    aggiornaRistoratori = new IOUtenti();
                                    Global.utenteLoggato = aggiornaRistoratori.aggiornaUtenteById(Global.utenteLoggato.getId(), tfNome.getText(),
                                            tfCognome.getText(), tfComune.getText(), tfSiglaProvincia.getText());

                                    JOptionPane.showMessageDialog(null, "Modifica account eseguta con " +
                                            "successo", "Modifica eseguita", JOptionPane.PLAIN_MESSAGE);
                                    ristoratori.closePreviousWindow(MenuListener.modifyAccount); //Chiusura della finestra di modifica
                                } else { //Se l'utente non conferma le modifiche
                                    ristoratori.closePreviousWindow(MenuListener.modifyAccount); //Chiusura della finestra
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                    }
                });
            }
        });

        btnChangePswRistoratore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Funzione da implementare
                try {
                    modifyPassword.setContentPane(new ModificaPasswordRistoratore().panelModificaPasswordRistoratore);
                    ristoratori.initUI(modifyPassword); //Icona
                    modifyPassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce il comportamento della finestraregistrazioneFrame.pack();
                    modifyPassword.pack();
                    modifyPassword.setLocationRelativeTo(null);
                    modifyPassword.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    private void setAllTextField() { // Settaggio iniziale
        tfNome.setText(Global.utenteLoggato.getNome()); // Prelevo il nome dell'utente loggato in questo momento
        tfNome.setEditable(false);  // Impostando a false, non ho la possibilità di modificare il campo di testo
        tfNome.setVisible(true);    // Impostando a true, posso visualizzare il testo presente nel textfield

        tfCognome.setText(Global.utenteLoggato.getCognome()); //Prelevo il cognome dell'utente loggato in questo momento
        tfCognome.setEditable(false);
        tfCognome.setVisible(true);

        tfComune.setText(Global.utenteLoggato.getComune()); //Prelevo il comune dell'utente loggato in questo momento
        tfComune.setEditable(false);
        tfComune.setVisible(true);

        tfSiglaProvincia.setText(Global.utenteLoggato.getSiglaProvincia()); //Prelevo la provincia dell'utente loggato in questo momento
        tfSiglaProvincia.setEditable(false);
        tfSiglaProvincia.setVisible(true);

        tfEmail.setText(Global.utenteLoggato.getEmail()); //Prelevo l'email dell'utente loggato in questo momento
        tfEmail.setEditable(false);
        tfEmail.setVisible(true);

    }

    private void setTrueEditable() { // metodo per l'abilitazione dei textfield
        tfNome.setEditable(true);  // impostando a true, ho la possibilità di modificare il campo di testo
        tfCognome.setEditable(true);
        tfComune.setEditable(true);
        tfSiglaProvincia.setEditable(true);
    }

    /**
     * @return un risultato booleano
     */
    private boolean checkAllInputs() { //Metodo per la verifica di tutti i campi

        boolean allFieldsValid = true; //Tramite una variabile booleana, verifico se tutti i campi siano stati completati

        allFieldsValid &= checkInput(tfNome.getText()); //Per ogni TextField, verifico se &egrave; diverso da vuoto
        allFieldsValid &= checkInput(tfCognome.getText());
        allFieldsValid &= checkInput((tfComune.getText()));
        allFieldsValid &= checkInput(tfSiglaProvincia.getText());

        return allFieldsValid; //Restituisco il risultato booleano proveniente da CheckInput
    }

    /**
     * @param input stringa da controllare
     * @return boolean per indicare se la stringa &egrave; vuota
     */
    private boolean checkInput(String input) { //Metodo per la verifica del textfield
        boolean res;
        String tmp = "";
        tmp += input;
        //Se il campo &egrave; vuoto, visualizzo una scritta
        res = !tmp.equals("");

        return res; //Restituisco il risultato booleano a seguito del confronto
    }

    /**
     * @throws IOException &egrave;&egrave; un eccezione che viene lanciata quando il programma non
     *                     trova il file che si vuole utilizzare
     */
    private void createUIComponents() throws IOException { //Logo
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratoriIlMioAccount.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}