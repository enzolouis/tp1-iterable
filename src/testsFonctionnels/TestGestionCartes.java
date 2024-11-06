package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import cartes.Borne;
import cartes.Carte;
import utils.GestionCartes;

public class TestGestionCartes {

	public static void main(String[] args) {
		List<Carte> l = new ArrayList<>();
		l.add(new Borne(50));l.add(new Borne(10));l.add(new Borne(30));
		l.add(new Borne(100));l.add(new Borne(20));l.add(new Borne(40));
		System.out.println(GestionCartes.extraire(l));

		List<Carte> l2 = new ArrayList<>();
		l2.add(new Borne(50));l2.add(new Borne(10));l2.add(new Borne(30));
		l2.add(new Borne(100));l2.add(new Borne(20));l2.add(new Borne(40));
		
		System.out.println(GestionCartes.mélanger(l2));
		
		List<Carte> l3_1 = new ArrayList<>();
		l3_1.add(new Borne(50));l3_1.add(new Borne(10));l3_1.add(new Borne(30));
		l3_1.add(new Borne(100));l3_1.add(new Borne(20));l3_1.add(new Borne(40));
		List<Carte> l3_2 = new ArrayList<>();
		l3_2.add(new Borne(50));l3_2.add(new Borne(10));l3_2.add(new Borne(30));
		l3_2.add(new Borne(100));l3_2.add(new Borne(20));l3_2.add(new Borne(40));
		l3_2.add(new Borne(500));
		
		System.out.println(GestionCartes.verifierMelanger(l3_1, l3_2));
		
		List<Carte> l4 = new ArrayList<>();
		l4.add(new Borne(50));l4.add(new Borne(10));l4.add(new Borne(50));l4.add(new Borne(30));
		l4.add(new Borne(100));l4.add(new Borne(20));l4.add(new Borne(40));l4.add(new Borne(50));
		l4.add(new Borne(20));l4.add(new Borne(100));l4.add(new Borne(100));
		// tests rassembler
		List<Carte> result = GestionCartes.rassembler(l4);
		System.out.println("Rassemblement de " + l4 + " : \n" + GestionCartes.rassembler(l4));
		
		// false
		System.out.println("Vérification rassemblement : " + GestionCartes.verifierRassembler(l4));
		// true
		System.out.println("Vérification rassemblement : " + GestionCartes.verifierRassembler(result));
	
		// 
		System.out.println(GestionCartes.verifierRassembler(new ArrayList<>()));
	}

}
