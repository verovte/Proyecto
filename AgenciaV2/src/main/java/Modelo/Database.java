/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static Modelo.Conexiones.manejaConexion;
/**
 *
 * @author Vero
 */
public class Database {


	public static final String conexion = "/ConexionBD.txt";

	List<String> listaArchivo = manejaConexion(conexion);

	private String db = listaArchivo.get(0);

	private String user = listaArchivo.get(1);

	private String password = listaArchivo.get(2);

	private String url = listaArchivo.get(3) + db;

	private Connection con = null;

	public Database() {

		//this.url = "jdbc:mysql://vvizcaino.salesianas.es/" + this.db + "?useTimezone=true&serverTimezone=UTC";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	public Connection getConexion() {
		return this.con;
	}
}
