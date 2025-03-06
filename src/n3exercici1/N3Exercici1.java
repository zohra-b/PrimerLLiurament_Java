package n3exercici1;

import java.util.ArrayList;
import java.util.Scanner;

public class N3Exercici1 {
	static ArrayList<Redactor> redactors = new ArrayList<Redactor>();

	public static void main(String[] args) {
		String answer = "";
		int option;
		String name;
		String dni;
		String title;
		String text;
		String competition;
		String club;
		String player;
		String team;
		Scanner input = new Scanner(System.in);
		
////  AÑADIMOS UNOS REDACTORES AL ARRAY PARA TESTEAR EL CODIGO  /////////////////////////////////////////////////////////		
	redactors.add(new Redactor("Carlos López", "123456") );
	redactors.add(new Redactor("Silvia Rodríguez", "234567") );
	redactors.add(new Redactor("Marc Faure", "345678") );
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		do {
		System.out.println(""
				+ "1.- Introducir redactor/a.\r\n"
				+ "2.- Eliminar redactor/a.\r\n"
				+ "3.- Introducir noticia a un redactor/a.\r\n"
				+ "4.- Eliminar noticia (ha de demanar redactor/a i titular de la notícia).\r\n"
				+ "5.- Mostrar todas las noticias por redactor/a.\r\n"
				+ "6.- Calcular puntuación de la noticia.\r\n"
				+ "7.- Calcular precio de la noticia.\r\n"
				+ "0.- Salir del programa.");
		
		option = input.nextInt();
		input.nextLine();
		
		switch(option) {
		case 1 : 
			System.out.println("Introduce el nombre seguido del apellido del redactor");
			name = input.nextLine();
			System.out.println("Introduce el DNI del redactor");
			dni = input.nextLine();
			System.out.println(
					createRedactor(name, dni) + "\n" + 
					redactorsList());
			break;
			
		case 2 : 
			System.out.println(redactorsList());
			System.out.println("Introduce el DNI del redactor que quieres eliminar");
			dni = input.nextLine();
			System.out.println(
					deleteRedactor(dni) + "\n" + 
					redactorsList());
			break;
			
		case 3 : 
			System.out.println(
					"Introduce el numero de DNI del redactor \n" +   //para que sea un identificador único
					redactorsList());
			//se deberia hacer validacion de que el redactor existe
			dni = input.nextLine();
			System.out.println("Introduce el título de la noticia");
			title =  input.nextLine();
			System.out.println("Introduce el texto de la noticia");
			text =  input.nextLine();
			System.out.print("Introduce el tipo de noticia : "
					+ "1. Futbol "
					+ "2. Basquet "
					+ "3. Tenis "
					+ "4. F1 "
					+ "5. Motociclisme ");
				option = input.nextInt();
				input.nextLine();
				switch(option) {
				case 1: 
					System.out.println("Introduce la competición");
					competition = input.nextLine();
					System.out.println("Introduce el club");
					club = input.nextLine();
					System.out.println("Introduce el nombre del jugador");
					player = input.nextLine();
					answer = createNoticiaFutbol(dni, title, text, competition, club, player);
					break;
				case 2 :
					System.out.println("Introduce la competición");
					competition = input.nextLine();
					System.out.println("Introduce el club");
					club = input.nextLine();
					answer = createNoticiaBasquet(dni, title, text, competition, club);
					break;
				case 3 :
					System.out.println("Introduce la competición");
					competition = input.nextLine();
					System.out.println("Introduce el nombre del tenista");
					player = input.nextLine();
					answer = createNoticiaTenis(dni, title, text, competition, player);
					break;
				case 4 :
					System.out.println("Introduce la escudería");
					team = input.nextLine();
					answer = createNoticiaF1(dni, title, text,team);
					break;
				case 5 :
					System.out.println("Introduce el equipo");
					team = input.nextLine();
					answer = createNoticiaMoto(dni, title, text,team);
					break;
				}
				break;
			
		case 4 :
			System.out.println(redactorsList());
			System.out.println("Introduce el nombre y apellido del redactor que quieres consultar");
			name = input.nextLine();
			System.out.println(redactorArticlesByName(name));
			System.out.println("Introduce el titular de la noticia que quieres eliminar");
			title = input.nextLine();
			answer = deleteNoticia(name, title) + "\n" + redactorArticlesByName(name);
			break;
		
		case 5 :
			System.out.println(redactorsList());
			System.out.println("Introduce el DNI del redactor que quieres consultar");
			dni = input.nextLine();
			answer =redactorArticles(dni);
			break;
		
		case 6 :
			System.out.println(noticiasList());
			System.out.println("Introduce el nombre y apellido del redactor de la noticia");
			name = input.nextLine();
			System.out.println("Introduce el titular de la noticia para calcular los puntos");
			title = input.nextLine();
			answer = calculatePoints(name, title);
			break;
		
		case 7 :
			System.out.println(noticiasList());
			System.out.println("Introduce el nombre y apellido del redactor de la noticia");
			name = input.nextLine();
			System.out.println("Introduce el titular de la noticia para calcular el precio");
			title = input.nextLine();
			answer = calculatePrice(name, title);
			break;
		}
		
		System.out.println(answer);
//	NoticiaFutbol noticia = new NoticiaFutbol("increidble", "europe", "barça" , "Benzema");
//	System.out.println(noticia.calcularPreu());
		} while (option != 0);
		input.close();
	}



/////////////////// BUSCAR EL INDICE DE UN REDACTOR DENTRO DEL ARRAYLIST redactors por DNI
	public static int redactorIndex(String dni) {
		int redactorIndex = -1;
		for (int i = 0; i < redactors.size(); i++) {
			if (dni.equalsIgnoreCase(redactors.get(i).getDni())) 
				redactorIndex = i;
			}
			return redactorIndex;
	}

		
/////////////////// BUSCAR EL INDICE DE UN REDACTOR DENTRO DEL ARRAYLIST redactors por nombre
	public static int redactorIndexByName(String name) {
		int redactorIndexByName = -1;
		for (int i = 0; i < redactors.size(); i++) {
			if (name.equalsIgnoreCase(redactors.get(i).getNom())) 
				redactorIndexByName = i;
		}
		return redactorIndexByName;
	}
	
/////////////////// BUSCAR EL INDICE DE UNA NOTICIA POR EL Nombre DEL REDACTOR y el titulo
	public static int articleIndex(String name, String title) {
		int redactorIndex = redactorIndexByName(name);
		int articleIndex = -1;
		for (int i = 0 ; i < redactors.get(redactorIndex).getNoticias().size(); i++) {
				if(title.equalsIgnoreCase(redactors.get(redactorIndex).getNoticias().get(i).getTitular())) {
					articleIndex = i;
				}
				}
		return articleIndex;
		
	}
/////////////////// COMPROBAR SI ESTE DNI YA EXISTE DENTRO DE LA APP
	public static boolean existingDni(String dni) {
			boolean existingDni = false;
			for (Redactor r : redactors) {
				if (dni.equalsIgnoreCase(r.getDni())) {
					existingDni = true;
				}
			}
			return existingDni;
	}
/////////////////// MOSTRAR LA LISTA DE TODOS LOS REDACTORES	
	public static String redactorsList() {
		String redactorsList = "Lista redactores : \n";
		for(Redactor r : redactors) {
			redactorsList += "Nom : " + r.getNom() + " - DNI : " + r.getDni() + "\n";
		}
		return redactorsList;
	}

/////////////////// MOSTRAR LA LISTA DE TODAS LAS NOTICIAS 
	public static String noticiasList() { /////////ATTENTION NE MARCHE PAS 
		
		//////0. unr - Carlos López.1. waw - Carlos López.
		/////2. unr - Silvia Rodríguez.3. waw - Silvia Rodríguez.
		/////4. unr - Marc Faure.5. waw - Marc Faure.
		String noticiasList = "Lista noticias : \n";
		int i = 0;
		for(Redactor r : redactors) {
			for (Noticia n : r.getNoticias()) {
				noticiasList += i++ + ". " + n.getTitular() + " - " + r.getNom() + ".";
;			}
		}
		return noticiasList;
	}

/////////////////// DETERMINAR DE QUE DEPORTE HABLA LA NOTICIA DE NOTICIAS 
	public static String getSport(Noticia noticia) {
		String sport = "";
		if(noticia instanceof NoticiaFutbol ) {
			sport = "Futbol";
		} else if(noticia instanceof NoticiaBasquet ) {
			sport = "Basquet";
		} else if(noticia instanceof NoticiaTenis) {
			sport = "Tenis";
		} else if(noticia instanceof NoticiaF1 ) {
			sport = "F1";
		} else if(noticia instanceof NoticiaMoto ) {
			sport = "Motociclisme";
		}
		return sport;
	}
/////////////////// MOSTRAR LA LISTA DE NOTICIAS POR CADA REDACTOR BUSQUEDA POR DNI
	public static String redactorArticles(String dni) {
		int index = redactorIndex(dni);
		String redactorArticles = "Lista de las noticias del redactor/a : \n";
		Noticia noticia;
		String sport ="";
		String answer = "";
		if (index == -1){
			answer = "Comprueba el DNI introducido";
		} else {
				for (int i = 0 ; i < redactors.get(index).getNoticias().size() ; i++) {
				
					noticia = redactors.get(index).getNoticias().get(i);
					redactorArticles += (i+1) + ".- " + getSport(noticia) + " - " + noticia.getTitular() + "\n";
				}
				answer = redactorArticles;
			}
		return answer;
		}
	
/////////////////// MOSTRAR LA LISTA DE NOTICIAS POR CADA REDACTOR BUSQUEDA POR NOMBRE
public static String redactorArticlesByName(String name) {
	int index = redactorIndexByName(name);
	String redactorArticles = "Lista de las noticias del redactor/a : \n";
	String sport ="";
	String answer = "";
	Noticia noticia;
	if (index == -1){
		answer = "Comprueba el DNI introducido";
	} else {
		for (int i = 0 ; i < redactors.get(index).getNoticias().size() ; i++) {
		
			noticia = redactors.get(index).getNoticias().get(i);
			redactorArticles += (i+1) + ".- " + getSport(noticia) + " - " +noticia.getTitular() + "\n";
		}
		answer = redactorArticles;
	}
	return answer;
	}


///////////////// CREAR Y ELIMINAR UN REDACTOR
	public static String createRedactor(String name, String dni) {
		String answer = "";
		if(!existingDni(dni)) {
		Redactor newRedactor = new Redactor(name, dni);
		redactors.add(newRedactor);
		answer = "El redactor " + name + " con dni " + dni + " se ha creado." ;
		} else {
			answer = "Ya existe un redactor con est DNI. Vuelve a intentar";
		}
		return answer;
	}
	
	
	public static String deleteRedactor(String dni) {
		String answer="";
		int index = redactorIndex(dni);
			if (index == -1){
				answer = "Comprueba el DNI introducido";
			} else {
			redactors.remove(index);
			answer = "El redactor ha sido eliminado";
			}
		return answer;
	}
	
/////////////// CREAR LOS VARIOS TIPOS DE NOTICIAS
	public static String createNoticiaFutbol(String dni, String title, String text, 
											String competition, String club, String player){
		String answer = "";
		int index = redactorIndex(dni);
		if (index == -1) {
			answer = "No se ha encontrado este redactor";
		} else {
			for (Redactor r : redactors) {
				if (dni.equalsIgnoreCase(r.getDni())) {
				NoticiaFutbol newArticle = new NoticiaFutbol(title, competition, club, player);
				r.getNoticias().add(newArticle);
				answer = "La noticia ha sido creada"; // + lista noticias del redactor
				} 
			}
		}
		return answer;
	}
	
	public static String createNoticiaBasquet(String dni, String title, String text, 
										String competition, String club){
		String answer = "";
		int index = redactorIndex(dni);
		if (index == -1) {
			answer = "No se ha encontrado este redactor";
		} else {
		for (Redactor r : redactors) {
				if (dni.equalsIgnoreCase(r.getDni())) {
					NoticiaBasquet newArticle = new NoticiaBasquet(title, competition, club);
					r.getNoticias().add(newArticle);
					answer = "La noticia ha sido creada"; // + lista noticias del redactor
				} 			}
		}
		return answer;
	}
	
	public static String createNoticiaTenis(String dni, String title, String text, 
			String competition, String player){
			String answer = "";
			int index = redactorIndex(dni);
			if (index == -1) {
				answer = "No se ha encontrado este redactor";
			} else {
				for (Redactor r : redactors) {
					if (dni.equalsIgnoreCase(r.getDni())) {
						NoticiaTenis newArticle = new NoticiaTenis(title, competition, player);
						r.getNoticias().add(newArticle);
						answer = "La noticia ha sido creada"; // + lista noticias del redactor
					} 
				}
			}
			return answer;
	}
	
	public static String createNoticiaF1(String dni, String title, String text, 
			String team){
			String answer = "";
			int index = redactorIndex(dni);
			if (index == -1) {
				answer = "No se ha encontrado este redactor";
			} else {
				for (Redactor r : redactors) {
					if (dni.equalsIgnoreCase(r.getDni())) {
						NoticiaF1 newArticle = new NoticiaF1(title, team);
						r.getNoticias().add(newArticle);
						answer = "La noticia ha sido creada"; // + lista noticias del redactor
					} 
				}
			}
			return answer;
	}
	
	
	public static String createNoticiaMoto(String dni, String title, String text, 
			String team){
			String answer = "";
			int index = redactorIndex(dni);
			if (index == -1) {
				answer = "No se ha encontrado este redactor";
			} else {
				for (Redactor r : redactors) {
					if (dni.equalsIgnoreCase(r.getDni())) {
						NoticiaMoto newArticle = new NoticiaMoto(title, team);
						r.getNoticias().add(newArticle);
						answer = "La noticia ha sido creada"; // + lista noticias del redactor
					} 
				}
			}
			return answer;
	}
	
	/////////////////////ELIMINAR NOTICIA
	private static String deleteNoticia(String name, String title) {
		int redactorIndex = redactorIndexByName(name);
		int articleIndex = articleIndex(name, title);
		String answer = "";
		
		if(articleIndex == -1) {
			answer = "Este título no existe";
		} else {
		redactors.get(redactorIndex).getNoticias().remove(articleIndex);
		answer =  "La noticia ha sido eliminada";
		}
		return answer ;
	}
	
	
	//////////////////// CALCULAR PRECIO y puntos NOTICIA
	private static String calculatePrice(String name, String title) {
		int redactorIndex = redactorIndexByName(name);
		int articleIndex = articleIndex(name, title);
		String answer = "";
		int price; 
		if(articleIndex == -1) {
			answer = "Este título no existe";
		} else {
			price = redactors.get(redactorIndex).getNoticias().get(articleIndex).calcularPreu();
			answer = "El precio de la noticia es de " + price + " euros";
		}
		return answer;
	}
	
	private static String calculatePoints(String name, String title) {
		int redactorIndex = redactorIndexByName(name);
		int articleIndex = articleIndex(name, title);
		String answer = "";
		int points;
		if(articleIndex == -1) {
			answer = "Este título no existe";
		} else {
			points =  redactors.get(redactorIndex).getNoticias().get(articleIndex).calcularPunts();
			answer = "la noticia vale " + points + " puntos";
		}
		return answer;
	}
	
}
