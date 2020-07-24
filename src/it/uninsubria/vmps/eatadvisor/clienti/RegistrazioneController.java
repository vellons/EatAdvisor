package it.uninsubria.vmps.eatadvisor.clienti;

import it.uninsubria.vmps.eatadvisor.ioutenti.IOUtenti;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class RegistrazioneController implements ActionListener {

    private RegistrazioneFormView gble;
    private IOUtenti ioUtenti = new IOUtenti();

    public RegistrazioneController(RegistrazioneFormView gble) throws Exception {
        this.gble = gble;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkAllInputs()) { // Mi assicuro che tutti i TextField siano completi
            try {
                ioUtenti = new IOUtenti();
                ioUtenti.creaNuovoUtente("CLIE", this.gble.getTfEmail(), this.gble.getTfNickname(),
                        this.gble.getTfPsw(), this.gble.getTfName(), this.gble.getTfLastName(),
                        this.gble.getTfComune(), this.gble.getTfSigla());
            } catch (Exception exception) {
                if (Objects.equals(exception.getMessage(), "Email già utilizzata.")) {
                    JOptionPane.showMessageDialog(null, "Questa email è già stata utilizzata",
                            "Attenzione", JOptionPane.PLAIN_MESSAGE);
                }
                if (Objects.equals(exception.getMessage(), "Nickanme già utilizzato.")) {
                    JOptionPane.showMessageDialog(null, "Questo nickname è già stato utilizzato",
                            "Attenzione", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }

    private boolean checkAllInputs() {
        boolean allFieldsValid = true;  // Tramite una variabile booleana, verifico se tutti i campi siano completi

        allFieldsValid &= checkInput(this.gble.getTfName(), this.gble.getlNameError()); // Per ogni TextField, verifico se è diverso da vuoto
        allFieldsValid &= checkInput(this.gble.getTfLastName(), this.gble.getlLastNameError());
        allFieldsValid &= checkInput(this.gble.getTfComune(), this.gble.getlComuneError());
        allFieldsValid &= checkInput(this.gble.getTfSigla(), this.gble.getlSiglaError());
        allFieldsValid &= checkInput(this.gble.getTfNickname(), this.gble.getlNicknameError());
        allFieldsValid &= checkInput(this.gble.getTfEmail(), this.gble.getlEmailError());
        allFieldsValid &= checkInput(this.gble.getTfPsw(), this.gble.getlPswError());

        return allFieldsValid; // Restituisco il risultato booleano proveniente da CheckInput
    }

    protected static void updateErrorLabel(JLabel ErrorLabel, String labelTExt, boolean vis) {
        ErrorLabel.setText(labelTExt); // Inserisco la scritta "Inserire i dati richiesti" a destra del text Field
        ErrorLabel.setVisible(vis);    // Abilito la label qualora l'utente non avesse inserito nessun dato
    }

    private static boolean checkInput(String input, JLabel ErrorLabel) { // Funzione per la verifica del textfield
        boolean res = true;
        String tmp = "";
        tmp += input;
        if (tmp.equals("")) { // Se il campo e vuoto, visualizzo una scritta
            updateErrorLabel(ErrorLabel, "Inserire un dato valido", true);
            res = false;
        } else {
            updateErrorLabel(ErrorLabel, "", false);
            res = true;
        }
        return res;
    }
}
