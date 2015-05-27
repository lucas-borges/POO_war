
import GUI.*;	
import Game.*;

public class Principal {
	public static void main (String[]args){
		MainWindow gameWin=new MainWindow();
		StartWindow startWin=new StartWindow();
		
		gameWin.createGUI();
		startWin.createGUI();
		
		
	}
}
