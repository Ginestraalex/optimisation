package optimisation.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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

public class VueTabou extends JPanel implements Observer{

	private VueTaches vt;
	private JButton lancer;
	private JLabel critere;
	private JTextField critereVal;
	private JPanel jp;
	
	private VueInformation vi;
	private Modele mod;


	public VueTabou(Modele mod) {
		this.mod = mod;
		this.vt = new VueTaches(mod, Modele.algo.tabou);
		vi = new VueInformation(mod, Modele.algo.tabou);
		lancer = new JButton("Lancer");
		lancer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mod.demarrerAlgo(Modele.algo.tabou);
			}
		});
	
		
		critere = new JLabel("Taille du critere: ");
		critereVal = new JTextField("");
		critereVal.getDocument().addDocumentListener(new DocumentListener() {
			
			 @Override
			public void removeUpdate(DocumentEvent e) {
				String data = critereVal.getText();
				update(data);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String data = critereVal.getText();
				update(data);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
		        String data = critereVal.getText();	
		        update(data);
			}
			
			public int update(String s){
			
				return 0;
			}
			
		});
		this.setLayout(new BorderLayout());
		jp = new JPanel();
		jp.setLayout(new GridLayout(1, 3));
		jp.add(critere);
		jp.add(critereVal);
		jp.add(lancer);
		this.add(vt,BorderLayout.CENTER);
		this.add(jp,BorderLayout.NORTH);
		this.add(vi,BorderLayout.SOUTH);
		mod.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		
	}
}

