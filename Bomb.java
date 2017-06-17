package makieta;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasa przechowujaca wspolrzedne obiektow bomb.
 */
public class Bomb extends Field {
	Timer explosionTimer;
	Timer flamesTimer;
	boolean on_the_map;

	Bomb(Level level)
	{
	
	}
	
void elo(Level level)
{
	class ExplodeTask extends TimerTask {
		public void run() {
			level.numberOfFlames++;
			System.out.println(level.numberOfFlames);
			for(int i=0;i<5;i++)
    		{
    		level.flames.add(new Flame(level));
    		}
    		level.flames.get(5*(level.numberOfFlames-1)).initPosition(level.bombs.get(0).getX()-50, level.bombs.get(0).getY());
			level.flames.get(5*(level.numberOfFlames-1)+1).initPosition(level.bombs.get(0).getX()+50, level.bombs.get(0).getY());
    		level.flames.get(5*(level.numberOfFlames-1)+2).initPosition(level.bombs.get(0).getX(),level.bombs.get(0).getY()+50);
    		level.flames.get(5*(level.numberOfFlames-1)+3).initPosition(level.bombs.get(0).getX(), level.bombs.get(0).getY()-50);
    		level.flames.get(5*(level.numberOfFlames-1)+4).initPosition(level.bombs.get(0).getX(), level.bombs.get(0).getY());    	
			System.out.println(level.fields.size());
			level.fields.remove(level.fields.size()-level.numberOfBombs);
			level.bombs.remove(level.bombs.get(0));
			System.out.println(level.fields.size());
			level.numberOfBombs--;
			System.out.println("bomba znikla");
			
			class FlamesTask extends TimerTask {
				public void run(){
					for(int i=0;i<5;i++)
					{
						level.flames.remove(0);
					}
					level.numberOfFlames--;
				}
			}
	
		flamesTimer = new Timer();
		flamesTimer.schedule(new FlamesTask(), 2000);
		}
	}
	
	
explosionTimer = new Timer();
explosionTimer.schedule(new ExplodeTask(), 3000);
}
	
	
	
}
