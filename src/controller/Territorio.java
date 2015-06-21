package controller;

import java.awt.Color;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;
import Game.TerritorioDataBase;
import etc.enumTerritorio.nomePais;;

public class Territorio{

	
	private nomePais Nome;
	private GeneralPath poligono;
	private List<Territorio> lstFronteiras = new ArrayList<Territorio>();
	Color ownerColor;
	int numTropas;

	public Territorio(nomePais nome, Ponto p[], float x, float y) {
		super();
		
		this.Nome = nome;
		
		GeneralPath gp = new GeneralPath(GeneralPath.WIND_EVEN_ODD);				
		
		gp.moveTo(p[0].get("x") + (x),p[0].get("y") + (y));

		for (int i = 1; i < p.length; i++) {
			gp.lineTo(p[i].get("x") + (x), p[i].get("y") + (y));
		}

		gp.closePath();
		
		this.poligono = gp;
	}
	
	public GeneralPath getPoligono() {
		return this.poligono;
	}
	
	public nomePais getNome () {
		return this.Nome;
	}
	public void lstFronteirasAdd(Territorio fronteira){
		lstFronteiras.add(fronteira);
	}
	public List<Territorio> getLstFronteiras(){
		return lstFronteiras;
	}
	public void setOwnerColor(Color c){
		ownerColor=c;		
	}
	public Color getOwnerColor(){
		return ownerColor;
	}
	public int getNTropas (){
		return numTropas;
	}
}
