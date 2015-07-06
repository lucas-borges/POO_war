package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.*;

import Game.TerritorioDataBase;

import controller.Territorio;
import etc.enumTerritorio;
import etc.enumTerritorio.nomePais;

public class AttackWindow extends Observable implements ActionListener{
	
	private JFrame topLevelFrame;
	private JLabel textFronteiras;
	private ArrayList<String> nString;
	private JComboBox<String> FronteirasBox;
	private JButton attackBut;
	private Territorio territorioAlvo;
	
	public AttackWindow (Territorio t,Color currentColor){
		territorioAlvo=t;
		this.nString=new ArrayList<String>();
		this.topLevelFrame = new JFrame("Atacar Fronteiras");
		this.textFronteiras = new JLabel("Atacar com:");
		for(Territorio f:t.getLstFronteiras()){
			if(f.getOwnerColor()==currentColor&&f.getNTropas()>1){
				this.nString.add(f.getNome().getNome());
			}	
		}
		String[] arrayString=new String[1];
		arrayString=nString.toArray(arrayString);
		this.FronteirasBox = new JComboBox<String>(arrayString);		
		this.attackBut = new JButton("Atacar");
		attackBut.addActionListener(this);
	}
	
	public void createGUI(){
		Container c = this.topLevelFrame.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets.set(10,10,10,10);
		c.add(textFronteiras, gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.ipadx=25;
		c.add(FronteirasBox,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.ipadx=0;
		gbc.gridwidth=2;
		c.add(attackBut,gbc);

		this.topLevelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		topLevelFrame.dispose();
		
		setChanged();
		notifyObservers(new String("AttackWindow_atacarTerritorio"));
	}
		

	public Territorio getSource(){
		String destino=(String)FronteirasBox.getSelectedItem();		
		return TerritorioDataBase.buscaTerritorio(enumTerritorio.toNomePais(destino));
	}
	public Territorio getTarget(){
		return this.territorioAlvo;
	}

}
