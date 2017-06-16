package makieta;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Creep extends Field {
	
	private Timer moveTimer;
	private Random random = new Random();
	
	Creep(Level level){
	class MoveTask extends TimerTask{
		public void run() {
		int moveDir = random.nextInt(4);
	
		if(moveDir == 0 )
    	{
    		boolean brak_kolizji=true;
    		for(int i=0;i<level.fields.size();i++)
    		{
    			if(level.creeps.get(0).prawaKolizja(level.fields.get(i))==true)
    			{
    				brak_kolizji=false;
    			}
    		}
    		if(brak_kolizji)
    			x+=50;

    	}
		else if(moveDir == 1) 
    	{
    		boolean brak_kolizji=true;
    		for(int i=0;i<level.fields.size();i++)
    		{
    			if(level.creeps.get(0).lewaKolizja(level.fields.get(i))==true)
    			{
    				brak_kolizji=false;
    			}
    		}
    		if(brak_kolizji)
    			x-=50;

    	}
		else if(moveDir == 2) 
    	{
    		boolean brak_kolizji=true;
    		for(int i=0;i<level.fields.size();i++)
    		{
    			if(level.creeps.get(0).gornaKolizja(level.fields.get(i))==true)
    			{
    				brak_kolizji=false;
    			}
    		}
    		if(brak_kolizji)
    			y-=50;

    	}
		else 
    	{
    		boolean brak_kolizji=true;
    		for(int i=0;i<level.fields.size();i++)
    		{
    			if(level.creeps.get(0).dolnaKolizja(level.fields.get(i))==true)
    			{
    				brak_kolizji=false;
    			}
    		}
    		if(brak_kolizji)
    			y+=50;

    	}
		
		level.repaint();
		}
	}
	moveTimer = new Timer();
	moveTimer.schedule(new MoveTask(), 500, 500);
	
	}
	}
