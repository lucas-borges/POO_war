package GUI;

import javax.swing.*;

public class TopMenuPanel {

	private TopMenuPanel(){
		
	}
	
	static public JPanel getGUI(){
		JPanel p=new JPanel();
		
		JButton newGameBut = new JButton("Novo Jogo");
		p.add(newGameBut);
		return p;
	}
}
