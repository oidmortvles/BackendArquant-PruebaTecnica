package arquant.backend.entity;

public class Talla {
	
	private int idTalla;
	private int idProducto;
	private boolean backsoon;
	private boolean special;
	
	public Talla() {
		
	}
	
	public Talla(int idTalla, int idProducto, boolean backsoon, boolean special) {
		this.idTalla = idTalla;
		this.idProducto = idProducto;
		this.backsoon = backsoon;
		this.special = special;
	}

	public int getIdTalla() {
		return idTalla;
	}

	public void setIdTalla(int idTalla) {
		this.idTalla = idTalla;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public boolean isBacksoon() {
		return backsoon;
	}

	public void setBacksoon(boolean backsoon) {
		this.backsoon = backsoon;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	@Override
	public String toString() {
		return "Talla [idTalla=" + idTalla + ", idProducto=" + idProducto + ", backsoon=" + backsoon + ", special="
				+ special + "]";
	}
	
	


}
