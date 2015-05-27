package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TopMenuPanel implements ActionListener {

	private static JButton newGameBut;
	
	
	private TopMenuPanel(){
	}
	
	static public JPanel getGUI(){
		JPanel p=new JPanel();
		
		newGameBut = new JButton("Novo Jogo");
		newGameBut.setActionCommand("newGame");
		
		//Listen
		newGameBut.addActionListener(TopMenuPanel);		
		
		//Add components
		p.add(newGameBut);
		
		
		return p;
	}
	
	public void actionPerformed(ActionEvent e){
		if("newGame".equals(e.getActionCommand())){
			JOptionPane.showMessageDialog(null,"novo jogo criado");
		}
	}
	
}
