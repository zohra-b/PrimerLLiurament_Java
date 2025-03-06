package n3exercici1;

public class NoticiaMoto extends Noticia {
	//atributs
	private String equip;
	private final int preuIni = 100;
	private final int honYam = 50;
	
	//constructor
	public NoticiaMoto(String titular , String equip) {
		super(titular);
		this.equip = equip;
		
	}
	
	// getters
	public String getEquip() {
		return this.equip;
	}
			
	
			
			
	// setters
	public void setEquip(String equip) {
		this.equip = equip;
	}
				
	
	// metodes generals
	public int calcularPreu() {
		int preu = preuIni;
		
		if (this.equip.equalsIgnoreCase("Honda") || this.equip.equalsIgnoreCase("Yamaha")) {
			preu += honYam;
		}
		return preu;
	}
	
	public int calcularPunts() {
		int punts = 3;
		
		if (this.equip.equalsIgnoreCase("Honda") || this.equip.equalsIgnoreCase("Yamaha")) {
			punts +=3;
		}
		return punts;
	}
	
	// metodes propis
		public String toString() {
			return "Esto es una noticia de motociclisme. Mi título es : " + super.getTitular() + ". ";
		}

}
