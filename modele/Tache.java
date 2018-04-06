package optimisation.modele;

public class Tache {
	private int time; // durée de la tache
	
	public Tache(int tps) {
		this.time = tps;
	}
	

	public int getTime() {
		return time;
	}
	

	public void setTime(int tps) {
		this.time = tps;
	}

	
	public boolean estEgal(Tache t) {
		if( time == t.time ) {
			return true;
		}
		return false;
	}
	
}
