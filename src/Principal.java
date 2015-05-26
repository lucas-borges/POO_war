
import GUI.*;	
import Game.*;

public class Principal {
	public static void main (String[]args){
		MainWindow gameWin=new MainWindow("WAR");
		StartWindow startWin=new StartWindow("Configurações");
		
		gameWin.setVisible(true);
		startWin.setVisible(true);
		
		
	}
}
