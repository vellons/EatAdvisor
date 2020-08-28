package eatadvisor.clienti;

import eatadvisor.ioeatadvisor.Recensione;
import eatadvisor.ioutenti.IOUtenti;

import javax.swing.*;

/**
 * La classe RecensioniPerRistorante permette la gestione delle
 * recensioni rilasciate per un ristorante
 * @author Manuel Macaj
 */

public class RecensioniPerRistorante {

    /**
     * <code>ioUtenti</code> è un'istanza della classe IOUtenti che
     * permette di usare le funzionalità per la gestione degli utenti.
     * @see IOUtenti
     * <p>
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     */

    private IOUtenti ioutenti = new IOUtenti();

    /**
     * <code>panelRecensioniPerRistorante</code> è un pannello Swing che compone
     * l'interfaccia grafica, nella fattispecie la finestra dedicata alle
     * recensioni relative ad uno specifico ristorante
     * <p>
     * è dichiarato <strong>public</strong> in quanto l'attributo è utilizzabile all'esterno della classe
     */

    public JPanel panelRecensionePerRistorante;

    /**
     * <code>lbNickname</code> è un'etichetta Swing dedicata al campo nickname
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>lbRate</code> è un'etichetta Swing dedicata al campo del valore della recensione
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
     * <p>
     * <code>txtRecensione</code> è un'area di testo Swing dedicata al campo recensione
     * è dichiarata <strong>private</strong> in quanto l'attributo è utilizzabile all'interno della classe
    */

     private JLabel lbNickname;
    private JLabel lbRate;
    private JTextArea txtRecensione;

    /**
     * Main della classe
     *
     * @param rec insieme di dati relativi alla recensione rilasciata
     * @throws Exception è utilizzata quando non si sa che tipo di eccezione potrebbe
     * essere sollevata durante l'esecuzione del programma
     */

    public RecensioniPerRistorante(Recensione rec) throws Exception {
        String nickname =  ioutenti.getUtenteById(rec.getUtenteId()).getNickname();
        lbNickname.setText("Nick: " + nickname.substring(0, Math.min(nickname.length(), 12)));
        lbRate.setText("Valutazione: " + rec.getValutazione());
        txtRecensione.setText(rec.getCommento().substring(0, Math.min(rec.getCommento().length(), 256)));
        setTextAreaRec(); // metodo per il "settaggio" della textArea
    }

    /**
     * <code>setTextAreaRec</code> è una procedura per impostare la parte dedicata
     * alle recensioni del ristorante quando viene caricato il frame
     * è dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     */

    private void setTextAreaRec() {
        txtRecensione.setEditable(false); // impostando a false, non posso scrivere nella textarea
        txtRecensione.setOpaque(true);
        txtRecensione.setFocusable(false);
        txtRecensione.setLineWrap(true);
        txtRecensione.setWrapStyleWord(true);
    }
}
