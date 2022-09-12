package s1t1n3exercici1.noticia;

public class NBaloncesto extends Noticia {
	private String club;
	
	public NBaloncesto(String tutular, String competicion, String club) {
		super(tutular, competicion);
		this.club = club;
	}
	
	@Override
	public float calcularPreuNoticia() {
		float preu = 250;
		final float BARCA_MADRID = 75;
		final float EUROLIGA = 75;
		
		if (super.competicion.equalsIgnoreCase("Euroliga")) {
			preu = preu + EUROLIGA;
			
		}
		
		if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
			preu = preu + BARCA_MADRID;
		}
		
		return preu;
	}
	
	@Override
	public int calcularPuntuacion() {
		int puntos = 4;
		final int EUROLIGA = 3;
		final int ACB = 2;
		final int BARCA_MADRID = 1;
		
		if (super.competicion.equalsIgnoreCase("Euroliga")) {
			puntos = puntos + EUROLIGA;
			
		}
		
		if (super.competicion.equalsIgnoreCase("ACB")) {
			puntos = puntos + ACB;
		}
		
		if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
			puntos = puntos + BARCA_MADRID;
		}
		
		return puntos;
	}
	
	@Override
	public Categoria getCategoria() {
		return Categoria.BALONCESTO;
	}
	
	@Override
	public String toString() {
		return "NBaloncesto [club=" + club + "]";
	}
	
}
