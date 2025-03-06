package n1exercici1;

public class Vent extends Instrument {
	// 1 atributs
	// 2 constructors
	public Vent(String nom, double preu) {
		super(nom, preu);
		}
	// 3 getters
	// 4 setters
	// 5 metodes generals
	public void tocar() {
		System.out.println("Està sonant un instrument de vent");
	}
}
