/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rodri
 */
public class Hotel {
    
	 	String codH;
	    String nombre;
	    String ciudad;
	    String numEstrellas;
	    String regimen;
	    String claseHabitacion;
	    String disponible;
	                    
	    public Hotel(){
	    	codH="";
	        nombre="";
	        ciudad="";
	        numEstrellas="";
	        regimen="";
	        claseHabitacion="";
	        disponible="";
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		public String getNumEstrellas() {
			return numEstrellas;
		}

		public void setNumEstrellas(String numEstrellas) {
			this.numEstrellas = numEstrellas;
		}

		public String getRegimen() {
			return regimen;
		}

		public void setRegimen(String regimen) {
			this.regimen = regimen;
		}

		public String getClaseHabitacion() {
			return claseHabitacion;
		}

		public void setClaseHabitacion(String clasHabitacion) {
			this.claseHabitacion = clasHabitacion;
		}

		public String getCodH() {
			return codH;
		}

		public void setCodH(String codH) {
			this.codH = codH;
		}

		public String getDisponible() {
			return disponible;
		}

		public void setDisponible(String disponible) {
			this.disponible = disponible;
		}
		
	    
    
}
