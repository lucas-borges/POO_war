package Game;

//import etc.*;
//DEBUG

//DEBUG

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import controller.Territorio;
import etc.enumTerritorio.nomePais;
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
	
	public int DistribuirTropas(){
		
		return players[currentPlayerIndex].getNumTropasDist()/2;
		
	}
	public Color getCurrentColor ()	{
		return players[currentPlayerIndex].getColor();
	}
	public void deltaT(Territorio t, int n){
		players[currentPlayerIndex].deltaT(t, n);
	}
	public void SelectWinner(int[] attack, int[] defense, int[] result){
		// result = vetor do resultado posi��o 0 = ex�rcitos perdidos pelo ataque; posi��o 1 = ex�rcitos perdidos pela defesa
		int contAttack=0, contDefense=0;
		System.out.println("Entrou no selectWinner");
		
		if(attack.length == 1 || defense.length == 1){
			
			if(attack[0]>defense[0])
				contDefense++;
			else
				contAttack++;
		}
		else if(attack.length == 3 && defense.length == 3)
		{
			if(attack[2]>defense[2])
				contDefense++;
			else
				contAttack++;
			
			if(attack[1]>defense[1])
				contDefense++;
			else
				contAttack++;
			
			if(attack[0]>defense[0])
				contDefense++;
			else
				contAttack++;
		}
		else if(attack.length == 3 && defense.length == 2){
			
			if(attack[0]>defense[0])
				contDefense++;
			else
				contAttack++;
			
			if(attack[1]>defense[1])
				contDefense++;
			else
				contAttack++;
		}
		else if(attack.length == 2 && defense.length == 3)
		{
			if(attack[0]>defense[0])
				contDefense++;
			else
				contAttack++;
			
			if(attack[1]>defense[1])
				contDefense++;
			else
				contAttack++;
			
		}
		else if(attack.length == 2 && defense.length == 2){
			
			if(attack[0]>defense[0])
				contDefense++;
			else
				contAttack++;
			
			if(attack[1]>defense[1])
				contDefense++;
			else
				contAttack++;
		}
		
		result[0]=contAttack;
		result[1]=contDefense;
		
		System.out.printf("Ataque perdeu %d territorios\n",result[0]);
		System.out.printf("Defesa perdeu %d territorios",result[1]);
		
		
	}
	
	public void DistribuirObjetivos(){
		
		ArrayList<CartaObjetivo> objetivos = CartaObjetivoDataBase.copyLstObjetivos();
		Random randObj = new Random();
		
		for (int i=0;i<nPlayers;i++){
			int index=randObj.nextInt(objetivos.size());
			CartaObjetivo o = CartaObjetivoDataBase.buscaObjetivo(objetivos.get(index).getNome());
			players[i].setObjetivo(objetivos.remove(index).getNome());
			
		}
	}

	
	//DEBUG
		public void randomizeStart(){
			ArrayList<Territorio> tempTerr = TerritorioDataBase.copyLstTerritorios()/* TODOS OS TERRITORIOS */;
			Random randGen = new Random();
			
			int terrPPlayer = tempTerr.size()/nPlayers;
			int resto = tempTerr.size()%nPlayers;
			
			for(int i=0;i<terrPPlayer;i++){
				for (int j=0;j<nPlayers;j++){
					int index=randGen.nextInt(tempTerr.size());
					Territorio t=TerritorioDataBase.buscaTerritorio(tempTerr.get(index).getNome());
					t.setOwnerColor(players[j].getColor());
					t.deltaTropas(1);
					players[j].addTerr(tempTerr.remove(index));
					
				}
			}
			for(int i=0;i<resto;i++){
				for (int j=0;j<nPlayers && tempTerr.size()>0;j++){
					int index=randGen.nextInt(tempTerr.size());
					Territorio t=TerritorioDataBase.buscaTerritorio(tempTerr.get(index).getNome());
					t.setOwnerColor(players[j].getColor());
					t.deltaTropas(1);
					players[j].addTerr(tempTerr.remove(index));
				}
			}
		}
		
		public void playerTerr(int n){
			players[n].listTerr();
		}
		
		//END DEBUG

}
