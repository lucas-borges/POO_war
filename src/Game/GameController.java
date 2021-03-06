package Game;

import GUI.AttackWindow;
import GUI.CardsWindow;
import GUI.DicesWindow;
import GUI.MainWindow;
import GUI.StartWindow;
import GUI.SideMenuPanel;
import GUI.MovementWindow;

import java.awt.*;
import java.io.File;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.MapClickRedirect;


public class GameController implements Observer {
	public static final boolean DEV_MODE = true;
	public static final boolean BUTTONS_ALWAYS_ENABLED = false;
	
	private static GameController ctrl=null;
	
	private Game game;
	private MainWindow gameWin;
	private StartWindow startWin;
	private Territorio terrCorr;
	private int gameState=1;
	Territorio source;
	Territorio target;
	
	private GameController(){
		gameWin=new MainWindow();
		startWin=new StartWindow();
		
		startWin.addObserver(this);
		gameWin.addObserver(this);
		
		gameWin.createGUI();
		startWin.createGUI();
	}
	
	public static GameController getInstance(){
		if(ctrl==null){
			ctrl=new GameController();
		}
		return ctrl;
	}
	
	public void update (Observable o, Object arg){
		String x=(String)arg;
		
		/* start StartWindow events */
		if(x.equals("StartWindow_startGame")){
			int nPlayers=((StartWindow)o).getComboValue();
			game=Game.getInstance(nPlayers);
			
			gameWin.setColorPanel(game.getNPlayers(),game.getColorOrder());
			gameWin.repaint();
			
			game.randomizeStart();
			
			game.DistribuirObjetivos();
			gameWin.setTropasDist(game.DistribuirTropas());
			gameWin.setInfText("Clique num territorio seu para alocar tropas");
				
			JOptionPane.showMessageDialog(null, "Os objetivos foram distribuidos. \nClique em ver objetivo para saber qual e o seu.");
		}
		
		else if(DEV_MODE && x.equals("StartWindow_loadGame")){
			final JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
			FileFilter filter= new FileNameExtensionFilter("Text Files", "txt");
			fc.setFileFilter(filter);
			fc.setSelectedFile(new File("gameState.txt"));
			
			int returnVal =fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				startWin.close();
			    String path=fc.getSelectedFile().getAbsolutePath();
				
				game=new Game(path);
	
				gameWin.setColorPanel(game.getNPlayers(),game.getColorOrder());
				gameWin.setTropasDist(game.DistribuirTropas());
				gameWin.setInfText("Clique num territorio seu para alocar tropas");
				
				JOptionPane.showMessageDialog(null, "Estado de jogo carregado conforme arquivo.");
			}
		}
		/* end StartWindow events */
		
		/* start SideMenu events */
		else if(x.equals("SideMenu_nextTurn")){
			game.nextTurn();
			SideMenuPanel p = (SideMenuPanel)o;
			p.setTropasDist(game.DistribuirTropas());
			System.out.println("Turno: " + game.getTurn());
			System.out.println("Jogador: " + game.getCurrentIndex());
			gameWin.nextTurn();
			gameWin.repaint();
			this.advanceGameState();
			if(game.realizouTroca()){
				JOptionPane.showMessageDialog(null, (game.getNTrocas())+ " troca realizada!");
			}
		}
		else if(x.equals("SideMenu_mover")){
			MovementWindow moverTropas=new MovementWindow(terrCorr);
			moverTropas.addObserver(this);
			moverTropas.createGUI();
			if(game.ChecarObjetivo(2))
				JOptionPane.showMessageDialog(null, "Parabens!Voce Ganhou!");
		}
		else if(x.equals("SideMenu_alocarTropas")){
			SideMenuPanel p = (SideMenuPanel)o;
			int tropas[]=p.getTropasDist();
			
			switch (terrCorr.getContinente()){
			
			case AmericaDoNorte:
				if(tropas[2]>0){
					tropas[2]--;
					game.deltaT(terrCorr,1);
				}
				else{
					if(tropas[1]>0){
						tropas[1]--;
						game.deltaT(terrCorr,1);
					}
					else{
						if(tropas[0]>0){
							tropas[0]--;
							game.deltaT(terrCorr,1);
						}
					}
				}
				break;
				
			case AmericaDoSul:
				if(tropas[3]>0){
					tropas[3]--;
					game.deltaT(terrCorr,1);
				}
				else{
					if(tropas[1]>0){
						tropas[1]--;
						game.deltaT(terrCorr,1);
					}
					else{
						if(tropas[0]>0){
						
							tropas[0]--;
							game.deltaT(terrCorr,1);
						}
					}
				}
				break;
			case Africa:
				if(tropas[4]>0){
					tropas[4]--;
					game.deltaT(terrCorr,1);
				}
				else{
					if(tropas[1]>0){
						tropas[1]--;
						game.deltaT(terrCorr,1);
					}
					else{
						if(tropas[0]>0){
							tropas[0]--;
							game.deltaT(terrCorr,1);
						}
					}
				}
				break;
			case Europa:
				if(tropas[5]>0){
					tropas[5]--;
					game.deltaT(terrCorr,1);
				}
				else{
					if(tropas[1]>0){
						tropas[1]--;
						game.deltaT(terrCorr,1);
					}
					else{
						if(tropas[0]>0){
							tropas[0]--;
							game.deltaT(terrCorr,1);
						}
					}
				}
				break;
			case Asia:
				if(tropas[6]>0){
					tropas[6]--;
					game.deltaT(terrCorr,1);
				}
				else{
					if(tropas[1]>0){
						tropas[1]--;
						game.deltaT(terrCorr,1);
					}
					else{
						if(tropas[0]>0){
							tropas[0]--;
							game.deltaT(terrCorr,1);
						}
					}
				}
				break;
			case Oceania:
				if(tropas[7]>0){
					tropas[7]--;
					game.deltaT(terrCorr,1);
				}
				else{
					if(tropas[1]>0){
						tropas[1]--;
						game.deltaT(terrCorr,1);
					}
					else{
						if(tropas[0]>0){
							tropas[0]--;
							game.deltaT(terrCorr,1);
						}
					}					
				}
				break;
			}
			p.setTropasDist(tropas);
			
			
			gameWin.displayT(terrCorr.getNome().getNome(),terrCorr.getOwnerColor(),terrCorr.getNTropas());
			gameWin.repaint();
			if(tropas[0]==0&&tropas[2]==0&&tropas[3]==0&&tropas[4]==0&&tropas[5]==0&&tropas[6]==0&&tropas[7]==0){
				this.advanceGameState();
			}
			if(game.ChecarObjetivo(2))
				JOptionPane.showMessageDialog(null, "Parabens!Voce Ganhou!");
		}
		else if(x.equals("SideMenu_atacar")){
			AttackWindow atacarTerritorio=new AttackWindow(terrCorr,game.getCurrentColor());
			atacarTerritorio.addObserver(this);
			atacarTerritorio.createGUI();
		}
		else if(x.equals("SideMenu_termAtaque")){
			game.recebeCarta();
			this.advanceGameState();
		}
		else if(x.equals("SideMenu_showObj")){
			JOptionPane.showMessageDialog(null,"Objetivo:"+game.getCurrentPlayer().getObjetivo());
		}
		else if(x.equals("SideMenu_showCards")){
			CardsWindow cardsWin = new CardsWindow();
			cardsWin.createGUI();
			String s[];
			System.out.println("cartas size "+game.getCurrentPlayer().getCartas().size());
			s=new String [game.getCurrentPlayer().getCartas().size()];
			Iterator<Carta> i=	game.getCurrentPlayer().getCartas().iterator();
			int j=0;
			while(i.hasNext()){
				
				//System.out.println("String "+i.next().getFileName());
				s[j]=i.next().getFileName();
				System.out.println("String2 "+ s[j]);
				j++;
				
			}
			System.out.println("J: "+j);
			cardsWin.setCards(s);
		}
		/* end SideMenu events */
		
		/* start DicesWindow events */
		else if(x.equals("DicesWindow_dadosRolados")){
			DicesWindow d = (DicesWindow)o;
			int result[] = {0,0};
			game.SelectWinner(d.getAttackDices(), d.getDefenseDices(), result);
			d.setResult(result);
			
			source.deltaTropas(-result[0]);
			target.deltaTropas(-result[1]);
			
			if(target.getNTropas()==0){
				game.getPlayer(target.getOwnerColor()).removeTerr(target);
				if(game.getPlayer(target.getOwnerColor()).IsDead()){
					game.setDead(game.getPlayerIndex(target.getOwnerColor()));
					gameWin.setColorPanel(game.getNPlayersAlive(),game.getAliveColorOrder());
					if(game.ChecarMorteJogador(game.getPlayer(target.getOwnerColor())))
						JOptionPane.showMessageDialog(null, "Parabens!Voce Ganhou!");
				}
				game.getPlayer(source.getOwnerColor()).addTerr(target);
				source.deltaTropas(-1);
				target.deltaTropas(1);
				gameWin.repaint();
				game.setCurrentPlayerWonATerritory();
				JOptionPane.showMessageDialog(null, target.getNome().getNome()+" conquistado!");
				if(game.ChecarObjetivo(1))
					JOptionPane.showMessageDialog(null, "Parabens!Voce Ganhou!");
				
			}
			gameWin.displayT(terrCorr.getNome().getNome(),terrCorr.getOwnerColor(),terrCorr.getNTropas());
		}
		/* end DicesWindow events */
		
		/* start MapClickRedirect events */
		else if(x.equals("MapClickRedirect_click")){
			MapClickRedirect r=(MapClickRedirect)o;
			for(Territorio t:TerritorioDataBase.getLstTerritorios()){
				if(t.getPoligono().contains(r.getX(),r.getY())){

					
					gameWin.displayT(t.getNome().getNome(),t.getOwnerColor(),t.getNTropas());
					terrCorr = t;
					
					
					if(gameState==1){
						if(t.getOwnerColor()==game.getCurrentColor()){
							gameWin.enableAlocar(true);
						}
						else{
							gameWin.enableAlocar(false);
						}
					}
					if(gameState==2){
						if(t.getOwnerColor()!=game.getCurrentColor()){
							gameWin.enableAtacar(true);
						}
						else{
							gameWin.enableAtacar(false);
						}
					}
					if(gameState==3){
					//mover exercitos
						if(t.getOwnerColor()==game.getCurrentColor()){
							gameWin.enableMover(true);
						}
						else{
							gameWin.enableMover(false);
						}
											
					}//end mover exercitos
				}
			}
		}
		/* end MapClickRedirect events */
		
		/* start MovementWindow events */
		else if(x.equals("MovementWindow_moveTropas")){
			MovementWindow m=(MovementWindow)o;
			Territorio source=m.getSource();
			Territorio destination=m.getDestination();
			destination.deltaTropas(m.getNTropas());
			source.deltaTropas(-m.getNTropas());
		}
		/* end MovementWindow events */
		
		/* start AttackWindow events */
		else if(x.equals("AttackWindow_atacarTerritorio")){
			AttackWindow a=(AttackWindow)o;
			source=a.getSource();
			target=a.getTarget();
			int nAtaque=source.getNTropas()-1;
			int nDefesa=target.getNTropas();
			if(nAtaque>3){
				nAtaque=3;
			}
			if(nDefesa>3){
				nDefesa=3;
			}
			
			DicesWindow dWin=new DicesWindow();
			dWin.addObserver(this);
			dWin.setNumDices(nAtaque, nDefesa);
			dWin.createGUI();
			//destination.deltaTropas(m.getNTropas());
			//source.deltaTropas(-m.getNTropas());
		}
		/* end AttackWindow events */
		
	}
	public int getNPlayers (){
		return game.getNPlayers();
	}
	public Color[] getColorOrder(){
		return game.getColorOrder();
	}
	
	private void advanceGameState (){
		if (gameState==1){
			gameState=2;
			gameWin.enableTerminarAtacar(true);
			gameWin.setInfText("Clique num territorio inimigo para atacar");
		}
		else if (gameState==2){
			gameState=3;
			gameWin.enableAtacar(false);
			gameWin.enableTerminarAtacar(false);
			gameWin.enableNextTurn(true);
			gameWin.setInfText("Clique num territorio seu para mover topas");
			
			if(BUTTONS_ALWAYS_ENABLED==true){
				gameWin.enableAtacar(true);
				gameWin.enableTerminarAtacar(true);
			}
		}
		else if (gameState==3){
			gameState=1;
			gameWin.enableMover(false);
			gameWin.enableNextTurn(false);
			gameWin.setInfText("Clique num territorio seu para alocar tropas");
			
			if(BUTTONS_ALWAYS_ENABLED==true){
				gameWin.enableMover(true);
				gameWin.enableNextTurn(true);
			}
		}
	}
	
	/*public static void main (String[]args){
		GameController controller=new GameController();	
	}*/
}
