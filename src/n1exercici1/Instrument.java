package n1exercici1;

/*Static initializer blocks always execute before the instance initialization blocks because static blocks run at the time of class loading. 
However, the instance block runs at the time of instance creation. 
The Java compiler copies initializer blocks into every constructor. 
Therefore, multiple constructors can use this approach to share a block of code:*/

public abstract class Instrument {
	// 1 atributs
	private String nom;
	private double preu;
	
	
	
	//2 constructors
	public Instrument(String nom,double preu ) {
		nom = this.nom;
		preu = this.preu;
	}
	
	// 3 getters (return)
	public String getNom() {
		return this.nom;
	}
	
	public double getPreu() {
		return this.preu;
	}
	
	//4 setters (void)
	public void setNom (String nom) {
		nom = this.nom;
	}
	
	public void setPreu (double preu) {
		preu = this.preu;
	}
	
	// 5 methodes generals
	public abstract void tocar();
	
	static void access_static() {
		System.out.println( "AIXO ES UN ACCES A TRAVES D'UN MEMBRE STATIC DE UNA CLASSE");
	}
	
	// 6 metodes propis
	public String toString() {
		return "Això es un " + this.nom + " i costa " + this.preu;
	}
}


