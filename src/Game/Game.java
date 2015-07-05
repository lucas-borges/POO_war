package Game;



import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.Territorio;
import etc.enumTerritorio;
import etc.enumColor.NamedColor;
import etc.enumObjetivo.Objetivo;
import etc.Figura;

import etc.enumTerritorio.nomePais;
public class Game {
	private int nPlayers;
	private Player[] players;
	private int currentPlayerIndex;
	private int turn;
	private int nTrocas=0;
	private boolean currentPlayerWonATerritory;
	private boolean trocaRealizada=false;
	
	
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
		currentPlayerWonATerritory=false;
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
	public int getCurrentIndex(){
		return currentPlayerIndex+1;
	}
	public Player getCurrentPlayer(){
		return players[currentPlayerIndex];
	}
	public void setCurrentPlayerWonATerritory(){
		currentPlayerWonATerritory=true;
	}
	public int DistribuirTropas(){
		
		return ((players[currentPlayerIndex].getNumTropasDist()/2)+realizaTroca());
		
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
			if(players[i].getObjetivo().startsWith("Destruir")){
				System.out.println("Destruir");
				if(players[i].getObjetivo().endsWith(NamedColor.getMatch(players[i].getColor()).getColorName())){
					players[i].setObjetivo(Objetivo.T24);
				}
			}
			
		}
	}
	
	public boolean ChecarObjetivo(){
		return true;
		
		
	}
	
	public void recebeCarta(){
		if(currentPlayerWonATerritory){
			currentPlayerWonATerritory=false;
			Carta c=CartaDataBase.puxaCarta();
			JOptionPane.showMessageDialog(null, "Carta recebida", "Carta conquistada", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(c.getFileName()));
			players[currentPlayerIndex].adicionaCarta(c);
		}
	}
	public int realizaTroca(){
		boolean trocaPossivel=false,randomT=true,randomQ=true,randomC=true;
		int i=0,it=0,iq=0,ic=0,ir=0;
		int indexCartas[]=null;
		int indexT[]=new int[3];
		int indexQ[]=new int[3];
		int indexC[]=new int[3];
		int indexR[]=new int[3];
		for(Carta c : players[currentPlayerIndex].getCartas()){
			switch (c.getFigura()){
			
			case triangulo:
				indexT[it++]=i;
				System.out.println("Adicionado no T");
				if(randomT){
					randomT=false;
					indexR[ir++]=i;
					System.out.println("Adicionado no random");
				}
				break;
			case quadrado:
				indexQ[iq++]=i;
				System.out.println("Adicionado no quadrado");
				if(randomQ){
				    randomQ=false;
					indexR[ir++]=i;
					System.out.println("Adicionado no random");
				}
				break;
			case circulo:
				indexC[ic++]=i;
				System.out.println("Adicionado no circulo");
				if(randomC){
					randomC=false;
					indexR[ir++]=i;
					System.out.println("adicionado no random");
				}
				break;
			case coringa:
				indexT[it++]=i;
				indexQ[iq++]=i;
				indexC[ic++]=i;
				indexR[ir++]=i;
				System.out.println("adicionado em todos");
				break;
			}
			if(it==3){
				System.out.println("it==3");
				indexCartas=indexT;
				trocaPossivel=true;
				break;
			}
			if(iq==3){
				System.out.println("iq==3");
				indexCartas=indexQ;
				trocaPossivel=true;
				break;
			}
			if(ic==3){
				System.out.println("ic==3");
				indexCartas=indexC;
				trocaPossivel=true;
				break;
			}
			if(ir==3){
				System.out.println("ir==3");
				indexCartas=indexR;
				trocaPossivel=true;
				break;
			}
			i++;
		}
		
		if (trocaPossivel) {
			System.out.println("vai trocar");
			trocaRealizada=true;
			for (int icartas=2;icartas>=0;icartas--) {
				System.out.println(indexCartas[icartas]);
				System.out.println(players[currentPlayerIndex].getCartas().get(indexCartas[icartas]).getFileName());
				CartaDataBase.insereCarta(players[currentPlayerIndex].getCartas().remove(indexCartas[icartas]));// devolve as cartas para o "baralho"
			}
			if (nTrocas < 5) {
				return 4 + (2 * (nTrocas++));
			}
			return 15 + (5 * ((nTrocas++) - 5));
		}
		
		return 0;
	}
	public boolean realizouTroca(){
		if (trocaRealizada==true){
			trocaRealizada=false;
			return true;
		}
		return false;
	}
	public int getNTrocas(){
		return nTrocas;
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
		
		public Game(String filename){
			try(BufferedReader br = new BufferedReader(new FileReader(filename))){
				String sCurrentLine;
				
				while((sCurrentLine = br.readLine()) != null){
					if(!sCurrentLine.startsWith("//")){
						if(sCurrentLine.startsWith("-")){
							int n=Integer.parseInt(sCurrentLine.substring(1));
							nPlayers=n;
							players=new Player[n];
						}
						else if(sCurrentLine.startsWith("#")){
							int i=0;
							while(players[i]!=null){
								i++;
							}
							players[i]=new Player(NamedColor.getColor(sCurrentLine.substring(1)));
						}
						else{
							int div1, div2;
							Territorio terr; 
							int playerIndx, nTropas; 
							div1=sCurrentLine.indexOf(' ');
							div2=sCurrentLine.lastIndexOf(' ');
							
							terr=TerritorioDataBase.buscaTerritorio(enumTerritorio.toNomePais(sCurrentLine.substring(0,div1)));
							playerIndx=Integer.parseInt(sCurrentLine.substring(div1+1, div2))-1;
							nTropas=Integer.parseInt(sCurrentLine.substring(div2+1));
							
							players[playerIndx].addTerr(terr);
							terr.deltaTropas(nTropas);
							
						}
					}
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
			
			
		}

}
