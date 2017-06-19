package makieta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Klasa przechowujaca i aktualizujaca liste najlepszych wynikow uzyskanych w grze.
 */
public class HighScores extends JPanel{

    /**
     * Zmienna przechowujaca nazwe pliku z najlepszymi wynikami.
     */
    String scoresFile = "scores.txt";

    /**
     * Zmienna przechowujaca przycisk sluzacy do powrotu do menu.
     */
    JButton Back = new JButton("Back");

    /**
     *  Zmienna przechowujaca panel glowny, do ktorego dodawany jest panel z lista najlepszych wynikow.
     */
    JPanel mainPanel;

    /**
     *  Zmienna przechowujaca liste graczy. Uzywana do wyswietlania wynikow oraz sortowania.
     */
    static ArrayList<Player> list;

    /**
     * Zmienna przechowujaca panel z lista wynikow, ktory znajduje sie po lewej stronie glownego okna.
     */
    Lista leftPanel;

    /**
     *  Zmienna przechowujaca obiekt typu Properties. Sluzy do wywolania metody odczytujacej wyniki z pliku.
     */
    static Properties properties;
    
    /**
     * Zmienna przechowujaca obrazek tla glownego okna.
     */
    Image highScoresImage = new ImageIcon("highscores.png").getImage();

    /**
     * Konstruktor bezparametrowy klasy ListaNajlepszychWynikow.
     * Tutaj lista jest odczytywana z pliku, a nastepnie pokazywana w oknie.
     */
    public HighScores() {
        setLayout(new BorderLayout());    
        
        properties = new Properties();
        list = new ArrayList();
        
        Back.setPreferredSize(new Dimension(350, 40));
		Back.setBackground(new Color(30,10,180));
		Back.setForeground(Color.WHITE);
		Back.setFont(new Font("Calibri", Font.PLAIN, 16));
		Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                MainWindow.mainLayout.show(MainWindow.panels,"start");

            }
        });

        mainPanel = new JPanel(new GridLayout(1, 1));

        for (int i = 0; i < 10; i++) {
            list.add(new Player());
        }


        properties.readHighScores(scoresFile, list);



        leftPanel = new Lista(10);
        mainPanel.add(leftPanel);

        add(BorderLayout.CENTER, mainPanel);
    }

    
    /**
     * Metoda sluzaca do posortowania nowego wyniku dodanego do listy oraz dodania informacji o graczu do pliku.
     * @param points liczba punktow uzyskana przez gracza
     * @param nick nick gracza
     */
    public static void dodajWynikiSortuj(int points, String nick){


            list.add(new Player(points, nick));
            Collections.sort(list);


            properties.saveHighScores("scores.txt", list);
    }

    


    /**
     * Metoda tworzaca liste na podstawie ciagow znakow zlozonych z nicku, przecinka i liczby punktow.
     * Na poczatku ciag rozdzialny jest przecinkiem, a potem kolejny element w liscie zyskuje nick i liczbe punktow.
     * @param wiersz_danych aktualny wiersz danych
     * @param lista lista, do ktorej zapisujemy odczytane wyniki
     * @param p zmienna uzywana do zmiany indeksu listy podczas zapisywania
     */
    public void tworzListe(String wiersz_danych,ArrayList<Player> list,int p){
        String[] wierszeListy = wiersz_danych.split(",");


        list.get(p).setNick(wierszeListy[0]);
        list.get(p).setPoints(Integer.parseInt(wierszeListy[1]));


    }


    /**
     * Klasa panelu, w ktorej dodawane sa kolejne najlepsze wyniki z listy.
     */
    class Lista extends JPanel {


        /**
         * Konstruktor z parametrami. Tutaj ustawiane jest rozlozenie wynikow.
         * @param koniec parametr odpowiadajacy z ilosc wynikow na stronie.
         */
        public Lista(int koniec) {

           setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.insets = new Insets(0,0,0,0);
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridy = 0;
            JLabel nick = new JLabel("Nick");
            nick.setFont(new Font("Comic Sans", Font.PLAIN,20));
            nick.setForeground(Color.WHITE);
            add(nick,gbc);
            for (int i = 0; i < koniec; i++) {
                gbc.gridy=i+1;


                add(new JLabel((i+1)+". "+list.get(i).getNick()),gbc);
            }
            gbc.gridy=0;
            gbc.gridx=2;
            gbc.insets = new Insets(0,0,0,0);
            JLabel punkty = new JLabel("Points");
            punkty.setForeground(Color.WHITE);
            punkty.setFont(new Font("Comic Sans", Font.PLAIN,20));
            add(punkty,gbc);

            for (int i = 0; i < koniec; i++) {
                gbc.gridy=i+1;
                add(new JLabel(""+list.get(i).getPoints()),gbc);
            }


            gbc.gridy++;
            gbc.gridx=0;
            gbc.insets=new Insets(0,-50,0,0);

          add(Back,gbc);

        }


        /**
         * Metoda odpowiadajaca za rysowanie obrazka w oknie z lista najlepszych wynikow.
         * @param g kontekst graficzny
         */
        public void paintComponent(Graphics g){
            g.drawImage(highScoresImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
