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
	public int nAsia=0;
	public int nEuropa=0;
	public int nAfrica =0;
	public int nOceania = 0;
	public int nAmSul =0;
	public int nAmNorte =0;
	
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
	public String getObjetivo(){
		return objetivo.getNome();
	}
	public void atualizaContador(Territorio t, int n){
	
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
