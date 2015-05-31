package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

//import etc.Color;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;

import javax.swing.*;

public class TopMenuPanel {

	private JButton newGameBut;
	private ColorPanel orderPanel;
	
	public TopMenuPanel(){
		this.newGameBut=new JButton("Novo Jogo");
		newGameBut.addActionListener(new NewGameAction());
		this.orderPanel=new ColorPanel(3,new Color[]{Color.black,Color.blue,Color.red});
	}
	
	public JPanel getGUI(){
		JPanel p=new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Add components
		gbc.gridx=0;
		gbc.gridy=0;
		p.add(newGameBut,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;		
		p.add(orderPanel,gbc);
		
		
		return p;
	}
	
	
	private class NewGameAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,"novo jogo criado");
		}
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
			this.setPreferredSize(new Dimension(n*RECT_WIDTH+2*RECT_PADD*(n+1),RECT_HEIGHT+2*RECT_OFFS+2*RECT_PADD));
			this.colors=colors;
			this.current=2;
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
