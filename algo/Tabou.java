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
		for(int i = 0 ; i < modele.getNbTache() ; i++) {
			eInit.listeProc[0].add(modele.getTache(i));
		}
		
		return eInit;
	}
	
	public Etat successeur(Etat e) {
		Etat successeur = new Etat(e);
		
		
		
		return successeur;
	}
}
