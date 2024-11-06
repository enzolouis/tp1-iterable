package jeu;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable {
	private Carte[] cartes;
	private int nbCartes;
	private final int MAXCARTES = 110;
	private int nombreOperations = 0;
	private Iterateur iterateur = null;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = cartes.length;
	}
	
	public boolean estVide() {
		return this.nbCartes == 0;
	}
	
	public void ajouterCartes(Carte carte) throws IllegalStateException {
		if (nbCartes == MAXCARTES) {
			throw new IllegalStateException("max atteint");
		}
		
		this.cartes[this.nbCartes] = carte;
		this.nombreOperations++;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	public Carte piocher() {
		if (iterateur == null) {
			iterateur = (Iterateur) this.iterator();
		}
		
        Carte cartePiochee = iterateur.next();
        iterateur.remove();
        
        return cartePiochee;
	}
	
	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private int nombreOperationsReference = nombreOperations;
		private boolean nextEffectue = false;
		
		public boolean hasNext() {
			return indiceIterateur <= nbCartes;
		}
		
		public Carte next() {
			verificationConcurrence();
			
			if (!hasNext()) {
				throw new NoSuchElementException("Le sabot est vide, impossible de piocher");
			}
			
			nextEffectue=true;
			indiceIterateur++;
			
			return cartes[indiceIterateur - 1]; // 1 - 1 = 0, on pioche la première carte
		}
		
		@Override
		public void remove() {
			verificationConcurrence();

			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException("Pioche vide ou nextEffectue");
			}
			
			// remove
			for (int x = indiceIterateur - 1; x < nbCartes - 1; x++) {
				cartes[x] = cartes[x+1];
			}
			// optionnel si on suit bien la progression de nbCartes et qu'on se sert
			// de nbCartes pour parcourir/afficher cartes, avec Arrays.toString ca buguera sans ça
			cartes[nbCartes - 1] = null;
			
			nbCartes--;
			nextEffectue=false;
			nombreOperations++;
			nombreOperationsReference++;
			indiceIterateur--;
		}
		
		private void verificationConcurrence() {
			if (nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
	}
}
