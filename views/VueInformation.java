package optimisation.views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import optimisation.modele.Modele;

public class VueInformation extends JPanel implements Observer{
	
	private JLabel ite;
	private JLabel fonctionObj;
	private Modele mod;
	private Modele.algo algo;
	
	public VueInformation(Modele mod, Modele.algo algo) {
		super();
		this.mod = mod;
		this.mod.addObserver(this);
		this.algo = algo;
		this.ite = new JLabel("nombre d'itérations : "); 
		this.fonctionObj = new JLabel("valeur de la fonction Objectif : ");
		this.add(ite);
		this.add(fonctionObj);
	}
	
	public void update(Observable o, Object arg) {
		switch (algo) {
		case tabou:
			ite.setText("nombre d'itérations : " + mod.getIterationGenetique());
			fonctionObj.setText("valeur de la fonction Objectif : " + mod.getTachesGenetique());
			break;
		case recuit:
			ite.setText("nombre d'itérations : " + mod.getIterationGenetique());
			fonctionObj.setText("valeur de la fonction Objectif : " + mod.getTachesRecuit());
			break;
		}
	}
	
}

