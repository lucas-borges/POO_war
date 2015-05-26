package Game;

import etc.*;
import java.util.Random;

public class Game {
	private int nPlayers;
	private Player[] players;
	
	public Game (int n){
		nPlayers=n;
		players=new Player[n];
		
	}
	
	public Color[] getOrder(){
		Color order[]=new Color[nPlayers];
		
		return order;
	}
}
