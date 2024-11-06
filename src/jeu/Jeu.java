package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	
	private Sabot sabot;
	private Set<Joueur> joueurs;
	private Iterator<Joueur> iteratorJoueurs;

	public Jeu() {
		JeuDeCartes j = new JeuDeCartes();
		Carte[] cartes_tab = j.donnerCartes();
		
		List<Carte> cartes = new ArrayList<>();
		
		Collections.addAll(cartes, cartes_tab);
		
		List<Carte> newcartes = GestionCartes.mélanger(cartes);
		
		Carte[] cartesArray = newcartes.toArray(new Carte[0]);
		this.sabot = new Sabot(cartesArray);
		
		this.joueurs = new HashSet<>();
		this.iteratorJoueurs = joueurs.iterator();
	}
	
	public void inscrire(Joueur... joueurs) {
		this.joueurs.addAll(Arrays.asList(joueurs));
		this.iteratorJoueurs = this.joueurs.iterator();
	}
	
	public void distribuerCartes() {
		for (int i = 0; i < 6; i++) {
			for (Joueur j : this.joueurs) {
				j.donner(sabot.piocher());
			}
		}
	}
	
	public String jouerTour(Joueur joueur) {
		String actions = "";
		Carte carte = joueur.prendreCarte(sabot);
		actions += "\nLe joueur " + joueur + " a pioché " + carte;
		Coup coup = joueur.choisirCoup(joueurs);
		actions += "\nLe joueur " + joueur + " " + coup;
		joueur.retirerDeLaMain(carte);
		if (coup.getJoueurCible() == null) {
			sabot.ajouterCartes(carte);
		} else {
			coup.getJoueurCible().getZoneDeJeu().deposer(carte);
		}
		
		return actions;
	}
	
	public Joueur donnerJoueurSuivant() {
		if (!iteratorJoueurs.hasNext()) {
			iteratorJoueurs = this.joueurs.iterator();
		}
		return iteratorJoueurs.next();
	}
	
	public String lancer() {
		String actions = "";
		boolean jeuTerminé = false;
		while (!sabot.estVide() && !jeuTerminé) {
			for (Joueur joueur : this.joueurs) {
				actions += this.jouerTour(joueur);
				if (joueur.donnerKmParcourus() == 1000) {
					jeuTerminé = true;
					break;
				}
				if (sabot.estVide()) {
					break;
				}
			}
		}
		if (jeuTerminé) {
			System.out.println("FIN DU JEU PAR VICTOIRE !");
		}
		if (sabot.estVide()) {
			System.out.println("FIN DU JEU PAR SABOT VIDE !");
		}
		
		return actions;
	}
	
	/*
	public List<Joueur> classement() {
		ComparatorJoueur jComparator = new ComparatorJoueur();
		TreeSet<Joueur> sortedJoueurs = new TreeSet<>(new ComparatorJoueur());
        sortedJoueurs.addAll(this.joueurs);

        return new ArrayList<>(sortedJoueurs);
	}*/
	
	public static void main(String[] args) {
		Jeu j = new Jeu();
	}

}
