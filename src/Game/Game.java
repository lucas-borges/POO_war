package Game;

//import etc.*;
//DEBUG
import controller.Mapa;
//DEBUG

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import controller.Territorio;

public class Game {
	private int nPlayers;
	private Player[] players;
	private int currentPlayerIndex;
	private int turn;
	
	//DEBUG
	Mapa mapaD=new Mapa();
	//END DEBUG
	
	public Game (int n){
		nPlayers=n;
		players=new Player[n];
		
		ArrayList<Color> colors=new ArrayList<Color>(Arrays.asList(
				new Color[]{Color.blue, Color.black, Color.white,Color.green,
						Color.red,Color.yellow}));
		Random randGen = new Random();
		
		
		for(int i=0;i<nPlayers;i++){
			int posColor=randGen.nextInt(colors.size());
			Color playerColor = colors.remove(posColor);
			players[i]=new Player(playerColor);
		}
		
		currentPlayerIndex=0;
		turn=1;
	}
	public void nextTurn (){
		turn++;
		if(currentPlayerIndex==nPlayers-1){
			currentPlayerIndex=0;
		}
		else {
			currentPlayerIndex++;
		}
	}
	
	
	public Color[] getColorOrder(){
		Color order[]=new Color[nPlayers];
		int i=0;
		
		for(Player p:players){
			order[i]=p.getColor();
			i++;
		}
		/*for(Color c:order){
			System.out.println(c.name());
		}*/
		return order;
	}
	public int getNPlayers(){
		return nPlayers;
	}
	public int getTurn(){
		return turn;
	}
	public int getCurrentPlayer(){
		return currentPlayerIndex+1;
	}
	
	//DEBUG
		public void randomizeStart(){
			ArrayList<Territorio> tempTerr = mapaD.copyLstTerritorios()/* TODOS OS TERRITORIOS */;
			Random randGen = new Random();
			
			int terrPPlayer = tempTerr.size()/nPlayers;
			int resto = tempTerr.size()%nPlayers;
			
			for(int i=0;i<terrPPlayer;i++){
				for (int j=0;j<nPlayers;j++){
					players[j].addTerr(tempTerr.remove(randGen.nextInt(tempTerr.size())));
				}
			}
			for(int i=0;i<resto;i++){
				for (int j=0;j<nPlayers;j++){
					players[j].addTerr(tempTerr.remove(randGen.nextInt(tempTerr.size())));
				}
			}
		}
		
		public void playerTerr(int n){
			players[n].listTerr();
		}
		
		//END DEBUG
}
