package Game;

//import etc.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game {
	private int nPlayers;
	private Player[] players;
	private int currentPlayerIndex;
	private int turn;
	
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
	public void SelectWinner(int[] attack, int[] defense, int[] result){
		// result = vetor do resultado posição 0 = exércitos perdidos pelo ataque; posição 1 = exércitos perdidos pela defesa
		int contAttack=0, contDefense=0;
		System.out.println("Entrou no selectWinner");
		
		if(attack.length == 1 || defense.length == 1){
			
			if(getHighest(attack)>getHighest(defense))
				contDefense++;
			else
				contAttack++;
		}
		else if(attack.length == 3 && defense.length == 3)
		{
			if(getHighest(attack)>getHighest(defense))
				contDefense++;
			else
				contAttack++;
			
			if(getSecond(attack)>getSecond(defense))
				contDefense++;
			else
				contAttack++;
			
			if(getLowest(attack)>getLowest(defense))
				contDefense++;
			else
				contAttack++;
		}
		else if(attack.length == 3 && defense.length == 2){
			
			if(getHighest(attack)>getHighest(defense))
				contDefense++;
			else
				contAttack++;
			
			if(getSecond(attack)>getLowest(defense))
				contDefense++;
			else
				contAttack++;
		}
		else if(attack.length == 2 && defense.length == 3)
		{
			if(getHighest(attack)>getHighest(defense))
				contDefense++;
			else
				contAttack++;
			
			if(getLowest(attack)>getSecond(defense))
				contDefense++;
			else
				contAttack++;
			
		}
		else if(attack.length == 2 && defense.length == 2){
			
			if(getHighest(attack)>getHighest(defense))
				contDefense++;
			else
				contAttack++;
			
			if(getLowest(attack)>getLowest(defense))
				contDefense++;
			else
				contAttack++;
		}
		
		result[0]=contAttack;
		result[1]=contDefense;
		
		System.out.printf("Ataque perdeu %d territorios\n",result[0]);
		System.out.printf("Defesa perdeu %d territorios",result[1]);
		
		
	}
	private int getHighest(int[] vet){
		int highest =0;
		
		for(int i: vet){
			if(i>highest)
				highest=i;
		}
		
		return highest;
	}
	private int getSecond(int[] vet){
		int second=0;
		
		for(int i: vet){
			if(i!=getHighest(vet) && i>second)
				second=i;
		}
		
		return second;
	}
	private int getLowest(int[] vet){
		int lowest=7;
		
		for(int i:vet){
			if(i<lowest)
				lowest=i;
		}
		
		return lowest;
	}
}
