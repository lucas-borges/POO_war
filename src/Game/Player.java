package Game;

import java.awt.Color;
import java.util.ArrayList;

import etc.enumObjetivo.Objetivo;

//import etc.*;


public class Player {
	private Color color;
	private ArrayList<Territorio> territorios;
	private ArrayList<Carta> cartas;
	private Objetivo objetivo;
	public int nAsia = 0;
	public int nEuropa = 0;
	public int nAfrica = 0;
	public int nOceania = 0;
	public int nAmSul = 0;
	public int nAmNorte = 0;
	
	public Player (Color x){
		color=x;
		territorios=new ArrayList<Territorio>();
		cartas=new ArrayList<Carta>();
	}
	public void addTerr (Territorio t){
		territorios.add(t);
		t.setOwnerColor(color);
		
		String continente = t.getContinente().getNome();
		
		if(continente.equals("as")){
			nAsia++;
		}
		else if(continente.equals("af")){
			nAfrica++;
		}
		else if(continente.equals("an")){
			nAmNorte++;
		}
		else if(continente.equals("asl")){
			nAmSul++;
		}
		else if(continente.equals("eu")){
			nEuropa++;
		}
		else {
			nOceania++;
		}
	}
	public void removeTerr (Territorio t){
		territorios.remove(t);
		
		String continente = t.getContinente().getNome();
		
		if(continente.equals("as")){
			nAsia++;
		}
		else if(continente.equals("af")){
			nAfrica--;
		}
		else if(continente.equals("an")){
			nAmNorte--;
		}
		else if(continente.equals("asl")){
			nAmSul--;
		}
		else if(continente.equals("eu")){
			nEuropa--;
		}
		else {
			nOceania--;
		}
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
	public ArrayList<Territorio> getTerritorios(){
		return territorios;
	}

	public void adicionaCarta(Carta c){
		cartas.add(c);
	}
	public ArrayList<Carta> getCartas(){
		return cartas;
	}
	public boolean IsDead(){
		return territorios.isEmpty();
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
