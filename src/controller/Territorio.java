package controller;

import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Territorio {

	private String Nome;
	private GeneralPath poligono;
	private List<Territorio> lstFronteiras = new ArrayList<Territorio>();

	public Territorio(String nome, Ponto p[], float x, float y) {
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
	
	public String getNome () {
		return this.Nome;
	}
	public void lstFronteirasAdd(Territorio fronteira){
		lstFronteiras.add(fronteira);
	}
}
