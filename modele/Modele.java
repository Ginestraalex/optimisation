package optimisation.modele;

import java.util.ArrayList;
import java.util.Observable;

import optimisation.algo.Tabou;
import optimisation.algo.RecuitSimule;
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
	protected StringBuilder recuit;
	protected int compt;
	
	
	public Modele() {
		recuit=new StringBuilder();
		compt=0;
		listeVues = new ArrayList<Vue>();
		temperature = 0;
		critereTabou = Integer.MAX_VALUE;
		taillePopulation = 0;
		probabiliteMutation = 0;
		initisalisationTache();
	}
	
	public Modele(Vue... vues) {
		recuit=new StringBuilder();
		compt=0;
		listeVues = new ArrayList<Vue>();
		for(Vue v : vues) {
			listeVues.add(v);
		}
		
		temperature = 0;
		critereTabou = Integer.MAX_VALUE;
		taillePopulation = 0;
		probabiliteMutation = 0;
		initisalisationTache();
	}
	
	public void initisalisationTache() {
		listeProcess = new ArrayList<Processeur>();
		listeProcess.add(new Processeur());
		listeProcess.add(new Processeur());
		tabTache = new Tache[6];
		tabTache[0] = new Tache(5, 1);
		tabTache[1] = new Tache(4, 2);
		tabTache[2] = new Tache(3, 3);
		tabTache[3] = new Tache(6, 4);
		tabTache[0] = new Tache(5, 5);
		tabTache[0] = new Tache(7, 6);
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

	public Etat demarrerAlgo(algo enm) {
		if(enm == algo.tabou) {
			Tabou tabou = new Tabou(this);
			return tabou.rechercher(critereTabou);
		}
		else {
			return null;
		}
	}
	
	public String demarrerAlgo2(algo enm) {
		if(enm==algo.recuit) {
			RecuitSimule recuitS = new RecuitSimule(temperature, this);
			this.setRecuit(recuitS.recuitSimule());
			return recuit.toString();
		}
		else {
			return null;
		}
	}

	public void setIteration(int compteur) {
		// TODO Auto-generated method stub
		this.compt = compteur;
	}
	
	public int getIteration() {
		return compt;
	}
	
	public void setAction(StringBuilder sp) {
		recuit.append(sp);
	}

	public void setRecuit(ArrayList<Processeur> liste) {
		// TODO Auto-generated method stub
		for ( Processeur p : liste) {
			recuit.append("\nproc  " + p.getDureeTache());
			for ( Tache t : p.getListe()) {
				recuit.append("   Tache  " + t.getTime());
			}
		}
	}
	
	public StringBuilder getRecuit() {
		return recuit;
	}

}
