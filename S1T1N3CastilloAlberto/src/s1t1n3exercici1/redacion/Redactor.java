package s1t1n3exercici1.redacion;

import java.util.ArrayList;

import s1t1n3exercici1.noticia.Noticia;

public class Redactor {
	
	private String nombre;
	private final String dni;
	public static final float SUELDO = 1500;
	
	private ArrayList<Noticia> listNoticia;
	
	public Redactor(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.listNoticia = new ArrayList<Noticia>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public static float getSueldo() {
		return SUELDO;
	}
	
	public ArrayList<Noticia> getListNoticia() {
		return listNoticia;
	}
	
	public void introducirNoticia(Noticia n) {
		this.listNoticia.add(n);
	}
	
	@Override
	public String toString() {
		return "Redator: " + nombre + ", dni: " + dni + " Sueldo: " + getSueldo();
	}
	
}
