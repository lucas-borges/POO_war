package GUI;

import java.awt.event.*;
import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class DicesWindow extends JFrame {
	
	final int height = 300;
	final int width = 500;
	
	JLabel dices []= {new JLabel("dado1"),new JLabel("dado2"),new JLabel("dado3")};
	boolean clicked = false;
	String diceColor = "ataque";
	

	public DicesWindow(String title)
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
		
	}
	
	private void RollDices (String s)
	{
		int dice;
		Random dicesNumber = new Random();
		
		for(int i=0;i<3;i++)
		{
			dice = dicesNumber.nextInt(6) + 1;
			dices[i].setIcon(new ImageIcon("dado_" + s + "_"+dice+".png"));		
			//System.out.println(dice);
		}
	}
}
