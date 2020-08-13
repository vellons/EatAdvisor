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
    private JLabel lbTxtRecensione;

    public RecensioniPerRistorante(Recensione rec) throws Exception {
        lbNickname.setText("Nickname: "+ioutenti.getUtenteById(rec.getUtenteId()).getNickname());
        lbRate.setText("Valutazione utente:" + rec.getValutazione());
        lbTxtRecensione.setText(rec.getCommento());
    }
}
