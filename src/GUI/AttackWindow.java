package GUI;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AttackWindow extends Observable
							implements ActionListener{
	private JFrame topLevelFrame;
	private JComboBox<String> territoriosAdj;
	private JLabel attWithL;
	private JLabel troopsNL;
	
	
	public AttackWindow (){
		this.topLevelFrame= new JFrame("Janela de Ataque");
		this.attWithL = new JLabel("Atacar com: ");
		this.troopsNL = new JLabel("Numero de tropas: ");
		this.territoriosAdj=new JComboBox<String>();		
	}
	
	public void createGUI(){
		Container c = this.topLevelFrame.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets.set(10,10,10,10);
		c.add(attWithL, gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		//gbc.insets.set(10,10,10,10);
		c.add(territoriosAdj, gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		c.add(troopsNL,gbc);
		
		this.topLevelFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
	}
	
	public void setVisible(){
		topLevelFrame.setVisible(true);
		topLevelFrame.getContentPane().removeAll();
		createGUI();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	public void setAdjVet(String[] s){
		this.territoriosAdj=new JComboBox<String>(s);
		
	}
	/*private void updateGUI(){
		Container c = this.topLevelFrame.getContentPane();
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=1;
		gbc.gridy=0;
		//gbc.insets.set(10,10,10,10);
		c.add(territoriosAdj, gbc);
	}*/
	
}
