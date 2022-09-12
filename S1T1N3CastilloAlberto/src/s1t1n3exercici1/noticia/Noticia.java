package s1t1n3exercici1.noticia;

public abstract class Noticia {
	private String tutular;
	private String texto;
	protected String competicion;
	private int puntuacion;
	private float precio;
	
	protected Noticia(String tutular, String competicion) {
		this.tutular = tutular;
		this.competicion = competicion;
		
	}
	
	public String getTitular() {
		return this.tutular;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	public void setPuntuacion() {
		this.puntuacion = calcularPuntuacion();
		
	}
	
	public float getPrecio() {
		return this.precio;
	}
	
	public void setPrecio() {
		this.precio = calcularPreuNoticia();
		
	}
	
	public abstract Categoria getCategoria();
	
	public abstract float calcularPreuNoticia();
	
	public abstract int calcularPuntuacion();
	
}
