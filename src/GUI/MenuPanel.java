//OBSOLETA

package GUI;

import java.awt.*;
import javax.swing.*;

public class MenuPanel {
	
	private MenuPanel(){
		
	}
	
	static public JPanel getGUI(){
		JPanel p=new JPanel();
		
		TopMenuPanel top_menu_panel=new TopMenuPanel();
		JPanel bottom_menu_panel = BottomMenuPanel.getGUI();
			
		
		/* Top menu panel */
		//top_menu_panel.setPreferredSize(new Dimension(200,768/2));
		p.add(top_menu_panel.getGUI(),BorderLayout.NORTH);
		
		/* Bottom menu panel */
		bottom_menu_panel.setPreferredSize(new Dimension(200,768/2));
		p.add(bottom_menu_panel,BorderLayout.SOUTH);
		
		
		return p;
	}
}
