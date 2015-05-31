//teste


package Game;

import GUI.MainWindow;
import GUI.StartWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class GameFacade implements Observer {
	private Game game;
	
	public GameFacade(){

	}
	
	public void update (Observable o, Object arg){
		String x=(String)arg;
		System.out.println("entrou facade update");
		if(x.equals("startGame")){
			int nPlayers=((StartWindow)o).getComboValue();
			game=new Game(nPlayers);
			System.out.println("Jogo criado com " + game.getNPlayers());
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
}
