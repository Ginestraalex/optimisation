package optimisation.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import optimisation.modele.Modele;

public class MenuBar extends JMenuBar implements Vue{
	
	private JMenu menu;
	private JMenuItem valeurTemperature;
	private JMenuItem tailleListeTabou;
	private JMenuItem taillePopulation;
	private JMenuItem probabiliteMutation;
	private Modele modele;
	
	public MenuBar(Modele mod) {
		menu = new JMenu("Parametres");
		valeurTemperature = new JMenuItem("Valeur temperature depart");
		tailleListeTabou = new JMenuItem("Taille de la liste");
		taillePopulation = new JMenuItem("Taille de la population");
		probabiliteMutation = new JMenuItem("Probabilite de mutation");
		modele = mod;
		
		valeurTemperature.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String res = (String)JOptionPane.showInputDialog(null, "Choisissez la temperature initale", "Choix temperture", JOptionPane.QUESTION_MESSAGE);
				if(res != null) {
					modele.setTemperature(Integer.parseInt(res));
				}
			}
		});
		
		tailleListeTabou.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String res = (String)JOptionPane.showInputDialog(null, "Choisissez la taille de la liste tabou", "Choix taille liste", JOptionPane.QUESTION_MESSAGE);
				if(res != null) {
					modele.setTailleListeTabou(Integer.parseInt(res));
				}
			}
		});
		
		taillePopulation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String res = (String)JOptionPane.showInputDialog(null, "Choisissez la taille de la population", "Choix taille population", JOptionPane.QUESTION_MESSAGE);
				if(res != null) {
					modele.setTaillePopulation(Integer.parseInt(res));
				}				
			}
		});
		
		probabiliteMutation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String res = (String)JOptionPane.showInputDialog(null, "Choisissez la probabilite de mutation", "Choix probabilite", JOptionPane.QUESTION_MESSAGE);
				if(res != null) {
					modele.setProbabiliteMutation(Integer.parseInt(res));
				}						
			}
		});
		
		add(menu);
		menu.add(valeurTemperature);
		menu.add(tailleListeTabou);
		menu.add(taillePopulation);
		menu.add(probabiliteMutation);
		
	}

	@Override
	public void maj() {
		// TODO Auto-generated method stub
		
	}
}
