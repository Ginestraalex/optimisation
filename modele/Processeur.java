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
	
	public boolean estEgal(Processeur p) {
		if(listeTaches.size() != p.getNbTaches()) {
			return false;
		}
		for(int i = 0 ; i < listeTaches.size() ; i++) {
			if(!p.getTache(i).estEgal(listeTaches.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("liste des taches: ");
		for(int i = 0 ; i < listeTaches.size() ; i++) {
			str .append(listeTaches.get(i).toString());
		}
		return str.toString();
	}

}
