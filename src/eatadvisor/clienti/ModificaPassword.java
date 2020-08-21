package eatadvisor.clienti;

import eatadvisor.global.Global;
import eatadvisor.ioutenti.IOUtenti;
import eatadvisor.ioutenti.Utente;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ModificaPassword {
    public JPanel panelChangePassword;
    private JPasswordField tfVecchiaPassword;
    private JPasswordField tfNuovaPassword;
    private JLabel lbVecchiaPassword;
    private JButton btnCambiaPassword;
    private JLabel lbNuovaPassword;
    private JPanel panelLogo;

    public ModificaPassword() throws Exception {
        IOUtenti ioUtenti = new IOUtenti();
        btnCambiaPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfVecchiaPassword.getPassword().length == 0 || tfNuovaPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Non è stato possibile modificare la password" +
                            " perchè il campo risulta vuoto", "Cambio password non riuscito", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        ioUtenti.aggiornaPasswordById(Global.utenteLoggato.getId(),
                                String.valueOf(tfVecchiaPassword.getPassword()),
                                String.valueOf(tfNuovaPassword.getPassword()));
                        JOptionPane.showMessageDialog(null, "Password cambiata con successo", "Cambio Password eseguito",
                                JOptionPane.PLAIN_MESSAGE);

                    } catch (Exception exception) {
                        if (Objects.equals(exception.getMessage(), "La vecchia password non corrisponde.")) {
                            JOptionPane.showMessageDialog(null, "La vecchia password non corrisponde",
                                    "Attenzione", JOptionPane.PLAIN_MESSAGE);
                        } else if (Objects.equals(exception.getMessage(), "Le due password risultano uguali.")) {
                            JOptionPane.showMessageDialog(null, "Le due password risultano uguali.",
                                    "Attenzione", JOptionPane.PLAIN_MESSAGE);
                        }
                    } finally {
                        clienti.closePreviousWindow(AccountCliente.modifyPassword);
                    }
                }
            }
        });
    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisorLogoClientiCambioPassword.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);
    }
}