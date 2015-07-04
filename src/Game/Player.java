package Game;

import java.awt.Color;
import java.util.ArrayList;

import controller.Territorio;
import etc.enumObjetivo.Objetivo;

//import etc.*;


public class Player {
	private Color color;
	private ArrayList<Territorio> territorios;
	private ArrayList<Carta> cartas;
	private Objetivo objetivo;
	
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
	public void deltaT(Territorio t, int n){
		for(Territorio x: territorios){
			if(x.equals(t))
				x.deltaTropas(n);
		}
	}
	public void setObjetivo(Objetivo o){
		objetivo=o;
	}
	//DEBUG
	public void listTerr(){
		for(Territorio t:territorios){
			System.out.println(t.getNome());
		}
	}
	public int getNumTropasDist(){
		return territorios.size();
	}
	//END DEBUG
}
