package controladores;

import java.util.ArrayList;
import java.util.List;

import modelo.Combustible;
import modelo.Repostaje;
import vistas.FormularioAlta;
import vistas.ListadoVentas;

public class Principal {
	
	private FormularioAlta fAlta;
	private List<Combustible> listaCombustibles;
	private ListadoVentas fListado;
	private List<Repostaje> ListaRepostajes;
	

	public Principal() {
		fAlta=new FormularioAlta();
		fListado=new ListadoVentas();
		
		ListaRepostajes=new ArrayList<Repostaje>();
		
		
		listaCombustibles=new ArrayList<Combustible>();
		listaCombustibles.add(new Combustible("Gasolina",1.794));
		listaCombustibles.add(new Combustible("Gasoil",1.773));
		listaCombustibles.add(new Combustible("Gasolina Plus",1.832));
		listaCombustibles.add(new Combustible("Gasoil Plus",1.842));
		fAlta.setListaCombustibles(listaCombustibles);
		
		fAlta.setVisible(true);	
	}
	
	public void insertarRepostaje(Repostaje r) {
		ListaRepostajes.add(r);
		fAlta.setVisible(false);
		
		fListado.setListaRepostajes(ListaRepostajes);
		
		
		fListado.setVisible(true);
	}

	public static void main(String[] args) {
		Principal ppal=new Principal();
		
		
		

	}

}
