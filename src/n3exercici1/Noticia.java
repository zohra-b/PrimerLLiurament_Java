package n3exercici1;

public class Noticia implements Preu, Puntuacio{
	//n titular, un text, una puntuació i un preu
// 1 atributs 
	private String titular;
	private String text;
	private int puntuacio;
	private int preu;

// 2 constructor
	public Noticia(String titular) {
		this.titular = titular;
		
	}

// 3 getters
	public String getTitular() {
		return this.titular;
	}
	public String getText() {
		return this.text;
	}
	
	public int getPuntuacio() {
		return this.calcularPunts();
	}
	
	public int getPreu() {
		return this.calcularPreu();
	}
	
// 4 setters
	
// 5 metodes generals
	
	@Override
	public int calcularPunts() {
		
		return 0;
	}

	@Override
	public int calcularPreu() {
		
		return preu;
	}

// 6 metodes propis
	public String toString() {
		return "Esto es una noticia general. Mi titulo es : " + this.titular + ".";
	}
}
