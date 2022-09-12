package s1t1n3exercici1;

import java.util.ArrayList;

import s1t1n3exercici1.noticia.NBaloncesto;
import s1t1n3exercici1.noticia.NFormula1;
import s1t1n3exercici1.noticia.NFutbol;
import s1t1n3exercici1.noticia.NMotociclismo;
import s1t1n3exercici1.noticia.NTenis;
import s1t1n3exercici1.noticia.Noticia;
import s1t1n3exercici1.redacion.Redactor;

public class MainExercici1 {
	
	public static void main(String[] args) {
		
		ArrayList<Redactor> listRedator = new ArrayList<Redactor>();
		
		Redactor redator = new Redactor("Pablo", "12345678Z");
		Redactor redator2 = new Redactor("Robert", "87654321X");
		
		listRedator.add(redator);
		listRedator.add(redator2);
		
		Noticia n1 = new NFutbol("Gol", "La liga", "Betis", "Joaquin");
		Noticia n2 = new NBaloncesto("Canasta", "Euroliga", "Madrid");
		Noticia n3 = new NTenis("Joven promesa", "Roland Garros", "Carlos Alcalaz");
		Noticia n4 = new NFormula1("Carlos Sainz jr", "Gran premio de España", "Ferrari");
		Noticia n5 = new NMotociclismo("La ausencia de Marc", "Gran premio de Catalunya", "Repsol Honda");
		
		redator.introducirNoticia(n1);
		redator.introducirNoticia(n2);
		redator2.introducirNoticia(n3);
		redator2.introducirNoticia(n4);
		redator2.introducirNoticia(n5);
		
		boolean sortir = false;
		do {
			switch (menu()) {
			case 1:
				introducirRedactor(listRedator);
				break;
			case 2:
				eliminarRedator(listRedator);
				break;
			case 3:
				introducirNoticia(listRedator);
				break;
			case 4:
				eliminarNoticia(listRedator);
				break;
			case 5:
				mostrarNoticaRedator(listRedator);
				break;
			case 6:
				calcularPuntuacionNoticia(listRedator);
				break;
			case 7:
				calcularPreuNoticia(listRedator);
				break;
			case 0:
				Entrada.escribir("Gracias por utilizar la aplicación");
				sortir = true;
				break;
			
			default:
				System.err.println("ERROR");
				break;
			}
		} while (!sortir);
		
	}
	
	// Menu
	public static byte menu() {
		
		byte opcio;
		
		final byte MINIMO = 0;
		final byte MAXIMO = 7;
		
		do {
			Entrada.escribir("\nMENú PRINCIPAL");
			Entrada.escribir("0. Salir de la aplicacion ");
			Entrada.escribir("1. Introducir redator ");
			Entrada.escribir("2. Eliminar  redator");
			Entrada.escribir("3. Introducir noticia redator");
			Entrada.escribir("4. Eliminar noticia ");
			Entrada.escribir("5. Mostrar todas las noticias por redator  ");
			Entrada.escribir("6. Calcular puntuación de la noticia");
			Entrada.escribir("7. Calcular precio-noticia ");
			
			opcio = Entrada.leerByte("Introduce una opción");
			Entrada.vaciarBuffer();
			
			if (opcio < MINIMO || opcio > MAXIMO) {
				Entrada.escribir("Escoje una opción valida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
		
	}
	
	// Método para dar de alta a un redactor
	public static void introducirRedactor(ArrayList<Redactor> listRedator) {
		
		String nombreRedator;
		String dni;
		
		nombreRedator = Entrada.leerString("Introduce el nombre de redator");
		dni = Entrada.leerDni("Introduce el DNI del redator");
		
		Redactor redator = buscarRedator(listRedator, dni);
		
		if (redator != null) {
			
			Entrada.escribir("El redator ya exite");
			
		} else {
			redator = new Redactor(nombreRedator, dni);
			listRedator.add(redator);
			
		}
		
	}
	
	// Método para buscar a un redactor, si no encuentra el objecto devuelve null
	public static Redactor buscarRedator(ArrayList<Redactor> listRedator, String dni) {
		
		Redactor redator = null;
		int size = listRedator.size();
		boolean encontrado = false;
		
		int i = 0;
		
		while (i < size && !encontrado) {
			if (listRedator.get(i).getDni().equalsIgnoreCase(dni)) {
				encontrado = true;
				redator = listRedator.get(i);
			}
			
			i++;
			
		}
		
		return redator;
	}
	
	public static void eliminarRedator(ArrayList<Redactor> listRedator) {
		
		String dni;
		dni = Entrada.leerDni("Introduce el DNI del redator");
		Redactor redator = buscarRedator(listRedator, dni);
		
		if (redator == null) {
			Entrada.escribir("No se encontrado el  redator ");
			
		} else {
			listRedator.remove(redator);
			
		}
		
	}
	
	// Método para introducir una noticia a un redactores
	public static void introducirNoticia(ArrayList<Redactor> listRedator) {
		
		String dni;
		dni = Entrada.leerDni("Introduce el DNI del redator");
		Redactor redator = buscarRedator(listRedator, dni);
		
		if (redator == null) {
			Entrada.escribir("No se encontrado el  redator ");
			
		} else {
			
			final byte MINIMO = 1;
			final byte MAXIMO = 5;
			byte opcion;
			
			String titular;
			String competicion;
			String equipo;
			String jugador;
			
			do {
				System.out.println("Elija una categoria de noticia");
				System.out.println("1. Futbol ");
				System.out.println("2. Baloncesto ");
				System.out.println("3. Tenis ");
				System.out.println("4. Formula 1");
				System.out.println("5. Motociclismo ");
				
				opcion = Entrada.leerByte("Introduce una opción");
				Entrada.vaciarBuffer();
				if (opcion < MINIMO || opcion > MAXIMO) {
					System.out.println("Escoje una opción valida");
				}
				
			} while (opcion < MINIMO || opcion > MAXIMO);
			
			switch (opcion) {
			
			case 1:
				titular = Entrada.leerString("Introduce la el titular");
				competicion = Entrada.leerString("Introduce la competición");
				equipo = Entrada.leerString("Introduce el club");
				jugador = Entrada.leerString("Introduce el jugador");
				
				Noticia noticia = new NFutbol(titular, competicion, equipo, jugador);
				redator.introducirNoticia(noticia);
				
				break;
			
			case 2:
				titular = Entrada.leerString("Introduce la el titular");
				competicion = Entrada.leerString("Introduce la competición");
				jugador = Entrada.leerString("Introduce el jugador");
				
				Noticia noticia2 = new NBaloncesto(titular, competicion, jugador);
				redator.introducirNoticia(noticia2);
				break;
			case 3:
				titular = Entrada.leerString("Introduce la el titular");
				competicion = Entrada.leerString("Introduce la competición");
				jugador = Entrada.leerString("Introduce el jugador");
				
				Noticia noticia3 = new NTenis(titular, competicion, jugador);
				redator.introducirNoticia(noticia3);
				break;
			case 4:
				titular = Entrada.leerString("Introduce la el titular");
				competicion = Entrada.leerString("Introduce la competición");
				equipo = Entrada.leerString("Introduce la escuderia");
				
				Noticia noticia4 = new NFormula1(titular, competicion, equipo);
				redator.introducirNoticia(noticia4);
				break;
			case 5:
				titular = Entrada.leerString("Introduce la el titular");
				competicion = Entrada.leerString("Introduce la competición");
				equipo = Entrada.leerString("Introduce la escuderia");
				
				Noticia noticia5 = new NMotociclismo(titular, competicion, equipo);
				redator.introducirNoticia(noticia5);
				break;
			
			default:
				System.err.println("ERROR");
				break;
			
			}
			
		}
		
	}
	
	// Método para eliminar una noticia
	public static void eliminarNoticia(ArrayList<Redactor> listRedator) {
		
		String dni;
		String titular;
		
		dni = Entrada.leerDni("Introduce el DNI del redator");
		titular = Entrada.leerString("Introduce el titular de la noticia");
		
		Redactor redator = buscarRedator(listRedator, dni);
		
		if (redator != null) {
			Noticia noticia = buscarNoticia(redator.getListNoticia(), titular);
			
			if (noticia != null) {
				redator.getListNoticia().remove(noticia);
				
			} else {
				Entrada.escribir("No se encontro la noticia");
				
			}
			
		} else {
			Entrada.escribir("No se encontro al redator");
			
		}
		
	}
	
	// Método para buscar una noticia
	public static Noticia buscarNoticia(ArrayList<Noticia> listNoticia, String titular) {
		Noticia noticia = null;
		int size = listNoticia.size();
		boolean encontrado = false;
		int i = 0;
		
		while (i < size && !encontrado) {
			if (listNoticia.get(i).getTitular().equalsIgnoreCase(titular)) {
				encontrado = true;
				noticia = listNoticia.get(i);
				
			}
			
			i++;
			
		}
		return noticia;
		
	}
	
//Método que muestra las noticias de un redactor 
	public static void mostrarNoticaRedator(ArrayList<Redactor> listRedator) {
		
		String dni;
		dni = Entrada.leerDni("Introduce el DNI del redator");
		Redactor redator = buscarRedator(listRedator, dni);
		
		if (redator != null) {
			
			for (Noticia n : redator.getListNoticia()) {
				Entrada.escribir("\nNoticia \n" + n + "\n");
				
			}
			
		} else {
			Entrada.escribir("No se encontro al redator");
			
		}
		
	}
	
	// Método que muestra el precio de una noticia
	public static void calcularPreuNoticia(ArrayList<Redactor> listRedator) {
		
		String titular;
		String dni;
		
		titular = Entrada.leerString("Introduce el titular de la noticia");
		dni = Entrada.leerString("Introduce el dni del redator");
		Redactor redator;
		redator = buscarRedator(listRedator, dni);
		
		if (redator != null) {
			Noticia noticia;
			noticia = buscarNoticia(redator.getListNoticia(), titular);
			
			if (noticia != null) {
				Entrada.escribir("El precio de la noticia es : " + noticia.calcularPreuNoticia());
				
			} else {
				Entrada.escribir("No se encontro la noticia");
				
			}
			
		} else {
			Entrada.escribir("No se encontro el redator");
			
		}
		
	}
	
	// Método que muestra la puntuación de una noticia
	public static void calcularPuntuacionNoticia(ArrayList<Redactor> listRedator) {
		
		String titular;
		String dni;
		
		titular = Entrada.leerString("Introduce el titular de la noticia");
		dni = Entrada.leerDni("Introduce el dni del redator");
		Redactor redator;
		redator = buscarRedator(listRedator, dni);
		
		if (redator != null) {
			Noticia noticia;
			noticia = buscarNoticia(redator.getListNoticia(), titular);
			
			if (noticia != null) {
				Entrada.escribir("La puntuación de la noticia es  : " + noticia.calcularPuntuacion());
				
			} else {
				Entrada.escribir("No se encontro la noticia");
				
			}
			
		} else {
			Entrada.escribir("No se encontro el redator");
			
		}
		
	}
	
}
