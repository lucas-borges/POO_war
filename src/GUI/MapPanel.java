package GUI;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class MapPanel extends JPanel {
	Image bg_img;
	public MapPanel (){
		try{
			bg_img=ImageIO.read(new File("war_tabuleiro_com_nomes.png"));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg_img,0,0,1024,768,0,0,2133,1600,null);
	}
}
