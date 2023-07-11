package arquant.backend.entity;

public class Stock {

	private int idTalla;
	private int cantidad;
	
	public Stock() {
		
	}
	
	public Stock(int idTalla, int cantidad) {
		this.idTalla = idTalla;
		this.cantidad = cantidad;
	}

	public int getIdTalla() {
		return idTalla;
	}

	public void setIdTalla(int idTalla) {
		this.idTalla = idTalla;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Stock [idTalla=" + idTalla + ", cantidad=" + cantidad + "]";
	}
	
	
	
}
