package n3exercici1;

public class NoticiaF1 extends Noticia {
		//atributs
		private String escuderia;
		private final int preuIni = 100;
		private final int ferMer = 50;
		
		//constructor
		public NoticiaF1(String titular , String escuderia) {
			super(titular);
			this.escuderia = escuderia;
			
		}
		
		// getters
		public String getEscuderia() {
			return this.escuderia;
		}
				
		
				
				
		// setters
		public void setEscuderia(String escuderia) {
			this.escuderia = escuderia;
		}
					
		
		// metodes generals
		public int calcularPreu() {
			int preu = preuIni;
			
			if (this.escuderia.equalsIgnoreCase("Ferrari") || this.escuderia.equalsIgnoreCase("Mercedes")) {
				preu += ferMer;
			}
			return preu;
		}
		
		public int calcularPunts() {
			int punts = 4;
			
			if (this.escuderia.equalsIgnoreCase("Ferrari") || this.escuderia.equalsIgnoreCase("Mercedes")) {
				punts += 2;
			}
			return punts;
		}
		
		// metodes propis
			public String toString() {
				return "Esto es una noticia de F1. Mi título es : " + super.getTitular() + ". ";
			}

	


}
