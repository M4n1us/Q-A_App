package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import controller.Controller;

/**
 * Beinhaltet die Erstellung und Benennung der Kategorien und ButtonCommands
 * @author Manuel Kisser
 * @version 05-05-2018
 * TODO: get kategorieNamen from config file, via model
 */
public class KategorienPanel extends JPanel{
	private Controller controller;
	
	private String[] kategorieNamen = {"Mechanik", "Physik", "Thermodynamik", "Kräfte", "Fünf", "Sechs"};
	
	KategorienPanel(Controller controller){
		this.controller = controller;
		this.setLayout(new BorderLayout());
		
		JPanel content = createKategorienPanel();
		JScrollPane pane = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.add(pane, BorderLayout.CENTER);
	}
	
	public JPanel createKategorienPanel(){
		//JPanel kategorien = new JPanel(new GridLayout(this.kategorieNamen.length, 1));
		JPanel kategorien = new JPanel();
		kategorien.setLayout(new BoxLayout(kategorien, BoxLayout.PAGE_AXIS));
		
		for(int i = 0; i < this.kategorieNamen.length; i++){
			JPanel temp = createKategorie(this.kategorieNamen[i]);
			if(i < this.kategorieNamen.length -1) temp.setBorder(new EmptyBorder(0, 0, 10, 0));
			kategorien.add(temp);
		}
		
		return kategorien;
	}
	
	/*
	 * Generiert JPanel für einzelne Kategorien, Actioncommands lauten Kategoriename+Buttonfunktion
	 */
	public JPanel createKategorie(String kategorieName){
		//JPanel kategorie = new JPanel(new GridLayout(1,3));
		JPanel kategorie = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		
		JLabel name = new JLabel(kategorieName, JLabel.CENTER);
		
		JButton zufallsFrage = new JButton("Generiere Zufallsfrage");
		
		JButton bearbeiten = new JButton("Bearbeite Kategorie");
		
		kategorie.add(name);
		
		
		zufallsFrage.addActionListener(this.controller);
		zufallsFrage.setActionCommand(kategorieName + "Zufall");
		kategorie.add(zufallsFrage);
		
		
		bearbeiten.addActionListener(this.controller);
		bearbeiten.setActionCommand(kategorieName + "Bearbeiten");
		kategorie.add(bearbeiten);
		
		return kategorie;
	}
	
}
