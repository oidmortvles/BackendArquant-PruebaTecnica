package arquant.backend.entity;

public class Producto {
	private int id;
	private int orden;
	
	public Producto() {
		
	}
	
	public Producto(int id, int orden) {
		this.id = id;
		this.orden = orden;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", orden=" + orden + "]";
	}
	
	
	
	
	
	
}
