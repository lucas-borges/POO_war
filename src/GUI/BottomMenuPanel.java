package GUI;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class BottomMenuPanel {
	
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

}
