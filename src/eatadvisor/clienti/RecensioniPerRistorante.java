package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioeatadvisor.Recensione;

import javax.swing.*;

public class RecensioniPerRistorante {
    private JPanel panelRecensionePerRistorante;
    private JLabel lbNickname;
    private JLabel lbRate;
    private JLabel lbTxtRecensione;

    public RecensioniPerRistorante(Recensione rec){
        lbNickname.setText(Global.utenteLoggato.getNickname());
        lbRate.setText(String.valueOf(rec.getValutazione()));
        lbTxtRecensione.setText(rec.getCommento());
    }
}
