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
	//private JLabel textTropas;
	private ArrayList<String> nString;
	private JComboBox<String> FronteirasBox;
	//private JComboBox<String> nTropasBox;
	private JButton attackBut;
	private Territorio territorioAlvo;
	
	public AttackWindow (Territorio t,Color currentColor){
		System.out.println(t.getNome().getNome());
		territorioAlvo=t;
		this.nString=new ArrayList<String>();
		this.topLevelFrame = new JFrame("Atacar Fronteiras");
		this.textFronteiras = new JLabel("Atacar com:");
		//this.textTropas = new JLabel("Quantidade de tropas para atacar:");
		for(Territorio f:t.getLstFronteiras()){
			System.out.println("Fronteira:"+f.getNome().getNome());
			if(f.getOwnerColor()==currentColor&&f.getNTropas()>1){
				this.nString.add(f.getNome().getNome());
			}
			
		}/*
		String []nTropas=new String[t.getNTropas()-1];
		for(int i=1;i<t.getNTropas()&&i<4;i++){
			nTropas[i-1]=String.valueOf(i);
			System.out.println(nTropas[i-1]);
		}*/
		String[] arrayString=new String[1];
		arrayString=nString.toArray(arrayString);
		this.FronteirasBox = new JComboBox<String>(arrayString);		
		//this.nTropasBox = new JComboBox<String>(nTropas);
		this.attackBut = new JButton("Atacar");
	}
	
	public void createGUI(){
		System.out.println("Criou GUI da attack window");
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
		
		/*gbc.gridx=0;
		gbc.gridy=1;
		gbc.insets.set(10,10,10,10);
		c.add(textTropas, gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.ipadx=25;
		c.add(nTropasBox,gbc);
		*/
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.ipadx=0;
		gbc.gridwidth=2;
		c.add(attackBut,gbc);
		attackBut.addActionListener(this);//new StartGameAction());

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
