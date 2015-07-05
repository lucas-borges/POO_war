package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.*;

import static Game.GameController.DEV_MODE;

public class StartWindow extends Observable
						implements ActionListener{
	
	
	private JFrame topLevelFrame;
	private JLabel text;
	private final String[] nString={"3","4","5","6"};
	private JComboBox<String> nPlayerBox;
	private JButton But_start;
	
	//used for debug
	private JButton But_load;
	
	public StartWindow (){
		this.topLevelFrame = new JFrame("Novo Jogo");
		this.text = new JLabel("Número de jogadores");
		this.nPlayerBox = new JComboBox<String>(nString);
		
		But_start = new JButton("Começar jogo");
		But_start.setActionCommand("startGame");
		But_start.addActionListener(this);
		
		if(DEV_MODE){
			But_load = new JButton("Carregar estado");
			But_load.setActionCommand("loadGame");
			But_load.addActionListener(this);
		}
	}
	
	public void createGUI(){
		Container c = this.topLevelFrame.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets.set(10,10,10,10);
		c.add(text, gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.ipadx=25;
		c.add(nPlayerBox,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.ipadx=0;
		gbc.gridwidth=2;
		c.add(But_start,gbc);
		
		if(DEV_MODE){
			gbc.gridx=0;
			gbc.gridy=2;
			gbc.ipadx=0;
			gbc.gridwidth=2;
			c.add(But_load,gbc);
		}

		this.topLevelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		
		setChanged();
		
		if(s.equals("startGame")){
			topLevelFrame.dispose();
			notifyObservers(new String("StartWindow_startGame"));
		}
		else if (s.equals("loadGame")){
			notifyObservers(new String("StartWindow_loadGame"));
		}
	}
	public int getComboValue(){
		return Integer.parseInt((String)nPlayerBox.getSelectedItem());
	}
	public void close(){
		topLevelFrame.dispose();
	}

}
