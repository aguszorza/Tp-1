package fiuba.algo3.ejemplo1;

import java.util.Hashtable;

public class Contacto extends Mensajeable{
	
	private Hashtable<String, Grupo> grupos;
	
	public Contacto(String nombre){
		super(nombre);
		this.grupos = new Hashtable<String, Grupo>();
	}
	
	public Boolean perteneceAlGrupo(String nombre){
		return this.grupos.containsKey(nombre);
	}
	
	public void agregarGrupo(Grupo grupo){
		this.grupos.put(grupo.getNombre(), grupo);
		grupo.agregarContactoAGrupo(this);
	}
	
	public int cantidadDeGrupos(){
		return this.grupos.size();
	}
	
	/*public int cantidadTotalMensajesRecibidos(){
		int cantidad = this.conversacion.cantidadTotalMensajesRecibidos();
		Iterator <Grupo> iter = this.grupos.values().iterator();
		while (iter.hasNext()){
			cantidad = cantidad + iter.next().cantidadDeMensajesDe(this.nombre);
		}
		return cantidad;
	}*/
	
	public Hashtable<String, Grupo> obtenerGrupos(){
		return this.grupos;
	}
}
