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
	
	SideMenuPanel side_menu_panel;
	MapClickRedirect clickRedirect;
	
	public MainWindow(){
		this.topLevelFrame = new JFrame ("WAR");
		
		clickRedirect=new MapClickRedirect();
		this.bg_panel = new MapPanel(clickRedirect);
		
		side_menu_panel = new SideMenuPanel();
	}
	public void createGUI(){
		Container c = this.topLevelFrame.getContentPane();
		
		bg_panel.setPreferredSize(new Dimension(MAP_WIDTH,MAP_HEIGHT));
		c.add(bg_panel, BorderLayout.WEST);		
		c.add(side_menu_panel.getGUI(),BorderLayout.EAST);
		
		this.topLevelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	public void addObserver(Observer o){
		super.addObserver(o);
		side_menu_panel.addObserver(o);
		this.clickRedirect.addObserver(o);
	}
	public void setColorPanel(int n,Color[] order){
		side_menu_panel.setColorPanel(n,order);
	}
	public void repaint(){
		topLevelFrame.repaint();
		System.out.println("gameWin repaint");
		topLevelFrame.pack();
	}
	public void nextTurn(){
		side_menu_panel.nextTurn();
	}
	public void displayT(String t, Color cor, int nTropas){
		side_menu_panel.setLabelTerritorio(t,cor,nTropas);
	}
	public void enableAlocar(boolean b){
		side_menu_panel.enableAlocar(b);
	}
	public void enableMover(boolean b){
		side_menu_panel.enableMover(b);
	}
	public void enableAtacar(boolean b){
		side_menu_panel.enableAtacar(b);
	}
	public void setTropasDist(int n){
		side_menu_panel.setTropasDist(n);
	}
	public void enableTerminarAtacar(boolean b){
		side_menu_panel.enableTerminarAtacar(b);
	}
}
