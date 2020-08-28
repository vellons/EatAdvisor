package eatadvisor.ristoratori;

import eatadvisor.clienti.AccountCliente;
import eatadvisor.clienti.clienti;
import eatadvisor.global.Global;
import eatadvisor.ioutenti.IOUtenti;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * La classe ModificaPasswordRistoratore permette la modifica della
 * password dell'account di un utente
 * @author Manuel Macaj
 * @author Silvio Pazienza
 */

public class ModificaPasswordRistoratore {

    /**
     * <code>panelModificaPasswordRistoratore</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra di cambio
     * password per i ristoratori
     * <p>
     * è dichiarato <strong>public</strong> in quanto l'attributo è utilizzabile all'esterno della classe
     */

    public JPanel panelModificaPasswordRistoratore;

    /**
     * <code>lbVecchiaPassword</code> è un'etichetta Swing dedicata al campo vecchia password
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lbNuovaPassword</code> è un'etichetta Swing dedicata al campo nuova password
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JLabel lbVecchiaPassword;

    /**
     * <code>tfVecchiaPassword</code> è un campo di testo Swing dedicato al campo vecchia password
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>tfNuovaPassword</code> è un campo di testo Swing dedicato al campo nuova password
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPasswordField tfVecchiaPassword;
    private JPasswordField tfNuovaPassword;
    private JLabel lbNuovaPassword;

    /**
     * <code>panelLogo</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie il logo dell'appicazione.
     * <p>
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JPanel panelLogo;

    /**
     * <code>btnCambiaPassword</code> è un bottone Swing che attiva la procedura
     * cambio password per un ristoratore
     * è dichiarato <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private JButton btnCambiaPassword;

    /**
     * Main della classe
     *
     * @throws Exception è utilizzata quando non si sa che tipo di eccezione potrebbe
     * essere sollevata durante l'esecuzione del programma
     */

    public ModificaPasswordRistoratore() throws Exception {
        IOUtenti ioUtenti = new IOUtenti();
        btnCambiaPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfVecchiaPassword.getPassword().length == 0 || tfNuovaPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Non è stato possibile modificare la password" +
                            " perchè il campo risulta vuoto", "Cambio password non riuscito", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        ioUtenti.aggiornaPasswordById(Global.utenteLoggato.getId(),
                                String.valueOf(tfVecchiaPassword.getPassword()),
                                String.valueOf(tfNuovaPassword.getPassword()));
                        JOptionPane.showMessageDialog(null, "Password cambiata con successo", "Cambio Password eseguito",
                                JOptionPane.PLAIN_MESSAGE);

                    } catch (Exception exception) {
                        if (Objects.equals(exception.getMessage(), "La vecchia password non corrisponde.")) {
                            JOptionPane.showMessageDialog(null, "La vecchia password non corrisponde",
                                    "Attenzione", JOptionPane.PLAIN_MESSAGE);
                        } else if (Objects.equals(exception.getMessage(), "Le due password risultano uguali.")) {
                            JOptionPane.showMessageDialog(null, "Le due password risultano uguali.",
                                    "Attenzione", JOptionPane.PLAIN_MESSAGE);
                        }
                    } finally {
                        ristoratori.closePreviousWindow(AccountRistoratore.modifyPassword);
                    }
                }
            }
        });
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
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoRistoratoriCambioPassword.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}
