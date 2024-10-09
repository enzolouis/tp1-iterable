package cartes;

import java.util.Objects;

public class DebutLimite extends Limite {

	public DebutLimite() {
		
	}
	
	public String toString() {
		return "Début de limite.";
	}
	
	public static void main(String[] args) {
		DebutLimite d1 = new DebutLimite();
		DebutLimite d2 = new DebutLimite();
		
		System.out.println(d1 == d2);
		System.out.println(d1.equals(d2));
		System.out.println(Objects.equals(d1, d2));
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof DebutLimite;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(DebutLimite.class);
	}

}
