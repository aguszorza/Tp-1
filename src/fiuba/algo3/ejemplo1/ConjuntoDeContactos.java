package fiuba.algo3.ejemplo1;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.function.Function;

public class ConjuntoDeContactos {

	private Hashtable <String, Contacto> contactos;

	public ConjuntoDeContactos(){
		this.contactos = new Hashtable <String, Contacto>();
	}
	
	public void comprobarContacto(String unContacto){
		if(!this.existeContacto(unContacto)){
			throw new ContactoInexistente();
		}
	}
	
	public void comprobarPertenenciaAGrupo(String unGrupo, String unContacto){
		if(!this.contactos.get(unContacto).perteneceAlGrupo(unGrupo)){
			throw new ContactoNoPertenecienteAlGrupo();
		}
	}
	
	public int cantidadDeContactos(){
		return this.contactos.size();
	}
	
	public int cantidadDeChatsIndividuales(){
		int cantidad = 0;
		Iterator <Contacto> iter = this.contactos.values().iterator();
		while (iter.hasNext()){
			if(iter.next().obtenerConversacion().cantidadDeMensajes() != 0){
				cantidad = cantidad + 1;
			}
		}
		return cantidad;
	}
	
	private int cantidadTotalMensajes(Function<Contacto, Integer> funcion){
		int cantidad = 0;
		Iterator <Contacto> iter = this.contactos.values().iterator();
		while (iter.hasNext()){
			cantidad = cantidad + funcion.apply(iter.next());
		}
		return cantidad;
	}
	
	public int cantidadTotalMensajesEnviados(){
		Function<Contacto, Integer> cantidad = (Contacto contacto) -> {return contacto.cantidadTotalMensajesEnviados();}; 
		return cantidadTotalMensajes(cantidad);
	}
	
	public int cantidadTotalMensajesRecibidos(){
		Function<Contacto, Integer> cantidad = (Contacto contacto) -> {return contacto.cantidadTotalMensajesRecibidos();}; 
		return cantidadTotalMensajes(cantidad);
	}
	
	public int cantidadMensajesDe(String unContacto){
		comprobarContacto (unContacto);
		int cantidad = this.contactos.get(unContacto).cantidadTotalMensajesRecibidos();
		Iterator <Grupo> iter = this.contactos.get(unContacto).obtenerGrupos().values().iterator();
		while (iter.hasNext()){
			cantidad = cantidad + iter.next().cantidadDeMensajesDe(unContacto);
		}
		return cantidad;
	}
	
	public int cantidadMensajesEnviadosA(String unContacto){
		comprobarContacto (unContacto);
		return this.contactos.get(unContacto).cantidadTotalMensajesEnviados();
	}
	
	public void agregarContacto(String unContacto){
		Contacto contacto = new Contacto(unContacto);
		this.contactos.put(unContacto, contacto);
	}
	
	public Boolean existeContacto(String unContacto){
		return this.contactos.containsKey(unContacto);
	}
	
	public void recibirMensajeDe(String unContacto, String unMensaje){
		comprobarContacto (unContacto);
		this.contactos.get(unContacto).recibirMensajeDe(unContacto, unMensaje);
	}
	
	public void enviarMensajeA(String unContacto, String unMensaje){
		comprobarContacto (unContacto);
		this.contactos.get(unContacto).enviarMensaje(unMensaje);
	}
	
	public ListadoDeMensajes obtenerConversacionCon(String unContacto){
		comprobarContacto (unContacto);
		return this.contactos.get(unContacto).obtenerConversacion();
	}
	
	public void borrarMensajesDelContacto(String unContacto){
		comprobarContacto (unContacto);
		this.contactos.get(unContacto).borrarConversacion();
	}
	
	public void agregarContactoAGrupo(String unContacto, Grupo unGrupo){
		comprobarContacto(unContacto);
		this.contactos.get(unContacto).agregarGrupo(unGrupo);
	}
	
	public void recibirMensajeDeGrupo(String unGrupo, String unContacto, String unMensaje){
		comprobarContacto(unContacto);
		comprobarPertenenciaAGrupo(unGrupo, unContacto);
		Hashtable<String, Grupo> grupos = this.contactos.get(unContacto).obtenerGrupos();
		grupos.get(unGrupo).recibirMensajeDe(unContacto, unMensaje);
	}
}
