/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodri
 */
public class ModeloAgencia extends Database{
    Database conn;

    public ModeloAgencia() {
        conn=new Database();
    }
    
   public ArrayList<Hotel> listHoteles() {
        ArrayList listaHoteles = new ArrayList();
        Hotel hotel;
        try {
            Connection acceDB = conn.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("{CALL BuscarHotel()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hotel = new Hotel();
                hotel.setCodH(rs.getString(1));
                hotel.setNombre(rs.getString(2));
                hotel.setCiudad(rs.getString(3));
                hotel.setNumEstrellas(rs.getString(4));
                hotel.setRegimen(rs.getString(5));
                hotel.setClaseHabitacion(rs.getString(6));
                listaHoteles.add(hotel);
            }
        } catch (Exception e) {
        }
        return listaHoteles;
    }
   // reserva hotel
   public ArrayList<RHotel> listRHoteles() {
       ArrayList listaRHoteles = new ArrayList();
       RHotel rhotel;
       try {
           Connection acceDB = conn.getConexion();
           PreparedStatement ps = acceDB.prepareStatement("{CALL BuscarHotel()}");
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
        	   rhotel = new RHotel();
        	   rhotel.setCodSucursal(rs.getString(1));
        	   rhotel.setCodH(rs.getString(2));
        	   rhotel.setNombre(rs.getString(3));
        	   rhotel.setCiudad(rs.getString(4));
        	   rhotel.setNumEstrellas(rs.getString(5));
        	   rhotel.setRegimen(rs.getString(6));
        	   rhotel.setClaseHabitacion(rs.getString(7));
        	   rhotel.setNombreCliente(rs.getString(8));
        	   rhotel.setDniCliente(rs.getString(9));
        	   rhotel.setTlfCliente(rs.getString(10));
        	   rhotel.setFechaE(rs.getString(11));
        	   rhotel.setFechaS(rs.getString(12));
               listaRHoteles.add(rhotel);
           }
       } catch (Exception e) {
       }
       return listaRHoteles;
   }
   
   
   
   /*public ArrayList<Hotel> buscarHotel(String nombre, String ciudad, String numEstrellas, String regimen, String claseHabitacion ) {
       ArrayList<Hotel> listaHotel = new ArrayList();
       Hotel hotel;
       try {
           Connection acceDB = conn.getConexion();
           CallableStatement cs = acceDB.prepareCall("{CALL BusacrHotel(?,?,?,?,?)}");
           cs.setString(1, nombre);
           cs.setString(2, ciudad);
           cs.setString(3, numEstrellas);
           cs.setString(4, regimen);
           cs.setString(5, claseHabitacion);
           ResultSet rs = cs.executeQuery();
           while (rs.next()) {
               hotel = new Hotel();
               hotel.setNombre(rs.getString(1));
               hotel.setCiudad(rs.getString(2));
               hotel.setNumEstrellas(rs.getString(3));
               hotel.setRegimen(rs.getString(4));
               hotel.setClaseHabitacion(rs.getString(5));
               listaHotel.add(hotel);
           }
       } catch (Exception e) {
       }

       return listaHotel;

   }*/
    
   public ArrayList<Vuelo> listVuelos() {
       ArrayList listaVuelos = new ArrayList();
       Vuelo vuelo;
       try {
           Connection acceDB = conn.getConexion();
           PreparedStatement ps = acceDB.prepareStatement("{CALL BuscarVuelo()}");
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               vuelo = new Vuelo();
               vuelo.setCodVuelo(rs.getString(1));
               vuelo.setCompania(rs.getString(2));
               vuelo.setOrigen(rs.getString(3));
               vuelo.setDestino(rs.getString(4));
               vuelo.setFechaS(rs.getString(5));
               vuelo.setFechaL(rs.getString(6));
               listaVuelos.add(vuelo);
           }
       } catch (Exception e) {
       }
       return listaVuelos;
   }
   
   // reserva vuelo
   public ArrayList<RVuelo> listRVuelos() {
       ArrayList listaRVuelos = new ArrayList();
       RVuelo rvuelo;
       try {
           Connection acceDB = conn.getConexion();
           PreparedStatement ps = acceDB.prepareStatement("{CALL MostrarRVuelo()}");
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               rvuelo = new RVuelo();
               rvuelo.setCodSucursal(rs.getString(1));
               rvuelo.setCodVuelo(rs.getString(2));
               rvuelo.setCompania(rs.getString(3));
               rvuelo.setOrigen(rs.getString(4));
               rvuelo.setDestino(rs.getString(5));
               rvuelo.setFechaS(rs.getString(6));
               rvuelo.setFechaL(rs.getString(7));
               rvuelo.setNombreCliente(rs.getString(8));
               rvuelo.setDniCliente(rs.getString(9));
               rvuelo.setTlfCliente(rs.getString(10));
               listaRVuelos.add(rvuelo);
           }
       } catch (Exception e) {
       }
       return listaRVuelos;
   }
   
   /*public ArrayList<RVuelo> buscarRVuelo(String compania, String origen, String destino, String fechaS, String fechaL ) {
       ArrayList<RVuelo> listaRVuelo = new ArrayList();
       Vuelo vuelo;
       try {
           Connection acceDB = conn.getConexion();
           CallableStatement cs = acceDB.prepareCall("{CALL BuscarVuelo(?,?,?,?,?)}");
           cs.setString(1, compania);
           cs.setString(2, origen);
           cs.setString(3, destino);
           cs.setString(4, fechaS);
           cs.setString(5, fechaL);
           ResultSet rs = cs.executeQuery();
           while (rs.next()) {
               vuelo = new Vuelo();
               vuelo.setCompania(rs.getString(1));
               vuelo.setOrigen(rs.getString(2));
               vuelo.setDestino(rs.getString(3));
               vuelo.setFechaS(rs.getString(4));
               vuelo.setFechaL(rs.getString(5));
               listaVuelo.add(vuelo);
           }
       } catch (Exception e) {
       }

       return listaVuelo;

   }*/
   
   public String insertReservaH(String codSucusal, String nombre, String ciudad, String numEstrellas, String regimen, String claseHabitacion, String nombreC, String dni,  String tlf, String codH ) {
       String rptaRegistro = null;
       try {
           Connection accesoDB = conn.getConexion();
           CallableStatement cs = accesoDB.prepareCall("{CALL insertReservaH(?,?,?,?,?,?,?,?,?,?)}");
           cs.setString(1, codSucusal);
           cs.setString(2, nombre);
           cs.setString(3, ciudad);
           cs.setString(4, numEstrellas);
           cs.setString(5, regimen);
           cs.setString(6, claseHabitacion);
           cs.setString(7, nombreC);
           cs.setString(8, dni);
           cs.setString(9, tlf);
           cs.setString(10, codH);
           

           int numFAfectadas = cs.executeUpdate();
           if (numFAfectadas > 0) {
               rptaRegistro = "Registro exitoso.";
           }
       } catch (Exception e) {
       }
       return rptaRegistro;
   }
   
   public String insertReservaV(String codSucusal, String empresa, String origen, String destino, String fechaSalida, String fechaLlegada, String nombreC, String dni, String tlf, String codV) {
       String rptaRegistro = null;
       try {
           Connection accesoDB = conn.getConexion();
           CallableStatement cs = accesoDB.prepareCall("{CALL insertReservaV(?,?,?,?,?,?,?,?,?,?)}");
           cs.setString(1, codSucusal);
           cs.setString(2, empresa);
           cs.setString(3, origen);
           cs.setString(4, destino);
           cs.setString(5, fechaSalida);
           cs.setString(6, fechaLlegada);
           cs.setString(7, nombreC);
           cs.setString(8, dni);
           cs.setString(9, tlf);
           cs.setString(10, codV);
           

           int numFAfectadas = cs.executeUpdate();
           if (numFAfectadas > 0) {
               rptaRegistro = "Registro exitoso.";
           }
       } catch (Exception e) {
       }
       return rptaRegistro;
   }
    
    FileOutputStream salida;
    File archivo;
    FileReader entrada2;
	BufferedReader mibuffer;
	// ABRIR UN FICHERO Y MOSTRARLO EN UN TEXTAREA
    public String AbrirTexto(File archivo){
        String contenido ="";
        String linea = "";
        
        try {

        	entrada2 = new FileReader(archivo);
        	mibuffer = new BufferedReader(entrada2);

            while ((linea = mibuffer.readLine()) != null){

                contenido+= linea;
            	
            }
            
            entrada2.close();
            mibuffer.close();
        }catch (Exception e){}finally {
        	 try {
                 //Cerrar el fichero si se ha abierto
                 if(entrada2 != null)
                	 entrada2.close();
             }
             catch (Exception e) {
                 System.out.println("Error al cerrar el fichero");
                 System.out.println(e.getMessage());
             }
        }
        
        return contenido;
    }
    // GUARDAR UN FICHERO MODIFICADO DESDE EL TEXTAREA
    public String GuardarAtexto(File archivo, String contenido){
    	
    	BufferedWriter mibuffwrite;
        String respuesta = null;
        try{
            salida = new FileOutputStream(archivo);
            mibuffwrite = new BufferedWriter(new OutputStreamWriter(salida));

            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);

            respuesta = "Se guardo con exito el archivo";
            salida.close();
        }catch(Exception e){}
        
        return respuesta;
    }
   
}
