package Game;



import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import controller.Territorio;
import etc.enumColor;
import etc.enumTerritorio;
import etc.enumColor.NamedColor;
import etc.enumObjetivo.Objetivo;
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
	public int getCurrentIndex(){
		return currentPlayerIndex+1;
	}
	public Player getCurrentPlayer(){
		return players[currentPlayerIndex];
	}
	
	public int DistribuirTropas(){
		
		return players[currentPlayerIndex].getNumTropasDist()/2;
		
	}
	public Color getCurrentColor ()	{
		return players[currentPlayerIndex].getColor();
	}
	public int getPlayerIndex(Color c){
		for(int i=0; i<nPlayers;i++){
			if(players[i].getColor().equals(c))
				return i;
		}
		return -1;
	}
	public void deltaT(Territorio t, int n){
		players[currentPlayerIndex].deltaT(t, n);
	}
	
	public void SelectWinner(int[] attack, int[] defense, int[] result){
		// result = vetor do resultado posiï¿½ï¿½o 0 = exï¿½rcitos perdidos pelo ataque; posiï¿½ï¿½o 1 = exï¿½rcitos perdidos pela defesa
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
				System.out.println(players[i].getObjetivo());
				if(players[i].getObjetivo().endsWith(NamedColor.getMatch(players[i].getColor()).getColorPlural())){
					players[i].setObjetivo(Objetivo.T24);
					return;
				}
				for(Player p: players){
					if(players[i].getObjetivo().endsWith(NamedColor.getMatch(p.getColor()).getColorPlural())){
						return;
					}
				}
				players[i].setObjetivo(Objetivo.T24);
			}
			
		}
	}
	
	public boolean ChecarObjetivo(){
		if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro.")){
			if(players[currentPlayerIndex].nEuropa==Territorio.nEuropa && players[currentPlayerIndex].nOceania==Territorio.nOceania){
				if(players[currentPlayerIndex].nAmNorte==Territorio.nAmNorte || players[currentPlayerIndex].nAmSul==Territorio.nAmSul 
						|| players[currentPlayerIndex].nAfrica==Territorio.nAfrica || players[currentPlayerIndex].nAsia == Territorio.nAsia){
					return true;
				}
				
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar na totalidade a ASIA e a AMÉRICA DO SUL.")){
			if(players[currentPlayerIndex].nAsia == Territorio.nAsia && 
					players[currentPlayerIndex].nAmSul == Territorio.nAmSul){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar na totalidade a EUROPA, a AMÉRICA DO SUL e mais um terceiro.")){
			if(players[currentPlayerIndex].nEuropa==Territorio.nEuropa && players[currentPlayerIndex].nAmSul==Territorio.nAmSul){
				if(players[currentPlayerIndex].nAmNorte==Territorio.nAmNorte || players[currentPlayerIndex].nAfrica==Territorio.nAfrica 
						|| players[currentPlayerIndex].nOceania==Territorio.nOceania || players[currentPlayerIndex].nAsia == Territorio.nAsia){
					return true;
				}
				
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar 18 TERRITÓRIOS e ocupar cada um deles com pelo menos dois exércitos.")){
			if(players[currentPlayerIndex].nAfrica+players[currentPlayerIndex].nAmNorte+players[currentPlayerIndex].nAmSul+
					players[currentPlayerIndex].nAsia+players[currentPlayerIndex].nEuropa+
					players[currentPlayerIndex].nOceania>=18){
				int n=0;
				for(Territorio t: players[currentPlayerIndex].getTerritorios()){
					if(t.getNTropas()>=2)
						n++;
					if(n>=18)
						return true;
				}
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Conquistar na totalidade a ASIA e a ÁFRICA.")){
			if(players[currentPlayerIndex].nAsia == Territorio.nAsia && 
					players[currentPlayerIndex].nAfrica == Territorio.nAfrica){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Conquistar na totalidade a AMÉRICA DO NORTE e a ÁFRICA.")){
			if(players[currentPlayerIndex].nAmNorte == Territorio.nAmNorte && 
					players[currentPlayerIndex].nAfrica == Territorio.nAfrica){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Conquistar 24 TERRITÓRIOS à sua escolha.")){
			if(players[currentPlayerIndex].nAfrica+players[currentPlayerIndex].nAmNorte+players[currentPlayerIndex].nAmSul+
					players[currentPlayerIndex].nAsia+players[currentPlayerIndex].nEuropa+
					players[currentPlayerIndex].nOceania>=24){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar na totalidade a AMÉRICA DO NORTE e a OCEANIA.")){
			if(players[currentPlayerIndex].nAmNorte == Territorio.nAmNorte && 
					players[currentPlayerIndex].nOceania == Territorio.nOceania){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EXÉRCITOS AZUIS.")){
			return players[getPlayerIndex(Color.BLUE)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EXÉRCITOS AMARELOS.")){
			return players[getPlayerIndex(Color.YELLOW)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EXÉRCITOS VERMELHOS.")){
			return players[getPlayerIndex(Color.RED)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EXÉRCITOS PRETOS.")){
			return players[getPlayerIndex(Color.BLACK)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EXÉRCITOS BRANCOS.")){
			return players[getPlayerIndex(Color.WHITE)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EXÉRCITOS VERDES.")){
			return players[getPlayerIndex(Color.GREEN)].IsDead();
		
		}
		return false;
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
					t.deltaTropas(1);
					players[j].addTerr(tempTerr.remove(index));
					
				}
			}
			for(int i=0;i<resto;i++){
				for (int j=0;j<nPlayers && tempTerr.size()>0;j++){
					int index=randGen.nextInt(tempTerr.size());
					Territorio t=TerritorioDataBase.buscaTerritorio(tempTerr.get(index).getNome());
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
					System.out.println(sCurrentLine);
					if(sCurrentLine.startsWith("//")||sCurrentLine.isEmpty() || sCurrentLine.trim().equals("") || sCurrentLine.trim().equals("\n")){
						//do nothing
					}
					else if(sCurrentLine.startsWith("-")){
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
						
						System.out.println("$"+sCurrentLine.substring(0, div1) + "-"+div1+"-"+div2);
						
						terr=TerritorioDataBase.buscaTerritorio(nomePais.valueOf(sCurrentLine.substring(0,div1)));
						playerIndx=Integer.parseInt(sCurrentLine.substring(div1+1, div2))-1;
						nTropas=Integer.parseInt(sCurrentLine.substring(div2+1));
						
						//System.out.print("$"+sCurrentLine.substring(0,div1));
						//System.out.println("$"+playerIndx +"*"+nTropas);
						//System.out.println("$"+(enumTerritorio.toNomePais(sCurrentLine.substring(0,div1)).getNome()));
						//System.out.println("$"+terr.getNome().getNome());
						
						players[playerIndx].addTerr(terr);
						terr.deltaTropas(nTropas);
						
					}
				}
				
				currentPlayerIndex=0;
				turn=1;
			}
			catch(IOException e){
				e.printStackTrace();
			}
			
			
		}

}
