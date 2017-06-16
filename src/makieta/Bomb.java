package makieta;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasa przechowujaca wspolrzedne obiektow bomb.
 */
public class Bomb extends Field {
	Timer explosionTimer;

	Bomb(Level level)
	{
	
		
		class ExplodeTask extends TimerTask {
			public void run() {
				System.out.println(level.fields.size());
				level.fields.remove(level.fields.size()-level.numberOfBombs);
				level.bombs.remove(level.bombs.get(0));
				System.out.println(level.fields.size());
				level.numberOfBombs--;
				level.x--;
				level.flame=true;
				level.repaint();
				
			
				
		}
		}
	explosionTimer = new Timer();
	explosionTimer.schedule(new ExplodeTask(), 3000);
	
	
	 
	}
	

	
	
	
}
