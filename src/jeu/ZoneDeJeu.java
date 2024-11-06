package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private List<Borne> pileBorne;
	private HashSet<Botte> bottes;
	
	public boolean estPrioritaire() {
		return bottes.contains(Cartes.PRIORITAIRE);
	}

	public ZoneDeJeu() {
		pileLimite = new ArrayList<>();
		pileBataille = new ArrayList<>();
		pileBorne = new ArrayList<>();
		bottes = new HashSet<>();
	}
	
	public HashSet<Botte> getBottes() {
		return this.bottes;
	}
	
	public List<Bataille> getPileBataille() {
		return this.pileBataille;
	}
	
	public int donnerLimitationVitesse() {
		int limit;
		
		if (pileLimite.isEmpty() || pileLimite.get(pileLimite.size() - 1).equals(new FinLimite()) || estPrioritaire()) {
			limit = 200;
		} else {
			limit = 50;
		}
		
		return limit;
	}
	
	public int donnerKmParcourus() {
		int sum = 0;
		
		for (Borne c : pileBorne) {
			sum += c.getKm();
		}
		
		return sum;
	}
	
	public void deposer(Carte c) {
		if (c instanceof Borne) {
			pileBorne.add((Borne) c);
		} else if (c instanceof Limite) {
			pileLimite.add((Limite) c);
		} else if (c instanceof Bataille) {
			pileBataille.add((Bataille) c);			
		} else if (c instanceof Botte) {
			bottes.add((Botte) c);
		}
	}
	
	public boolean peutAvancer() {
		if (pileBataille.isEmpty()) {
			return this.estPrioritaire();
		}
		Bataille lastB = pileBataille.get(pileBataille.size() - 1);
		return (
				lastB.equals(Cartes.FEU_VERT) ||
				(lastB instanceof Parade && this.estPrioritaire()) ||
				(lastB instanceof Attaque && lastB.equals(Cartes.FEU_ROUGE) && this.estPrioritaire()) ||
				(lastB instanceof Attaque && !lastB.equals(Cartes.FEU_ROUGE) && 
						bottes.contains(new Botte(lastB.getType())) && this.estPrioritaire()));
	}
	
	private boolean estDepotFeuVertAutorise() {
		return !this.estPrioritaire() || pileBataille.isEmpty() || (
				pileBataille.get(pileBataille.size() - 1).equals(new Attaque(Type.FEU))
				|| (
						pileBataille.get(pileBataille.size() - 1) instanceof Parade &&
						!pileBataille.get(pileBataille.size() - 1).equals(new Parade(Type.FEU))
			
					)
				|| (
						pileBataille.get(pileBataille.size() - 1) instanceof Attaque && 
						bottes.contains(new Botte(pileBataille.get(pileBataille.size() - 1).getType()))
					)
			);
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		return this.peutAvancer() && borne.getKm() < this.donnerLimitationVitesse() && (this.donnerKmParcourus() + borne.getKm()) < 1000; // Somme borne avec la nouvelle borne ou pas ? ici non
	}

	private boolean estDepotLimiteAutorise(Limite limite) {
		if (this.estPrioritaire()) {
			return false;
		}
		if (limite instanceof DebutLimite) {
			return pileLimite.isEmpty() || pileLimite.get(pileLimite.size() - 1) instanceof FinLimite;
		} else if (limite instanceof FinLimite) {
			return pileLimite.get(pileLimite.size() - 1) instanceof DebutLimite;
		}
		return false;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bottes.contains(new Botte(bataille.getType()))) {
			return false;
		}
		
		if (bataille instanceof Attaque) {
			return this.peutAvancer();
		} else if (bataille instanceof Parade) {
			if (bataille.getType() == Type.FEU) {
				return this.estDepotFeuVertAutorise();
			} else {
				return !pileBataille.isEmpty() && pileBataille.get(pileBataille.size() - 1) instanceof Attaque && 
		                   pileBataille.get(pileBataille.size() - 1).getType() == bataille.getType();
			}
		}
		
		return false;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne) {
			return this.estDepotBorneAutorise((Borne) carte);
		} else if (carte instanceof Limite) {
			return this.estDepotLimiteAutorise((Limite) carte);
		} else if (carte instanceof Bataille) {
			return this.estDepotBatailleAutorise((Bataille) carte);
		}
		
		return true; // botte?
	}
}
