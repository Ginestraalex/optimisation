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
	
	
	public int getNbProcesseur() {
		return listeProc.length;
	}
	

	public void setTache(Tache task, int numProc) {
		if(numProc < listeProc.length) {
			listeProc[numProc].add(task);
		}
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
	
}
