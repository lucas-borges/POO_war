package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class CenterMenuPanel {
	private JLabel t;
	private JPanel p;
	
	public CenterMenuPanel (){
		t=new JLabel("temp text");
	}
	
	public JPanel getGUI(){
		p=new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		p.add(t,gbc);
		
		return p;
	}
	
	public void setLabel(String text){
		t.setText(text);
	}
}
