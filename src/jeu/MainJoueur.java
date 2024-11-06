package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainJoueur {
	
	private List<Carte> cartes;

	public MainJoueur() {
		this.cartes = new ArrayList<>();
	}
	
	public List<Carte> getCartes() {
		return cartes;
	}

	public void prendre(Carte c) {
		this.cartes.add(c);
	}
	
	public void jouer(Carte c) throws Exception {
		if (!this.cartes.contains(c)) {
			throw new Exception("non existant dans la liste");
		}
		
		this.cartes.remove(c);
	}
	
	public String toString() {
		String s = "-----------MAIN-----------\n";
		for (Carte c : cartes) {
			s += c.toString() + "\n";
		}
		
		s += "--------------------------";
		
		return s;
	}
}
