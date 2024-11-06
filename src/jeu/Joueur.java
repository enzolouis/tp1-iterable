package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.FinLimite;
import utils.GestionCartes;

public class Joueur {
	private String nom;
	private ZoneDeJeu zone;
	private MainJoueur main;

	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
		this.main = new MainJoueur();
	}
	
	public ZoneDeJeu getZoneDeJeu() {
		return zone;
	}
	
	public void donner(Carte c) {
		main.prendre(c);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		Carte c = null;
		if (!sabot.estVide()) {
			c = sabot.piocher();
			main.prendre(c);
		}
		
		return c;
	}
	
	public int donnerKmParcourus() {
		return this.zone.donnerKmParcourus();
	}
	
	public void deposer(Carte c) {
		this.zone.deposer(c);
	}
	
	public boolean estDepotAutorise(Carte carte) {
		return this.zone.estDepotAutorise(carte);
	}
	
	public MainJoueur getMain() {
		return main;
	}
	
	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
        Set<Coup> coupsValid = new HashSet<>();
        
        for (Joueur participant : participants) {
            for (Carte carte : this.getMain().getCartes()) {
                Coup coup = new Coup(this, carte, participant);
                if (coup.estValide()) {
                    coupsValid.add(coup);
                }
            }
        }
        
        return coupsValid;
    }
	
	public Set<Coup> coupsDefausse() {
        Set<Coup> coupsDefausse = new HashSet<>();
        
        for (Carte carte : this.getMain().getCartes()) {
            Coup coup = new Coup(this, carte, null);
            coupsDefausse.add(coup);
        }
        
        return coupsDefausse;
    }
	
	public void retirerDeLaMain(Carte carte) {
		this.deposer(carte);
	}
	
	public Coup choisirCoup(Set<Joueur> participants) {
		Set<Coup> cp = this.coupsPossibles(participants);
		if (!cp.isEmpty()) {
			return GestionCartes.extraire(new ArrayList<>(cp));
		}
		Set<Coup> cf = this.coupsDefausse();
		return GestionCartes.extraire(new ArrayList<> (cf));
	}
	
	public String afficherEtatJoueur() {
		String bottesstr = "";
		for (Botte b : this.zone.getBottes()) {
			bottesstr += b.toString();
		}
		
		boolean isLimitation = this.zone.donnerLimitationVitesse() == 50;

		List<Bataille> lBataille = this.zone.getPileBataille();
		String sommetstr = lBataille.isEmpty() ? null : lBataille.get(lBataille.size() - 1).toString();
		String mainstr = this.getMain().toString();
		
		return bottesstr + "\n" + isLimitation + "\n" + sommetstr + "\n" + mainstr;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (!(o instanceof Joueur)) return false;
		
		Joueur joueur = (Joueur) o;
		
		return this.nom.equals(joueur.nom);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Joueur.class);
	}
	
	public String toString() {
		return this.nom;
	}

}
