
import GUI.*;	
import Game.*;

public class Principal {
	public static void main (String[]args){
		MainWindow gameWin=new MainWindow("WAR");
		StartWindow startWin=new StartWindow("Configura��es");
		
		gameWin.setVisible(true);
		startWin.setVisible(true);
		
		
	}
}
