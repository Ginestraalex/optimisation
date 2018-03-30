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
	
	public ArrayList<Tache> getListe(){
		return listeTaches;
	}

}
