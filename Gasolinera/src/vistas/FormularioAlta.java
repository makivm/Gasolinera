package vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;

import modelo.Combustible;
import modelo.Repostaje;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;

import controladores.Principal;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class FormularioAlta extends JFrame {
	private JTextField txtMatricula;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtLitros;
	private JTextField txtTotal;
	private List<Combustible> listaCombustibles;
	private JComboBox<Combustible> comboBoxCombustible;
	private JCheckBox chckbxAgrario;
	private JCheckBox chckbxPorqueTuVuelves;
	private JCheckBox chckbxBonificacion;
	private Principal controlador;
	private JButton btnResumen;
	private Repostaje editar=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAlta frame = new FormularioAlta();
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
	public FormularioAlta() {
		setMinimumSize(new Dimension(600, 500));
		setTitle("Nuevo Repostaje");
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][fill][fill][fill]"));
		
		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblMatricula, "cell 0 0,alignx trailing");
		
		txtMatricula = new JTextField();
		txtMatricula.setMaximumSize(new Dimension(200, 35));
		txtMatricula.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(txtMatricula, "cell 1 0,grow");
		txtMatricula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblNombre, "cell 0 1,alignx trailing");
		
		txtNombre = new JTextField();
		txtNombre.setMaximumSize(new Dimension(2147483647, 35));
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(txtNombre, "cell 1 1,grow");
		txtNombre.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblDni, "cell 0 2,alignx trailing");
		
		txtDni = new JTextField();
		txtDni.setMaximumSize(new Dimension(200, 35));
		txtDni.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(txtDni, "cell 1 2,growx");
		txtDni.setColumns(10);
		
		JLabel lblCombustible = new JLabel("Combustible:");
		lblCombustible.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblCombustible, "cell 0 3,alignx trailing");
		
		comboBoxCombustible = new JComboBox<Combustible>();
		comboBoxCombustible.setMaximumSize(new Dimension(500, 35));
		comboBoxCombustible.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(comboBoxCombustible, "cell 1 3,growx");
		
		JLabel lblLitros = new JLabel("Litros:");
		lblLitros.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblLitros, "cell 0 4,alignx trailing");
		
		txtLitros = new JTextField();
		txtLitros.setMaximumSize(new Dimension(200, 35));
		txtLitros.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(txtLitros, "cell 1 4,growx");
		txtLitros.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblTotal, "cell 0 5,alignx trailing");
		
		txtTotal = new JTextField();
		txtTotal.setMaximumSize(new Dimension(200, 35));
		txtTotal.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(txtTotal, "cell 1 5,growx");
		txtTotal.setColumns(10);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblDescuento, "cell 0 6");
		
		chckbxAgrario = new JCheckBox("Agrario");
		chckbxAgrario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarDescuentos();
			}
		});
		chckbxAgrario.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(chckbxAgrario, "flowx,cell 1 6");
		
		chckbxPorqueTuVuelves = new JCheckBox("Porque tu vuelves");
		chckbxPorqueTuVuelves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compruebaAgrario();
			}
		});
		chckbxPorqueTuVuelves.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(chckbxPorqueTuVuelves, "flowx,cell 1 7");
		
		chckbxBonificacion = new JCheckBox("Bonificación Gobierno");
		chckbxBonificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compruebaAgrario();
			}
		});
		chckbxBonificacion.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(chckbxBonificacion, "cell 1 6");
		
		JButton btnAceptar = new JButton("Aceptar");
		getContentPane().add(btnAceptar, "flowx,cell 1 8,alignx center");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		btnResumen = new JButton("Mostrar Resumen");
		btnResumen.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarListado();
			}
		});
		getContentPane().add(btnResumen, "cell 1 8,alignx center");
	}

	protected void comprobarDescuentos() {
		if (chckbxAgrario.isSelected() && (chckbxBonificacion.isSelected()||chckbxPorqueTuVuelves.isSelected())) {
			JOptionPane.showMessageDialog(this, "No se puede seleccionar agrario junto a otros descuentos", "Descuento no aplicable",JOptionPane.INFORMATION_MESSAGE);
			chckbxAgrario.setSelected(false);
		}
		
	}

	protected void compruebaAgrario() {
		if (chckbxBonificacion.isSelected() && chckbxAgrario.isSelected()) {
			JOptionPane.showMessageDialog(this, "No se puede seleccionar descuento de Gobierno adicional al agrario", "Descuento no aplicable",JOptionPane.INFORMATION_MESSAGE);
			chckbxBonificacion.setSelected(false);
		}
		if (chckbxPorqueTuVuelves.isSelected() && chckbxAgrario.isSelected()) {
			JOptionPane.showMessageDialog(this, "No se puede seleccionar descuento Porque tu Vuelves adicional al agrario", "Descuento no aplicable",JOptionPane.INFORMATION_MESSAGE);
			chckbxPorqueTuVuelves.setSelected(false);
		}
	}

	protected void insertar() {
		Repostaje r= new Repostaje();
		
		if (txtMatricula.getText()==null || txtMatricula.getText().isBlank() || txtNombre.getText()==null || txtNombre.getText().isBlank() || (txtDni.getText()==null || (txtDni.getText().isBlank()))) {
			JOptionPane.showMessageDialog(this,"Los campos matricula,nombre y dni son obligatorios.","Datos incompletos",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		r.setMatricula(txtMatricula.getText());
		r.setNombre(txtNombre.getText());
		r.setDni(txtDni.getText());
		r.setCombustible((Combustible)comboBoxCombustible.getSelectedItem());
		r.setAgrario(chckbxAgrario.isSelected());
		r.setGobierno(chckbxPorqueTuVuelves.isSelected());
		r.setVuelves(chckbxBonificacion.isSelected());	
		
		try{
			if(txtLitros.getText()!=null && !txtLitros.getText().isBlank() && txtTotal.getText()!=null && !txtTotal.getText().isBlank())
			{
				JOptionPane.showMessageDialog(this,"Solo debe rellenar uno de los dos campos: Litros o Total","Datos incorrectos",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if(txtLitros.getText()!=null && !txtLitros.getText().isBlank()) {
				r.setLitros(Double.parseDouble(txtLitros.getText()));
			}else {
				r.setTotal(Double.parseDouble(txtTotal.getText()));
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this,"Debe introducir un numero valido en litros o total.","N",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if(editar!=null) {
			controlador.borrarRepostaje(editar);
		}
		controlador.insertarRepostaje(r);	
	}

	public void setListaCombustibles(List<Combustible> listaCombustibles) {
		this.listaCombustibles=listaCombustibles;
		DefaultComboBoxModel<Combustible> modelo=new DefaultComboBoxModel<>();
		modelo.addAll(listaCombustibles);
		comboBoxCombustible.setModel(modelo);
		comboBoxCombustible.setSelectedIndex(0);
		
	}
	
	public void borrarfAlta() {
		this.editar=null;
		txtMatricula.setText("");
		txtNombre.setText("");
		txtDni.setText("");
		comboBoxCombustible.setSelectedIndex(0);
		txtLitros.setText("");
		txtTotal.setText("");
		chckbxAgrario.setSelected(false);
		chckbxBonificacion.setSelected(false);
		chckbxPorqueTuVuelves.setSelected(false);
		
	}

	public void setControlador(Principal controlador) {
		this.controlador = controlador;
	}

	public void setRepostaje(Repostaje r) {
		this.editar=r;
		txtMatricula.setText(r.getMatricula()); 
		txtNombre.setText(r.getNombre());
		txtDni.setText(r.getDni());
		comboBoxCombustible.setSelectedItem(r.getCombustible());
		txtLitros.setText(""+r.getLitros());
		txtTotal.setText(""+r.getTotal());
		chckbxAgrario.setSelected(r.isAgrario());
		chckbxBonificacion.setSelected(r.isGobierno());
		chckbxPorqueTuVuelves.setSelected(r.isVuelves());
	}
}
