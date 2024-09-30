package cartes;

public class Configuration {
	
	private int nbExemplaires;
	private Carte carte;

	public Configuration(Carte carte, int nbExemplaires) {
		this.carte = carte;
		this.nbExemplaires = nbExemplaires;
	}

	public Carte getCarte() {
		return carte;
	}

	public int getNbExemplaires() {
		return nbExemplaires;
	}


}
