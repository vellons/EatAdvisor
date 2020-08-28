package eatadvisor.ristoratori;

import eatadvisor.global.Global;

import javax.swing.*;
import java.awt.*;

/**
 * La classe ristoratori permette di settare le impostazioni
 * della parte ristoranti e ristoratori dell'applicazione
 *
 * @author
 */
public class ristoratori {

    /**
     * <code>mainFrame</code> &egrave; una cornice Swing attivata nel momento nel
     * quale &egrave; richiesto il login come ristoratore
     * <p>
     * &egrave; dichiarata <strong>public</strong> in quanto l'attributo &egrave; utilizzabile all'esterno della classe
     * &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */
    public static JFrame mainFrame = new JFrame("EatAdvisor Ristoratori - Login");

    /**
     * Main della classe
     *
     * @param args &egrave; nome dell'array di stringhe
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */
    public static void main(String[] args) throws Exception {
        mainFrame.setContentPane(new StartRistoratore().panelStartRistoratore);
        initUI(mainFrame);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    /**
     * <code>initUI</code> &egrave; una procedura per inizializzare l'interfaccia
     * utente su una finestra e per finalizzarne le impostazioni
     *
     * @param frame &egrave; il frame sul quale applicare le impostazioni
     *              &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *              &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     * @throws ClassNotFoundException          se non trova la classe da caricare
     * @throws UnsupportedLookAndFeelException e le classi look and feel richieste non sono presenti sul sistema
     * @throws InstantiationException          se per qualche motivo la classe non può essere istanziata
     * @throws IllegalAccessException          quando si cerca di effettuare l'accesso ad un campo laddove non &egrave; possibile
     */
    public static void initUI(JFrame frame) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        ImageIcon imageIcon = new ImageIcon("media/EatAdvisorIcon.png");
        Image image = imageIcon.getImage();
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce il comportamento della finestra

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.awt.brushMetalLook", "true");
            // use the mac system menu bar
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            // set the "About" menu item name
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "EatAdvisor Ristoratori");
            // use smoother fonts
            System.setProperty("apple.awt.textantialiasing", "true");
            // ref: http://developer.apple.com/releasenotes/Java/Java142RNTiger/1_NewFeatures/chapter_2_section_3.html
            System.setProperty("apple.awt.graphics.EnableQ2DX", "true");
            // use the system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }

        JMenuBar myBar = new JMenuBar();
        frame.setJMenuBar(myBar);
        if (Global.utenteLoggato != null) {
            setMenuAccount(myBar);
        }
        setMenuInfo(myBar);
    }

    /**
     * <code>setMenuAccount</code> &egrave; una procedura per aggiungere il menù
     * a tendina dell'account alla barra superiore
     *
     * @param myMenuBar &egrave; la barra alla quale aggiungere il menù a tendina
     *                  &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *                  &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */
    private static void setMenuAccount(JMenuBar myMenuBar) { // Creazione del JMenu account
        MenuListener mLR = new MenuListener();
        JMenu f = new JMenu("Account");
        JMenuItem f1 = new JMenuItem("Modifica account");
        JMenuItem f2 = new JMenuItem("Logout");
        f1.addActionListener(mLR);
        f2.addActionListener(mLR);
        f.add(f1);
        f.add(f2);
        myMenuBar.add(f);
    }

    /**
     * <code>setMenuInfo</code> &egrave; una procedura per aggiungere il menù
     * a tendina delle info alla barra superiore
     *
     * @param myMenuBar &egrave; la barra alla quale aggiungere il menù a tendina
     *                  &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *                  &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */
    private static void setMenuInfo(JMenuBar myMenuBar) { // Creazione del JMenu info
        MenuListener ml = new MenuListener();
        JMenu f = new JMenu("Info");
        JMenuItem f1 = new JMenuItem("Versione");
        f1.addActionListener(ml);
        f.add(f1);
        myMenuBar.add(f);
    }

    /**
     * <code>closePreviousWindow</code> &egrave; una procedura per chiudere una
     * finestra non più utilizzata
     *
     * @param finestra &egrave; la finestra da chiudere
     *                 &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *                 &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     */
    public static void closePreviousWindow(JFrame finestra) {
        finestra.setVisible(false);
        finestra.dispose();
    }

    /**
     * <code>reloadDashboardRistoratori</code> &egrave; una procedura per ricaricare la
     * dashboard dei ristoranti dopo un'operazione importante
     *
     * @param finestra &egrave; la finestra da ricaricare
     *                 &egrave; dichiarato <strong>void</strong> in quanto non restituisce alcun valore
     *                 &egrave; dichiarata <strong>static</strong> così da non doverla istanziare creando un oggetto
     * @throws Exception &egrave; utilizzata quando non si sa che tipo di eccezione potrebbe
     *                   essere sollevata durante l'esecuzione del programma
     */
    public static void reloadDashboardRistoranti(JFrame finestra) throws Exception {
        finestra.setVisible(false);
        finestra.dispose();
        finestra.invalidate();
        finestra.setContentPane(new DashboardRistoratori().panelDashboardRistoratori);
        initUI(finestra);
        finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        finestra.pack();
        finestra.setLocationRelativeTo(null);
        finestra.setVisible(true);
    }
}
