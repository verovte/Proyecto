package Modelo;

public class Vuelo {
	String codVuelo;
	String compania;
	String origen;
	String destino;
	String fechaS;
	String fechaL;
	
	public Vuelo() {
		codVuelo="";
		compania="";
		origen="";
		destino="";
		fechaS="";
		fechaL="";
	}

	public String getCodVuelo() {
		return codVuelo;
	}

	public void setCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getFechaS() {
		return fechaS;
	}

	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
	}

	public String getFechaL() {
		return fechaL;
	}

	public void setFechaL(String fechaL) {
		this.fechaL = fechaL;
	}
	

}
