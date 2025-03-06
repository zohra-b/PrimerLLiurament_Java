package n1exercici2;

public class N1Exercici2 {

	public static void main(String[] args) {
		Cotxe.frenar();
		
		//si excribimos Cotxe.  nos salen todos los metodos accessibles de manera estatica o sea getMarca(), getModel() y frenar();
		//pero para acceder al metodo accelerar(), hay que instanciar un objeto de la clase Cotxe :
		
		Cotxe miCoche = new Cotxe(); //no hace falta ningun argumento ya que no hay nada en el constructor
		miCoche.accelerar(); 
		miCoche.frenar(); // aquí a pesar de poder ejecutar el metodo frenar(), Eclipse nos aconseja accedir de una manera estatica (como en linea 6)

	}

}
