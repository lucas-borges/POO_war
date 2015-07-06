package GUI;
import controller.*;
import Game.Territorio;
import Game.TerritorioDataBase;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import java.io.*;

import javax.imageio.*;

public class MapPanel extends JPanel {
	Image bg_img;
	//Mapa map;	
	MapClickRedirect clickRedirect;
	
	public MapPanel (/*Mapa mapa*/MapClickRedirect redirect){
		/*map=mapa;
		map.setOpaque(false);
		map.setPreferredSize(new Dimension(1024,768));
		add(map,BorderLayout.WEST);*/
		clickRedirect=redirect;
		initializeMouseListener();
		try{
			bg_img=ImageIO.read(new File("war_tabuleiro_com_nomes.png"));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(bg_img,0,0,1024,768,0,0,2133,1600,null);
		for(Territorio t:TerritorioDataBase.getLstTerritorios()){
			g.setColor(t.getOwnerColor());
			g.fillRect((int)(t.getPoligono().getBounds2D().getCenterX())-10, (int)(t.getPoligono().getBounds2D().getCenterY())-10, 10, 10);
			g.setColor(Color.black);
			g.drawRect((int)(t.getPoligono().getBounds2D().getCenterX())-10, (int)(t.getPoligono().getBounds2D().getCenterY())-10, 10, 10);
		}
	}
	private void initializeMouseListener(){

		this.addMouseListener(new MouseListener() {
			
			// Evento de click para detectar se o ponto clicado est� dentro da area do teritorio.
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clickRedirect.click(e.getX(),e.getY());	
				
			}
	

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
								
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

	}
	public void addRedirect (MapClickRedirect m){
		clickRedirect=m;
	}
}
