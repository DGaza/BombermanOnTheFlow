package makieta;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Klasa przechowujaca informacje o graczu.
 */
public class Player extends Field implements Comparable<Player> {
    
	/**
     * Zmienna przechowujaca nick gracza.
     */
    static String nick;
    
    /**
     * Zmienna pozwalajaca na wypisanie punktow zdobytych przez graczy w liscie najlepszych wynikow.
     */
    public int pointsToList;
    
    /**
     * Zmienna pozwalajaca na wypisanie nickow graczy w liscie najlepszych wynikow.
     */
    private String nickToList;

    /**
     * Konstruktor bezparametrowy tworzacy obiekt gracza i nadajacy mu poczatkowe wspolrzedne.
     */
    Player(){
    	x=Properties.PlayerStartPositionX;
    	y=Properties.PlayerStartPositionY;
    }
    
    /**
     * Konstruktor z parametrami tworzacy obiekt gracza. Uzywany do wypisania wynikow w liscie najlepszych wynikow.
     * @param pointss liczba punktow
     * @param nickk nick
     */
    public Player(int pointss, String nickk){
        pointsToList=pointss;
        nickToList=nickk;
    }
    
    /**
     * Metoda zwracaj¹ca liczbe punktów
     * @return Liczba Punktow Gracza
     */
    public int getPoints(){return pointsToList;}
    
    /**
     * Metoda zwracaj¹ca nick gracza
     * @return Nick Gracza
     */
    public String getNick(){return nickToList;}
    /**
     * Metoda ustawia nick gracza w liscie najlepszych wynikow.
     * @param n nick gracza 
     */
    public void setNick(String n){
    	nickToList = n;
    	}

    /**
     * Metoda ustawiajaca liczbe punktow gracza w liscie najlepszych wynikow.
     * @param p liczba punktow
     */
    public void setPoints(int p){
        pointsToList=p;
    }

    /**
     * Metoda pozwalajaca porownac wyniki punktowe graczy. Potrzeba do sortowania w liscie najlepszych wynikow.
     * @param playerr gracz, ktorego punkty sa porownywane
     * @return wartosc do sortowania
     */
	public int compareTo(Player playerr) {
		return playerr.pointsToList-Bomb.points;
	}

}



