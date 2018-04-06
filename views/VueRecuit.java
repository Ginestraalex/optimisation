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
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

import optimisation.controller.Ecouteur;
import optimisation.controller.Ecouteur;
import optimisation.modele.Modele;

public class VueRecuit extends JPanel implements Observer {

	private VueTaches vt;
	private JButton lancer;
	private JLabel temp;
	private JTextField tempVal;
	private JPanel jp;
	private VueInformation vi;
	private Modele mod;

	// TODO RAJOUTER LE MODELE

	public VueRecuit(Modele mod) {
		this.mod = mod;
		this.vt = new VueTaches(mod, Modele.algo.recuit);
		vi = new VueInformation(mod, Modele.algo.recuit);
		lancer = new JButton("Lancer");
		lancer.setEnabled(false);
		//lancer.addActionListener((ActionListener) new Ecouteur(mod, Modele.algo.recuit));
		temp = new JLabel("Température: ");
		tempVal = new JTextField();
		tempVal.getDocument().addDocumentListener(new DocumentListener() {
			
			 @Override
			public void removeUpdate(DocumentEvent e) {
				String data = tempVal.getText();
				update(data);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String data = tempVal.getText();
				update(data);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
		        String data = tempVal.getText();	
		        update(data);
			}
			
			public int update(String s){
				int i;
				try{
					i = Integer.parseInt(s);
					mod.setTemperature(i);
					mod.setTmpCorrect(true);
				}catch(NumberFormatException e){
					i = 0;
					mod.setTmpCorrect(false);
				} 
				return i;
			}
			
		});
		this.setLayout(new BorderLayout());
		jp = new JPanel();
		jp.setLayout(new GridLayout(1, 2));
		jp.add(temp);
		jp.add(tempVal);
		jp.add(lancer);
		this.add(vt, BorderLayout.CENTER);
		this.add(jp, BorderLayout.NORTH);
		this.add(vi, BorderLayout.SOUTH);
		mod.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	
	}
}
