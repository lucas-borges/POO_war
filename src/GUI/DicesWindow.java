package GUI;

import java.awt.event.*;
import java.awt.*;
import java.util.Observable;
import java.util.Arrays;

import etc.*;

import javax.swing.*;

public class DicesWindow extends Observable implements ActionListener {
	
	private JFrame topLevelFrame;
	final int height = 300;
	final int width = 500;
	private JLabel AttackDices [] = {new JLabel("dado1"),new JLabel("dado2"),new JLabel("dado3")};
	private JLabel DefenseDices []= {new JLabel("dado1"),new JLabel("dado2"),new JLabel("dado3")};
	private JLabel ResultAttack = new JLabel("Ataque perdeu:");
	private JLabel ResultDefense = new JLabel("Defesa perdeu:");
	private int nAttackDices=3, nDefenseDices=1;
	private int result[];
	boolean clicked;// = false;
	private JButton rollAttackDicesBut;	
	private JButton rollDefenseDicesBut;
	private Dices diceAttack = new Dices();
	private int numDicesAttack [];
	private Dices diceDefense = new Dices();
	private int numDicesDefense [];
	
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
		GridBagConstraints gbc = new GridBagConstraints();
		Container c;
		
		c = this.topLevelFrame.getContentPane();
		c.setLayout(new GridBagLayout());
		
		rollAttackDicesBut.setActionCommand("rollAttack");
		rollAttackDicesBut.addActionListener(this);
		rollDefenseDicesBut.setActionCommand("rollDefense");
		rollDefenseDicesBut.addActionListener(this);
		
		
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
		
		gbc.gridx=0;
		gbc.gridy=2;
		c.add(ResultAttack, gbc);	
		
		gbc.gridx=0;
		gbc.gridy=3;
		c.add(ResultDefense, gbc);
		
		this.topLevelFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	
	public void setNumDices (int nAttack, int nDefense)
	{
		nAttackDices=nAttack;
		nDefenseDices=nDefense;
	}
	public int[] getAttackDices()
	{
		return numDicesAttack;
	}
	
	public int[] getDefenseDices()
	{
		return numDicesDefense;
	}
	public void setResult(int[] result)
	{
		System.out.println("Entrou set");
		this.result=result;
		
		ResultAttack.setText("Ataque perdeu:" + result[0] );
		ResultDefense.setText("Defesa perdeu:" + result[1] );
	}
	public int[] getResult(){
		return result;
	}
	
		public void actionPerformed(ActionEvent e){
			
			String s=e.getActionCommand();
			
			if(s.equals("rollAttack"))
			{
				numDicesAttack= diceAttack.lancar_dados(nAttackDices);
				Arrays.sort(numDicesAttack);
				for(int i=0;i<numDicesAttack.length/2;i++) {
				     // swap the elements
				     int temp = numDicesAttack[i];
				     numDicesAttack[i] = numDicesAttack[numDicesAttack.length-(i+1)];
				     numDicesAttack[numDicesAttack.length-(i+1)] = temp;
				}
			
				rollAttackDicesBut.setEnabled(false);
				rollDefenseDicesBut.setEnabled(true);
			
				for(int i=0;i<nAttackDices;i++)
				{
					AttackDices[i].setIcon(new ImageIcon("Dados/dado_ataque_"+numDicesAttack[i]+".png"));		
				}
			}
			else if(s.equals("rollDefense"))
			{
				numDicesDefense = diceDefense.lancar_dados(nDefenseDices);
				Arrays.sort(numDicesDefense);
				for(int i=0;i<numDicesDefense.length/2;i++) {
				     // swap the elements
				     int temp = numDicesDefense[i];
				     numDicesDefense[i] = numDicesDefense[numDicesDefense.length-(i+1)];
				     numDicesDefense[numDicesDefense.length-(i+1)] = temp;
				}
				
				rollDefenseDicesBut.setEnabled(false);
				
				for(int i=0;i<nDefenseDices;i++)
				{
					DefenseDices[i].setIcon(new ImageIcon("Dados/dado_defesa_"+numDicesDefense[i]+".png"));		
				}
				
				setChanged();
				notifyObservers(new String ("DadosRolados"));
				
				
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
