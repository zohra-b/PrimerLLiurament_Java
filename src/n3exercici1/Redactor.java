package n3exercici1;

import java.util.ArrayList;

public class Redactor {
	
// 1 atributs
	private String nom;
	private String dni;
	private static int sou = 1500;
	private ArrayList<Noticia> noticias = new ArrayList<Noticia>();

// 2 constructor
	public Redactor(String nom , String dni) {
		this.nom = nom;
		this.dni = dni;
	}
	
// 3 getters return
	public String getNom() {
		return this.nom;
	}
	public String getDni() {
		return this.dni;
	}
	
	public ArrayList<Noticia> getNoticias(){
		return noticias;
	}
	
// 4 setters void
	public void setNom(String nom) {
		this.nom = nom;
	}
	public static void setSou(int sou) {
		Redactor.sou = sou;
	}

// 5 metodes generals

// 6 metodes propis
	public String toString() {
		return "Soy el redactor " + this.nom + " con el DNI " + this.dni + "y como todos mis compañeros mi sueldo es de "
				+ sou + " euros";
	}
}
