//teste


package Game;

import GUI.MainWindow;
import GUI.StartWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GameFacade implements ActionListener {
	private Game game;
	private MainWindow gameWin;
	private StartWindow startWin;
	
	public GameFacade(){
		gameWin=new MainWindow();
		startWin=new StartWindow();
		
		gameWin.createGUI();
		startWin.createGUI();
	}
	
	public void actionPerformed(ActionEvent e){
		StartWindow.topLevelFrame.dispose();
		int i =	Integer.parseInt((String)nPlayerBox.getSelectedItem());
		JOptionPane.showMessageDialog(null,"Que começe o jogo! ("+i+")");
	}
}
