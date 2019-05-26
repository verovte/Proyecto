package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloAgencia;
import Vista.Inicio;

public class ControladorAgencia implements ActionListener, MouseListener {

	Inicio vistaAgencia = new Inicio();
	ModeloAgencia agencia = new ModeloAgencia();

	public ControladorAgencia(Inicio vistaAgencia, ModeloAgencia agencia) {
		this.agencia = agencia;
		this.vistaAgencia = vistaAgencia;
		this.vistaAgencia._BuscarH.addActionListener(this);
		this.vistaAgencia._BuscarV.addActionListener(this);
		this.vistaAgencia._CancelarH.addActionListener(this);
		this.vistaAgencia._CancelarV.addActionListener(this);
		this.vistaAgencia._RervarH.addActionListener(this);
		this.vistaAgencia._RervarV.addActionListener(this);
		//this.vistaAgencia.JTableReservas.addActionListener(this);
	}

	/*
	 * vistaCliente.btnRegistrarCliente.addActionListener(this);
	 * this.vistaCliente.btnActualizarCliente.addActionListener(this);
	 * this.vistaCliente.btnEditarCliente.addActionListener(this);
	 * this.vistaCliente.btnEliminarCliente.addActionListener(this);
	 * this.vistaCliente.btnGEditCliente.addActionListener(this);
	 * this.vistaCliente.txtTelefonoCliente.addKeyListener(this);
	 */

	public void InicializarAgencia() {

	}

	// Tabla hotel
	public void LlenarTabla(JTable tablaD) {
		DefaultTableModel modeloT = new DefaultTableModel();
		tablaD.setModel(modeloT);

		modeloT.addColumn("CodHotel");
		modeloT.addColumn("Nombre");
		modeloT.addColumn("Ciudad");
		modeloT.addColumn("NºEstrellas");
		modeloT.addColumn("Regimen");
		modeloT.addColumn("Clase Habitacion");

		Object[] columna = new Object[6];

		int numRegistros = agencia.listHoteles().size();

		for (int i = 0; i < numRegistros; i++) {
			columna[0] = agencia.listHoteles().get(i).getCodH();
			columna[1] = agencia.listHoteles().get(i).getNombre();
			columna[2] = agencia.listHoteles().get(i).getCiudad();
			columna[3] = agencia.listHoteles().get(i).getNumEstrellas();
			columna[4] = agencia.listHoteles().get(i).getRegimen();
			columna[5] = agencia.listHoteles().get(i).getClaseHabitacion();

			modeloT.addRow(columna);
		}
	}

	public void LimpiarElementos() {
		vistaAgencia._CodH.setText("");
		vistaAgencia._NombreH.setText("");
		vistaAgencia._Ciu.setText("");
		vistaAgencia._NEstrellas.setText("");
		vistaAgencia._Reg.setText("");
		vistaAgencia._ClaseH.setText("");
	}

	// Tabla Vuelos
	public void LlenarTablaV(JTable tablaD) {
		DefaultTableModel modeloT = new DefaultTableModel();
		tablaD.setModel(modeloT);

		modeloT.addColumn("CodVuelo");
		modeloT.addColumn("Compañia");
		modeloT.addColumn("Origen");
		modeloT.addColumn("Destino");
		modeloT.addColumn("Fecha Salida");
		modeloT.addColumn("Fecha Llegada");

		Object[] columna = new Object[6];

		int numRegistros = agencia.listVuelos().size();

		for (int i = 0; i < numRegistros; i++) {
			columna[0] = agencia.listVuelos().get(i).getCodVuelo();
			columna[1] = agencia.listVuelos().get(i).getCompania();
			columna[2] = agencia.listVuelos().get(i).getOrigen();
			columna[3] = agencia.listVuelos().get(i).getDestino();
			columna[4] = agencia.listVuelos().get(i).getFechaS();
			columna[5] = agencia.listVuelos().get(i).getFechaL();
			modeloT.addRow(columna);
		}
	}

	public void LimpiarElementosV() {
		vistaAgencia._CodV.setText("");
		vistaAgencia._Compania.setText("");
		vistaAgencia._Origen.setText("");
		vistaAgencia._Destino.setText("");
		vistaAgencia._FechaS.setText("");
		vistaAgencia._FechaL.setText("");
	}

	// Botones
	public void actionPerformed(ActionEvent e) {

		// Llenar tabla hoteles
		if (e.getSource() == vistaAgencia._BuscarH) {
			LlenarTabla(vistaAgencia._Tab_H);
		}
		// Llenar tabla vuelos
		if (e.getSource() == vistaAgencia._BuscarV) {
			LlenarTablaV(vistaAgencia._Tab_V);
		}
		// Borrar datos introducidos en Hotel
		if (e.getSource() == vistaAgencia._CancelarH) {
			LimpiarElementos();
			JOptionPane.showMessageDialog(null, "Su reserva ha sido cancelada!");
		}
		// Borrar datos introducidos en Vuelo
		if (e.getSource() == vistaAgencia._CancelarV) {
			LimpiarElementosV();
			JOptionPane.showMessageDialog(null, "Su reserva ha sido cancelada!");
		}
		// Insert datos en la tabla de reservaHotel
		if (e.getSource() == vistaAgencia._RervarH) {
			String codSucursal = vistaAgencia._CodSuc.getText();
			String nombreH = vistaAgencia._NombreH.getText();
			String ciudad = vistaAgencia._Ciu.getText();
			String numEstrellas = vistaAgencia._NEstrellas.getText();
			String regimen = vistaAgencia._Reg.getText();
			String claseHabitacion = vistaAgencia._ClaseH.getText();
			String nombreC = vistaAgencia._NombreC.getText();
			String dni = vistaAgencia._Dni.getText();
			String tlfCliente = vistaAgencia._Tlf.getText();
			String codH = vistaAgencia._CodH.getText();

			String rptaRegistro = agencia.insertReservaH(codSucursal, nombreH, ciudad, numEstrellas, regimen,
					claseHabitacion, nombreC, dni, tlfCliente, codH);

			if (rptaRegistro != null) {
				JOptionPane.showMessageDialog(null, rptaRegistro);
			} else {
				JOptionPane.showMessageDialog(null, "Registro Erroneo.");
			}
		}
		// Insert datos en la tabla reservaV
		if (e.getSource() == vistaAgencia._RervarV) {

			String codSucursal = vistaAgencia._CodSuc.getText();
			String empresa = vistaAgencia._Compania.getText();
			String origen = vistaAgencia._Origen.getText();
			String destino = vistaAgencia._Destino.getText();
			String fechaSalida = vistaAgencia._FechaS.getText();
			String fechaLlegada = vistaAgencia._FechaL.getText();
			String nombreC = vistaAgencia._NombreC.getText();
			String dniCliente = vistaAgencia._Dni.getText();
			String tlfCliente = vistaAgencia._Tlf.getText();
			String codV = vistaAgencia._CodV.getText();

			String rptaRegistro = agencia.insertReservaV(codSucursal, empresa, origen, destino, fechaSalida,
					fechaLlegada, nombreC, dniCliente, tlfCliente, codV);

			if (rptaRegistro != null) {
				JOptionPane.showMessageDialog(null, rptaRegistro);
			} else {
				JOptionPane.showMessageDialog(null, "Registro Erroneo.");
			}
		}
		/* Insert datos de las reservas de Vuelos en la tabla reservas
		if (e.getSource() == vistaAgencia._RervarV) {

			String codSucursal = vistaAgencia._CodSuc.getText();
			String empresa = vistaAgencia._Compania.getText();
			String origen = vistaAgencia._Origen.getText();
			String destino = vistaAgencia._Destino.getText();
			String fechaSalida = vistaAgencia._FechaS.getText();
			String fechaLlegada = vistaAgencia._FechaL.getText();
			String nombreC = vistaAgencia._NombreC.getText();
			String dniCliente = vistaAgencia._Dni.getText();
			String tlfCliente = vistaAgencia._Tlf.getText();
			String codV = vistaAgencia._CodV.getText();

			String rptaRegistro = agencia.insertReservaV(codSucursal, empresa, origen, destino, fechaSalida,
					fechaLlegada, nombreC, dniCliente, tlfCliente, codV);

			if (rptaRegistro != null) {
				JOptionPane.showMessageDialog(null, rptaRegistro);
			} else {
				JOptionPane.showMessageDialog(null, "Registro Erroneo.");
			}
		}*/

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
