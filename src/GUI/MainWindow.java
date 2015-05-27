package GUI;


import javax.swing.*;

import com.sun.media.sound.ModelAbstractOscillator;

import java.awt.*;

public class MainWindow extends JFrame {
	public final int MAP_WIDTH=1024;
	public final int MAP_HEIGHT=768;
	JPanel bg_panel=new MapPanel();
	JPanel menu_panel = MenuPanel.getGUI();
	
	public MainWindow(String title){
		super(title);
		Container c=getContentPane();
		//Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		/* Map panel */
		bg_panel.setPreferredSize(new Dimension(MAP_WIDTH,MAP_HEIGHT));
		c.add(bg_panel, BorderLayout.WEST);
		
		
		/* Menu Panel*/ 
		menu_panel.setPreferredSize(new Dimension(400,768/2));
		c.add(menu_panel,BorderLayout.EAST);
		
		/* fit to panels and determine location */
		pack();
		//setLocation(new Point((screenSize.width-getWidth())/2,(screenSize.height-getHeight())/2));
		setLocationRelativeTo(null);
	}
}
