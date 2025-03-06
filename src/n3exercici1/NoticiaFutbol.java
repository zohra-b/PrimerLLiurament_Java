package n3exercici1;

public class NoticiaFutbol extends Noticia{
	// 1 atributs
	private String competicio;
	private String club;
	private String jugador;
	private final int preuIni = 300;
	private final int lliga = 100;
	private final int barcaMadrid = 100;
	private final int torresBenze = 50;
	
	
	// constructor
	public NoticiaFutbol(String titular , String competicio, String club, String jugador) {
		super(titular);
		this.competicio = competicio;
		this.club = club;
		this.jugador = jugador;
		
	}
	
	// getters
	public String getCompeticio() {
		return this.competicio;
	}
	
	public String getClub() {
		return this.club;
	}
	
	public String getJugador() {
		return this.jugador;
	}
	
	// setters
	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}
		
	public void setClub(String club) {
		this.club = club;
	}
		
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	
	
	// metodes generals
	public int calcularPreu() {
		int preu = preuIni;
		if (this.competicio.equalsIgnoreCase("Lliga de Campions")) {
			preu += lliga;
		}
		if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
			preu += barcaMadrid;
		}
		if (this.jugador.equalsIgnoreCase("Ferran Torres") || this.jugador.equalsIgnoreCase("Benzema")) {
			preu += torresBenze;
		}
		return preu;
	}
	
	public int calcularPunts() {
		int punts = 5;
		if (this.competicio.equalsIgnoreCase("Lliga de Campions")) {
			punts +=3;
		} else if (this.competicio.equalsIgnoreCase("Lliga")) {
			punts +=2;
		} 
		if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
			punts +=1;
		}
		if (this.jugador.equalsIgnoreCase("Ferran Torres") || this.jugador.equalsIgnoreCase("Benzema")) {
			punts +=1;
		}
		return punts;
	}
	
	// metodes propis
	public String toString() {
		return "Esto es una noticia de futbol. Mi título es : " + super.getTitular() + ". ";
	}
	

}
