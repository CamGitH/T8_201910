package model.estructuras;

public class Vertecss {

	private double latitud;
	private double longitud;
	private long id;
	
	
	
	public Vertecss(double latitud, double longitud, long id) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.id = id;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
