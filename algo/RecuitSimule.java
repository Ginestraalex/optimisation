package optimisation.algo;

import java.util.ArrayList;

import optimisation.modele.Etat;
import optimisation.modele.Modele;
import optimisation.modele.Processeur;
import optimisation.modele.Tache;

public class RecuitSimule implements IAlgo{
	
	protected Modele modele;
	protected ArrayList<Processeur> listeCourant;
	protected ArrayList<Processeur> listeMeilleur;
	protected int limiteSup;
	protected int limiteInf;
	protected double temperature;
	protected Etat etat;
	
	
	public RecuitSimule(Modele mod){
		this.modele = mod;
		this.listeCourant = new ArrayList<Processeur>();
		this.listeMeilleur = new ArrayList<Processeur>();
		this.limiteSup = 5000;
		this.limiteInf = 0;  
		this.temperature = 4000; // valeur par défaut
	}
	
	
	
	public RecuitSimule(double temp , Modele mod){
		this.modele = mod;
		this.listeCourant = new ArrayList<Processeur>();
		this.listeMeilleur = new ArrayList<Processeur>();
		this.limiteSup = 5000;
		this.limiteInf = 0;  
		this.temperature = temp;  // valeur température entrée par utilisateur
	}

	
	public void recuitSimule(){
		double probabilite , aleatoire;
		int valeurEtat = etat.getDureeTotale();
		Etat eta = this.etat.successeur();
		int valeurEta = eta.getDureeTotale();
		int res = valeurEtat - valeurEta ;
		if(res < 0) {
			aleatoire = Math.random();
			probabilite = Math.exp(res/this.temperature);
			if(aleatoire < probabilite) {
				this.etat = eta ;
			}
		} else {
			this.etat = eta;
		}
		
	}
	
	public boolean stop(){
		return ( temperature > limiteSup );
	}
	
	
	public void diminutionTemperature(){
		temperature *= 0.999;
	}
	
}
