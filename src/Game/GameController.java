package Game;

import GUI.AttackWindow;
import GUI.DicesWindow;
import GUI.MainWindow;
import GUI.StartWindow;
import GUI.SideMenuPanel;
import GUI.MovementWindow;

import java.awt.*;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.MapClickRedirect;
import controller.Territorio;


public class GameController implements Observer {
	public static final boolean DEV_MODE = true;
	public static final boolean BUTTONS_ALWAYS_ENABLED = true;
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
		
		/* start StartWindow events */
		if(x.equals("StartWindow_startGame")){
			int nPlayers=((StartWindow)o).getComboValue();
			game=new Game(nPlayers);
			
			System.out.println("Jogo criado com " + game.getNPlayers());
			gameWin.setColorPanel(game.getNPlayers(),game.getColorOrder());
			gameWin.repaint();
			
			game.randomizeStart();
			
			game.DistribuirObjetivos();
			gameWin.setTropasDist(game.DistribuirTropas());
			gameWin.setInfText("Clique num territorio seu para alocar tropas");
				
			JOptionPane.showMessageDialog(null, "Os objetivos foram distribuídos. \nClique em ver objetivo para saber qual é o seu.");
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
				gameWin.repaint();
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
			p.setTropasDist(p.getTropasDist()-1);
			game.deltaT(terrCorr,1);
			gameWin.displayT(terrCorr.getNome().getNome(),terrCorr.getOwnerColor(),terrCorr.getNTropas());
			if(p.getTropasDist()==0){
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
			this.advanceGameState();
		}
		else if(x.equals("SideMenu_showObj")){
			JOptionPane.showMessageDialog(null,"Objetivo:"+game.getCurrentPlayer().getObjetivo());
		}
		else if(x.equals("SideMenu_showCards")){
			JOptionPane.showMessageDialog(null,"Cartas: ");
		}
		/* end SideMenu events */
		
		/* start DicesWindow events */
		else if(x.equals("DicesWindow_dadosRolados")){
			System.out.println("entrou dados rolados");
			DicesWindow d = (DicesWindow)o;
			int result[] = {0,0};
			System.out.printf("%d",result[0]);
			game.SelectWinner(d.getAttackDices(), d.getDefenseDices(), result);
			d.setResult(result);
			
			source.deltaTropas(-result[0]);
			target.deltaTropas(-result[1]);
			
			if(target.getNTropas()==0){
				game.getPlayer(target.getOwnerColor()).removeTerr(target);
				game.getPlayer(source.getOwnerColor()).addTerr(target);
				source.deltaTropas(-1);
				target.deltaTropas(1);
				gameWin.repaint();
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
	
	public static void main (String[]args){
		GameController controller=new GameController();	
	}
}
