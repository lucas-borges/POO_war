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
import etc.enumColor;
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
	
	private boolean[] isDead=null;
	private int nPlayersAlive;
	
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
		
		if(isDead!=null){
			while(isDead[currentPlayerIndex]==true){
				if(currentPlayerIndex==nPlayers-1){
					currentPlayerIndex=0;
				}
				else {
					currentPlayerIndex++;
				}
			}
		}
		System.out.println("turno atual: "+players[currentPlayerIndex].getColor());
	}
	public void setDead (int i){
		if(isDead==null){
			isDead=new boolean[nPlayers];
			for(int j=0;j<nPlayers;j++){
				isDead[j]=false;
			}
			nPlayersAlive=nPlayers;
		}
		isDead[i]=true;
		nPlayersAlive--;
	}
	public int getNPlayersAlive (){
		return nPlayersAlive;
	}
	public Color[] getAliveColorOrder(){
		Color order[]=new Color[nPlayersAlive];
		int j=0;
		
		for(int i=0;i<nPlayers;i++){
			if(isDead[i]==false){
				order[j]=players[i].getColor();
				j++;
			}
		}
		return order;
	}
	
	public Color[] getColorOrder(){
		Color order[]=new Color[nPlayers];
		int i=0;
		
		for(Player p:players){
			order[i]=p.getColor();
			i++;
		}	
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
	public int[] DistribuirTropas(){
		
		int tropas[]=new int[8];
		int an=0,asl=0,af=0,eu=0,as=0,oc=0;
		for(int i=2;i<8;i++){
			tropas[i]=0;
		}
		
		tropas[0]=players[currentPlayerIndex].getNumTropasDist()/2;
		
		tropas[1]=realizaTroca();
		
		for(Territorio t:players[currentPlayerIndex].getTerritorios()){
			switch (t.getContinente()){
			
			case AmericaDoNorte:
				af++;
				if(af==t.nAmNorte){
					tropas[2]=5;
				}
				break;
				
			case AmericaDoSul:
				asl++;
				if(asl==t.nAmSul){
					tropas[3]=2;
				}
				break;
			
			case Africa:
				af++;
				if(af==t.nAfrica){
					tropas[4]=3;
				}
				break;
				
			case Europa:
				eu++;
				if(asl==t.nEuropa){
					tropas[5]=5;
				}
				break;
			
			case Asia:
				as++;
				if(as==t.nAsia){
					tropas[6]=7;
				}
				break;
			
			case Oceania:
				oc++;
				if(asl==t.nOceania){
					tropas[7]=2;
				}
				break;			
			}
		}
		
		return tropas;
		
	}
	public Color getCurrentColor ()	{
		return players[currentPlayerIndex].getColor();
	}
	public Player getPlayer(Color c){
		for(Player p: players){
			if(p.getColor().equals(c))
				return p;
		}
		return null;
	}
	public int getPlayerIndex(Color c){
		for(int i=0;i<nPlayers;i++){
			if(players[i].getColor().equals(c))
				return i;
		}
		return -1;
	}
	public void deltaT(Territorio t, int n){
		players[currentPlayerIndex].deltaT(t, n);
	}
	
	public void SelectWinner(int[] attack, int[] defense, int[] result){
		// result = vetor do resultado posicao 0 = exercitos perdidos pelo ataque; posicao 1 = exercitos perdidos pela defesa
		int contAttack=0, contDefense=0;
		
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
	}
	
	private void SetarObjetivo(Player p, Objetivo o){
		
		p.setObjetivo(o);
		if(p.getObjetivo().startsWith("Destruir")){	
			if(p.getObjetivo().endsWith(NamedColor.getMatch(p.getColor()).getColorPlural())){
				p.setObjetivo(Objetivo.T24);
				return;
			}
			for(Player P: players){
				if(p.getObjetivo().endsWith(NamedColor.getMatch(P.getColor()).getColorPlural())){
					return;
				}
				
			}
			p.setObjetivo(Objetivo.T24);

		}
	}
			
	
	
	public void DistribuirObjetivos(){
		
		ArrayList<CartaObjetivo> objetivos = CartaObjetivoDataBase.copyLstObjetivos();
		Random randObj = new Random();
		
		for (int i=0;i<nPlayers;i++){
			int index=randObj.nextInt(objetivos.size());
			CartaObjetivo o = CartaObjetivoDataBase.buscaObjetivo(objetivos.get(index).getNome());
			SetarObjetivo(players[i],objetivos.remove(index).getNome());
			
		}
	}

	
	public boolean ChecarObjetivo1(){
		if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro.")){
			if(players[currentPlayerIndex].nEuropa==Territorio.nEuropa && players[currentPlayerIndex].nOceania==Territorio.nOceania){
				if(players[currentPlayerIndex].nAmNorte==Territorio.nAmNorte || players[currentPlayerIndex].nAmSul==Territorio.nAmSul 
						|| players[currentPlayerIndex].nAfrica==Territorio.nAfrica || players[currentPlayerIndex].nAsia == Territorio.nAsia){
					return true;
				}
				
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar na totalidade a ASIA e a AM�RICA DO SUL.")){
			if(players[currentPlayerIndex].nAsia == Territorio.nAsia && 
					players[currentPlayerIndex].nAmSul == Territorio.nAmSul){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar na totalidade a EUROPA, a AM�RICA DO SUL e mais um terceiro.")){
			if(players[currentPlayerIndex].nEuropa==Territorio.nEuropa && players[currentPlayerIndex].nAmSul==Territorio.nAmSul){
				if(players[currentPlayerIndex].nAmNorte==Territorio.nAmNorte || players[currentPlayerIndex].nAfrica==Territorio.nAfrica 
						|| players[currentPlayerIndex].nOceania==Territorio.nOceania || players[currentPlayerIndex].nAsia == Territorio.nAsia){
					return true;
				}
				
			}
		}
		
		else if(players[currentPlayerIndex].getObjetivo().equals("Conquistar na totalidade a ASIA e a �FRICA.")){
			if(players[currentPlayerIndex].nAsia == Territorio.nAsia && 
					players[currentPlayerIndex].nAfrica == Territorio.nAfrica){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Conquistar na totalidade a AM�RICA DO NORTE e a �FRICA.")){
			if(players[currentPlayerIndex].nAmNorte == Territorio.nAmNorte && 
					players[currentPlayerIndex].nAfrica == Territorio.nAfrica){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Conquistar 24 TERRIT�RIOS � sua escolha.")){
			if(players[currentPlayerIndex].nAfrica+players[currentPlayerIndex].nAmNorte+players[currentPlayerIndex].nAmSul+
					players[currentPlayerIndex].nAsia+players[currentPlayerIndex].nEuropa+
					players[currentPlayerIndex].nOceania>=24){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar na totalidade a AM�RICA DO NORTE e a OCEANIA.")){
			if(players[currentPlayerIndex].nAmNorte == Territorio.nAmNorte && 
					players[currentPlayerIndex].nOceania == Territorio.nOceania){
				return true;
			}
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EX�RCITOS AZUIS.")){
			return players[getPlayerIndex(Color.BLUE)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EX�RCITOS AMARELOS.")){
			return players[getPlayerIndex(Color.YELLOW)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EX�RCITOS VERMELHOS.")){
			return players[getPlayerIndex(Color.RED)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EX�RCITOS PRETOS.")){
			return players[getPlayerIndex(Color.BLACK)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EX�RCITOS BRANCOS.")){
			return players[getPlayerIndex(Color.WHITE)].IsDead();
		
		}
		else if(players[currentPlayerIndex].getObjetivo().equals("Destruir totalmente OS EX�RCITOS VERDES.")){
			return players[getPlayerIndex(Color.GREEN)].IsDead();
		
		}
		return false;
	}

	public boolean ChecarObjetivo2(){
		if(players[currentPlayerIndex].getObjetivo().equals(" Conquistar 18 TERRIT�RIOS e ocupar cada um deles com pelo menos dois ex�rcitos.")){
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
		return false;
	}
	
	public boolean ChecarMorteJogador(Player p){
		
		for(Player p1: players){
			if(p1.getObjetivo().endsWith(NamedColor.getMatch(p.getColor()).getColorPlural())){
				if(p1.equals(p))
					return true;
				else
					p1.setObjetivo(Objetivo.T24);
			}
			
		}
		
		return false;
		
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
				if (!players[currentPlayerIndex].getCartas()
						.get(indexCartas[icartas]).getFileTerritorio()
						.equals("coringa")) {
					for (Territorio t : players[currentPlayerIndex]
							.getTerritorios()) {
						if (players[currentPlayerIndex]
								.getCartas()
								.get(indexCartas[icartas])
								.getFileName()
								.equalsIgnoreCase(
										nomePais.valueOf(t.toString())
												.toString())) {
							t.deltaTropas(2);
						}
					}
				}
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

	
	
	
	public boolean ChecarObjetivo(int n){
		if(n==1)
			return ChecarObjetivo1();
		return ChecarObjetivo2();
	}
		
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
		
		// DEBUG
		
		public Game(String filename){
			try(BufferedReader br = new BufferedReader(new FileReader(filename))){
				String sCurrentLine;
				Objetivo objs[] = null;
				
				while((sCurrentLine = br.readLine()) != null){
					//System.out.println(sCurrentLine);
					if(sCurrentLine.startsWith("//")||sCurrentLine.isEmpty() || sCurrentLine.trim().equals("") || sCurrentLine.trim().equals("\n")){
						//do nothing
					}
					else if(sCurrentLine.startsWith("-")){
						int n=Integer.parseInt(sCurrentLine.substring(1));
						nPlayers=n;
						players=new Player[n];
						objs=new Objetivo[n];
					}
					else if(sCurrentLine.startsWith("#")){
						int i=0, div;
						div=sCurrentLine.indexOf(' ');
						while(players[i]!=null){
							i++;
						}
						players[i]=new Player(NamedColor.getColor(sCurrentLine.substring(1,div)));
						objs[i]=Objetivo.valueOf(sCurrentLine.substring(div+1));
					}
					else if(sCurrentLine.startsWith("$")){
						int i=0;
						
						for(Objetivo o:objs){
							this.SetarObjetivo(players[i],o);
							i++;
						}
					}
					else if(sCurrentLine.startsWith("@")){
						int div1=1,div2, i;
						div2=sCurrentLine.indexOf(' ');
						
						if(div2!=-1){
							String s=sCurrentLine.substring(div1, div2);
							i=Integer.parseInt(s)-1;
							
							while(div2!=sCurrentLine.length()){
								div1=div2+1;
								div2=sCurrentLine.indexOf(' ',div2+1);
								if(div2==-1){
									div2=sCurrentLine.length();
								}
								s=sCurrentLine.substring(div1, div2);
								players[i].adicionaCarta(CartaDataBase.getCarta(s));
							}
						}
					}
					else{
						int div1, div2;
						Territorio terr; 
						int playerIndx, nTropas; 
						div1=sCurrentLine.indexOf(' ');
						div2=sCurrentLine.lastIndexOf(' ');						
						
						terr=TerritorioDataBase.buscaTerritorio(nomePais.valueOf(sCurrentLine.substring(0,div1)));
						playerIndx=Integer.parseInt(sCurrentLine.substring(div1+1, div2))-1;
						nTropas=Integer.parseInt(sCurrentLine.substring(div2+1));
						
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
