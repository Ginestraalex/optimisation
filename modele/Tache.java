package optimisation.modele;

public class Tache {
	private int noTache;
	private int time; // durée de la tache
	
	public Tache(int tps, int no) {
		this.time = tps;
		noTache = no;
	}
	

	public int getTime() {
		return time;
	}
	
	public int getNumTache() {
		return noTache;
	}
	

	public void setTime(int tps) {
		this.time = tps;
	}

	public void setNumTache(int no) {
		noTache = no;
	}
	
	public boolean estEgal(Tache t) {
		if( time == t.time ) {
			return true;
		}
		return false;
	}
	
	
	public String toString() {
		return "T"+noTache+" ";
	}
}
