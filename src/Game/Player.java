package Game;

import java.awt.Color;

//import etc.*;


public class Player {
	private Color color;
	//private Territorios[] territorios;
	
	public Player (Color x){
		color=x;
	}
	
	public Color getColor (){
		return color;
	}
}
