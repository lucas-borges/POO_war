package Game;

import GUI.AttackWindow;
import GUI.DicesWindow;
import GUI.MainWindow;
import GUI.StartWindow;
import GUI.SideMenuPanel;
import GUI.MovementWindow;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import controller.MapClickRedirect;
import controller.Territorio;

public class GameController implements Observer {
	private Game game;
	/**/private MainWindow gameWin;
	/**/private StartWindow startWin;
		private Territorio terrCorr;
		private int gameState=1;
		Territorio source;
		Territorio target;
	
	public GameController(){
		/**/gameWin=new MainWindow();
		/**/startWin=new StartWindow();
		
		/**/startWin.addObserver(this);
		/**/gameWin.addObserver(this);
		
		/**/gameWin.createGUI();
		/**/startWin.createGUI();
	}
	
	
	
	public void update (Observable o, Object arg){
		String x=(String)arg;
		System.out.println("entrou controller update");
		
		if(x.equals("startGame")){
			int nPlayers=((StartWindow)o).getComboValue();
			game=new Game(nPlayers);
			
			System.out.println("Jogo criado com " + game.getNPlayers());
			/**/gameWin.setColorPanel(game.getNPlayers(),game.getColorOrder());
			gameWin.repaint();
			
			/**/game.randomizeStart();
			/**///game.playerTerr(0);
				game.DistribuirObjetivos();
				
			JOptionPane.showMessageDialog(frame, "Os Objetivos foram distribuídos");
			
			gameWin.setTropasDist(game.DistribuirTropas());
		}
		else if(x.equals("nextTurn")){
			game.nextTurn();
			SideMenuPanel p = (SideMenuPanel)o;
			p.setTropasDist(game.DistribuirTropas());
			System.out.println("Turno: " + game.getTurn());
			System.out.println("Jogador: " + game.getCurrentPlayer());
			gameWin.nextTurn();
			gameWin.repaint();
			gameState=1;
			gameWin.enableMover(false);
		}

		/*else if(x.equals("RollDices")){
			SideMenuPanel p = ((SideMenuPanel)o);
			p.createGUIDices();
		}*/
		else if(x.equals("DadosRolados")){
			System.out.println("entrou dados rolados");
			DicesWindow d = (DicesWindow)o;
			int result[] = {0,0};
			System.out.printf("%d",result[0]);
			game.SelectWinner(d.getAttackDices(), d.getDefenseDices(), result);
			d.setResult(result);
			
			source.deltaTropas(-result[0]);
			target.deltaTropas(-result[1]);
			
			if(target.getNTropas()==0){
				target.setOwnerColor(source.getOwnerColor());
				source.deltaTropas(-1);
				target.deltaTropas(1);
				JOptionPane.showMessageDialog(null, target.getNome().getNome()+" conquistado!");
			}
			gameWin.displayT(terrCorr.getNome().getNome(),terrCorr.getOwnerColor(),terrCorr.getNTropas());
			
			
		}
		else if(x.equals("click")){
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
		else if(x.equals("moveTropas")){
			MovementWindow m=(MovementWindow)o;
			Territorio source=m.getSource();
			Territorio destination=m.getDestination();
			destination.deltaTropas(m.getNTropas());
			source.deltaTropas(-m.getNTropas());
		}
		else if(x.equals("Mover")){
			MovementWindow moverTropas=new MovementWindow(terrCorr);
			moverTropas.addObserver(this);
			moverTropas.createGUI();
		}

		else if(x.equals("AlocarTropas")){
			SideMenuPanel p = (SideMenuPanel)o;
			p.setTropasDist(p.getTropasDist()-1);
			game.deltaT(terrCorr,1);
			gameWin.displayT(terrCorr.getNome().getNome(),terrCorr.getOwnerColor(),terrCorr.getNTropas());
			if(p.getTropasDist()==0){
				gameState=2;
				gameWin.enableTerminarAtacar(true);
			}
		}
		else if(x.equals("Atacar")){
			AttackWindow atacarTerritorio=new AttackWindow(terrCorr,game.getCurrentColor());
			atacarTerritorio.addObserver(this);
			atacarTerritorio.createGUI();
		}
		else if(x.equals("Atacar Territorio")){
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
		else if(x.equals("TermAtaque")){
			gameState=3;
			gameWin.enableAtacar(false);
			gameWin.enableTerminarAtacar(false);
		}
	}
	public int getNPlayers (){
		return game.getNPlayers();
	}
	public Color[] getColorOrder(){
		return game.getColorOrder();
	}
	
	public static void main (String[]args){
		GameController controller=new GameController();
		
	}
}
