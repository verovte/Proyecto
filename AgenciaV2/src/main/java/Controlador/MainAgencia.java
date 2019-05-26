package Controlador;

import Modelo.ModeloAgencia;
import Vista.Inicio;

public class MainAgencia {

	public static void main(String[] args) {
		Inicio vistaAgencia = new Inicio();
		ModeloAgencia agencia = new ModeloAgencia();
		ControladorAgencia controlA = new ControladorAgencia(vistaAgencia, agencia);

		vistaAgencia.setVisible(true);
		vistaAgencia.setLocationRelativeTo(null);
	}

}
