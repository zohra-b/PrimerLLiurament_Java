package n2exercici1;

public class Telefon {
// 1 atributs marca i model, i el mètode trucar()
	private String marca;
	private String model;
	
	
// 2 constructor
	public Telefon(String marca,String model ) {
		this.marca = marca;
		this.model = model;
	}
	
// 3 getters (return)
	public String getMarca() {
		return this.marca;
	}
	
	public String getModel() {
		return this.model;
	}
	
// 4 setters (void)
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
// 5 metodes
	public void trucar(String numTelefon) {
		System.out.println("s’està trucant al número " + numTelefon);
		
	}
}
