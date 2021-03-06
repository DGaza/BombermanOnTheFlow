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
				
					if(Creep.this.prawaKolizja(level.fields.get(i))==true)
					{
						moveDir = random.nextInt(4);
						brak_kolizji=false;
					}
				}
				for(int i=0;i<level.flames.size();i++)
				{
					if(Creep.this.prawaKolizja(level.flames.get(i))==true)
					{
						brak_kolizji=false;
					}
				}
				if(brak_kolizji&&level.pause==false)
				{
					x+=50;
				}
			}
			else if(moveDir == 1) 
			{
				boolean brak_kolizji=true;
				for(int i=0;i<level.fields.size();i++)
				{
					
					if(Creep.this.lewaKolizja(level.fields.get(i))==true)
					{
						moveDir = random.nextInt(4);
						brak_kolizji=false;
					}
				}
				for(int i=0;i<level.flames.size();i++)
				{
					if(Creep.this.lewaKolizja(level.flames.get(i))==true)
					{
						brak_kolizji=false;
					}
				}
			
				if(brak_kolizji&&level.pause==false)
				{
					x-=50;
				}
			}
			else if(moveDir == 2) 
			{
				boolean brak_kolizji=true;
				for(int i=0;i<level.fields.size();i++)
				{
					
					if(Creep.this.gornaKolizja(level.fields.get(i))==true)
					{
						moveDir = random.nextInt(4);
						brak_kolizji=false;
					}
				}
				for(int i=0;i<level.flames.size();i++)
				{
					if(Creep.this.gornaKolizja(level.flames.get(i))==true)
					{
						brak_kolizji=false;
					}
				}
				
				if(brak_kolizji&&level.pause==false)
				{
					y-=50;
				}
			}
			else 
			{
				boolean brak_kolizji=true;
				for(int i=0;i<level.fields.size();i++)
				{
					
					if(Creep.this.dolnaKolizja(level.fields.get(i))==true)
					{
						moveDir = random.nextInt(4);
						brak_kolizji=false;
					}
				}
				for(int i=0;i<level.flames.size();i++)
				{
					if(Creep.this.dolnaKolizja(level.flames.get(i))==true)
					{
						brak_kolizji=false;
					}
				}
		
				if(brak_kolizji&&level.pause==false)
				{
					y+=50;
				}
			}
			level.repaint();
		}
	}
	moveTimer = new Timer();
	moveTimer.schedule(new MoveTask(), 1000, 1000);
	
	}
	
	
	}