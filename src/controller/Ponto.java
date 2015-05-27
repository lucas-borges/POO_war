package controller;

public class Ponto {

	private Double x;
	private Double y;
	
	public Ponto(Double x, Double y) {
		this.x = x;
		this.y = y;
	}
	
public double get(String s) {
		
		switch (s) {
			case "x": return this.x;
			case "y": return this.y;
		}
		
		return 0;
	}
}
