package optimisation.controller;

import java.awt.event.ActionEvent;

import optimisation.modele.Modele;

public class Ecouteur {
	private Modele mod;
	private Modele.algo enm;
	
	public Ecouteur(Modele mod,Modele.algo enm){
		this.mod = mod;
		this.enm = enm;
	}

	public void actionPerformed(ActionEvent arg0) {
		mod.demarrerAlgo(enm);
	}

}
