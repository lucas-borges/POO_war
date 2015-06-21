package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SideMenuPanel extends Observable
							implements ActionListener {

	private JButton newGameBut;
	private ColorPanel orderPanel;
	private JButton nextTurnBut;
	private JPanel p;
	
	private JLabel territorioL;
	private JLabel corL;
	private JLabel nTropas;
	private JLabel tropasDist;
	private int nTropasDist;
	private JButton alocarTer;
	
	private DicesWindow diceWindow;
	private JButton rollDicesBut;

	public SideMenuPanel(){
		this.newGameBut=new JButton("Novo Jogo");
		newGameBut.setActionCommand("newGame");
		newGameBut.addActionListener(this);
		
		this.orderPanel=new ColorPanel(6,new Color[]{Color.black,Color.black,Color.black,Color.black,Color.black,Color.black});//3,new Color[]{Color.black,Color.blue,Color.red});
		
		this.nextTurnBut=new JButton("Prox Turno");
		nextTurnBut.setActionCommand("nextTurn");
		nextTurnBut.addActionListener(this);
		
		territorioL=new JLabel("Clique num territorio");
		corL=new JLabel();
		nTropas=new JLabel();
		tropasDist=new JLabel("Voce tem "+nTropasDist+" para distribuir");
		alocarTer = new JButton("Alocar Territorios");
		
		this.diceWindow = new DicesWindow();
		this.rollDicesBut = new JButton("Rolar Dados");
		rollDicesBut.setActionCommand("rollDice");
		rollDicesBut.addActionListener(this);
	}

	public JPanel getGUI(){
		p=new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		//Add components
		gbc.gridx=0;
		gbc.gridy=0;
		p.add(newGameBut,gbc);

		gbc.gridx=1;
		gbc.gridy=0;
		p.add(nextTurnBut,gbc);

		gbc.gridx=0;
		gbc.gridy=1;	
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		p.add(orderPanel,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		p.add(territorioL,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		p.add(corL,gbc);
		
		gbc.gridx=1;
		gbc.gridy=3;
		p.add(nTropas,gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;
		p.add(tropasDist,gbc);
		
		gbc.gridx=0;
		gbc.gridy=5;
		p.add(alocarTer,gbc);
		
		gbc.gridx=0;
		gbc.gridy=6;
		p.add(rollDicesBut,gbc);

		return p;
	}


	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("newGame")){
			JOptionPane.showMessageDialog(null,"nao implementado");
		}
		else if(s.equals("nextTurn")){
			setChanged();
			notifyObservers("nextTurn");
		}
		if(s.equals("rollDice")){
			setChanged();
			notifyObservers(new String ("RollDices"));
		}
	}

	public void setColorPanel(int n,Color[] order){
		orderPanel.n=n;
		orderPanel.colors=order;
		orderPanel.updateSize();
	}
	public void nextTurn(){
		orderPanel.nextTurn();
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
	public void createGUIDices()
	{
		diceWindow.createGUI();
        System.out.println("You clicked the button");
	}
	public void addObserver(Observer o)
	{
		super.addObserver(o);
		diceWindow.addObserver(o);
	}
	
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
					g.drawRect(i*RECT_WIDTH+RECT_PADD*(2*i+1), RECT_OFFS, RECT_WIDTH+2*RECT_PADD, RECT_HEIGHT+2*RECT_PADD);
				}
			}
		}
	}
}