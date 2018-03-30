package optimisation.modele;

import java.util.ArrayList;

import optimisation.menu.Vue;

public class Modele {

	private ArrayList<Vue> listeVues;
	private int temperature;
	private int tailleListeTabou;
	private int taillePopulation;
	private int probabiliteMutation;
	private ArrayList<Processeur> listeProcess;
	private Tache[] tabTache;
	
	
	public Modele() {
		listeVues = new ArrayList<Vue>();
		temperature = 0;
		tailleListeTabou = 0;
		taillePopulation = 0;
		probabiliteMutation = 0;
	}
	
	public Modele(Vue... vues) {
		listeVues = new ArrayList<Vue>();
		for(Vue v : vues) {
			listeVues.add(v);
		}
		
		temperature = 0;
		tailleListeTabou = 0;
		taillePopulation = 0;
		probabiliteMutation = 0;
	}
	
	public void addVue(Vue v) {
		listeVues.add(v);
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public int getTailleListeTabou() {
		return tailleListeTabou;
	}
	
	public int getTaillePopulation() {
		return taillePopulation;
	}
	
	public int getProbabiliteMutation() {
		return probabiliteMutation;
	}
	
	public void setTemperature(int t) {
		temperature = t;
	}
	
	public void setTailleListeTabou(int t) {
		tailleListeTabou = t;
	}
	
	public void setTaillePopulation(int t) {
		taillePopulation = t;
	}
	
	public void setProbabiliteMutation(int p) {
		probabiliteMutation = p;
	}
}
