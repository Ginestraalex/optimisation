package optimisation.algo;

import optimisation.modele.Modele;

public class RecuitSimule implements IAlgo{
	
	protected Modele modele;
	protected int evalCourant;
	protected int evalMeilleur;
	protected int iteration;
	protected int limite;
	protected double temperature;
	
	
	public RecuitSimule(Modele mod){
		this.modele = mod;
		this.evalCourant = Integer.MAX_VALUE;
		this.iteration = 0;
		this.limite = 1000;                // valeur par défaut
	}

	
	public boolean stop(){
		return ( temperature > limite );
	}
	
	
	public void diminutionTemperature(){
		temperature *= 0.999;
	}
	
}
