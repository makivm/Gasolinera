package modelo;

public class Repostaje {
	private String matricula;
	private String nombre;
	private String dni;
	private Combustible combustible;
	private double litros;
	private boolean agrario;
	private boolean gobierno;
	private boolean vuelves;
	
	public static final double DESCUENTO_AGRARIO=0.45;
	public static final double DESCUENTO_GOBIERNO=0.20;
	public static final double DESCUENTO_VUELVES=0.05;
	
	
	public Repostaje(String matricula, String nombre, String dni, Combustible combustible, double litros, double total,
			boolean agrario, boolean gobierno, boolean vuelves) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.dni = dni;
		this.combustible = combustible;
		this.litros = litros;
		this.agrario = agrario;
		this.gobierno = gobierno;
		this.vuelves = vuelves;
	}
	
	public Repostaje() {
		this.matricula = "";
		this.nombre = "";
		this.dni = "";
		this.combustible = new Combustible();
		this.litros = 0;
		this.agrario = false;
		this.gobierno = false;
		this.vuelves = false;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Combustible getCombustible() {
		return combustible;
	}
	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}
	public double getLitros() {
		return litros;
	}
	public void setLitros(double litros) {
		this.litros = litros;
	}
	
	public boolean isAgrario() {
		return agrario;
	}
	public void setAgrario(boolean agrario) {
		this.agrario = agrario;
	}
	public boolean isGobierno() {
		return gobierno;
	}
	public void setGobierno(boolean gobierno) {
		this.gobierno = gobierno;
	}
	public boolean isVuelves() {
		return vuelves;
	}
	public void setVuelves(boolean vuelves) {
		this.vuelves = vuelves;
	}

	@Override
	public String toString() {
		return "Repostaje [matricula=" + matricula + ", nombre=" + nombre + ", dni=" + dni + ", combustible="
				+ combustible + ", litros=" + litros + ", agrario=" + agrario + ", gobierno="
				+ gobierno + ", vuelves=" + vuelves + "]";
	}
	
	public double getTotal() {
		return getPrecioLitroDescuento()*this.litros;
	}
	
	protected double getPrecioLitroDescuento() {
		double total=this.combustible.getPrecio();
		if(isAgrario()) {
			total=total-DESCUENTO_AGRARIO;
			
		}else {
			if (isGobierno()) {
			total=total-DESCUENTO_GOBIERNO;
			}
			if (isVuelves()) {
				total=total-DESCUENTO_VUELVES;
			}
		}
		return total;
	}
	
	public void setTotal(double total) {
		this.litros=total/getPrecioLitroDescuento();
	}
}
