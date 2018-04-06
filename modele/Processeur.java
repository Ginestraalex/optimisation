package optimisation.modele;

import java.util.ArrayList;

public class Processeur {
	private ArrayList<Tache> listeTaches;
	
	public Processeur() {
		this.listeTaches = new ArrayList<Tache>();
	}
	
	public void add(Tache t){
		listeTaches.add(t);
	}
	
	public Tache getTache(int index) {
		return listeTaches.get(index);
	}
	
	public int getNbTaches() {
		return listeTaches.size();
	}
	
	public int getDureeTache() {
		int duree = 0;
		for(Tache t : listeTaches) {
			duree += t.getTime();
		}
		return duree;
	}
	
	public ArrayList<Tache> getListe(){
		return listeTaches;
	}
	
	public void supprimerTache(int index) {
		listeTaches.remove(index);
	}

}
