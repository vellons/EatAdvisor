package it.uninsubria.vmps.eatadvisor.clienti;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutFormView extends JPanel {

    private JLabel lName;
    private JTextField tfName;
    private JLabel lNameError;

    private JLabel lLastName;
    private JTextField tfLastName;
    private JLabel lLastNameError;

    private JLabel lComune;
    private JTextField tfComune;
    private JLabel lComuneError;

    private JLabel lSigla;
    private JTextField tfSigla;
    private JLabel lSiglaError;

    private JLabel lNickname;
    private JTextField tfNickname;
    private JLabel lNicknameError;

    private JLabel lEmail;
    private JTextField tfEmail;
    private JLabel lEmailError;

    private JLabel lPsw;
    private JTextField tfPsw;
    private JLabel lPswError;

    private JButton submitButton;

    //GETTERS E SETTERS
    public JComponent getTfName() {
        return this.tfName;
    }

    public JComponent getTfLastName() {
        return this.tfLastName;
    }

    public JLabel getlNameError() {
        return this.lNameError;
    }

    public JLabel getlLastNameError() { return this.lLastNameError; }

    public JComponent getTfComune() {
        return this.tfComune;
    }

    public JLabel getlComuneError() {
        return this.lComuneError;
    }

    public JComponent getTfSigla() {
        return this.tfSigla;
    }

    public JLabel getlSiglaError() { return this.lSiglaError; }

    public JComponent getTfNickname() { return this.tfNickname; }

    public JLabel getlNicknameError() { return this.lNicknameError; }

    public JComponent getTfEmail() { return this.tfEmail; }

    public JLabel getlEmailError() { return this.lEmailError; }

    public JComponent getTfPsw() { return this.tfPsw; }

    public JLabel getlPswError() { return this.lPswError; }

    // Costruttore

    public GridBagLayoutFormView () throws Exception {
        this.build();
    }

    // Funzione build per la costruzione di una GridBagConstraint
    private void build() throws Exception {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Row 2 - Name
        // Col 0
        this.lName = new JLabel("Nome:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 0, 0, 10);
        this.add(this.lName, gbc);

        // Col 1
        this.tfName = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.tfName, gbc);

        // Col 2
        this.lNameError = new JLabel("Inserisci il tuo nome: ");
        this.lNameError.setForeground(Color.RED);
        this.lNameError.setVisible(false);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.lNameError, gbc);

        // Row 3 - Last Name
        // Col 0
        this.lLastName = new JLabel("Cognome:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(5, 0, 0, 10);
        this.add(this.lLastName, gbc);

        // Col 1
        this.tfLastName = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.tfLastName, gbc);

        // Col 2
        this.lLastNameError = new JLabel("Inserire il cognome.");
        this.lLastNameError.setForeground(Color.RED);
        this.lLastNameError.setVisible(false);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.lLastNameError, gbc);

        // Row 4 - Comune
        // Col 0
        this.lComune = new JLabel("Comune di residenza:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 0, 0, 10);
        this.add(this.lComune, gbc);

        // Col 1
        this.tfComune= new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.tfComune, gbc);

        // Col 2
        this.lComuneError = new JLabel("Inserire il comune di appartenenza.");
        this.lComuneError.setForeground(Color.RED);
        this.lComuneError.setVisible(false);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.lComuneError, gbc);

        // Row 5 - Sigla
        // Col 0
        this.lSigla = new JLabel("Sigla della provincia: ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(5, 0, 0, 10);
        this.add(this.lSigla, gbc);

        // Col 1
        this.tfSigla = new JTextField(2);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.tfSigla, gbc);

        // Col 2
        this.lSiglaError = new JLabel("Inserire la sigla della Provincia di appartenenza.");
        this.lSiglaError.setForeground(Color.RED);
        this.lSiglaError.setVisible(false);
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.lSiglaError, gbc);

        // Row 6 - Nickname
        // Col 0
        this.lNickname = new JLabel("Inserire il nickname");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 0, 0, 10);
        this.add(this.lNickname, gbc);

        // Col 1
        this.tfNickname = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(this.tfNickname, gbc);

        // Col 2
        this.lNicknameError = new JLabel("Inserire un nickname valido");
        this.lNicknameError.setForeground(Color.RED);
        this.lNicknameError.setVisible(false);
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.lNicknameError, gbc);

        // Row 7 - Email
        // Col 0
        this.lEmail = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(5, 0, 0, 10);
        this.add(this.lEmail, gbc);

        // Col 1
        this.tfEmail = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.tfEmail, gbc);

        // Col 2
        this.lEmailError = new JLabel("Inserire un'email.");
        this.lEmailError.setForeground(Color.RED);
        this.lEmailError.setVisible(false);
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.lEmailError, gbc);

        // Row 8 - Psw
        // Col 0
        this.lPsw = new JLabel("Password :");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 0, 0, 10);
        this.add(this.lPsw, gbc);

        // Col 1
        this.tfPsw = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.tfPsw, gbc);

        // Col 2
        this.lPswError = new JLabel("Inserire una password.");
        this.lPswError.setForeground(Color.RED);
        this.lPswError.setVisible(false);
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(this.lPswError, gbc);

        // Row 9 - Submit button
        // Col 0 empty

        // Col 1
        this.submitButton = new JButton("Iscriviti");
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(25, 0, 0, 10);
        this.add(this.submitButton, gbc);
        this.submitButton.addActionListener(new GridBagController(this));
    }

  /*  public static void main(final String[] args) {

        JFrame frame = new JFrame();
        GridBagLayoutFormView myPanel = new GridBagLayoutFormView();


        frame.setSize(700, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Registrazione cliente");
        frame.getContentPane().add(myPanel);
        frame.setVisible(true);

    }*/
}