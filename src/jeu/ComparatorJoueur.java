package jeu;

import java.util.Comparator;

public class ComparatorJoueur implements Comparator<Joueur> {
    public int compare(Joueur j1, Joueur j2) {
        return Integer.compare(j2.donnerKmParcourus(), j1.donnerKmParcourus());
    }
}
