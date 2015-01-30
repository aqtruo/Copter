import java.awt.Graphics;
import java.awt.Image;

/**
 * 
 */

/**
 * @author i331673
 *
 */
public class Helicopter {

		private double xPos, yPos, heliWidth, heliHeight;
		private Image img;
		private double add;
		
		
		public Helicopter(double xPos, double yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
			
			img = HelicopterPanel.loadImageFile("helicopter.gif");
			
			heliWidth = img.getWidth(null);
			heliHeight = img.getHeight(null);
		}

		public void helicopterUp() {
			add+=1.75;
			yPos=yPos-add;		
		}
		public void helicopterDown() {
			add-=.95;
			yPos=yPos-add;
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
		 * @return the heliWidth
		 */
		public double getHeliWidth() {
			return heliWidth;
		}

		/**
		 * @param heliWidth the heliWidth to set
		 */
		public void setHeliWidth(double heliWidth) {
			this.heliWidth = heliWidth;
		}

		/**
		 * @return the heliHeight
		 */
		public double getHeliHeight() {
			return heliHeight;
		}

		/**
		 * @param heliHeight the heliHeight to set
		 */
		public void setHeliHeight(double heliHeight) {
			this.heliHeight = heliHeight;
		}
		
		public void paint(Graphics g) {
			g.drawImage(img, (int)xPos, (int)yPos, null);
		}
		
}
