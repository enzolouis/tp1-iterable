package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;
import jeu.Cartes;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {

	public static void main(String[] args) {
		/*ZoneDeJeu z = new ZoneDeJeu();
		Borne b = new Borne(25);
		System.out.println("Je dépose " + b);
		z.deposer(b);
		
		Borne b2 = new Borne(50);
		System.out.println("Je dépose " + b2);
		z.deposer(b2);
		
		Borne b3 = new Borne(75);
		System.out.println("Je dépose " + b3);
		z.deposer(b3);
		
		System.out.println("Total des bornes : " + z.donnerKmParcourus());
		
		
		System.out.println("Limite : " + z.donnerLimitationVitesse());
		z.deposer(new DebutLimite());
		System.out.println("Limite : " + z.donnerLimitationVitesse());
		z.deposer(new FinLimite());
		System.out.println("Limite : " + z.donnerLimitationVitesse());*/
		
//		boolean depotOK = false;
//		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
//		// Feu rouge
//		System.out.println("Deposer carte Feu rouge");
//		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// accident
//		System.out.println("Deposer carte attaque - accident");
//		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// Feu vert
//		System.out.println("Deposer carte Feu vert");
//		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(Cartes.FEU_VERT);
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// panne d'essence
//		System.out.println("Deposer carte attaque - essence");
//		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ESSENCE));
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Attaque(Type.ESSENCE));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// roue de secours
//		System.out.println("Deposer carte parade - roue de secours");
//		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.CREVAISON));
//		if (depotOK) {
//			zoneDeJeu.deposer(new Parade(Type.CREVAISON));
//		}
//		System.out.println("d�p�t ok ? " + depotOK); // false (j'ai true)
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer()); // false (j'ai false)
//		// bidon d'essence
//		System.out.println("Deposer carte parade - essence");
//		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.ESSENCE));
//		if (depotOK) {
//			zoneDeJeu.deposer(new Parade(Type.ESSENCE));
//		}
//		System.out.println("d�p�t ok ? " + depotOK);
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// Feu vert
//		System.out.println("Deposer carte Feu vert");
//		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(Cartes.FEU_VERT);
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot 100 bornes
//		System.out.println("Deposer carte borne - 100");
//		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Borne(100));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot limitation de vitesse 50 bornes
//		System.out.println("Deposer carte limite - 50");
//		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new DebutLimite());
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot 100 bornes
//		System.out.println("Deposer carte borne - 100");
//		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Borne(100));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// Depot 25 bornes
//		System.out.println("Deposer carte borne - 25");
//		depotOK = zoneDeJeu.estDepotAutorise(new Borne(25));
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Borne(25));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot fin limitation
//		System.out.println("Deposer carte fin limite - 50");
//		depotOK = zoneDeJeu.estDepotAutorise(new FinLimite());
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new FinLimite());
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot 100 bornes
//		System.out.println("Deposer carte borne - 100");
//		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Borne(100));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		
		boolean depotOK = false;
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		// Feu rouge
		System.out.println("Deposer carte Feu rouge");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// Botte Vehicule prioritaire
		System.out.println("Deposer carte Vehicule prioritaire");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.PRIORITAIRE);
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.PRIORITAIRE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// accident
		System.out.println("Deposer carte attaque - accident");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
	
		// botte roue de secours
		System.out.println("Deposer botte - roue de secours");
		depotOK = zoneDeJeu.estDepotAutorise(new Botte(Type.CREVAISON));
		if (depotOK) {
			zoneDeJeu.deposer(new Botte(Type.CREVAISON));
		}
		System.out.println("d�p�t ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// botte as du volant
		System.out.println("Deposer carte as du volant");
		depotOK = zoneDeJeu.estDepotAutorise(new Botte(Type.ACCIDENT));
		if (depotOK) {
			zoneDeJeu.deposer(new Botte(Type.ACCIDENT));
		}
		System.out.println("d�p�t ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot attaque accident
		System.out.println("Deposer carte accident");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot limitation de vitesse 50 bornes
		System.out.println("Deposer carte limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new DebutLimite());
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
	}

}
