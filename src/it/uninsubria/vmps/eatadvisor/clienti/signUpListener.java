package it.uninsubria.vmps.eatadvisor.clienti;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUpListener implements ActionListener {
    private JFrame frame;
    @Override
    public void actionPerformed(ActionEvent e) {
        frame = new JFrame();
        GridBagLayoutFormView myPanel;
        try {
            myPanel = new GridBagLayoutFormView();
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
