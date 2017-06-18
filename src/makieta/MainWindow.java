package makieta;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	
	/**
     * Zmienna przechowujaca layout pozwalajacy na podmienianie paneli
     */
	static CardLayout mainLayout = new CardLayout();

	/**
     * Zmienna przechowujaca panel, ktory przechowuje wszystkie okna gry.
     */
    static JPanel panels = new JPanel();

    /**
     * Zmienna przechowujaca okno menu glownego.
     */
    static StartScreen startScreen;
    
    /**
     * Zmienna przechowujaca okno 1 poziomu.
     */
    static Level level1;
    
    /**
     * Zmienna przechowujaca okno 2 poziomu.
     */
    static Level level2;
    
    /**
     * Zmienna przechowujaca okno 3 poziomu.
     */
    static Level level3;
    
    /**
     * Zmienna przechowujaca okno po ukonczeniu 1 poziomu.
     */
    static LevelCompleteWindow complete1;
    
    /**
     * Zmienna przechowujaca okno po ukonczeniu 1 poziomu.
     */
    static LevelCompleteWindow complete2;
    
    
    /**
     * Zmienna przechowujaca wysokosc okna.
     */
    static int screenHeight;

    /**
     * Zmienna przechowujaca szerokosc okna.
     */
    static int screenWidth;
    
    public static ArrayList<Level> levels;
    
    public MainWindow()
    {
    	InitWindow();
    }
    
    private void InitWindow()
    {
    	setTitle("Bomberman on the flow");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setMinimumSize(new Dimension(Properties.FrameWidth,Properties.FrameHeight));
    	setLocationRelativeTo(null);
    	
    	levels = new ArrayList<Level>();
    	
    	startScreen = new StartScreen();
    	level1 = new Level(Properties.mapa1);
    	level2 = new Level(Properties.mapa2);
    	level3 = new Level(Properties.mapa3);
    	complete1 = new LevelCompleteWindow(2);
    	complete2 = new LevelCompleteWindow(3);
    	
    	levels.add(level1);
    	levels.add(level2);
    	levels.add(level3);
    	
        panels = new JPanel();
        panels.setLayout(mainLayout);
        
        panels.add(startScreen, "start");
        panels.add(level1, "level1");
        panels.add(level2, "level2");
        panels.add(level3, "level3");
        panels.add(complete1, "complete1");
        panels.add(complete2, "complete2");

        mainLayout.show(panels, "start");
        add(panels);
  
        setVisible(true);
    }
}