package makieta;
import java.util.Timer;
import java.util.TimerTask;

public class Flame extends Field{
	public Timer FlameTimer;
	boolean on_the_map=false;
		public Flame(Level level)
	{
	}


		

		
int porownanie(Level level)
{
	for(int i=0;i<level.fields.size();i++)
	{
if(this.getX()==level.fields.get(i).getX() && this.getX()==level.fields.get(i).getX())
{
	if(level.fields.get(i) instanceof Wall)
	{
	return 1;
	}
	else if(level.fields.get(i) instanceof Chest)
	{
	return 2;
	}
	else if(level.fields.get(i) instanceof Creep){
		return 3;
	}
	else return 4;
}
	}
	
	return 0;
}



	}


