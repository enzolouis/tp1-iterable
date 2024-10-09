package cartes;

import java.util.Objects;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.setKm(km);
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	public String toString() {
		return km + "KM";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false; // if (o == null || getClass() != o.getClass()) return false;
		if (!(o instanceof Borne)) return false;
		
		Borne borne = (Borne)o;
		
		return this.km == borne.km;
	}

	@Override
	public int hashCode() {
		return Objects.hash(km);
	}
	

}
