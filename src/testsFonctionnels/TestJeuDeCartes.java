package testsFonctionnels;

import java.util.Arrays;
import java.util.List;

import cartes.Configuration;
import cartes.JeuDeCartes;

public class TestJeuDeCartes {

	public TestJeuDeCartes() {
	}
	
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println(jeu.affichageJeuDeCartes());
		
		System.out.println(Arrays.toString(jeu.donnerCartes()));
		
		List<Configuration> lst = jeu.getListConfiguration();
		
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i).getNbExemplaires() + " " + lst.get(i).getCarte());
		}
		
		System.out.println(jeu.checkCount());
	}

}
