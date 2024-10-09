package cartes;

import java.util.Objects;

public abstract class Probleme extends Carte {
	private Type type;
	
	public Probleme(Type type) {
		super();
		this.setType(type);
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Probleme probleme = (Probleme) o;
		
		return this.type == probleme.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

}
