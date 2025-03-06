package n3exercici1;

public class NoticiaTenis extends Noticia {
	//atributs
	private String competicio;
	private String tenista;
	private final int preuIni = 150;
	private final int goat = 100;
	
	//constructor
	public NoticiaTenis(String titular , String competicio, String tenista) {
		super(titular);
		this.competicio = competicio;
		this.tenista = tenista;
	}
	
	// getters
	public String getCompeticio() {
		return this.competicio;
	}
			
	public String getTenista() {
		return this.tenista;
	}
			
			
	// setters
	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}
				
	public void setClub(String tenista) {
		this.tenista = tenista;
	}

	// metodes generals
	public int calcularPreu() {
		int preu = preuIni;
		
		if (this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal") || this.tenista.equalsIgnoreCase("Djokovic")) {
			preu += goat;
		}
		return preu;
	}
	
	public int calcularPunts() {
		int punts = 4;
		
		if (this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal") || this.tenista.equalsIgnoreCase("Djokovic")) {
			punts += 3;
		}
		return punts;
	}
	
	// metodes propis
		public String toString() {
			return "Esto es una noticia de tenis. Mi título es : " + super.getTitular() + ". ";
		}

}
