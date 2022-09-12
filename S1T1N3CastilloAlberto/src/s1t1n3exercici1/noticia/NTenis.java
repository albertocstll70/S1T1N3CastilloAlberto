package s1t1n3exercici1.noticia;

public class NTenis extends Noticia {
	
	private String tenista;
	
	public NTenis(String tutular, String competicion, String tenista) {
		super(tutular, competicion);
		this.competicion = competicion;
		this.tenista = tenista;
	}
	
	@Override
	public float calcularPreuNoticia() {
		float preu = 150;
		final float FEDERER_NADAL_DJOKOVIC = 100;
		
		if (this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal")
				|| this.tenista.equalsIgnoreCase("Djokovic")) {
			
			preu = preu + FEDERER_NADAL_DJOKOVIC;
		}
		return preu;
	}
	
	@Override
	public int calcularPuntuacion() {
		
		int puntos = 4;
		final int FEDERER_NADAL_DJOKOVIC = 3;
		
		if (this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal")
				|| this.tenista.equalsIgnoreCase("Djokovic")) {
			
			puntos = puntos + FEDERER_NADAL_DJOKOVIC;
		}
		
		return 0;
	}
	
	@Override
	public Categoria getCategoria() {
		
		return Categoria.TENIS;
	}
	
	@Override
	public String toString() {
		return "tenista : " + tenista;
	}
	
}
