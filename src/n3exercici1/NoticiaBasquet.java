package n3exercici1;

public class NoticiaBasquet extends Noticia{
	private String competicio;
	private String club;
	private final int preuIni = 250;
	private final int eurolliga = 75;
	private final int barcaMadrid = 75;
	
	public NoticiaBasquet(String titular , String competicio, String club) {
		super(titular);
		this.competicio = competicio;
		this.club = club;
	}
	
	// getters
		public String getCompeticio() {
			return this.competicio;
		}
		
		public String getClub() {
			return this.club;
		}
		
		
	// setters
	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}
			
	public void setClub(String club) {
		this.club = club;
	}
			


	public int calcularPreu() {
		int preu = preuIni;
		if (this.competicio.equalsIgnoreCase("Eurolliga")) {
			preu += eurolliga;
		}
		if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
			preu += barcaMadrid;
		}
		return preu;
	}
	
	public int calcularPunts() {
		int punts = 4;
		if (this.competicio.equalsIgnoreCase("Eurolliga")) {
			punts +=3;
		} else if (this.competicio.equalsIgnoreCase("ACB")) {
			punts +=2;
		} 
		if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
			punts +=1;
		}
		return punts;
	}
	
	// metodes propis
		public String toString() {
			return "Esto es una noticia de básquet. Mi título es : " + super.getTitular() + ". ";
		}
}
