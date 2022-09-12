package s1t1n3exercici1.noticia;

public class NFutbol extends Noticia {
	
	private String club;
	private String jugador;
	
	public NFutbol(String titular, String competicion, String club, String jugador) {
		super(titular, competicion);
		
		this.club = club;
		this.jugador = jugador;
		super.setPrecio();
		super.setPuntuacion();
		
	}
	
	// Método que añade la categoría utilizando una clase ENUM
	@Override
	public Categoria getCategoria() {
		return Categoria.FUTBOL;
		
	}
	
	// Método para calcular el precio de una noticias
	@Override
	public float calcularPreuNoticia() {
		float preu = 300;
		final float LIGA_CAMPEONES = 100;
		final float BARCA_MADRID = 100;
		final float FERRAN_BENZEMA = 50;
		
		if (super.competicion.equalsIgnoreCase("liga de campeones")) {
			preu = preu + LIGA_CAMPEONES;
			
		}
		if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
			preu = preu + BARCA_MADRID;
			
		}
		
		if (this.jugador.equalsIgnoreCase("Benzema") || this.jugador.equalsIgnoreCase("Ferran Torres")) {
			preu = preu + FERRAN_BENZEMA;
			
		}
		
		return preu;
	}
	
	// Método para calcular la puntuación de una noticias
	@Override
	public int calcularPuntuacion() {
		int puntos = 5;
		final int LIGA_CAMPEONES = 3;
		final int LIGA = 2;
		final int BARCA_MADRID = 1;
		final int FERRAN_BENZEMA = 1;
		
		if (this.competicion.equalsIgnoreCase("liga de campeones")) {
			puntos = puntos + LIGA_CAMPEONES;
			
		}
		
		if (this.competicion.equalsIgnoreCase("liga")) {
			puntos = puntos + LIGA;
			
		}
		
		if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
			puntos = puntos + BARCA_MADRID;
			
		}
		
		if (this.jugador.equalsIgnoreCase("Benzema") || this.jugador.equalsIgnoreCase("Ferran Torres")) {
			puntos = puntos + FERRAN_BENZEMA;
			
		}
		
		return puntos;
	}
	
	@Override
	public String toString() {
		return "Categoria: " + getCategoria() + "\n" + "titular:  " + super.getTitular() + "\n" + "competicion: "
				+ super.competicion + "\n" + "club: " + club + "\n" + "jugador: " + jugador;
	}
	
}
