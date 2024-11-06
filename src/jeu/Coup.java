package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.Limite;

public class Coup {
	
	private Joueur joueurCourant;
	private Carte carteJouée;
	private Joueur joueurCible;

	public Coup(Joueur joueurCourant, Carte carteJouée, Joueur joueurCible) {
		this.joueurCourant = joueurCourant;
		this.carteJouée = carteJouée;
		this.joueurCible = joueurCible;
	}
	
	public Joueur getJoueurCourant() {
		return this.joueurCourant;
	}
	
	public Carte getCarteJouée() {
		return this.carteJouée;
	}
	
	public Joueur getJoueurCible() {
		return this.joueurCible;
	}
	
	public boolean estValide() {
        if (carteJouée instanceof Attaque || carteJouée instanceof Limite) {
            return joueurCible != null && joueurCible != joueurCourant;
        } else {
            return joueurCible == null || joueurCible == joueurCourant;
        }
    }
	
	public String toString() {
		return this.joueurCible == null ? 
				"defausse la carte " + this.carteJouée.toString() : 
					"depose la carte " + this.carteJouée.toString() + " dans la zone de jeu de " + this.joueurCible.toString();
	}

}
