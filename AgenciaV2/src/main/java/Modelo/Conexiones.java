package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Conexiones {
	
	public static List<String> manejaConexion(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		List<String> listaArchivo = new ArrayList<String>();

		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			int cont = 1;
			while (cont < 4) {
				listaArchivo.add(entrada.readLine());
				cont++;
			}
			entrada.close();
		} catch (IOException e) {
			listaArchivo.add("vvizcaino_AgenciaViajes");
			listaArchivo.add("vvizc_1234");
			listaArchivo.add("N@3ssa+85");
			listaArchivo.add("jdbc:mysql://vvizcaino.salesianas.es/");
		}

		return listaArchivo;

	}

}
