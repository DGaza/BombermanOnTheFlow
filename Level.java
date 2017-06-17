package makieta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*; 
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;


/**
 * Klasa obslugujaca zdarzenia i rysowanie w oknie gry.
 */
public class Level extends JPanel implements ActionListener,KeyListener {
	 
	
	/**
	 * Obiekty klasy Image przechowujace obrazy.
	 */
	 private BufferedImage image1;
	 private BufferedImage image2;
	 private BufferedImage image3;
	 private BufferedImage image4;
	 private BufferedImage image5;
	 private BufferedImage image6;
	 private BufferedImage image7;
	 private BufferedImage image8;
	 private BufferedImage image;
	 
	 
	 JButton EndGame= new JButton("End Game");
	 JButton Pause= new JButton("Pause");
	 boolean initPosition;
	 boolean bomb;
	 Player gracz=new Player();	
	 private Timer time;
//	 java.util.Timer bombTime;
	 private int delay=8;
//	 private int bombDelay=0;
	 public int numberOfBombs=0;
	 public int numberOfFlames=0;
//	 private Timer moveTimer;
	 int p=0;
	 
	 
	
	 /**
	  * Lista przechowujaca obiekty scian.
	  */
	 private ArrayList<Wall> walls;
	 
	 /**
	  * Lista przechowujaca obiekty skrzynek.
	  */
	 private ArrayList<Chest> chests;
	 
	 /**
	  * Lista przechowujaca obiekty bomb.
	  */
	 public ArrayList<Bomb> bombs;
	 
	 public ArrayList<Flame> flames;
	 
	 /**
	  * Lista przechowujaca wszystkie pola.
	  */
	 public ArrayList<Field> fields;
	 
	
	 public ArrayList<Creep> creeps;
	 /**
	  * Konstruktor bezparametrowy.
	  */
	 public Level()
	 {
		 initPosition=true;
		 bomb=false;
		 createMap();
		 time=new Timer(delay,this);
		 time.start();
		 add(EndGame);
		 add(Pause);
		 EndGame.setBounds(Properties.EndGameButtonVerticalPosition, Properties.EndGameButtonHorizontalPosition, Properties.GameScreenButtonsWidth, Properties.GameScreenButtonsHeight);
		 Pause.setBounds(Properties.PauseButtonVerticalPosition, Properties.PauseButtonHorizontalPosition, Properties.GameScreenButtonsWidth, Properties.GameScreenButtonsHeight);
		 EndGame.addActionListener(this);
		 Pause.addActionListener(this);
		 setFocusable(true);
		 requestFocusInWindow();
		 addKeyListener(this);
		 
		/* java.util.Timer explosionTimerr;
		 explosionTimerr = new java.util.Timer();
			class ExplodeTask extends TimerTask {
				public void run() {
					List<Flame> toDelete = new LinkedList<Flame>();
					for(Flame f : flames){
						if(System.currentTimeMillis()-f.instantiated>1000){
							toDelete.add(f);
						}
					}
					for(Flame f: toDelete){
						flames.remove(f);
					}
					toDelete.clear();
					
					
					
					
					
			}
			}
		
		explosionTimerr.schedule(new ExplodeTask(), 1000,1000);*/
	
	try {
		image = ImageIO.read(new File("front_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image1 = ImageIO.read(new File("front_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image2 = ImageIO.read(new File("back_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image3 = ImageIO.read(new File("left_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image4 = ImageIO.read(new File("right_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image5 = ImageIO.read(new File("bomb.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image6 = ImageIO.read(new File("wall.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image7 = ImageIO.read(new File("wood.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	try {
		image8 = ImageIO.read(new File("flame.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	 

	public void paintComponent(Graphics g)
	{
		
	    Graphics2D g2 = (Graphics2D) g;
	    for(int k=0;k<11;k++)
	    {
	    for (int i=0;i<11;i++)
	    {
	    if(Character.getNumericValue(Properties.mapa[k].charAt(i))==0||Character.getNumericValue(Properties.mapa[k].charAt(i))==3)
	    {
	    	g2.setPaint(Color.green);
	    	g2.fill(new Rectangle2D.Double(50*i,50*k,50,50));
	    }
	    else   if(Character.getNumericValue(Properties.mapa[k].charAt(i))==1)
	    {
	    	g2.setPaint(Color.gray);
	    	g2.fill(new Rectangle2D.Double(50*i,50*k,50,50));
	    	g.drawImage(image6,50*i,50*k,this);
	    }
	    else   if(Character.getNumericValue(Properties.mapa[k].charAt(i))==2)
	    {
	    	g2.setPaint(Color.yellow);
	    	g2.fill(new Rectangle2D.Double(50*i,50*k,50,50));
	    	g.drawImage(image7, 50*i, 50*k, this);
	    }
	    }
	    }
	    
	    if(initPosition){
	    	g.drawImage(image1, Properties.PlayerStartPositionX, Properties.PlayerStartPositionY, this);
	    	initPosition=false;
	    }
	    
	    if(bomb==true){
	    	for(int i=0; i<fields.size(); i++)
	    		if(fields.get(i) instanceof Bomb)
	    	g.drawImage(image5, fields.get(i).getX(),fields.get(i).getY() , this);
	    }
	  
	   	for(int i=0;i<numberOfFlames;i++)
	   	{
	    		for(int k=0;k<5;k++)
	    		{
	    		g.drawImage(image8,flames.get(5*i+k).getX() , flames.get(5*i+k).getY(), this);
	    		}
	    }
	    g.drawImage(image ,gracz.getX(),gracz.getY(),this);
	
		for(int i=0;i<creeps.size();i++)
    	{
			g.drawImage(image, creeps.get(i).getX(), creeps.get(i).getY(), this);
    	}
	
	}

	public void init() {
        image = new BufferedImage(50,50,2);
    }
    /**
     * Metoda do wywolania metody tworzacej bufor na samym poczatku.
     */
    public void addNotify() {
        super.addNotify();

        this.init();
    }
	
	
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	time.start();
    	repaint();
    }

    public void changeImage(int i)
    {
    	switch(i)
    	{
    	case 1:
    	{
    		image=image1;
    		break;
    	}
    	case 2:
    	{
    		image=image2;
    		break;
    	}
    	case 3:
    	{
    		image=image3;
    		break;
    	}
    	case 4:
    	{
    		image=image4;
    		break;
    	}
    	}
    	repaint();
    }


    @Override
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
    	{
    		changeImage(4);
    		boolean brak_kolizji=true;
    		for(int i=0;i<fields.size();i++)
    		{
    			if(gracz.prawaKolizja(fields.get(i))==true)
    			{
    				gracz.x=gracz.x;
    				brak_kolizji=false;
    			}
    		}
    		if(brak_kolizji)
    			gracz.x+=25;

    	}


    	else if(e.getKeyCode()==KeyEvent.VK_LEFT)
    	{
    		changeImage(3);
    		boolean brak_kolizji=true;
    		for(int i=0;i<fields.size();i++)
    		{
    			if(gracz.lewaKolizja(fields.get(i))==true)
    			{
    				gracz.x=gracz.x;
    				brak_kolizji=false;
    			}
    		}
    		if(brak_kolizji)
    			gracz.x-=25;

    	}
		
    	else if(e.getKeyCode()==KeyEvent.VK_UP)
    	{
    		changeImage(2);
	
    		boolean brak_kolizji=true;
    		for(int i=0;i<fields.size();i++)
    		{
    			if(gracz.gornaKolizja(fields.get(i))==true)
    			{
    				gracz.y=gracz.y;
    				brak_kolizji=false;
    			}
    		}
    		if(brak_kolizji)
    			gracz.y-=25;

    	}
    	else if (e.getKeyCode()==KeyEvent.VK_DOWN)
    	{
    		changeImage(1);
    		boolean brak_kolizji=true;
    		for(int i=0;i<fields.size();i++)
    		{
    			if(gracz.dolnaKolizja(fields.get(i))==true)
    			{
    				gracz.y=gracz.y;
    				brak_kolizji=false;
    			}
    		}
    		if(brak_kolizji)
    			gracz.y+=25;

    	}
    	else if (e.getKeyCode()==KeyEvent.VK_SPACE)
    	{
    		numberOfBombs++;
    		Bomb newBomb=new Bomb(this);
    		newBomb.initPosition(gracz.getX(), gracz.getY());
    		
    		if (bombs.size()==0){
    			bomb=true;
    			numberOfFlames++;
    			for(int i=0;i<5;i++)
        		{
        		flames.add(new Flame(this));
        		}
        		flames.get(5*(numberOfFlames-1)).initPosition(gracz.getX()-50, gracz.getY());
        		flames.get(5*(numberOfFlames-1)+1).initPosition(gracz.getX()+50, gracz.getY());
        		flames.get(5*(numberOfFlames-1)+2).initPosition(gracz.getX(),gracz.getY()+50);
        		flames.get(5*(numberOfFlames-1)+3).initPosition(gracz.getX(), gracz.getY()-50);
        		flames.get(5*(numberOfFlames-1)+4).initPosition(gracz.getX(), gracz.getY());    				
        		bombs.add(newBomb);
    			fields.addAll(bombs);
    			System.out.println("nowa bomba");
				bombs.get(0).elo(this);
				
    		}	
    		else{	
    			if((Math.abs(gracz.getX()-bombs.get(bombs.size()-1).getX())<50) && (Math.abs(gracz.getY()-bombs.get(bombs.size()-1).getY())<50))
    			{
    				numberOfBombs--;
    			}
    			else{
    				bomb=true;
    				numberOfFlames++;
    				bombs.add(newBomb);
    				fields.add(bombs.get(bombs.size()-1));
    				for(int i=0;i<5;i++)
            		{
            		flames.add(new Flame(this));
            		}
            		flames.get(5*(numberOfFlames-1)).initPosition(gracz.getX()-50, gracz.getY());
            		flames.get(5*(numberOfFlames-1)+1).initPosition(gracz.getX()+50, gracz.getY());
            		flames.get(5*(numberOfFlames-1)+2).initPosition(gracz.getX(),gracz.getY()+50);
            		flames.get(5*(numberOfFlames-1)+3).initPosition(gracz.getX(), gracz.getY()-50);
            		flames.get(5*(numberOfFlames-1)+4).initPosition(gracz.getX(), gracz.getY());
    				bombs.get(0).elo(this);
    				
    			}
    		}
    	}
    }
 
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    public void createMap()
    {	
    	int w=0;
    	int c=0;
    	int cr=0;
	
    	walls = new ArrayList<Wall>();
    	chests = new ArrayList<Chest>();
    	bombs = new ArrayList<Bomb>();
    	flames= new ArrayList<Flame>();
    	fields=new ArrayList<Field>();
    	creeps = new ArrayList<Creep>();
    	for(int k=0;k<11;k++)
    	{
    	
    		for (int i=0;i<11;i++)
    		{
    			if(Character.getNumericValue(Properties.mapa[k].charAt(i))==1)
    			{
    				walls.add(new Wall());
    				walls.get(w).initPosition(50*i,50*k);
    				w++;
    			}
    			if(Character.getNumericValue(Properties.mapa[k].charAt(i))==2)
    			{
    				chests.add(new Chest());
    				chests.get(c).initPosition(50*i,50*k);
    				c++;
    			}
    			if(Character.getNumericValue(Properties.mapa[k].charAt(i))==3)
    			{
    				creeps.add(new Creep(this));
    				creeps.get(cr).initPosition(50*i,50*k);
    				cr++;
    			}
    		}
    	}
    	fields.addAll(walls);
    	fields.addAll(chests);
    	fields.add(gracz);
    	
    }
    

	}
	