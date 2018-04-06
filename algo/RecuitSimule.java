package optimisation.algo;

import java.util.ArrayList;

import optimisation.modele.Modele;
import optimisation.modele.Processeur;

public class RecuitSimule implements IAlgo{
	
	protected Modele modele;
	protected ArrayList<Processeur> evalCourant;
	protected ArrayList<Processeur> evalMeilleur;
	protected int limiteSup;
	protected int limiteInf;
	protected double temperature;
	
	
	public RecuitSimule(Modele mod){
		this.modele = mod;
		this.evalCourant = new ArrayList<Processeur>();
		this.evalMeilleur = new ArrayList<Processeur>();
		this.limiteSup = 5000;
		this.limiteInf = 0;  
		this.temperature = 4000; // valeur par défaut
	}
	
	
	
	public RecuitSimule(double temp , Modele mod){
		this.modele = mod;
		this.evalCourant = new ArrayList<Processeur>();
		this.evalMeilleur = new ArrayList<Processeur>();
		this.limiteSup = 5000;
		this.limiteInf = 0;  
		this.temperature = temp;  // valeur température entrée par utilisateur
	}

	
	public boolean stop(){
		return ( temperature > limiteSup );
	}
	
	
	public void diminutionTemperature(){
		temperature *= 0.999;
	}
	
}
