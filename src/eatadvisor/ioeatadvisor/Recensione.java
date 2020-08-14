package eatadvisor.ioeatadvisor;

import java.io.Serializable;

public class Recensione implements Serializable {

    private static final long serialVersionUID = 5702291095524603496L;
    private int utenteId;
    private int valutazione; // 1:5
    private String commento;

    public Recensione(int utenteId, int valutazione, String commento) {
        this.utenteId = utenteId;
        this.valutazione = valutazione;
        this.commento = commento;
    }

    public int getUtenteId() {
        return this.utenteId;
    }

    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    public int getValutazione() {
        return this.valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public String getCommento() {
        return this.commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    @Override
    public String toString() {
        return "Recensione<" + valutazione + ", utente id: " + utenteId + ">: " + commento;
    }
}
