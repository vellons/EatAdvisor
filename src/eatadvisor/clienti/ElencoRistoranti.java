package eatadvisor.clienti;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ElencoRistoranti extends JFrame {
    public JPanel panelElencoRistoranti;
    private JButton btnButton;
    private JPanel panelLogo;
    private JPanel jPanelList;


    public ElencoRistoranti() throws Exception {

        btnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ciao");
                JPanel panel = new JPanel();
                panel.add(new JLabel("Hello"));
                panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.weightx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                jPanelList.add(panel, gbc, 0);

                validate();
                repaint();
            }
        });
    }

    private void createUIComponents() throws IOException {
        panelLogo = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("media/EatAdvisroLogoClienti.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelLogo.add(picLabel);

        jPanelList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        jPanelList.add(new JPanel(), gbc);

        //jPanelList.add(new JScrollPane(jPanelList));
    }

}
