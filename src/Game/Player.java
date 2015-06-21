package Game;

import java.awt.Color;
import java.util.ArrayList;

import controller.Territorio;

//import etc.*;


public class Player {
	private Color color;
	private ArrayList<Territorio> territorios;
	
	public Player (Color x){
		color=x;
		territorios=new ArrayList<Territorio>();
	}
	public void addTerr (Territorio t){
		territorios.add(t);
	}
	public Color getColor (){
		return color;
	}
	
	//DEBUG
	public void listTerr(){
		for(Territorio t:territorios){
			System.out.println(t.getNome());
		}
	}
	public int getNumTropas(){
		return territorios.size();
	}
	//END DEBUG
}
