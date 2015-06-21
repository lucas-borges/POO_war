package GUI;

import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import etc.*;

import javax.swing.*;

public class DicesWindow  {
	
	JFrame topLevelFrame;
	final int height = 300;
	final int width = 500;
	JLabel AttackDices [] = {new JLabel("dado1"),new JLabel("dado2"),new JLabel("dado3")};
	JLabel DefenseDices []= {new JLabel("dado1"),new JLabel("dado2"),new JLabel("dado3")};
	int nAttackDices=3, nDefenseDices=3;
	boolean clicked;// = false;
	JButton rollAttackDicesBut;	
	JButton rollDefenseDicesBut;
	
	
	public DicesWindow()
	{
		this.topLevelFrame = new JFrame ("Resultado");
		this.rollAttackDicesBut = new JButton("Rolar Dados Ataque");
		this.rollDefenseDicesBut = new JButton("Rolar Dados Defesa");
		this.clicked = false;
		rollDefenseDicesBut.setEnabled(false);
		//this.nAttackDices = 
		//this.nDefenseDices = 
	}
	
	public void createGUI()
	{
		Container c = this.topLevelFrame.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		rollAttackDicesBut.addActionListener(new RollAttackDicesAction() );
		rollDefenseDicesBut.addActionListener(new RollDefenseDicesAction() );
		
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.insets.set(10,10,10,10);
		c.add(rollAttackDicesBut, gbc);
		
		gbc.gridx=3;
		gbc.gridy=1;
		gbc.insets.set(10,10,10,10);
		c.add(rollDefenseDicesBut, gbc);
		
		for (int i=0; i< nAttackDices; i++)
		{
			gbc.gridx=i;
			gbc.gridy=0;
			AttackDices[i].setIcon((new ImageIcon("Dados/dado_ataque_1.png")));
			c.add(AttackDices[i], gbc);
		}
		
		for (int i=0; i< nDefenseDices; i++)
		{
			gbc.gridx=i;
			gbc.gridy=1;
			DefenseDices[i].setIcon((new ImageIcon("Dados/dado_defesa_1.png")));
			c.add(DefenseDices[i], gbc);
		}
		
		this.topLevelFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	
	private class RollAttackDicesAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			//Execute when button is pressed
			Dices dice = new Dices();
			int numDices [] = dice.lancar_dados(nAttackDices);
			
			rollAttackDicesBut.setEnabled(false);
			rollDefenseDicesBut.setEnabled(true);
			
			for(int i=0;i<nAttackDices;i++)
			{
				AttackDices[i].setIcon(new ImageIcon("Dados/dado_ataque_"+numDices[i]+".png"));		
			}
        	
		}
	}
	
	private class RollDefenseDicesAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			//Execute when button is pressed
			Dices dice = new Dices();
			int numDices [] = dice.lancar_dados(nDefenseDices);
			
			rollDefenseDicesBut.setEnabled(false);
			
			for(int i=0;i<nDefenseDices;i++)
			{
				DefenseDices[i].setIcon(new ImageIcon("Dados/dado_defesa_"+numDices[i]+".png"));		
			}
	
		}
	}
	
/*	public DicesWindow(String title)
	{
		super(title);
		
		JButton rollDicesBut = new JButton("Rolar Dados Defesa");
		rollDicesBut.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	if(clicked)
            		rollDicesBut.setText("terminou");//close window
            	else
            		rollDicesBut.setText("Ok");
            	clicked = true;
            	diceColor = "defesa";
            	
            	RollDices(diceColor);
            		
                //System.out.println("You clicked the button");
            }
        });
		
		
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(new Point((screenSize.width-width)/2,(screenSize.height-height)/2));
		setLayout(new GridLayout());
		setSize(width,height);
		
		if(!clicked)
			RollDices(diceColor);
		
		getContentPane().add(dices[0]);
		getContentPane().add(dices[1]);
		getContentPane().add(dices[2]);
		getContentPane().add(rollDicesBut);
		pack();
		
	}
	
	private void RollDices (String s)
	{
		int dice;
		Random dicesNumber = new Random();
		
		for(int i=0;i<3;i++)
		{
			dice = dicesNumber.nextInt(6) + 1;
			dices[i].setIcon(new ImageIcon("Dados/dado_" + s + "_"+dice+".png"));		
			//System.out.println(dice);
		}
	}
}*/
}
