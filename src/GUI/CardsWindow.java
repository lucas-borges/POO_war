package GUI;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardsWindow extends Observable
						implements ActionListener{
	private JFrame topLevelFrame;
	
	private JButton But_close;
	private JLabel Lab_vet[] = {new JLabel(),new JLabel(), new JLabel(), new JLabel(), new JLabel()};
	
	
	public CardsWindow (){
		topLevelFrame = new JFrame("Cartas");
		
		//Lab_vet = new JLabel[5];
		
		/*for(JLabel l:Lab_vet){
			l=new JLabel();
		}*/
		
		/*for(int i=0;i<5;i++){
			Lab_vet[i] = new JLabel("Carta"+i);
			Lab_vet[i].setVisible(true);
		}*/
		
		But_close = new JButton("OK");
		But_close.setActionCommand("closeWindow");
		But_close.addActionListener(this);
	}
	
	public void createGUI(){
		Container c = this.topLevelFrame.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int j=0;
		for (JLabel l:Lab_vet){
			gbc.gridx=j++;
			gbc.gridy=0;
			gbc.insets.set(5,5,5,5);
			c.add(l, gbc);
		}
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		c.add(But_close, gbc);
		
		this.topLevelFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	
	public void setCards (String s[]){
		int i=0;
		System.out.println(s.length);
		for(String path:s){
			Icon ic=new ImageIcon(path);
			if(Lab_vet[i]==null){
				System.out.println("ee nullllll");
			}
			Lab_vet[i].setIcon(ic);
			Lab_vet[i].setVisible(true);
			
			i++;
		}
		
		this.topLevelFrame.pack();
	}
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		
		setChanged();
		
		if(s.equals("closeWindow")){
			topLevelFrame.dispose();
			notifyObservers(new String("StartWindow_startGame"));
		}
	}
}
