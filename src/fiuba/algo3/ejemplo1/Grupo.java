package fiuba.algo3.ejemplo1;

import java.util.ArrayList;
import java.util.List;

public class Grupo extends Mensajeable{

	private List<String> contactos;
	
	public Grupo(String nombre){
		super(nombre);
		this.contactos = new ArrayList<String>();
	}
	
	public void agregarContactoAGrupo(Contacto unContacto){
		this.contactos.add(unContacto.getNombre());
	}
	
	public int cantidadMiembrosEnGrupo(){
		return this.contactos.size() + 1;
	}
	
	public int cantidadDeMensajesDe(String unNombre){
		return this.obtenerConversacion().cantidadDeMensajesDe(unNombre);
	}
}
