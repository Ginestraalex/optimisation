package optimisation.modele;

import java.util.ArrayList;
import java.util.Observable;

import optimisation.algo.Tabou;
import optimisation.menu.Vue;

public class Modele extends Observable{
	public enum algo {
		tabou, recuit
	};

	private ArrayList<Vue> listeVues;
	private int temperature;
	private int critereTabou;
	private int taillePopulation;
	private int probabiliteMutation;
	private ArrayList<Processeur> listeProcess;
	private Tache[] tabTache;
	
	
	public Modele() {
		listeVues = new ArrayList<Vue>();
		temperature = 0;
		critereTabou = Integer.MAX_VALUE;
		taillePopulation = 0;
		probabiliteMutation = 0;
	}
	
	public Modele(Vue... vues) {
		listeVues = new ArrayList<Vue>();
		for(Vue v : vues) {
			listeVues.add(v);
		}
		
		temperature = 0;
		critereTabou = Integer.MAX_VALUE;
		taillePopulation = 0;
		probabiliteMutation = 0;
	}
	
	public void addVue(Vue v) {
		listeVues.add(v);
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public int getCritereTabou() {
		return critereTabou;
	}
	
	public int getTaillePopulation() {
		return taillePopulation;
	}
	
	public int getProbabiliteMutation() {
		return probabiliteMutation;
	}
	
	public int getNbProcesseur() {
		return listeProcess.size();
	}
	
	public int getNbTache() {
		return tabTache.length;
	}
	
	public Tache getTache(int index) {
		return tabTache[index];
	}
	
	public void setTemperature(int t) {
		temperature = t;
	}
	
	public void setCritereTabou(int c) {
		critereTabou = c;
	}
	
	public void setTaillePopulation(int t) {
		taillePopulation = t;
	}
	
	public void setProbabiliteMutation(int p) {
		probabiliteMutation = p;
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public String getIterationGenetique() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getTachesGenetique() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTmpCorrect(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public Object getTachesRecuit() {
		// TODO Auto-generated method stub
		return null;
	}

	public void demarrerAlgo(algo enm) {
		if(enm == algo.tabou) {
			Tabou tabou = new Tabou(this);
			Etat eTemp = tabou.rechercher(critereTabou);
		}
	}
}
