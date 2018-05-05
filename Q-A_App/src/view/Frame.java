package view;

import javax.swing.JFrame;
import controller.Controller;

public class Frame {

	private KategorienPanel kategorien;
	private JFrame frame;
	
	public Frame(String windowName, Controller controller){
		
		this.frame = new JFrame(windowName);
		this.kategorien = new KategorienPanel(controller);
		this.frame.add(this.kategorien);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setBounds(400, 200, 500, 300);
		this.frame.setVisible(true);

	}
	
}
