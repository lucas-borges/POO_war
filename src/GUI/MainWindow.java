package GUI;


import javax.swing.*;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import controller.*;

public class MainWindow extends Observable{
	private JFrame topLevelFrame;
	public final int MAP_WIDTH=1024;
	public final int MAP_HEIGHT=768;
	JPanel bg_panel;
	TopMenuPanel top_menu_panel;
	CenterMenuPanel center_menu_panel;
	BottomMenuPanel bot_menu_panel;
	//Mapa mapa;
	MapClickRedirect clickRedirect;
	
	public MainWindow(){
		this.topLevelFrame = new JFrame ("WAR");
		//mapa=new Mapa();
		clickRedirect=new MapClickRedirect();
		this.bg_panel = new MapPanel(/*mapa*/clickRedirect);
		top_menu_panel = new TopMenuPanel();
		center_menu_panel = new CenterMenuPanel();
		bot_menu_panel = new BottomMenuPanel();
		
		//this.bg_panel.addRedirect(clickRedirect);
	}
	public void createGUI(){
		Container c = this.topLevelFrame.getContentPane();
		
		bg_panel.setPreferredSize(new Dimension(MAP_WIDTH,MAP_HEIGHT));
		c.add(bg_panel, BorderLayout.WEST);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(top_menu_panel.getGUI(),BorderLayout.NORTH);
		p.add(center_menu_panel.getGUI(),BorderLayout.CENTER);
		p.add(bot_menu_panel.getGUI(),BorderLayout.SOUTH);
		c.add(p,BorderLayout.EAST);
		
		this.topLevelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	public void addObserver(Observer o){
		super.addObserver(o);
		top_menu_panel.addObserver(o);
		bot_menu_panel.addObserver(o);
		this.clickRedirect.addObserver(o);
	}
	public void setColorPanel(int n,Color[] order){
		top_menu_panel.setColorPanel(n,order);
	}
	public void repaint(){
		topLevelFrame.repaint();
		System.out.println("gameWin repaint");
		topLevelFrame.pack();
	}
	public void nextTurn(){
		top_menu_panel.nextTurn();
	}
	public void displayT(String t){
		center_menu_panel.setLabel(t);
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
