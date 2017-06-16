package makieta;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Flame extends Field{
	
	public long instantiated=-1;
	
	public Flame(Level level)
	{
	/*	instantiated = System.currentTimeMillis();
		 java.util.Timer explosionTimerr;
		 explosionTimerr = new java.util.Timer();
			class ExplodeTask extends TimerTask {
				public void run() {
					List<Flame> toDelete = new LinkedList<Flame>();
					for(Flame f : level.flames){
						if(System.currentTimeMillis()-f.instantiated>1000){
							toDelete.add(f);
						}
					}
					for(Flame f: toDelete){
						level.flames.remove(f);
					}
					toDelete.clear();
					
					
					
					
					
			}
			}
		
		explosionTimerr.schedule(new ExplodeTask(), 1000,1000);*/
	
	/*	 java.util.Timer explosionTimerr;
		 explosionTimerr = new java.util.Timer();
			class ExplodeTask extends TimerTask {
				public void run() {
					List<Flame> toDelete = new LinkedList<Flame>();
					
						if(System.currentTimeMillis()-instantiated>1000)
							toDelete.add(level.flames.get(0));
						
					
					
						level.flames.remove(0);
					
					toDelete.clear();
					
					
					
					
					
			}
			}
		
		explosionTimerr.schedule(new ExplodeTask(), 1000,1000);*/
	}
	
	@Override
	public boolean equals(Object o){
		if (o==null)
			return false;
		Flame tmp = (Flame)o;
		if(tmp.x == this.x && tmp.y == this.y){
			return true;
		}
		return false;
	}

	}


