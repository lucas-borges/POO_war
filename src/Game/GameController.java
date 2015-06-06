package Game;

import GUI.MainWindow;
import GUI.StartWindow;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer {
	private Game game;
	
	/**/private MainWindow gameWin;
	/**/private StartWindow startWin;
	
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
		}
		else if(x.equals("nextTurn")){
			game.nextTurn();
			System.out.println("Turno: " + game.getTurn());
			System.out.println("Jogador: " + game.getCurrentPlayer());
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
