package cartes;

public enum Type {
	FEU("Feu rouge", "Feu vert", "Véhicule prioritaire"),
	ESSENCE("Panne d'essence", "Essence", "Citerne"),
	CREVAISON("Crevaison", "Roue de secours", "Increvable"),
	ACCIDENT("Accident", "Réparation", "As du volant");
	
	public final String attaqueDisplay;
	public final String paradeDisplay;
	public final String botteDisplay;
	
	private Type(String attaqueDisplay, String paradeDisplay, String botteDisplay) {
		this.attaqueDisplay = attaqueDisplay;
		this.paradeDisplay = paradeDisplay;
		this.botteDisplay = botteDisplay;
	}
	
	
}
