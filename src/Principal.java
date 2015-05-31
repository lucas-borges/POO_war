
import java.util.Observable;
import java.util.Observer;

import GUI.*;	
import Game.*;

public class Principal  {
	public static void main (String[]args){
		GameFacade facade=new GameFacade();
		MainWindow gameWin=new MainWindow();
		StartWindow startWin=new StartWindow();
		
		startWin.addObserver(facade);
		gameWin.addObserver(facade);
		
		gameWin.createGUI();
		startWin.createGUI();
	}
}
