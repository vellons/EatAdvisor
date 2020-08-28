package eatadvisor.clienti;

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
 * La classe AccountCliente permette la visualizzazione delle informazioni relative al
 * cliente, oltre alla possibilità di modificare le informazioni del proprio account e
 * la propria password d'accesso
 *
 * @author Alex Vellone
 */
public class AccountCliente {
    /**
     * <code>modifyPassword</code> rappresenta una finestra.
     * <p>
     * è dichiarato <strong>public</strong> così da poter essere visibile anche alle altre classi
     * è dichiarato <strong>static</strong> così da non doverlo istanziare creando un oggetto
     */
    public static JFrame modifyPassword = new JFrame("Cambio Password"); //Creazione della finestra
    /**
     * <code>panelAccountCliente</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>public</strong> così da poter essere visibile anche alle altre classi
     */
    public JPanel panelAccountCliente;
    /**
     * <code>panelLogo</code> rappresenta un pannello.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JPanel panelLogo;
    /**
     * <code>lblNickname</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lblNickname;
    /**
     * <code>tfNickname</code> rappresenta un campo di testo.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JTextField tfNickname;
    /**
     * <code>lblNome</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lblNome;
    /**
     * <code>lblCognome</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lblCognome;
    /**
     * <code>lblComune</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lblComune;
    /**
     * <code>lblSiglaProvincia</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lblSiglaProvincia;
    /**
     * <code>lblEmail</code> rappresenta un etichetta.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JLabel lblEmail;
    /**
     * <code>tfNome</code> rappresenta un campo di testo.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JTextField tfNome;
    /**
     * <code>tfCognome</code> rappresenta un campo di testo.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JTextField tfCognome;
    /**
     * <code>tfComune</code> rappresenta un campo di testo.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JTextField tfComune;
    /**
     * <code>tfSiglaProvincia</code> rappresenta un campo di testo.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JTextField tfSiglaProvincia;
    /**
     * <code>tfEmail</code> rappresenta un campo di testo.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JTextField tfEmail;
    /**
     * <code>btnChangeAccount</code> rappresenta un bottone.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JButton btnChangeAccount;
    /**
     * <code>btnChangePsw</code> rappresenta un bottone.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */
    private JButton btnChangePsw;
    /**
     * <code>aggiornaUtenti</code> rappresenta una variabile di tipo IOUtenti.
     */
    IOUtenti aggiornaUtenti = null;

    /**
     * Costrutore della classe
     */
    public AccountCliente() {
        setAllTextField(); // "settaggio" iniziale dei textfiled
        btnChangeAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnChangeAccount.setText("Conferma modifiche"); // cambio il nome del bottone
                setTrueEditable(); // cambio la proprietà dei textfield
                btnChangeAccount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (!checkAllInputs()) { // verifico che tutti i campi siamo completi
                                JOptionPane.showMessageDialog(null, "Attenzione, tutti i " +
                                        "campi devono essere completati!", "Errore", JOptionPane.ERROR_MESSAGE);
                            } else {
                                if (JOptionPane.showOptionDialog(null, "Confermi di voler modificare modificare i tuoi dati?",
                                        "Conferma modifica", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                        null, null, null) == JOptionPane.YES_OPTION) { // chiedo all'utente se vuole aggiornare i dati inseriti
                                    //Se conferma, invoco il metodo aggiornaUtenteById
                                    aggiornaUtenti = new IOUtenti();
                                    Global.utenteLoggato = aggiornaUtenti.aggiornaUtenteById(Global.utenteLoggato.getId(), tfNome.getText(),
                                            tfCognome.getText(), tfComune.getText(), tfSiglaProvincia.getText());

                                    JOptionPane.showMessageDialog(null, "Modifica account eseguta con " +
                                            "successo", "Modifica eseguita", JOptionPane.PLAIN_MESSAGE);
                                    clienti.closePreviousWindow(MenuListener.mofidyAccount); //chiudo la finestra di modifica
                                } else { //se l'utente non conferma le modifiche
                                    clienti.closePreviousWindow(MenuListener.mofidyAccount); // chiudo la finestra
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                });
            }
        });

        btnChangePsw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Funzione da implementare
                try {
                    modifyPassword.setContentPane(new ModificaPassword().panelChangePassword);
                    clienti.initUI(modifyPassword); //Icona
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


    private void setTrueEditable() { // metodo per l'abilitazione dei textfield
        tfNome.setEditable(true);  // impostando a true, ho la possibilità di modificare il campo di testo
        tfCognome.setEditable(true);
        tfComune.setEditable(true);
        tfSiglaProvincia.setEditable(true);
    }

    private void setAllTextField() { // settaggio iniziale
        tfNome.setText(Global.utenteLoggato.getNome()); // prelevo il nome dell'utente loggato in questo momento
        tfNome.setEditable(false);  // impostando a false, non ho la possibilità di modificare il campo di testo
        tfNome.setVisible(true);    // impostando a true, posso visualizzare il testo presente nel textfield

        tfCognome.setText(Global.utenteLoggato.getCognome());
        tfCognome.setEditable(false);
        tfCognome.setVisible(true);

        tfComune.setText(Global.utenteLoggato.getComune());
        tfComune.setEditable(false);
        tfComune.setVisible(true);

        tfSiglaProvincia.setText(Global.utenteLoggato.getSiglaProvincia());
        tfSiglaProvincia.setEditable(false);
        tfSiglaProvincia.setVisible(true);

        tfEmail.setText(Global.utenteLoggato.getEmail());
        tfEmail.setEditable(false);
        tfEmail.setVisible(true);

        tfNickname.setText(Global.utenteLoggato.getNickname());
        tfNickname.setEditable(false);
        tfNickname.setVisible(true);
    }

    /**
     * @return un risultato booleano
     */
    private boolean checkAllInputs() { // Metodo per la verifica di tutti i campi
        boolean allFieldsValid = true;  // Tramite una variabile booleana, verifico se tutti i campi siano completi

        allFieldsValid &= checkInput(tfNome.getText()); // Per ogni TextField, verifico se &egrave; diverso da vuoto
        allFieldsValid &= checkInput(tfCognome.getText());
        allFieldsValid &= checkInput(tfComune.getText());
        allFieldsValid &= checkInput(tfSiglaProvincia.getText());

        return allFieldsValid; // Restituisco il risultato booleano proveniente da CheckInput
    }

    /**
     * @return un risultato booleano
     */
    private boolean checkInput(String input) { // Metodo per la verifica del textfield
        boolean res;
        String tmp = "";
        tmp += input;
        // Se il campo e vuoto, visualizzo una scritta
        res = !tmp.equals("");
        return res;
    }

    /**
     * @throws IOException èè un eccezione che viene lanciata quando il programma non
     *                     trova il file che si vuole utilizzare
     */
    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoClientiIlMioAccount.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}
