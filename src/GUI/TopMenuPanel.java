package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TopMenuPanel {

	private JButton newGameBut;
	
	
	public TopMenuPanel(){
		this.newGameBut=new JButton("Novo Jogo");
	}
	
	public JPanel getGUI(){
		JPanel p=new JPanel();
		
		
		//Listen
		newGameBut.addActionListener(new NewGameAction());		
		
		//Add components
		p.add(newGameBut);
		
		
		return p;
	}
	
	/*
	public void actionPerformed(ActionEvent e){
		if("newGame".equals(e.getActionCommand())){
			JOptionPane.showMessageDialog(null,"novo jogo criado");
		}
	}*/
	
	private class NewGameAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,"novo jogo criado");
		}
	}
	/*
	private static ActionListener newGameListener(){
		ActionListener x=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,"novo jogo criado");
			}
		};
		return x;
	}*/
}
