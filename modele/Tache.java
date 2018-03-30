package optimisation.modele;

public class Tache {
	private int num; // numero de la tache
	private int time; // durée de la tache
	private int dispo; // temps auquel la tache est dispo
	private int fin;  // temps auquella tache est terminé
	
	public Tache(int no, int tps, int disp, int over) {
		this.num = no;
		this.time = tps;
		this.dispo = disp;
		this.fin = over;
	}
	
	public int getNum() {
		return num;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getDispo() {
		return dispo;
	}
	
	public int getFin() {
		return fin;
	}

	public void setNum(int no) {
		this.num = no;
	}
	
	public void setTime(int tps) {
		this.time = tps;
	}
	
	public void setDispo(int disp) {
		this.dispo = disp;
	}
	
	public void setFin(int over) {
		this.fin = over;
	}
	
}
