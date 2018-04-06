package optimisation.algo;

import optimisation.modele.Etat;
import optimisation.modele.Modele;

public class Tabou implements IAlgo{

	public Modele modele;
	
	
	public Tabou(Modele mod) {
		modele = mod;
	}
	
	public Etat rechercher() {
		Etat eInit = new Etat(modele);
		
		return eInit;
	}
	
	public Etat successeur(Etat e) {
		Etat successeur = new Etat(e);
		
		
		
		return successeur;
	}
}
