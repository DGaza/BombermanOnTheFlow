package makieta;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelCompleteWindow extends JPanel implements ActionListener, KeyListener 
{
	JButton NextLevel=new JButton("Next level");
	JButton EndGame=new JButton("End game");
	
	/**
     * Zmienna przechowujaca obrazek tla.
     */
    Image levelCompleteImage = new ImageIcon("levelcomplete.png").getImage();
    
    public LevelCompleteWindow(int x)
    {
		setLayout(null);
		if(x!=3){
		add(NextLevel);
		NextLevel.setBounds(200, 400, 150, 50);
		
		NextLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.mainLayout.show(MainWindow.panels, "level"+x);
                MainWindow.levels.get(x-1).addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
   
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }); 
                
                MainWindow.levels.get(x-1).setFocusable(true);
                MainWindow.levels.get(x-1).requestFocusInWindow();
            }
        });
    }
		else {
			add(EndGame);
			EndGame.setBounds(Properties.NewGameButtonVerticalPosition, Properties.NewGameButtonHorizontalPosition, Properties.StartScreenButtonsWidth, Properties.StartScreenButtonsHeight);
			
			EndGame.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {	               
	            	System.exit(0);
	            }
	        });
	    }	
    }
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

    public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(levelCompleteImage,0,0,this.getWidth(), this.getHeight(), this);
    } 
	
}