package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Recensione;
import eatadvisor.ioutenti.IOUtenti;

import javax.swing.*;

public class RecensioniPerRistorante {
    private IOUtenti ioutenti = new IOUtenti();
    public JPanel panelRecensionePerRistorante;
    private JLabel lbNickname;
    private JLabel lbRate;
    private JTextArea txtRecensione;

    public RecensioniPerRistorante(Recensione rec) throws Exception {
        String nickname =  ioutenti.getUtenteById(rec.getUtenteId()).getNickname();
        lbNickname.setText("Nick: " + nickname.substring(0, Math.min(nickname.length(), 12)));
        lbRate.setText("Valutazione: " + rec.getValutazione());
        txtRecensione.setText(rec.getCommento().substring(0, Math.min(rec.getCommento().length(), 256)));
        setTextAreaRec(); // metodo per il "settaggio" della textArea
    }

    private void setTextAreaRec() {
        txtRecensione.setEditable(false); // impostando a false, non posso scrivere nella textarea
        txtRecensione.setOpaque(true);
        txtRecensione.setFocusable(false);
        txtRecensione.setLineWrap(true);
        txtRecensione.setWrapStyleWord(true);
    }
}
