import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author i331673
 *
 */
public class Obstacles {

	private double xPos, yPos, obsHeight, obsWidth;
	private Image img;
	private int speed;
	
	public static final int NUM_OBSTACLES = 20;
	
	public Obstacles(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		
		img = HelicopterPanel.loadImageFile("cowtower.png");
		
		obsWidth = img.getWidth(null);
		obsHeight = img.getHeight(null);
		
		speed = 2;
	}
	
	
	/**
	 * @return the xPos
	 */
	public double getxPos() {
		return xPos;
	}


	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}


	/**
	 * @return the yPos
	 */
	public double getyPos() {
		return yPos;
	}


	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}


	/**
	 * @return the obsHeight
	 */
	public double getObsHeight() {
		return obsHeight;
	}


	/**
	 * @param obsHeight the obsHeight to set
	 */
	public void setObsHeight(double obsHeight) {
		this.obsHeight = obsHeight;
	}


	/**
	 * @return the obsWidth
	 */
	public double getObsWidth() {
		return obsWidth;
	}


	/**
	 * @param obsWidth the obsWidth to set
	 */
	public void setObsWidth(double obsWidth) {
		this.obsWidth = obsWidth;
	}
	
	
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}


	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * moves obstacle image to the left
	 */
	public void move() {
		xPos-=speed;
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, (int)xPos, (int)yPos, null);
	}

}
