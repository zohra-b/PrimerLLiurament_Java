package n1exercici1;

public class N1Exercici1 {

	public static void main(String[] args) {
		//dentro de la super-clase Instrument hemos creado un metodo static access_static()
		//dentro de la consola, ya que se imprima 2 veces, vemos que este método se puede acceder tanto desde la super-clase como desde la sub-clase
		Instrument.access_static();
		Vent.access_static();
		
		//Pero si intentamos acceder a otro metodo de la clase Vent antes de instanciar un instrumento Vent nos dar error
		// Por ejemplo : 
		
		//Vent.tocar();
		// si decomentamos la linea 14, nos da este error : Cannot make a static reference to the non-static method tocar() from the type Vent
		
		
		
		//aquí instanciamos un instrumento de tipo Instrument y llamamos al metodo abstracto tocar();
		Instrument miVent = new Vent("Flauta", 200);
		miVent.tocar();
		Corda miCorda = new Corda("Violin", 750);
		miCorda.tocar();
		Percussio miPercussio = new Percussio("tambor", 250);
		miPercussio.tocar();

	}

}
