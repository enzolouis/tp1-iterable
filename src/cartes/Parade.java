package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}
	
	public String toString() {
		return super.getType().paradeDisplay;
	}

}
