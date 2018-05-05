package controller;

import java.awt.event.*;
import model.FragenModel;
import view.Frame;

public class Controller implements ActionListener{
	private FragenModel model;
	private Frame mainFrame;
	
	
	public Controller(){
		this.model = new FragenModel();
		this.mainFrame = new Frame("Fragentool", this);
	}
		
	
	@Override
	public void actionPerformed(ActionEvent ev){
		
	}
}
