package testsFonctionnels;

import jeu.Jeu;
import jeu.Joueur;
import jeu.ZoneDeJeu;

public class TestJeu {

	public static void main(String[] args) {
		Jeu j = new Jeu();
		ZoneDeJeu zonej1 = new ZoneDeJeu();
		Joueur j1 = new Joueur("Jack", zonej1);
		ZoneDeJeu zonej2 = new ZoneDeJeu();
		Joueur j2 = new Joueur("Bill", zonej2);
		ZoneDeJeu zonej3 = new ZoneDeJeu();
		Joueur j3 = new Joueur("Luffy", zonej3);
		
		j.inscrire(j1, j2, j3);
		
		j.distribuerCartes();
		
		/*System.out.println(j1.getMain());
		System.out.println(j.jouerTour(j1));
		System.out.println(j2.getMain());
		System.out.println(j.jouerTour(j2));
		System.out.println(j3.getMain());
		System.out.println(j.jouerTour(j3));*/
		
		System.out.println(j.lancer());
	}
	
	

}
