package it.uninsubria.vmps.eatadvisor.clienti;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SignUpListener implements ActionListener {
    private JFrame frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        frame = new JFrame();
        RegistrazioneFormView myPanel;
        try {
            myPanel = new RegistrazioneFormView();
            frame.setSize(700, 400);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            frame.setTitle("Registrazione cliente");
            frame.getContentPane().add(myPanel);
            frame.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
