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

public class MovementWindow extends Observable implements ActionListener{
	
	private JFrame topLevelFrame;
	private JLabel textFronteiras;
	private JLabel textTropas;
	private ArrayList<String> nString;
	private JComboBox<String> FronteirasBox;
	private JComboBox<String> nTropasBox;
	private JButton moveBut;
	private Territorio territorioSource;
	
	public MovementWindow (Territorio t){
		System.out.println(t.getNome().getNome());
		territorioSource=t;
		this.nString=new ArrayList<String>();
		this.topLevelFrame = new JFrame("Mover Tropas");
		this.textFronteiras = new JLabel("Fronteira de destino:");
		this.textTropas = new JLabel("Quantidade de tropas a mover:");
		for(Territorio f:t.getLstFronteiras()){
			System.out.println("Fronteira:"+f.getNome().getNome());
			if(t.getOwnerColor()==f.getOwnerColor()){
				this.nString.add(f.getNome().getNome());
			}
			
		}
		String []nTropas=new String[t.getNTropas()-1];
		for(int i=1;i<t.getNTropas();i++){
			nTropas[i-1]=String.valueOf(i);
			System.out.println(nTropas[i-1]);
		}
		String[] arrayString=new String[1];
		arrayString=nString.toArray(arrayString);
		this.FronteirasBox = new JComboBox<String>(arrayString);		
		this.nTropasBox = new JComboBox<String>(nTropas);
		this.moveBut = new JButton("Mover");
	}
	
	public void createGUI(){
		System.out.println("Criou GUI da movement window");
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
		gbc.insets.set(10,10,10,10);
		c.add(textTropas, gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.ipadx=25;
		c.add(nTropasBox,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.ipadx=0;
		gbc.gridwidth=2;
		c.add(moveBut,gbc);
		moveBut.addActionListener(this);//new StartGameAction());

		this.topLevelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		topLevelFrame.dispose();
		//int i =	Integer.parseInt((String)nPlayerBox.getSelectedItem());
		//JOptionPane.showMessageDialog(null,"Que come�e o jogo! ("+i+")");
		setChanged();
		notifyObservers(new String("moveTropas"));
	}
		
	public int getNTropas(){		
		return 1+nTropasBox.getSelectedIndex();
	}
	public Territorio getDestination(){
		String destino=(String)FronteirasBox.getSelectedItem();		
		return TerritorioDataBase.buscaTerritorio(enumTerritorio.toNomePais(destino));
	}
	public Territorio getSource(){
		return this.territorioSource;
	}

}
