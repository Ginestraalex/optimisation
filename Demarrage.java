package optimisation;


import java.awt.Dimension;

import javax.swing.JFrame;

import optimisation.menu.MenuBar;
import optimisation.modele.Modele;

public class Demarrage extends JFrame{


	public Demarrage() {
		super("Optimisation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(720, 480));
		setLocationRelativeTo(null);
		
		Modele mod = new Modele();
		MenuBar menu = new MenuBar(mod);
		mod.addVue(menu);
		setJMenuBar(menu);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String... args) {
		Demarrage dem = new Demarrage();
	}
}
