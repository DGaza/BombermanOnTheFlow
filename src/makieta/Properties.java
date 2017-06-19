package makieta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Klasa odczytujaca z pliku i przechowujaca dane gry.
 */
public class Properties {

	/**
	 * Zmienna przechowujaca nazwe okna.
	 */
	public static String FrameTitle;
	
	/**
	 * Zmienna przechowujaca szerokosc okna.
	 */
	public static int FrameWidth;

	/**
	 * Zmienna przechowujaca wysokosc okna.
	 */
	public static int FrameHeight;

	/**
	 * Zmienna przechowujaca szerokosc przyciskow okna startowego.
	 */
	public static int StartScreenButtonsWidth;

	/**
	 * Zmienna przechowujaca wysokosc przyciskow okna startowego.
	 */
	public static int StartScreenButtonsHeight;

	/**
	 * Zmienna przechowujaca pozycje w pionie przycisku New Game.
	 */
	public static int NewGameButtonVerticalPosition;

	/**
	 * Zmienna przechowujaca pozycje w poziomie przycisku New Game.
	 */
	public static int NewGameButtonHorizontalPosition;

	/**
	 * Zmienna przechowujaca pozycje w pionie przycisku How To Play.
	 */
	public static int HowToPlayButtonVerticalPosition;

	/**
	 * Zmienna przechowujaca pozycje w poziomie przycisku How To Play.
	 */
	public static int HowToPlayButtonHorizontalPosition;

	/**
	 * Zmienna przechowujaca pozycje w pionie przycisku High Scores.
	 */
	public static int HighScoresButtonVerticalPosition;

	/**
	 * Zmienna przechowujaca pozycje w poziomie przycisku High Scores.
	 */
	public static int HighScoresButtonHorizontalPosition;

	/**
	 * Zmienna przechowujaca pozycje w pionie przycisku Exit.
	 */
	public static int ExitButtonVerticalPosition;

	/**
	 * Zmienna przechowujaca pozycje w poziomie przycisku Exit.
	 */
	public static int ExitButtonHorizontalPosition;
	
	/**
	 * Zmienna przechowujaca szerokosc przyciskow okna gry.
	 */
	public static int GameScreenButtonsWidth;
	
	/**
	 * Zmienna przechowujaca wysokosc przyciskow okna gry.
	 */
	public static int GameScreenButtonsHeight;
	
	/**
	 * Zmienna przechowujaca pozycje w pionie przycisku Pause.
	 */
	public static int PauseButtonVerticalPosition;
	
	/**
	 * Zmienna przechowujaca pozycje w poziomie przycisku Pause.
	 */
	public static int PauseButtonHorizontalPosition;
	
	/**
	 * Zmienna przechowujaca pozycje w pionie przycisku End Game.
	 */
	public static int EndGameButtonVerticalPosition;
	
	/**
	 * Zmienna przechowujaca pozycje w poziomie przycisku End Game.
	 */
	public static int EndGameButtonHorizontalPosition;
	
	/**
	 * Zmienna przechowujaca szerokosc pola.
	 */
	public static int FieldWidth;
	
	/**
	 * Zmienna przechowujaca wysokosc pola.
	 */
	public static int FieldHeight;
	
	/**
	 * Zmienna przechowujaca pozycje startowa gracza w poziomie.
	 */
	public static int PlayerStartPositionX;
	
	/**
	 * Zmienna przechowujaca pozycje startowa gracza w pionie.
	 */
	public static int PlayerStartPositionY;

	/**
	 * Zmienna przechowujaca ilosc pol w rzedzie (w pionie i w poziomie).
	 */
	public static int NumberOfFields;
	
	/**
	 * Zmienna przechowujaca opis poziomu
	 */
	public static String[] mapa1=new String[11];
	public static String[] mapa2=new String[11];
	public static String[] mapa3=new String[11];
	


private static final String FILENAME = "config.txt";

/**
 * Konstruktor bezparametrowy, wywolujacy odczytanie zmiennych z pliku konfiguracyjnego.
 */
Properties()
{
load();
}

/**
 * Metoda odczytujaca zmienne z pliku konfiguracyjnego.
 */
public void load()
{
	BufferedReader br = null;
	FileReader fr = null;

	try {

		fr = new FileReader(FILENAME);
		br = new BufferedReader(fr);
		

		String line;
	
	
		br = new BufferedReader(new FileReader(FILENAME));
		
		while((line = br.readLine()) != null)
		{
			if(line.equals("#FrameTitle"))
				FrameTitle = br.readLine();
			else if (line.equals("#FrameWidth"))
				FrameWidth = Integer.parseInt(br.readLine());
			else if (line.equals("#FrameHeight"))
				FrameHeight = Integer.parseInt(br.readLine());
			else if (line.equals("#StartScreenButtonsWidth"))
				StartScreenButtonsWidth = Integer.parseInt(br.readLine());
			else if (line.equals("#StartScreenButtonsHeight"))
				StartScreenButtonsHeight = Integer.parseInt(br.readLine());
			else if (line.equals("#NewGameButtonVerticalPosition"))
				NewGameButtonVerticalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#NewGameButtonHorizontalPosition"))
				NewGameButtonHorizontalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#HowToPlayButtonVerticalPosition"))
				HowToPlayButtonVerticalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#HowToPlayButtonHorizontalPosition"))
				HowToPlayButtonHorizontalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#HighScoresButtonVerticalPosition"))
				HighScoresButtonVerticalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#HighScoresButtonHorizontalPosition"))
				HighScoresButtonHorizontalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#ExitButtonVerticalPosition"))
				ExitButtonVerticalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#ExitButtonHorizontalPosition"))
				ExitButtonHorizontalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#GameScreenButtonsWidth"))
				GameScreenButtonsWidth = Integer.parseInt(br.readLine());
			else if (line.equals("#GameScreenButtonsHeight"))
				GameScreenButtonsHeight = Integer.parseInt(br.readLine());
			else if (line.equals("#PauseButtonVerticalPosition"))
				PauseButtonVerticalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#PauseButtonHorizontalPosition"))
				PauseButtonHorizontalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#EndGameButtonVerticalPosition"))
				EndGameButtonVerticalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#EndGameButtonHorizontalPosition"))
				EndGameButtonHorizontalPosition = Integer.parseInt(br.readLine());
			else if (line.equals("#FieldWidth"))
				FieldWidth=Integer.parseInt(br.readLine());
			else if (line.equals("#FieldHeight"))
				FieldHeight=Integer.parseInt(br.readLine());
			else if (line.equals("#PlayerStartPositionX"))
				PlayerStartPositionX=Integer.parseInt(br.readLine());
			else if (line.equals("#PlayerStartPositionY"))
				PlayerStartPositionY=Integer.parseInt(br.readLine());
			else if (line.equals("#NumberOfFields"))
				NumberOfFields=Integer.parseInt(br.readLine());
			else if(line.equals("#MapConfiguration1"))
			{
			for(int i=0;i<NumberOfFields;i++)
			{
			mapa1[i]=br.readLine();
			}
			
			}
			else if(line.equals("#MapConfiguration2"))
			{
			for(int i=0;i<NumberOfFields;i++)
			{
			mapa2[i]=br.readLine();
			}
			
			}
			else if(line.equals("#MapConfiguration3"))
			{
			for(int i=0;i<NumberOfFields;i++)
			{
			mapa3[i]=br.readLine();
			}
			
			}
			
		}
		 for(int i=0;i<NumberOfFields;i++)
		 {
			System.out.println(mapa1[i]);
		 }
		}
	
	 catch (IOException e) {

		e.printStackTrace();

	}
}

public void readHighScores(String nazwa_pliku, ArrayList<Player> lista){
    try {
        File sciezka2 = new File(nazwa_pliku);
        FileReader plik2 = new FileReader(sciezka2);
        BufferedReader odczyt2 = new BufferedReader(plik2);
        String wiersz = null;
        odczyt2.readLine();

        for(int i =0 ;i<10;i++) {
            wiersz = odczyt2.readLine();
            tworzListe(wiersz,lista,i);

        }
        odczyt2.close();



    }
    catch(IOException e)
    {
        System.out.println("Plik nie móg³ zostaæ odczytany");
        e.printStackTrace();
    }
}

public void tworzListe(String wiersz_danych,ArrayList<Player> lista,int p){
    String[] wierszeListy = wiersz_danych.split(",");


    lista.get(p).setNick(wierszeListy[0]);
    lista.get(p).setPoints(Integer.parseInt(wierszeListy[1]));
}

public void saveHighScores(String nazwa_pliku,ArrayList<Player> lista){
    try{
        File sciezka = new File(nazwa_pliku);
        BufferedWriter zapis = new BufferedWriter(new FileWriter(sciezka));
        zapis.write("#Najlepsze Wyniki \n");
        for(int i =0; i <10;i++) {
            zapis.write(lista.get(i).getNick() + "," + lista.get(i).getPoints()+"\n");
        }
        zapis.close();
    }
    catch (FileNotFoundException e) {
        System.out.println(e.toString());
        System.out.println("Plik nie móg³ zostaæ odczytany");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
