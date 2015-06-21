package GUI;

import java.awt.event.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class BottomMenuPanel extends Observable 
								implements ActionListener{
	
	DicesWindow diceWindow;
	JButton rollDicesBut;
	private JPanel p;
	
	public BottomMenuPanel(){
		this.diceWindow = new DicesWindow();
		this.rollDicesBut = new JButton("Rolar Dados");
	}
	
	public JPanel getGUI(){
		p=new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		rollDicesBut.addActionListener(this);
		
		gbc.gridx=0;
		gbc.gridy=0;
		p.add(rollDicesBut,gbc);
		
		return p;
	}
	
		public void actionPerformed(ActionEvent e){
			//Execute when button is pressed
			setChanged();
			notifyObservers(new String ("RollDices"));
        	
		}
		public void createGUIDices()
		{
			diceWindow.createGUI();
            System.out.println("You clicked the button");
		}
		public void addObserver(Observer o)
		{
			super.addObserver(o);
			diceWindow.addObserver(o);
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
