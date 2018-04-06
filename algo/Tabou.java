package optimisation.algo;

import java.util.ArrayList;

import optimisation.modele.Etat;
import optimisation.modele.Modele;

public class Tabou implements IAlgo{

	public Modele modele;
	public ArrayList<Etat> etatDejaTest;
	
	
	public Tabou(Modele mod) {
		modele = mod;
	}
	
	public Etat rechercher(int critere) {
		etatDejaTest = new ArrayList<Etat>();
		Etat eInit = new Etat(modele);
		for(int i = 0 ; i < modele.getNbTache() ; i++) {
			eInit.listeProc[0].add(modele.getTache(i));
		}
		Etat etatSol = eInit;
		etatDejaTest.add(etatSol);
		
		ArrayList<Etat> successeurs;
		
		int i = 0;
		boolean aDesSuccesseur = false;
		
		while(critere >= etatSol.getDureeTotale()) {
			successeurs = Tabou.successeurs(etatSol, i, etatSol.listeProc[i].getNbTaches()-1);
			aDesSuccesseur = false;
			for(Etat e : successeurs) {
				if(!this.estDejaTeste(e)) {
					this.etatDejaTest.add(e);
					if(e.getDureeTotale() < etatSol.getDureeTotale()) {
						etatSol = e;
					}
					aDesSuccesseur = true;
				}
			}
			if(!aDesSuccesseur) {
				i++;
				if(i >= etatSol.listeProc.length) {
					return etatSol;
				}
			}
			else {
				i = 0;
			}
		}
		
		return etatSol;
	}
	
	
	public boolean estDejaTeste(Etat e) {
		if(this.etatDejaTest == null) {
			return false;
		}
		for(Etat eTemp : this.etatDejaTest) {
			if(eTemp.estEgal(e)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Etat> successeurs(Etat e, int numProcSupp, int numTacheDeplacer) {
		ArrayList<Etat> successeurs = new ArrayList<Etat>();
		for(int i = 0 ; i < e.getNbProcesseur() ; i++) {
			if(numProcSupp != i) {
				Etat eTemp = new Etat(e);
				eTemp.deplaceTache(numProcSupp, numTacheDeplacer, i);
				successeurs.add(eTemp);
			}
		}		
		return successeurs;
	}
}
