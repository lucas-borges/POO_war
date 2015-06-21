package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class CenterMenuPanel {
	private JLabel territorioL;
	private JLabel corL;
	private JLabel nTropas;
	private JLabel tropasDist;
	private int nTropasDist;
	private JPanel p;
	private JButton alocarTer;
	
	public CenterMenuPanel (){
		territorioL=new JLabel("Clique num territorio");
		corL=new JLabel();
		nTropas=new JLabel();
		tropasDist=new JLabel("Voce tem"+nTropasDist+"para distribuir");
		alocarTer = new JButton("Alocar Territorios");
	}
	
	public JPanel getGUI(){
		p=new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		p.add(territorioL,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		p.add(corL,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		p.add(nTropas,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		p.add(tropasDist,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		p.add(alocarTer,gbc);
		
		return p;
	}
	
	public void setTropas(int nTropas){ 
	}
	
	public void setLabelTerritorio(String t, String cor, int n){
		territorioL.setText(t);
		corL.setText(cor);
		nTropas.setText(Integer.toString(n)+ " tropas");
	}
	public void setTropasDist (int n) {
		nTropasDist=n;
	}
}
