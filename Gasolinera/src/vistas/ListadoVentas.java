package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import modelo.Repostaje;

import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class ListadoVentas extends JFrame {
	private JTable table;

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
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(btnVolver, "cell 0 2,alignx center");
	}

	public void setListaRepostajes(List<Repostaje> listaRepostajes) {
		
		
	}

}
