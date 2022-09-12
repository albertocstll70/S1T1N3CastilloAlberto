package s1t1n3exercici1.noticia;

public class NFormula1 extends Noticia {
	
	private String escuderia;
	
	public NFormula1(String titular, String competicion, String escuderia) {
		super(titular, competicion);
		
		this.escuderia = escuderia;
		
	}
	
	@Override
	public float calcularPreuNoticia() {
		
		float preu = 100;
		final float FERRARI_MERCEDES = 50;
		
		if (this.escuderia.equalsIgnoreCase("Ferrari") || this.escuderia.equalsIgnoreCase("Mercedes")) {
			preu = preu + FERRARI_MERCEDES;
		}
		
		return preu;
		
	}
	
	@Override
	public int calcularPuntuacion() {
		int puntos = 4;
		final int FERRARI_MERCEDES = 2;
		
		if (this.escuderia.equalsIgnoreCase("Ferrari") || this.escuderia.equalsIgnoreCase("Mercedes")) {
			
			puntos = puntos + FERRARI_MERCEDES;
		}
		
		return puntos;
	}
	
	@Override
	public Categoria getCategoria() {
		
		return Categoria.FORMULA1;
	}
	
	@Override
	public String toString() {
		return "NF1 [escuderia=" + escuderia + "]";
	}
	
}
