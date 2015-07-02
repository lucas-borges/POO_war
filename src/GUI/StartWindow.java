package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.*;


public class StartWindow extends Observable
						implements ActionListener{
	private JFrame topLevelFrame;
	private JLabel text;
	private final String[] nString={"3","4","5","6"};
	private JComboBox<String> nPlayerBox;
	private JButton startBut;
	
	public StartWindow (){
		this.topLevelFrame = new JFrame("Novo Jogo");
		this.text = new JLabel("Número de jogadores");
		this.nPlayerBox = new JComboBox<String>(nString);
		this.startBut = new JButton("Começar jogo");
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
		c.add(startBut,gbc);
		startBut.addActionListener(this);//new StartGameAction());

		this.topLevelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.topLevelFrame.setResizable(false);
		this.topLevelFrame.pack();
		this.topLevelFrame.setLocationRelativeTo(null);
		this.topLevelFrame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		topLevelFrame.dispose();
		//int i =	Integer.parseInt((String)nPlayerBox.getSelectedItem());
		//JOptionPane.showMessageDialog(null,"Que começe o jogo! ("+i+")");
		setChanged();
		notifyObservers(new String("StartWindow_startGame"));
	}
		
	public int getComboValue(){
		return Integer.parseInt((String)nPlayerBox.getSelectedItem());
	}
	
	
	
	/*public StartWindow(String title){
		super(title);
		setLayout(null);
		Container c=getContentPane();
		Dimension size;
		
		//Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Label 
		JLabel text=new JLabel("Número de jogadores: ");
		size=text.getPreferredSize();
		text.setBounds(xPadd/2,yPadd/2,size.width,size.height);
		updateSize(xPadd+text.getWidth(),yPadd);
		c.add(text);
		
		/* Combo Box 
		final String[] nPlayers={"3","4","5","6"};
		JComboBox<String> nPlayerBox = new JComboBox<String>(nPlayers);
		size=nPlayerBox.getPreferredSize();
		nPlayerBox.setBounds(10+text.getX()+text.getWidth(),yPadd/2,size.width,size.height);
		updateSize(nPlayerBox.getWidth()+10,nPlayerBox.getHeight());
		c.add(nPlayerBox);
		
		/* Button 
		JButton startBut = new JButton("Começar jogo!");
		size=startBut.getPreferredSize();
		startBut.setBounds((WIDTH-size.width)/2,HEIGHT,size.width,size.height);
		updateSize(0,startBut.getHeight());
		c.add(startBut);
		
		//WIDTH=nPlayerBox.getX()+nPlayerBox.getWidth()+xPadd;
		//HEIGHT=nPlayerBox.getHeight()+yPadd+30;
		updateSize(0,20);
		setResizable(false);
		setSize(WIDTH,HEIGHT+30);
		//setLocation(new Point((screenSize.width-WIDTH)/2,(screenSize.height-HEIGHT)/2));
		setLocationRelativeTo(null);
	}
	
	private void updateSize (int x, int y){
		WIDTH+=x;
		HEIGHT+=y;
	}*/

}
