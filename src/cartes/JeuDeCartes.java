package cartes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JeuDeCartes {
	private List<Configuration> typesDeCartes;

	public JeuDeCartes() {
		typesDeCartes = new ArrayList<>();
        typesDeCartes.add(new Configuration(new Borne(25), 10));
        typesDeCartes.add(new Configuration(new Borne(50), 10));
        typesDeCartes.add(new Configuration(new Borne(75), 10));
        typesDeCartes.add(new Configuration(new Borne(100), 12));
        typesDeCartes.add(new Configuration(new Borne(200), 4));
        typesDeCartes.add(new Configuration(new Parade(Type.FEU), 14));
        typesDeCartes.add(new Configuration(new FinLimite(), 6));
        typesDeCartes.add(new Configuration(new Parade(Type.ESSENCE), 6));
        typesDeCartes.add(new Configuration(new Parade(Type.CREVAISON), 6));
        typesDeCartes.add(new Configuration(new Parade(Type.ACCIDENT), 6));
        typesDeCartes.add(new Configuration(new Attaque(Type.FEU), 5));
        typesDeCartes.add(new Configuration(new DebutLimite(), 4));
        typesDeCartes.add(new Configuration(new Attaque(Type.ESSENCE), 3));
        typesDeCartes.add(new Configuration(new Attaque(Type.CREVAISON), 3));
        typesDeCartes.add(new Configuration(new Attaque(Type.ACCIDENT), 3));
        typesDeCartes.add(new Configuration(new Botte(Type.FEU), 1));
        typesDeCartes.add(new Configuration(new Botte(Type.ESSENCE), 1));
        typesDeCartes.add(new Configuration(new Botte(Type.CREVAISON), 1));
        typesDeCartes.add(new Configuration(new Botte(Type.ACCIDENT), 1));
        
        // System.out.println(Arrays.toString(this.donnerCartes()));
	}
	
	public static void main(String[] args) {
		JeuDeCartes j = new JeuDeCartes();
		System.out.println("helo");
		
		System.out.println(j.checkCount());
	}
	
	public List<Configuration> getListConfiguration() {
		return this.typesDeCartes;
	}	
	
	public String affichageJeuDeCartes() {
		String ret = "";
		for (Configuration c : this.typesDeCartes) {
			ret += c.getNbExemplaires() + " " + c.getCarte().toString() + "\n";
		}
		return ret;
	}
	
	public Carte[] donnerCartes() {
		Carte[] cartes = new Carte[106];
		int cursor = 0;
		
		for (Configuration c : this.typesDeCartes) {
			Carte carte = c.getCarte();
			for (int i = 0; i < c.getNbExemplaires(); i++) {
				cartes[cursor] = carte;
				cursor++;
			}
		}
		
		return cartes;
	}
	
	public int countConfigurationNumber(Carte c) {
		List<Configuration> lst = this.getListConfiguration();
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).getCarte().equals(c)) {
				return lst.get(i).getNbExemplaires();
			}
		}
		return 0;
	}
	
	public boolean countSameType(Carte[] cartes, Carte c) {
		int count = 0;
		for (int i = 0; i < cartes.length; i++) {
			if (cartes[i] == c) {
				count++;
			}
		}
		
		return count == countConfigurationNumber(c);
	}
	
	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		
		List<Configuration> l = this.getListConfiguration();
		for (int i = 0; i < cartes.length; i++) {
			if (!countSameType(cartes, cartes[i])) {
				return false;
			}
		}
		return true;
	}

}
