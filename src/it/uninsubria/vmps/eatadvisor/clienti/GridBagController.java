package it.uninsubria.vmps.eatadvisor.clienti;

import it.uninsubria.vmps.eatadvisor.ioutenti.IOUtenti;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridBagController implements ActionListener {

    private GridBagLayoutFormView gble;
    private IOUtenti addNewUser = new IOUtenti();

    public GridBagController(GridBagLayoutFormView gble) throws Exception {
        this.gble = gble;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkAllInputs()){ // Mi assicuro che tutti i TextField siano completi
           //System.out.println("Dati inseriti.");
            try {
                addNewUser.creaNuovoUtente("",
                        String.valueOf(this.gble.getTfEmail()),
                        String.valueOf(this.gble.getTfNickname()), String.valueOf(this.gble.getTfPsw()),
                        String.valueOf(this.gble.getTfName()), String.valueOf(this.gble.getTfLastName()),
                        String.valueOf(this.gble.getTfComune()), String.valueOf(this.gble.getTfSigla()));
            } catch (Exception exception) {
                exception.printStackTrace();
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

        return allFieldsValid; // Restituisco

    }

    protected static void updateErrorLabel( JLabel ErrorLabel, String labelTExt, boolean vis) {
        ErrorLabel.setText(labelTExt); // Inserisco la scritta "Inserire i dati richiesti" a destra del text Field
        ErrorLabel.setVisible(vis);    // Abilito la label qualora l'utente non avesse inserito nessun dato
    }

    private static boolean checkInput(JComponent input, JLabel ErrorLabel) { // Funzione per la verifica del textfield
        boolean res = true;
        if (input instanceof JTextField) { // Se l'oggetto input è un textfield, verifico se è stato omesso
            JTextField tmp = (JTextField) input;
            if (tmp.getText().equals("")) {
                updateErrorLabel(ErrorLabel, "Inserire i dati richiesti", true);
                res = false;
            }
        }
        return res;
    }
}
