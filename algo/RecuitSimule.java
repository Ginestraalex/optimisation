package optimisation.algo;

import java.util.ArrayList;

import optimisation.modele.Etat;
import optimisation.modele.Modele;
import optimisation.modele.Processeur;
import optimisation.modele.Tache;

public class RecuitSimule implements IAlgo{

	protected double temperature;
	protected ArrayList<Processeur> evalMeilleur;
	protected int limiteInf, limiteSup, nbProc, nbTache;
	
	public RecuitSimule() {
		this.temperature = 4000;
		evalMeilleur = new ArrayList<>();
		nbTache = 6;
		nbProc = 2;
		limiteInf = 0;
		limiteSup = 20;
	}
	
	public RecuitSimule(int temp, ArrayList<Processeur> proc) {
		this.temperature = temp;
		this.evalMeilleur = new ArrayList<>();
		this.evalMeilleur = proc;
		nbTache = 6;
		nbProc = 2;
		limiteInf = 0;
		limiteSup = 20;
	}	
	
	public ArrayList<Processeur> recuitSimule(Modele mod,int nbTache, int nbProc, int temp, int borneInf, int borneSup) {
		this.temperature = temp;
		double diminution = 0.999;
		int compteur= 0;
		evalMeilleur = new ArrayList<>();
		ArrayList<Processeur> evalCourant = new ArrayList<>();
		this.limiteInf = borneInf;
		this.limiteSup = borneSup;
		this.nbTache = nbTache;
		this.nbProc = nbProc;
	
		for (int i = 0; i < this.nbProc; i++)
		{
			this.evalMeilleur.add(new Processeur());
			evalCourant.add(new Processeur());
		}
	
		for (int i = 0; i < this.nbTache; i++){
			int comparaison = this.limiteSup-this.limiteInf;
			int duree = (int)(Math.random() * (comparaison)) + this.limiteInf;
			this.evalMeilleur.get(0).add(new Tache(duree,i));
			evalCourant.get(0).add(new Tache(duree,i));
		}
		
		double tempera=this.temperature;
		
		while (tempera > 1) {
			ArrayList<Processeur> procCourant =  voisin(evalCourant);
	
			int variation = getDureeTotale(procCourant) - getDureeTotale(evalCourant);
			if ( variation < 0  || ( variation > 0 && Math.random() < Math.exp((-variation)/tempera) )) {
				evalCourant = procCourant;
			}
			
			if ( getDureeTotale(evalMeilleur) >  getDureeTotale(evalCourant) ) {
				evalMeilleur = evalCourant;
				StringBuilder sb = new StringBuilder();
					sb.append(" \n \n itération  " + compteur +" :");
					for ( Processeur p : evalMeilleur) {
						sb.append("  \n processeur avec une duree total de " + p.getDureeTache()+ "\n");
						for ( Tache t : p.getListe()) {
							sb.append(" Tache " + t.getNum() +" :"+t.getTime()+"   ");
						}
					}
					mod.setRecuit(sb);
			}
			compteur++;
			tempera = tempera*diminution; 
		}
		mod.setIteration(compteur);
		return evalMeilleur;
	}
	
	
	public int getDureeTotale(ArrayList<Processeur> listeProc) {
		int dureeMax = 0;
		for(Processeur p : listeProc) {
			int dureeTemp = p.getDureeTache();
			if(dureeMax < dureeTemp) {
				dureeMax = dureeTemp;
			}
		}
		return dureeMax;
	}
	
	public ArrayList<Processeur> voisin( ArrayList<Processeur> proc) {
	
		int i = 0;
		ArrayList<Processeur> p =  new ArrayList<>();
	
		for ( Processeur pro : proc) {
			p.add(new Processeur());
			for (Tache tache : pro.getListe()) {
				int t = tache.getTime();
				int num= tache.getNumTache();
				p.get(i).add(new Tache(t,num));
			}
			i++;
		}

		int compt= 0;
		while (compt == 0 ) {
			if (Math.random() > 0.5) {
				enlever(p);
				compt++;
			} 
			if (Math.random() < 0.5) {
				inverser(p);
			}
			if (Math.random() > 0.5) {  
				echanger(p);
				compt++;
			}
		}
		return p;
	}
	
	public void inverser(ArrayList<Processeur> listeP ) {
		int taille , proc;
		Tache t ;
	
		for (int i =0; i < listeP.size(); i++) {
			if (Math.random() > 0.75 && listeP.get(i).getListe().size() > 1) {
				taille = listeP.get(i).getListe().size();
				proc =(int)(Math.random() * (taille));
				t = listeP.get(i).getListe().get(proc);
				if ( Math.random()> 0.5 ) {
					if ( proc > 0) {
						listeP.get(i).getListe().set(proc, listeP.get(i).getListe().get( (proc-1) ));
						listeP.get(i).getListe().set((proc-1) , t);
					} 
				} else {
					if ( proc < taille-1) {
						listeP.get(i).getListe().set(proc, listeP.get(i).getListe().get( (proc+1) ));
						listeP.get(i).getListe().set((proc+1) , t);
					} 
				}
			}
		}
	}
	
	
	public void enlever(ArrayList<Processeur> p ) {
	
		int taille, proc1,proc2, aleatoire, i = 0;
		Tache t;
	
		taille = p.size();
		boolean vide = true;
		while (i < p.size() && vide) {
			if (p.get(i).getListe().size() > 0) vide = false;
			i++;
		}
	
		if (!vide ) {
			proc1 =  (int)(Math.random() * (taille));
			i = 0;
			while (p.get(proc1).getListe().size() ==0)  {
				proc1 =(int)(Math.random() * (taille));
				i++;
			}
			aleatoire =(int)(Math.random() * (p.get(proc1).getListe().size()));
			t = p.get(proc1).getListe().get(aleatoire);
			p.get(proc1).getListe().remove(aleatoire);
			proc2 = (int)(Math.random() * (taille));
			while ( proc2 == proc1) {
				proc2 =(int)(Math.random() * (taille));
				i++;
			}
			p.get(proc2).getListe().add(t);
		}
	
	}
	
	
	
	public void echanger(ArrayList<Processeur> p ) {
		int taille, proc1, proc2,aleatoire, i =0;
		Tache t, t2;
	
		taille = p.size();
	
		proc1 =(int)(Math.random() * (taille));
	
		while (p.get(proc1).getListe().size() > 0 && i < p.size())  {
			proc1 = (int)(Math.random() * (taille));
			i++;
		}
		i = 0;
		proc2 = (int)(Math.random() * (taille));
		while ( proc2 == proc1 && p.get(proc2).getListe().size() > 0 && i < p.size()) {
			proc2 = (int)(Math.random() * (taille));
			i++;
		}
		if (p.get(proc1).getListe().size() >0  && p.get(proc2).getListe().size() > 0) {
			aleatoire =(int)(Math.random() * (p.get(proc1).getListe().size()));
			t = p.get(proc1).getListe().get(aleatoire);
			if ( aleatoire < p.get(proc2).getListe().size()) {
				t2 = p.get(proc2).getListe().get(aleatoire);
				p.get(proc2).getListe().set(aleatoire, t);
			} else {
				taille = p.get(proc2).getListe().size()-1;
				t2 = p.get(proc2).getListe().get(taille);
				p.get(proc2).getListe().remove(taille);
				p.get(proc2).getListe().add(t);
			}
			p.get(proc1).getListe().set(aleatoire, t2);
		}
	
	}
	
	
	public double getTemperature() {
		return temperature;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public ArrayList<Processeur> getLproc() {
		return evalMeilleur;
	}
	
	public void setLproc(ArrayList<Processeur> lproc) {
		this.evalMeilleur = lproc;
	}
	
	
	public int getBorneInf() {
		return limiteInf;
	}
	
	public void setBorneInf(int borneInf) {
		this.limiteInf = borneInf;
	}
	
	public int getBorneSup() {
		return limiteSup;
	}
	
	public void setBorneSup(int borneSup) {
		this.limiteSup = borneSup;
	}
	
	public int getNbProc() {
		return nbProc;
	}
	
	public void setNbProc(int nbProc) {
		this.nbProc = nbProc;
	}
	
	public int getNbTache() {
		return nbTache;
	}
	
	public void setNbTache(int nbTache) {
		this.nbTache = nbTache;
	}
}
