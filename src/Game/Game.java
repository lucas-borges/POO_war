package Game;

import etc.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game {
	private int nPlayers;
	private Player[] players;
	private int currentPlayerIndex;
	
	public Game (int n){
		nPlayers=n;
		players=new Player[n];
		
		int d=0;
		
		ArrayList<Color> colors=new ArrayList<Color>(Arrays.asList(Color.values()));
		Random randGen = new Random();
		
		
		for(int i=0;i<nPlayers;i++){
			int posColor=randGen.nextInt(colors.size());
			Color playerColor = colors.remove(posColor);
			players[i]=new Player(playerColor);
		}
		
		currentPlayerIndex=0;
		
	}
	
	public Color[] getColorOrder(){
		Color order[]=new Color[nPlayers];
		int i=0;
		
		for(Player p:players){
			order[i]=p.getColor();
			i++;
		}
		for(Color c:order){
			System.out.println(c.name());
		}
		return order;
	}
}
