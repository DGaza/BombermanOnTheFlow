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
	int collisions=0;

	Bomb(Level level)
	{
	
	}
	void checkCollisions(Level level)
	{
		for(int k=0;k<5-collisions;k++)
		{
		for(int i=0;i<level.walls.size();i++)
		{
		//	System.out.println("wspolrzedne usunietego plomienia: x:"+level.flames.get(5*(level.numberOfFlames-1)+k).getX()+"y:"+level.flames.get(5*(level.numberOfFlames-1)*k).getY());
		//	System.out.println("wspolrzedne kamienia: x:"+level.walls.get(5*(level.numberOfFlames-1)*k).getX()+"y:"+level.flames.get(5*(level.numberOfFlames-1)*k).getY());
		if(level.flames.get(5*(level.numberOfFlames-1)+k).Kolizja(level.walls.get(i)))
		{
			System.out.println("wspolrzedne usunietego plomienia: x:"+level.flames.get(5*(level.numberOfFlames-1)+k).getX()+"y:"+level.flames.get(5*(level.numberOfFlames-1)+k).getY());
		level.flames.remove(5*(level.numberOfFlames-1)+k);
		collisions++;
		k=0;
		}
		}
		for(int i=0;i<level.chests.size();i++)
		{
		if(level.flames.get(5*(level.numberOfFlames-1)+k).Kolizja(level.chests.get(i)))
		{
		for(int p=0;p<level.fields.size();p++)
		{
		if(level.chests.get(i).getX()==level.fields.get(p).getX()&&level.chests.get(i).getY()==level.fields.get(p).getY())
		{
			System.out.println("chuj");
			level.fields.remove(p);
		}
		}
		level.chests.remove(i);
		
		}
		}
		for(int i=0;i<level.creeps.size();i++)
		{
		if(level.flames.get(5*(level.numberOfFlames-1)+k).Kolizja(level.creeps.get(i)))
		{
		level.creeps.remove(i);
		}
		}
		}
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
			System.out.println("ilosc plomieni:"+level.numberOfFlames);
    		level.flames.get(5*(level.numberOfFlames-1)-collisions).initPosition(level.bombs.get(0).getX()-50, level.bombs.get(0).getY());
			level.flames.get(5*(level.numberOfFlames-1)+1-collisions).initPosition(level.bombs.get(0).getX()+50, level.bombs.get(0).getY());
    		level.flames.get(5*(level.numberOfFlames-1)+2-collisions).initPosition(level.bombs.get(0).getX(),level.bombs.get(0).getY()+50);
    		level.flames.get(5*(level.numberOfFlames-1)+3-collisions).initPosition(level.bombs.get(0).getX(), level.bombs.get(0).getY()-50);
    		level.flames.get(5*(level.numberOfFlames-1)+4-collisions).initPosition(level.bombs.get(0).getX(), level.bombs.get(0).getY());
			System.out.println(level.fields.size());
			checkCollisions(level);
			level.fields.remove(level.fields.size()-level.numberOfBombs);
			level.bombs.remove(level.bombs.get(0));
			System.out.println(level.fields.size());
			level.numberOfBombs--;
			System.out.println("bomba znikla");
			
			class FlamesTask extends TimerTask {
				public void run(){
					for(int i=0;i<5-collisions;i++)
					{
						level.flames.remove(0);
					}
					level.numberOfFlames--;
					collisions=0;
				}
			}
	
		flamesTimer = new Timer();
		flamesTimer.schedule(new FlamesTask(), 2000);
		System.out.println("number of collisions:"+collisions);
		level.repaint();
		}
	}
	
	
explosionTimer = new Timer();
explosionTimer.schedule(new ExplodeTask(), 3000);
}
	
	
}
