import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 */

/**
 * @author i331673
 *
 */
public class HelicopterFrame extends JFrame{
	
	public HelicopterFrame() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		HelicopterPanel panel = new HelicopterPanel();
		c.add(panel, BorderLayout.CENTER);
		
	}
	
	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		HelicopterFrame frame = new HelicopterFrame();
		
		frame.setSize(800,600);
		frame.setTitle("Helicopter");
		
		//user cannot resize the game window
		frame.setResizable(false);
		
		URL url = new URL("file:///C:/Users/i331673/MEB_WS/Copter/src/helicopter.gif");
		Icon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon);

        JFrame f = new JFrame("Animation");
        f.getContentPane().add(label);
		
		//exit program when game window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*adds menu option*/
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Game Settings");
		menuBar.add(menu);
		
		JMenuItem item = new JMenuItem("Exit");
		item.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		menu.add(item);
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}

}
