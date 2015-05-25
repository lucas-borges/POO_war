package GUI;
import java.awt.*;
import javax.swing.*;


public class StartWindow extends JFrame {
	final int xPadd=100;
	final int yPadd=60;
	int WIDTH, HEIGHT;
	
	public StartWindow(String title){
		super(title);
		setLayout(null);
		Container c=getContentPane();
		Dimension size;
		
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel text=new JLabel("Número de jogadores: ");
		size=text.getPreferredSize();
		text.setBounds(xPadd/2,yPadd/2,size.width,size.height);
		updateSize(xPadd+text.getWidth(),yPadd);
		c.add(text);
		
		final String[] nPlayers={"3","4","5","6"};
		JComboBox<String> nPlayerBox = new JComboBox<String>(nPlayers);
		size=nPlayerBox.getPreferredSize();
		nPlayerBox.setBounds(10+text.getX()+text.getWidth(),yPadd/2,size.width,size.height);
		updateSize(nPlayerBox.getWidth()+10,nPlayerBox.getHeight());
		c.add(nPlayerBox);
		
		JButton startBut = new JButton("Começar jogo!");
		size=startBut.getPreferredSize();
		startBut.setBounds((WIDTH-size.width)/2,HEIGHT,size.width,size.height);
		updateSize(0,startBut.getHeight());
		c.add(startBut);
		
		//WIDTH=nPlayerBox.getX()+nPlayerBox.getWidth()+xPadd;
		//HEIGHT=nPlayerBox.getHeight()+yPadd+30;
		updateSize(0,30);
		setSize(WIDTH,HEIGHT+30);
		setLocation(new Point((screenSize.width-WIDTH)/2,(screenSize.height-HEIGHT)/2));

	}
	
	private void updateSize (int x, int y){
		WIDTH+=x;
		HEIGHT+=y;
	}

}
