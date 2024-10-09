package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {

	public TestMethodeEquals() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Borne b1 = new Borne(25);
		Borne b2 = new Borne(25);
		
		Attaque feuRouge1 = new Attaque(Type.FEU);
		Attaque feuRouge2 = new Attaque(Type.FEU);
		
		Attaque feuRouge3 = new Attaque(Type.FEU);
		Parade feuVert1 = new Parade(Type.FEU);
		
		System.out.println(b1.equals(b2));
		System.out.println(feuRouge1.equals(feuRouge2));
		System.out.println(feuRouge3.equals(feuVert1));
	}

}
