package GUI;


import javax.swing.*;

import com.sun.media.sound.ModelAbstractOscillator;

import java.awt.*;

public class MainWindow  {
	private JFrame topLevelFrame;
	public final int MAP_WIDTH=1024;
	public final int MAP_HEIGHT=768;
	JPanel bg_panel;
	TopMenuPanel top_menu_panel;
	BottomMenuPanel bot_menu_panel;
	
	public MainWindow(){
		this.topLevelFrame = new JFrame ("WAR");
		this.bg_panel = new MapPanel();
		top_menu_panel = new TopMenuPanel();
		bot_menu_panel = new BottomMenuPanel();
	}
	public void createGUI(){
		Container c = this.topLevelFrame.getContentPane();
		
		bg_panel.setPreferredSize(new Dimension(MAP_WIDTH,MAP_HEIGHT));
		c.add(bg_panel, BorderLayout.WEST);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(top_menu_panel.getGUI(),BorderLayout.NORTH);
		p.add(bot_menu_panel.getGUI(),BorderLayout.SOUTH);
		c.add(p,BorderLayout.EAST);
		
		this.topLevelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	
	/*public MainWindow(String title){
		super(title);
		Container c=getContentPane();
		//Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		/* Map panel 
		bg_panel.setPreferredSize(new Dimension(MAP_WIDTH,MAP_HEIGHT));
		c.add(bg_panel, BorderLayout.WEST);
		
		
		/* Menu Panel
		menu_panel.setPreferredSize(new Dimension(400,768/2));
		c.add(menu_panel,BorderLayout.EAST);
		
		/* fit to panels and determine location
		pack();
		//setLocation(new Point((screenSize.width-getWidth())/2,(screenSize.height-getHeight())/2));
		setLocationRelativeTo(null);
	}*/
}
