package optimisation.modele;

import java.util.ArrayList;
import java.util.Observable;

import optimisation.menu.Vue;

public class Modele extends Observable{
	public enum algo {
		genetique, recuit
	};

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
		// TODO Auto-generated method stub
		
	}
}
