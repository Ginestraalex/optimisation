package optimisation.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import optimisation.controller.Ecouteur;
import optimisation.modele.Modele;

public class VueGenetique extends JPanel implements Observer{

	private VueTaches vt;
	private JButton lancer;
	private JLabel mutation;
	private JLabel population;
	private JTextField mutaVal;
	private JTextField popVal;
	private JPanel jp;
	private VueInformation vi;
	private Modele mod;

	// TODO RAJOUTER LE MODELE

	public VueGenetique(Modele mod) {
		this.mod = mod;
		this.vt = new VueTaches(mod, Modele.algo.genetique);
		vi = new VueInformation(mod, Modele.algo.genetique);
		lancer = new JButton("Lancer");
		lancer.setEnabled(false);
		//lancer.addActionListener((ActionListener) new Ecouteur(mod, Modele.algo.genetique));
		mutation = new JLabel("Probabilité de mutation (%): ");
		mutaVal = new JTextField("");
		mutaVal.getDocument().addDocumentListener(new DocumentListener() {
			
			 @Override
			public void removeUpdate(DocumentEvent e) {
				String data = mutaVal.getText();
				update(data);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String data = mutaVal.getText();
				update(data);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
		        String data = mutaVal.getText();	
		        update(data);
			}
			
			public int update(String s){
					return 0;
			}
			
		});
		population = new JLabel("Taille de la population: ");
		popVal = new JTextField("");
		popVal.getDocument().addDocumentListener(new DocumentListener() {
			
			 @Override
			public void removeUpdate(DocumentEvent e) {
				String data = popVal.getText();
				update(data);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String data = popVal.getText();
				update(data);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
		        String data = popVal.getText();	
		        update(data);
			}
			
			public int update(String s){
			
				return 0;
			}
			
		});
		this.setLayout(new BorderLayout());
		jp = new JPanel();
		jp.setLayout(new GridLayout(1, 4));
		jp.add(mutation);
		jp.add(mutaVal);
		jp.add(population);
		jp.add(popVal);
		jp.add(lancer);
		this.add(vt,BorderLayout.CENTER);
		this.add(jp,BorderLayout.NORTH);
		this.add(vi,BorderLayout.SOUTH);
		mod.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		
	}
}

