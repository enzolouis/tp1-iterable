package cartes;

import java.util.ArrayList;
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
        typesDeCartes.add(new Configuration(new Parade(Type.ESSENCE), 6));
        typesDeCartes.add(new Configuration(new Parade(Type.CREVAISON), 6));
        typesDeCartes.add(new Configuration(new Parade(Type.ACCIDENT), 6));
        typesDeCartes.add(new Configuration(new Attaque(Type.FEU), 5));
        typesDeCartes.add(new Configuration(new Attaque(Type.ESSENCE), 3));
        typesDeCartes.add(new Configuration(new Attaque(Type.CREVAISON), 3));
        typesDeCartes.add(new Configuration(new Attaque(Type.ACCIDENT), 3));
        typesDeCartes.add(new Configuration(new Attaque(Type.FEU), 4));
        typesDeCartes.add(new Configuration(new Botte(Type.FEU), 1));
        typesDeCartes.add(new Configuration(new Botte(Type.ESSENCE), 1));
        typesDeCartes.add(new Configuration(new Botte(Type.CREVAISON), 1));
        typesDeCartes.add(new Configuration(new Botte(Type.ACCIDENT), 1));
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

}
