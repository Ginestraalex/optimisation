package optimisation.algo;

import optimisation.modele.Modele;

public class AlgoGénétique implements IAlgo{
	
	protected Modele modele;
	protected int population;
	protected int iteration;
	protected int pourcentMutation;
	
	
	public AlgoGénétique(Modele mod){
		this.modele = mod;
	}
	
	
	public boolean stop(){
		return ( iteration < 1000 ) ;
	}

}
