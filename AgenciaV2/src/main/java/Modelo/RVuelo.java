package Modelo;

public class RVuelo {
	
	String codSucursal;
	String codVuelo;
	String compania;
	String origen;
	String destino;
	String fechaS;
	String fechaL;
	String nombreCliente;
	String dniCliente;
	String tlfCliente;
	
	public RVuelo() {
		codSucursal = "";
		codVuelo="";
		compania="";
		origen="";
		destino="";
		fechaS="";
		fechaL="";
		nombreCliente = "";
		dniCliente = "";
		tlfCliente = "";
		
	}

	public String getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
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

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getTlfCliente() {
		return tlfCliente;
	}

	public void setTlfCliente(String tlfCliente) {
		this.tlfCliente = tlfCliente;
	}
	
	
	

}
