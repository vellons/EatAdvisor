package eatadvisor.global;

import eatadvisor.ioutenti.Utente;


/**
 * La classe Global permette di gestire le variabili statiche disponibili globalmente all'interno delle applicazioni.
 *
 * @author Alex Vellone, Manuel Macaj
 */
public class Global {
    /**
     * <code>utenteLoggato</code> se l'utente &egrave; loggato in una delle due applicazioni all'interno di questa variabile
     * saranno presenti le sue informazioni
     * <p>
     * &egrave; dichiarato <strong>public</strong> in quanto l'attributo &egrave; utilizzabile ovunque
     * &egrave; dichiarato <strong>static</strong> così da poterla utlizzare senza istanziare l'oggetto
     */
    public static Utente utenteLoggato = null;
}
