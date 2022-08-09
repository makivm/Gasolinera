package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import controladores.Principal;
import modelo.Repostaje;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoVentas extends JFrame {
	private JTable table;
	private Principal controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoVentas frame = new ListadoVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListadoVentas() {
		setTitle("Listado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 385);
		getContentPane().setLayout(new MigLayout("", "[grow][]", "[][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Listado de Ventas");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matr\u00EDcula", "Nombre", "DNI", "Combustible", "Litros", "Total", "Agrario", "Bonificacion Gobierno", "Porque Tu Vuelves"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, Double.class, Double.class, Boolean.class, Boolean.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarAlta();
			}
		});
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(btnVolver, "flowx,cell 0 2,alignx center");
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table.getSelectedRow();
				controlador.mostrarAlta(fila);
			
				
			}
		});
		btnEditar.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(btnEditar, "cell 0 2,alignx center");
	}

	public void setListaRepostajes(List<Repostaje> listaRepostajes) {
		DefaultTableModel modelo=(DefaultTableModel) table.getModel();//CREA UNA TABLA
		modelo.setRowCount(0); //ESTABLECE EL NUMERO DE FILAS DE LA TABLA
		for (Repostaje repostaje : listaRepostajes) {
			Object[] fila= {repostaje.getMatricula(),repostaje.getNombre(),repostaje.getDni(),repostaje.getCombustible(),repostaje.getLitros(),repostaje.getTotal(),repostaje.isAgrario(),repostaje.isGobierno(),repostaje.isVuelves()};
			modelo.addRow(fila);
		}
	}

	public void setControlador(Principal controlador) {
		this.controlador = controlador;
	}
	
	
	
}
