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
		this.evalMeilleur.get(0).add(new Tache(duree));
		evalCourant.get(0).add(new Tache(duree));
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
			p.get(i).add(new Tache(t));
		}
		i++;
	}

	int r, rr;
	int size;
	Tache t ;

	size = p.size();

	r = (int)(Math.random() * (size)) + 1;
	int compt= 0;
	// methode englobante inverser ou non les listes

	while (compt == 0 ) {
		if (Math.random() < 0.5) {
			inversion(p);
		}

		if (Math.random() > 0.5) {
			enlevage(p);
			compt++;
		} 
		if (Math.random() > 0.5) {  
			echange(p);
			compt++;
		}


	}
	return p;
}

public void inversion(ArrayList<Processeur> p ) {

	int proc1, proc2;
	int size;
	Tache t ;

	// on va lancer un rand sur chaque proc pour savoir si on va linverser
	for (int i =0; i < p.size(); i++) {

		// inversion de 2elements
		if (Math.random() > 0.75 && p.get(i).getListe().size() > 1) {

			size = p.get(i).getListe().size();

			proc1 =  0 + (int)(Math.random() * (size - 0));

			t = p.get(i).getListe().get(proc1);

			// inversion r et son voisin r+1
			if ( Math.random() <  0.5  ) {
				if ( proc1 < size-1) {
					p.get(i).getListe().set(proc1, p.get(i).getListe().get( (proc1+1) ));
					p.get(i).getListe().set((proc1+1) , t);
				} 
			} else {
				// inversion r et son voisin r-1
				if ( proc1 > 0) {
					p.get(i).getListe().set(proc1, p.get(i).getListe().get( (proc1-1) ));
					p.get(i).getListe().set((proc1-1) , t);
				} 
			}
		}
	}
}


// methode 2 enlever un element et le mettre dans un autre proc 
public void enlevage(ArrayList<Processeur> p ) {

	int size, proc1,proc2, rr, i = 0;
	Tache t;

	size = p.size();
	boolean vide = true;
	while (i < p.size() && vide) {
		if (p.get(i).getListe().size() > 0) vide = false;
		i++;
	}

	if (!vide ) {

		proc1 =  (int)(Math.random() * (size));
		i = 0;
		while (p.get(proc1).getListe().size() ==0)  {
			proc1 =(int)(Math.random() * (size));
			i++;
		}

		rr =(int)(Math.random() * (p.get(proc1).getListe().size()));

		t = p.get(proc1).getListe().get(rr);


		p.get(proc1).getListe().remove(rr);

		proc2 = (int)(Math.random() * (size));

		while ( proc2 == proc1) {
			proc2 =(int)(Math.random() * (size));
			i++;
		}

		p.get(proc2).getListe().add(t);
	}

}



// echange de tache  a la meme place entre  2 proc different
public void echange(ArrayList<Processeur> p ) {

	int size, r, proc1, proc2, i =0;
	Tache t, t2;

	size = p.size();

	proc1 =(int)(Math.random() * (size));

	while (p.get(proc1).getListe().size() > 0 && i < p.size())  {
		proc1 = (int)(Math.random() * (size ));
		i++;
	}
	i = 0;
	proc2 = (int)(Math.random() * (size ));


	while ( proc2 == proc1 && p.get(proc2).getListe().size() > 0 && i < p.size()) {
		proc2 = (int)(Math.random() * (size));
		i++;
	}

	if (p.get(proc1).getListe().size() >0  && p.get(proc2).getListe().size() > 0) {
		//System.out.println(" WELLOU 2");
		r =(int)(Math.random() * (p.get(proc1).getListe().size()));

		t = p.get(proc1).getListe().get(r);


		// si lemplacement r est plus grand que la taille du proc2 on ajoute a la fin
		if ( r >= p.get(proc2).getListe().size()) {
			size = p.get(proc2).getListe().size()-1;
			t2 = p.get(proc2).getListe().get( size);
			p.get(proc2).getListe().remove(size);
			p.get(proc2).getListe().add(t);
		} else {
			t2 = p.get(proc2).getListe().get(r);
			p.get(proc2).getListe().set(r, t);
		}

		p.get(proc1).getListe().set(r, t2);


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
