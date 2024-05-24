package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.Empleado;
import co.edu.konradlorenz.model.Nomina;

import javax.swing.*;
import java.awt.*;
import java.util.List;

	public class NominaView extends JFrame {
		private Nomina nomina;

		public NominaView(Nomina nomina) {
			this.nomina = nomina;
			setTitle("Reporte de Nómina");
			setSize(400, 300);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			initUI();
		}

		private void initUI() {
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);

			if (nomina != null) {
				List<Empleado> empleados = nomina.obtenerEmpleados();
				if (empleados != null) {
					StringBuilder reportesNomina = new StringBuilder();
					for (Empleado empleado : empleados) {
						double salario = empleado.calcularSalario();
						reportesNomina.append("Empleado: ").append(empleado.getNombre())
								.append(", Salario: ").append(salario).append("\n");
					}
					textArea.setText(reportesNomina.toString());
				} else {
					textArea.setText("Error: La lista de empleados está vacía o no se pudo cargar.");
				}
			} else {
				textArea.setText("Error: La nómina no está inicializada.");
			}

			JScrollPane scrollPane = new JScrollPane(textArea);
			add(scrollPane, BorderLayout.CENTER);
		}

		public static void main(String[] args) {
			SwingUtilities.invokeLater(() -> {
				Nomina nomina = new Nomina();
				NominaView nominaView = new NominaView(nomina);
				nominaView.setVisible(true);
			});
		}
	}