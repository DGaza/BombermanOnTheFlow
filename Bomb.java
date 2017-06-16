package makieta;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasa przechowujaca wspolrzedne obiektow bomb.
 */
public class Bomb extends Field {
	Timer explosionTimer;
	boolean on_the_map;

	Bomb(Level level)
	{
	
		
		
		class ExplodeTask extends TimerTask {
			public void run() {
				System.out.println(level.fields.size());
				level.fields.remove(level.fields.size()-level.numberOfBombs);
				level.bombs.remove(level.bombs.get(0));
				System.out.println(level.fields.size());
				level.numberOfBombs--;
				System.out.println("bomba znikla");
				for(int i=0;i<5;i++)
				{
				level.flames.get((level.numberOfFlames-1)*5+i).on_the_map=true;
				level.repaint();
				}
				for(int i=0;i<5;i++)
				{
				level.flames.get((level.numberOfFlames-1)*5+i).disappear(level);
				}
				
		}
		}
		
	explosionTimer = new Timer();
	explosionTimer.schedule(new ExplodeTask(), 3000);
	}
	

	
	
	
}
