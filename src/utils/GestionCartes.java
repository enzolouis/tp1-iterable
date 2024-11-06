package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import cartes.Borne;
import cartes.Carte;

public class GestionCartes {
	
	public static <T> T extraire(List<T> lst) {
		int index = new Random().nextInt(lst.size());
        return lst.remove(index);
	}
	
	public static <T> T extraireAvecIterator(List<T> liste) {
        ListIterator<T> iterator = liste.listIterator();
        int index = new Random().nextInt(liste.size());
        T element = null;
        for (int i = 0; i <= index; i++) {
            element = iterator.next();
        }
        iterator.remove();
        return element;
    }
	
	public static <T> List<T> mélanger(List<T> lst) {
		List<T> newlst = new ArrayList<>();
		int size = lst.size();
		for (int i = 0; i < size; i++) {
			newlst.add(extraire(lst));
		}
		
		return newlst;
	}
	
	public static <T> boolean verifierMelanger(List<T> l1, List<T> l2) {
		if (l1.size() != l2.size()) {
            return false;
        }
		
		for (T c : l1) {
			if (Collections.frequency(l1, c) != Collections.frequency(l2, c)) {
				return false;
			}
		}
		
		for (T c : l2) {
			if (Collections.frequency(l2, c) != Collections.frequency(l1, c)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static List<Carte> rassembler(List<Carte> lst) {
		List<Carte> newl = new ArrayList<>();
		List<Carte> copy = new ArrayList<>();
		copy.addAll(lst);
		
		for (Carte c : lst) {
			for (int i = 0; i < copy.size(); i++) {
				if (copy.get(i).equals(c)) {
					newl.add(c);
					copy.remove(i);
					i--;
				}
			}
		}
		
		return newl;
	}
	
	public static <T> boolean verifierRassembler(List<T> lst) {
		ListIterator<T> ite1 = lst.listIterator();
		
		T lastelement = null;
		T element = null;
		int cursor = 0;
		
		while (ite1.hasNext()) {
			element = ite1.next();
			System.out.println(element + "/" + lastelement);
			if (!element.equals(lastelement) && cursor != 0) {
				// on pourrait reprendre le ite1 car il est placé pile là ou on veut
				ListIterator<T> ite2 = lst.subList(cursor, lst.size() - 1).listIterator();
				System.out.println(cursor + ":" + (lst.size() - 1) + "-> " + lst.subList(cursor, lst.size() - 1));
				T test_element = null;
				while (ite2.hasNext()) {
					test_element = ite2.next();
					if (lastelement.equals(test_element)) {
						return false;
					}
				}
			}
			
			cursor++;
			lastelement = element;
		}		
		
		return true;
	}
}
