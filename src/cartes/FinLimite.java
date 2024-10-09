package cartes;

import java.util.Objects;

public class FinLimite extends Limite {

	public FinLimite() {
		
	}
	
	public String toString() {
		return "Fin de limite.";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof FinLimite;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(FinLimite.class);
	}

}
