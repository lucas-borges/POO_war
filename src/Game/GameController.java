package Game;

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
			/**/game.playerTerr(0);
			
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
		}

		else if(x.equals("RollDices")){
			SideMenuPanel p = ((SideMenuPanel)o);
			p.createGUIDices();
		}
		else if(x.equals("DadosRolados")){
			System.out.println("entrou dados rolados");
			DicesWindow d = (DicesWindow)o;
			int result[] = {0,0};
			System.out.printf("%d",result[0]);
			game.SelectWinner(d.getAttackDices(), d.getDefenseDices(), result);
			d.setResult(result);
		}
		else if(x.equals("click")){
			MapClickRedirect r=(MapClickRedirect)o;
			for(Territorio t:TerritorioDataBase.getLstTerritorios()){
				if(t.getPoligono().contains(r.getX(),r.getY())){
//<<<<<<< HEAD
					
					gameWin.displayT(t.getNome().getNome(),t.getOwnerColor(),t.getNTropas());
					terrCorr = t;
					
					
					if(gameState==1){
						if(t.getOwnerColor()==game.getCurrentColor()){
							//JOptionPane.showMessageDialog(null,"dono");
							gameWin.enableAlocar(true);
						}
						else{
							//JOptionPane.showMessageDialog(null,"adversario");
							gameWin.enableAlocar(false);
						}
					}
					if(gameState==2){
					}
					if(gameState==3){
					
					//mover exercitos
						if(t.getOwnerColor()==game.getCurrentColor()){
							//JOptionPane.showMessageDialog(null,"dono");
							gameWin.enableMover(true);
						}
						else{
							//JOptionPane.showMessageDialog(null,"adversario");
							gameWin.enableMover(false);
						}
											
					}
					//end mover exercitos
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
				gameState=3;
			}
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
