package GUI;
import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
	final String[] nPlayers={"3,4,5,6"};
	
	public StartPanel (){
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		JComboBox nPlayerList = new JComboBox(nPlayers);
	}
}
