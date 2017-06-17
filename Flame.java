package makieta;
import java.util.Timer;
import java.util.TimerTask;

public class Flame extends Field{
	public Timer FlameTimer;
	boolean on_the_map=false;
		public Flame(Level level)
	{
	/*		class FlameTask extends TimerTask {
				public void run() {
					Flame.this.on_the_map=false;
					level.repaint();
			}
			}

		FlameTimer = new Timer();
		FlameTimer.schedule(new FlameTask(), 3000);	*/
	}


		

		
void porownanie(Level level)
{
	for(int i=0;i<level.fields.size();i++)
	{
if(this.getX()==level.fields.get(i).getX() && this.getX()==level.fields.get(i).getX())
{
	if(level.fields.get(i) instanceof Wall)
	{
	this.on_the_map=false;
	}
	else if(level.fields.get(i) instanceof Chest)
	{
	this.on_the_map=true;
	}
	else this.on_the_map=true;
}
	}
	
}



	}


