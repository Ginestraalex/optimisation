package optimisation;


import java.awt.Dimension;

import javax.swing.JFrame;

import optimisation.menu.MenuBar;
import optimisation.modele.Modele;

public class Demarage extends JFrame{

	public Demarage() {
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
		Demarage d = new Demarage();
		
	}
}
