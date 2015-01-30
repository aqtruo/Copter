import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 */

/**
 * @author i331673
 *
 */
public class HelicopterPanel extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	private Image helicopterImage, backgroundImage, obstacleImage;
	private Helicopter helo;
	private Obstacles obs;
	private ArrayList<Obstacles> obsTop;
	private ArrayList<Obstacles> obsMiddle;
	private ArrayList<Obstacles> obsBottom;
	private Timer timer;
	private boolean mousePressed, mouseClicked, keyTyped;
	private static boolean paused = false;
	private static boolean isAlive = true; 
	private int currDistance;
	private int xPos, xPos2;
	
	public HelicopterPanel() {
		
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		timer = new Timer(50, this);
		
		helicopterImage = loadImageFile("helicopter.gif");
		backgroundImage = loadImageFile("background.png");
		obstacleImage = loadImageFile("cowtower.png");
		
		obsTop = new ArrayList<Obstacles>(5);
		obsMiddle = new ArrayList<Obstacles>(5);
		obsBottom = new ArrayList<Obstacles>(5);
		
		helo = new Helicopter(50,225);
		obs = new Obstacles(200, 200);
		
		for(int numObs = 0; numObs <= Obstacles.NUM_OBSTACLES; numObs++) {
			//TODO need to randomly generate obstacles locations
			
			obsTop.add(new Obstacles(200, 200));
			obsMiddle.add(new Obstacles(200, 200));
			obsBottom.add(new Obstacles(200, 200));
		}
		
		currDistance = 0;
		xPos = 0;
		xPos2 = xPos + backgroundImage.getWidth(null);
	}

	public static boolean gameStatus() {
		return isAlive;
	}
	public static Image loadImageFile(String path) {
		try {
			java.io.InputStream stream = Helicopter.class.getResourceAsStream(path);
			return javax.imageio.ImageIO.read(stream);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mouseClicked = true;
		
		/*if(paused) {
			paused = false;
		}*/
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
		
		if(!timer.isRunning()) {
			timer.start();
			isAlive = true;
			paused = false;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
		isAlive = true;
		paused = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
		paused = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		currDistance++;
		if((helo.getyPos() <= 0 || (helo.getyPos() + helo.getHeliHeight()) >= (getHeight() - 75)) && isAlive && !paused) {
			//display Game Over Screen
			isAlive = false;
			timer.stop();
			System.out.println("heli status: " + isAlive);
		}
		if(mousePressed == true)
			helo.helicopterUp();
		else
			helo.helicopterDown();
		repaint();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(backgroundImage, xPos, 0, null);
		g.drawImage(backgroundImage, xPos2, 0, null);
		
		//loops background image
		if(xPos == ((-1) * backgroundImage.getWidth(null))) {
			xPos = backgroundImage.getWidth(null);
		}
		if(xPos2 == ((-1) * backgroundImage.getWidth(null))) {
			xPos2 = backgroundImage.getWidth(null);
		}
		
		g.setColor(Color.cyan);
		g.fillRect(0, getHeight() - 75, getWidth(), getHeight());
		helo.paint(g);
		System.out.println("status: " + isAlive);
		obs.paint(g);
		obs.move();
		
		if(!paused && isAlive) {
			System.out.println("game not paused: " + paused);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
			g.setColor(Color.BLACK);
			g.drawString("SCORE: " + currDistance, 100, 500);
			g.drawString("Ammo: ", 400, 500);
			g.drawString("Shield: ", 500, 500);
		}
		else if(paused && isAlive) {
			System.out.println("game is paused: " + paused);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
			g.setColor(Color.BLACK);
			g.drawString("GAME PAUSED!", getWidth()/2, getHeight()/2);
			g.drawString("SCORE: " + currDistance, 100, 500);
			g.drawString("Ammo: ", 400, 500);
			g.drawString("Shield: ", 500, 500);
			timer.stop();
		}
		else {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
			g.setColor(Color.RED);
			g.drawString("GAME OVER!", getWidth()/3, getHeight()/2);
			g.drawString("Final Score: " + currDistance, getWidth()/3, (getHeight()/2) + 25);
			g.drawString("Ammo: ", 400, 500);
			g.drawString("Shield: ", 500, 500);
			timer.stop();
		}
		System.out.println("xPos: " + xPos);
		System.out.println("xPos2: " + xPos2);
		xPos-=2;
		xPos2-=2;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyTyped = true;
		
		if(e.getKeyChar() == 'p' && !paused) {
			System.out.println(e.getKeyChar());
			paused = true;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
