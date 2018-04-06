package optimisation.views;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import optimisation.modele.Modele;

public class VueTaches extends JPanel implements Observer {


	private Modele mod;
	private Modele.algo algo;
	private int i, j;

	// TODO ne pas oublier le modele

	public VueTaches(Modele mod, Modele.algo algo) {
		super();
		this.algo = algo;
		this.mod = mod;
		mod.addObserver(this);
		this.setPreferredSize(new Dimension(500,500));
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	
	}

}

