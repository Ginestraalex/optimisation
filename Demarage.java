package opti;


import java.awt.Dimension;

import javax.swing.JFrame;

public class Demarage extends JFrame{

	public Demarage() {
		super("Optimisation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(720, 480));
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
	public static void main(String... args) {
		Demarage d = new Demarage();
	}
}
