package eatadvisor.clienti;

import eatadvisor.global.Global;
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
        lbNickname.setText("Nickname: "+ioutenti.getUtenteById(rec.getUtenteId()).getNickname());
        lbRate.setText("Valutazione utente:" + rec.getValutazione());
        txtRecensione.setText(rec.getCommento());
        setTextAreaRec(); // metodo per il "settaggio" della textArea


    }

    private void setTextAreaRec() {
        txtRecensione.setEditable(false); // impostando a false, non posso scrivere nella textarea
        //txtRecensione.setCursor(null); //
        txtRecensione.setOpaque(true);
        //txtRecensione.setOpaque(false);
        txtRecensione.setFocusable(false);
        txtRecensione.setLineWrap(true);
        txtRecensione.setWrapStyleWord(true);
    }
}
