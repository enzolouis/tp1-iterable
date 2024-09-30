package testsFonctionnels;

import java.util.Arrays;
import java.util.Iterator;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {

	public static void main(String[] args) {
		// 2a
		
		Carte[] cartes = new Carte[4];
        cartes[0]= new Borne(25);
        cartes[1]= new Parade(Type.FEU);
        cartes[2]= new Attaque(Type.FEU);
        cartes[3]= new Botte(Type.FEU);
        Sabot s = new Sabot(cartes);
        
        while (!s.estVide()) {
        	System.out.println("Je pioche " + s.piocher());
        }
        
        // 2b
        
        Carte[] cartes2 = new Carte[4];
        cartes2[0]= new Borne(25);
        cartes2[1]= new Parade(Type.FEU);
        cartes2[2]= new Attaque(Type.FEU);
        cartes2[3]= new Botte(Type.FEU);
        Sabot s2 = new Sabot(cartes2);
        
        while (!s2.estVide()) {
        	Iterator<Carte> ite = s2.iterator();
        	System.out.println("Je pioche " + ite.next());
        	ite.remove();
        }
        
        System.out.println("--------------------------");
        
        // 2c
        
        Carte[] cartes3 = new Carte[4];
        cartes3[0]= new Borne(25);
        cartes3[1]= new Parade(Type.FEU);
        cartes3[2]= new Attaque(Type.FEU);
        cartes3[3]= new Botte(Type.FEU);
        Sabot s3 = new Sabot(cartes3);
        
        while (!s3.estVide()) {
        	Iterator<Carte> ite = s3.iterator();
        	System.out.println("Je pioche " + ite.next());
        	ite.remove();
        	s3.piocher();
        }
	}

}
