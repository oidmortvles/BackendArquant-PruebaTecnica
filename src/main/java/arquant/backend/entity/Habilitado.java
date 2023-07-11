package arquant.backend.entity;



public class Habilitado{

	private int prodId;
	private int prodTalla;
	private boolean backsoon;
	private boolean special;
	private int prodCantidad;
	private boolean apto;
	private Integer orden;
	
	public Habilitado() {}
	
	public Habilitado(int prodId, int prodOrden, int prodTalla, boolean backsoon, int prodCantidad, boolean apto, Integer orden) {
		this.prodId = prodId;
		this.prodTalla = prodTalla;
		this.backsoon = backsoon;
		this.prodCantidad = prodCantidad;
		this.apto= apto;
		this.orden=orden;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}


	public int getProdTalla() {
		return prodTalla;
	}

	public void setProdTalla(int prodTalla) {
		this.prodTalla = prodTalla;
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

	public int getProdCantidad() {
		return prodCantidad;
	}

	public void setProdCantidad(int prodCantidad) {
		this.prodCantidad = prodCantidad;
	}

	public boolean isApto() {
		return apto;
	}

	public void setApto(boolean apto) {
		this.apto = apto;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "Habilitado [prodId=" + prodId + ", prodTalla=" + prodTalla + ", backsoon=" + backsoon + ", special="
				+ special + ", prodCantidad=" + prodCantidad + ", apto=" + apto + ", orden=" + orden + "]";
	}

	

	

	

	

	
	
	
	
	
	
}
