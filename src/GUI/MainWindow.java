package GUI;


import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
	public final int WIDTH_DEFAULT=1200;
	public final int HEIGHT_DEFAULT=800;
	JPanel bg_panel=new MapPanel();
	
	public MainWindow(String title){
		super(title);
		
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		setSize(WIDTH_DEFAULT,HEIGHT_DEFAULT);
		setLocation(new Point((screenSize.width-WIDTH_DEFAULT)/2,(screenSize.height-HEIGHT_DEFAULT)/2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(bg_panel);
	}
}
