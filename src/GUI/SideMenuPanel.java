package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
//import java.util.Observer;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SideMenuPanel extends Observable
							implements ActionListener {

	private JPanel p;
	private ColorPanel orderPanel;
	private int nTropasDist;
	
	private JLabel Lab_territorio;
	private JLabel Lab_cor;
	private JLabel Lab_nTropas;
	private JLabel Lab_tropasDist;
	private JLabel Lab_information;
	
	private JButton But_alocarTropas;
	private JButton But_terminarAtaque;
	private JButton But_nextTurn;
	private JButton But_showObj;
	private JButton But_showCards;
	private JButton But_atacar;
	private JButton But_mover;
	

	public SideMenuPanel(){
		
		this.orderPanel=new ColorPanel(6,new Color[]{Color.black,Color.black,Color.black,Color.black,Color.black,Color.black});//3,new Color[]{Color.black,Color.blue,Color.red});
		
		this.But_nextTurn=new JButton("Passar Turno");
		But_nextTurn.setActionCommand("nextTurn");
		But_nextTurn.addActionListener(this);
		But_nextTurn.setEnabled(false);
		
		Lab_territorio=new JLabel("Clique num territorio para ver informacoes");
		Lab_cor=new JLabel();
		Lab_nTropas=new JLabel();
		Lab_tropasDist=new JLabel("Voce tem "+nTropasDist+" tropas para distribuir");
		Lab_information = new JLabel();
		
		But_alocarTropas = new JButton("Alocar Tropas");
		But_alocarTropas.setActionCommand("alocarTropas");
		But_alocarTropas.addActionListener(this);
		But_alocarTropas.setEnabled(false);
		
		But_showObj = new JButton ("Ver Objetivos");
		But_showObj.setActionCommand("showObj");
		But_showObj.addActionListener(this);
		
		But_showCards = new JButton ("Ver Cartas");
		But_showCards.setActionCommand("showCards");
		But_showCards.addActionListener(this);

		But_atacar = new JButton("Atacar Territorio");
		But_atacar.setActionCommand("atacar");
		But_atacar.addActionListener(this);
		But_atacar.setEnabled(false);
		
		But_mover = new JButton("Mover Tropas");
		But_mover.setActionCommand("mover");
		But_mover.addActionListener(this);
		But_mover.setEnabled(false);
		
		But_terminarAtaque= new JButton("Terminar Ataque");
		But_terminarAtaque.setActionCommand("termAtaque");
		But_terminarAtaque.addActionListener(this);
		But_terminarAtaque.setEnabled(false);
	}

	public JPanel getGUI(){
		int row=0;
		p=new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		//Add components
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.insets=new Insets(0,10,0,0);
		p.add(But_showObj,gbc);
		
		gbc.gridx=1;
		gbc.gridy=row;
		p.add(But_showCards,gbc);
		
		row++;
		
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.gridwidth=2;
		gbc.insets=new Insets(5,0,5,0);
		p.add(orderPanel,gbc);
		
		row++;
		
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.gridwidth=2;
		p.add(Lab_territorio,gbc);
		
		row++;
		
		gbc.gridx=1;
		gbc.gridy=row;
		gbc.gridwidth=1;
		p.add(Lab_cor,gbc);
		
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.gridwidth=1;
		p.add(Lab_nTropas,gbc);
		
		row++;
		
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.gridwidth=2;
		p.add(Lab_tropasDist,gbc);
		
		row++;
		
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.gridwidth=2;
		p.add(But_alocarTropas,gbc);
		
		row++;
		
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.gridwidth=1;
		p.add(But_atacar,gbc);
		
		gbc.gridx=1;
		gbc.gridy=row;
		gbc.gridwidth=1;
		p.add(But_terminarAtaque,gbc);
		
		row++;
		
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.gridwidth=2;
		p.add(But_mover,gbc);		
		
		row++;
		
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.gridwidth=2;
		p.add(But_nextTurn,gbc);

		row++;
		
		gbc.gridx=0;
		gbc.gridy=row;
		gbc.gridwidth=2;
		p.add(Lab_information,gbc);
		
		row++;

		return p;
	}


	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();

		setChanged();
		
		if(s.equals("nextTurn")){
			notifyObservers("SideMenu_nextTurn");
		}
		else if(s.equals("alocarTropas")){
			notifyObservers(new String ("SideMenu_alocarTropas"));
		}
		else if(s.equals("atacar")){
			notifyObservers(new String ("SideMenu_atacar"));
		}
		else if(s.equals("mover")){
			notifyObservers(new String ("SideMenu_mover"));
		}
		else if(s.equals("termAtaque")){
			notifyObservers(new String ("SideMenu_termAtaque"));
		}
		else if(s.equals("showObj")){
			notifyObservers(new String ("SideMenu_showObj"));
		}
		else if(s.equals("showCards")){
			notifyObservers(new String ("SideMenu_showCards"));
		}
	}

	public void setColorPanel(int n,Color[] order){
		orderPanel.n=n;
		orderPanel.colors=order;
		orderPanel.updateSize();
	}
	public void nextTurn(){
		But_alocarTropas.setEnabled(false);
		orderPanel.nextTurn();
	}

	public void setTropas(int nTropas){ 
	}
	
	public void setLabelTerritorio(String t, Color cor, int n){
		Lab_territorio.setText(t);
		Lab_cor.setForeground(cor);
		Lab_cor.setText("   ***");
		Lab_nTropas.setText(Integer.toString(n)+ " tropas");
	}
	public void setInfText (String t){
		Lab_information.setText(t);
	}
	public int getTropasDist(){
		return nTropasDist;
	}
	public void setTropasDist (int n) {
		nTropasDist=n;
		Lab_tropasDist.setVisible(true);
		Lab_tropasDist.setText("Voce tem "+nTropasDist+" tropas para distribuir");
		if(nTropasDist==0){
			Lab_tropasDist.setVisible(false);
			But_alocarTropas.setEnabled(false);
		}
	}
	public void enableAlocar(boolean b){
		if(nTropasDist!=0)
			But_alocarTropas.setEnabled(b);
	}
	public void enableMover(boolean b){
		But_mover.setEnabled(b);
	}
	public void enableAtacar(boolean b){
		But_atacar.setEnabled(b);
	}
	public void enableTerminarAtacar(boolean b){
		But_terminarAtaque.setEnabled(b);
	}
	public void enableNextTurn (boolean b){
		But_nextTurn.setEnabled(b);
	}
	
//NESTED CLASSES	
	private class ColorPanel extends JPanel {
		public int n;
		public Color[] colors;
		public int current;

		private final int RECT_WIDTH=30;
		private final int RECT_HEIGHT=30;
		private final int RECT_PADD=5;
		private final int RECT_OFFS=10;

		public ColorPanel (int n, Color[] colors){
			this.n=n;
			//this.setPreferredSize(new Dimension(n*RECT_WIDTH+2*RECT_PADD*(n+1),RECT_HEIGHT+2*RECT_OFFS+2*RECT_PADD));
			this.updateSize();
			this.colors=colors;
			this.current=0;
		}

		public void updateSize(){
			this.setPreferredSize(new Dimension(n*RECT_WIDTH+2*RECT_PADD*(n+1),RECT_HEIGHT+2*RECT_OFFS+2*RECT_PADD));
			System.out.println("n jogad orderpanel " + n);
		}
		public void nextTurn(){
			if (current<n-1){
				current++;
			}
			else{
				current=0;
			}
		}

		public void paintComponent (Graphics g){
			int i;
			super.paintComponent(g);
			for(i=0;i<n;i++){
				g.setColor(colors[i]);
				g.fillRect(i*RECT_WIDTH+2*RECT_PADD*(i+1), RECT_OFFS+RECT_PADD, RECT_WIDTH , RECT_HEIGHT);
				if (current==i){
					g.setColor(Color.black);
					g.drawRect(i*RECT_WIDTH+RECT_PADD*(2*i+1), RECT_OFFS, RECT_WIDTH+2*RECT_PADD, RECT_HEIGHT+2*RECT_PADD);
				}
			}
		}
	}
}