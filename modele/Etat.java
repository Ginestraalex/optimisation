package optimisation.modele;

public class Etat {
	
	public Modele modele;
	public Processeur[] listeProc;
	
	public Etat(Modele mod) {
		modele = mod;
		listeProc = new Processeur[modele.getNbProcesseur()];
		for(int i = 0 ; i < listeProc.length ; i++) {
			listeProc[i] = new Processeur();
		}
	}
	
	public Etat(Etat e) {
		modele = e.modele;
		listeProc = new Processeur[e.listeProc.length];
		for(int i = 0 ; i < listeProc.length ; i++) {
			listeProc[i] = new Processeur();
			for(int j = 0 ; j < e.listeProc[i].getNbTaches() ; j++) {
				listeProc[i].add(e.listeProc[i].getTache(j));
			}
		}
	}
	
	
	public int getNbProcesseur() {
		return listeProc.length;
	}
	

	public void setTache(Tache task, int numProc) {
		if(numProc < listeProc.length) {
			listeProc[numProc].add(task);
		}
	}
	
	public void supprimerTache(int indexProc, int indexTache) {
		listeProc[indexProc].supprimerTache(indexTache);
	}
	
	public void deplaceTache(int indexProcSupp, int indexTache, int indexProcAjout) {
		listeProc[indexProcAjout].add(listeProc[indexProcSupp].getTache(indexTache));
		listeProc[indexProcSupp].supprimerTache(indexTache);
	}
	
	public void echangerTache(int indexTache1, int indexProcSupp, int indexTache2, int indexProcAjout) {
		listeProc[indexProcAjout].add(listeProc[indexProcSupp].getTache(indexTache1));
		listeProc[indexProcSupp].add(listeProc[indexProcAjout].getTache(indexTache2));
		listeProc[indexProcSupp].supprimerTache(indexTache1);
		listeProc[indexProcAjout].supprimerTache(indexTache2);
	}
	
	
	public int getDureeProc(int index) {
		return listeProc[index].getDureeTache();
	}
	
	
	public int getDureeTotale() {
		int dureeMax = 0;
		for(Processeur p : listeProc) {
			int dureeTemp = p.getDureeTache();
			if(dureeMax < dureeTemp) {
				dureeMax = dureeTemp;
			}
		}
		return dureeMax;
	}
	
	public boolean estEgal(Etat e) {
		if(listeProc.length != e.listeProc.length) {
			return false;
		}
		for(int i = 0 ; i < listeProc.length ; i++) {
			if(!listeProc[i].estEgal(e.listeProc[i])) {
				return false;
			}
		}
		return true;
	}

	public Etat successeur() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("Etat: \n");
		for(int i = 0 ; i < listeProc.length ; i++) {
			str.append("Processeur num "+i+" liste des taches: \n");
			str.append(listeProc[i].toString());
		}
		return str.toString();
	}
	
}
