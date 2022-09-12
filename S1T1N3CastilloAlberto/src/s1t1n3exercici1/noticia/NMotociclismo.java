package s1t1n3exercici1.noticia;

public class NMotociclismo extends Noticia {
	
	private String equipo;
	
	public NMotociclismo(String tutular, String competicion, String equipo) {
		super(tutular, competicion);
		this.competicion = competicion;
		this.equipo = equipo;
	}
	
	@Override
	public Categoria getCategoria() {
		
		return Categoria.MOTOCICLISMO;
		
	}
	
	@Override
	public float calcularPreuNoticia() {
		float preu = 100;
		final float HONDA_YAMAHA = 50;
		if (this.equipo.equalsIgnoreCase("Honda") || this.equipo.equalsIgnoreCase("Yamaha")) {
			
			preu = preu + HONDA_YAMAHA;
		}
		
		return preu;
	}
	
	@Override
	public int calcularPuntuacion() {
		int puntos = 3;
		final int HONDA_YAMAHA = 3;
		if (this.equipo.equalsIgnoreCase("Honda") || this.equipo.equalsIgnoreCase("Yamaha")) {
			
			puntos = puntos + HONDA_YAMAHA;
		}
		
		return puntos;
		
	}
	
	@Override
	public String toString() {
		return "NMotociclismo [equipo=" + equipo + "]";
	}
	
}
