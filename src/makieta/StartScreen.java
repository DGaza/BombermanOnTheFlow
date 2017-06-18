package makieta;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Klasa tworzaca okno startowe.
 */
public class StartScreen extends JPanel implements ActionListener, KeyListener
{
	
	JButton NewGame;
	JButton HighScores;
	JButton Exit;
	
    /**
     * Zmienna przechowujaca obrazek tla menu.
     */
    Image menuImage = new ImageIcon("menu.png").getImage();
	
	public StartScreen()
	{
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc;
		
		gbc = new GridBagConstraints();
        gbc.insets= new Insets(5,5,50,5);
        
        gbc.weighty=1;
        gbc.anchor=GridBagConstraints.SOUTH;
        
        NewGame = new JButton("New Game");
		NewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.mainLayout.show(MainWindow.panels, "level1");
                MainWindow.level1.addKeyListener(new KeyListener() {
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
                
                MainWindow.level1.setFocusable(true);
                MainWindow.level1.requestFocusInWindow();
            }
        });
		
		gbc.gridx=0;
        gbc.gridy=10;
        gbc.ipadx=10;
        gbc.ipady=10;

        NewGame.setForeground(Color.white);
        NewGame.setPreferredSize(new Dimension(150, 40));
        NewGame.setFont(new Font("Calibri", Font.PLAIN, 16));
        NewGame.setBackground(new Color(30,10,180));
        NewGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
        gbc.fill=GridBagConstraints.HORIZONTAL;

        add(NewGame,gbc);
        
        HighScores= new JButton("Najlepsze Wyniki");
        HighScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        HighScores.setForeground(Color.white);
        HighScores.setPreferredSize(new Dimension(150, 40));
        HighScores.setFont(new Font("Calibri", Font.PLAIN, 16));
        HighScores.setBackground(new Color(30,10,180));
        HighScores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        gbc.gridx=1;

        add(HighScores,gbc);
        
        Exit= new JButton("Wyjœcie");
        Exit.setPreferredSize(new Dimension(150, 40));
		Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	               
            	System.exit(0);
            }
        });
		
		Exit.setForeground(Color.white);
        Exit.setFont(new Font("Calibri", Font.PLAIN, 16));
        Exit.setBackground(new Color(30,10,180));
        Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
        gbc.gridx=2;

        add(Exit,gbc);
        setVisible(true);
	
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
	
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(menuImage,0,0,this.getWidth(), this.getHeight(), this);
    } 
	
}
