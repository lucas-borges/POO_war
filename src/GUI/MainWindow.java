package GUI;


import javax.swing.*;

public class MainWindow extends JFrame {
	public final int WIDTH_DEFAULT=1200;
	public final int HEIGHT_DEFAULT=800;
	JPanel bg_panel=new MapPanel();
	
	public MainWindow(){
		setSize(WIDTH_DEFAULT,HEIGHT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(bg_panel);
	}
}
