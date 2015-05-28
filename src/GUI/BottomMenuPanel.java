package GUI;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class BottomMenuPanel {
	
	DicesWindow diceWindow;
	JButton rollDicesBut;
	
	public BottomMenuPanel(){
		this.diceWindow = new DicesWindow();
		this.rollDicesBut = new JButton("Rolar Dados");
	}
	
	public JPanel getGUI(){
		JPanel p=new JPanel();
		
		rollDicesBut.addActionListener(new RollDiceAction());
		
		p.add(rollDicesBut);
		
		return p;
	}
	
	private class RollDiceAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			//Execute when button is pressed
        	diceWindow.createGUI();
            System.out.println("You clicked the button");
		}
	}
	
	/*
private BottomMenuPanel(){
		
	}
	
	static public JPanel getGUI(){
		JPanel p=new JPanel();
		JFrame diceWindow = new DicesWindow("Resultado");
		
		JButton rollDicesBut = new JButton("Rolar Dados");
		rollDicesBut.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	diceWindow.setVisible(true);
                System.out.println("You clicked the button");
            }
        });
		p.add(rollDicesBut);
		return p;
	}
*/
}
