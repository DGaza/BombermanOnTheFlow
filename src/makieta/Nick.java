package makieta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klasa opisujaca wyglad okna do wpisywania nazwy gracza.
 */
public class Nick extends JPanel {

    /**
     * Zmienna przechowujaca przycisk sluzacy do pobrania nicku i startu gry.
     */
    JButton Ok = new JButton("Ok");

    /**
     * Przycisk do powrotu do glownego menu.
     */
    JButton Back = new JButton("Back");

    /**
     * Pole do wpisywania nicku.
     */
    JTextField tekst = new JTextField(15);

    /**
     * Obrazek w tle okna z nickiem.
     */
    Image nickImage = new ImageIcon("nick.png").getImage();



    /**
     * Konstruktor bezparametrowy. Tutaj konstruowany jest wyglad calego okna, ustalane wlasciwosci przyciskow.
     */
    public Nick(){

        GridBagConstraints gbc;
        JPanel downPanel;
        JPanel middlePanel;


        tekst.setFont(new Font("Calibri",Font.PLAIN,16));
        tekst.setText("Player");

        setLayout(new GridBagLayout());

        downPanel= new JPanel();
        middlePanel= new JPanel();

        gbc = new GridBagConstraints();
        gbc.weighty=1;
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets= new Insets(30,0,-15,0);

        middlePanel.add(tekst);
        middlePanel.setOpaque(false);
        gbc.gridy = 1;
        gbc.insets= new Insets(200,0,0,0);
        add(middlePanel,gbc);

        Ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Player.nick=tekst.getText();
                MainWindow.mainLayout.show(MainWindow.panels,"level1");
                MainWindow.level1.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });

                MainWindow.level1.setFocusable(true);
                MainWindow.level1.requestFocusInWindow();




            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainWindow.mainLayout.show(MainWindow.panels,"start");
            }
        });
        Ok.setPreferredSize(new Dimension(150, 40));
        Ok.setBackground(new Color(30,10,180));
        Ok.setFont(new Font("Calibri", Font.PLAIN, 16));
        Ok.setForeground(Color.WHITE);
        Ok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Back.setPreferredSize(new Dimension(150, 40));
        Back.setBackground(new Color(30,10,180));
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Calibri", Font.PLAIN, 16));
        Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        downPanel.add(Ok);
        downPanel.setOpaque(false);
        downPanel.add(Back);
        gbc.gridy= 1;
        gbc.insets= new Insets(300,0,0,0);


        add(downPanel,gbc);
        setVisible(true);

    }

    /**
     * Metoda sluzaca do rysowania obrazka w tle okna z miejscem na podanie nicku.
     * @param g kontekst graficzny
     */
   public void paintComponent(Graphics g){
        g.drawImage(nickImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

