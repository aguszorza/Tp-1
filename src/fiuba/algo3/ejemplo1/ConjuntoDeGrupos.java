package fiuba.algo3.ejemplo1;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.function.Function;

public class ConjuntoDeGrupos {

	private Hashtable <String, Grupo> grupos;

	public ConjuntoDeGrupos(){
		this.grupos = new Hashtable <String, Grupo>();
	}
	
	public void comprobarGrupo(String unGrupo){
		if(!this.existeGrupo(unGrupo)){
			throw new GrupoInexistente();
		}
	}
	
	public int cantidadDeGrupos(){
		return this.grupos.size();
	}
	
	public int cantidadDeChatsGrupales(){
		int cantidad = 0;
		Iterator <Grupo> iter = this.grupos.values().iterator();
		while (iter.hasNext()){
			if(iter.next().obtenerConversacion().cantidadDeMensajes() != 0){
				cantidad = cantidad + 1;
			}
		}
		return cantidad;
	}
	
	private int cantidadTotalMensajes(Function<Grupo, Integer> funcion){
		int cantidad = 0;
		Iterator <Grupo> iter = this.grupos.values().iterator();
		while (iter.hasNext()){
			cantidad = cantidad + funcion.apply(iter.next());
		}
		return cantidad;
	}
	
	public int cantidadTotalMensajesEnviados(){
		Function<Grupo, Integer> cantidad = (Grupo grupo) -> {return grupo.cantidadTotalMensajesEnviados();}; 
		return cantidadTotalMensajes(cantidad);
	}
	
	public int cantidadTotalMensajesRecibidos(){
		Function<Grupo, Integer> cantidad = (Grupo grupo) -> {return grupo.cantidadTotalMensajesRecibidos();}; 
		return cantidadTotalMensajes(cantidad);
	}
	
	public void crearGrupo(String unGrupo){
		Grupo grupo = new Grupo(unGrupo);
		this.grupos.put(unGrupo, grupo);
	}
		
	public Boolean existeGrupo(String unGrupo){
		return this.grupos.containsKey(unGrupo);
	}		
	
	public Grupo get(String unGrupo){
		comprobarGrupo(unGrupo);
		return this.grupos.get(unGrupo);
	}
	
	public int cantidadMiembrosEnGrupo(String unGrupo){
		comprobarGrupo(unGrupo);
		return this.grupos.get(unGrupo).cantidadMiembrosEnGrupo();
	}
	
	public void enviarMensajeAGrupo(String unGrupo, String unMensaje){
		comprobarGrupo(unGrupo);
		this.grupos.get(unGrupo).enviarMensaje(unMensaje);
	}
	
	public int cantidadMensajesRecibidosDelGrupo(String unGrupo){
		comprobarGrupo(unGrupo);
		return this.grupos.get(unGrupo).cantidadTotalMensajesRecibidos();
	}
	
	public int cantidadMensajesEnviadosAlGrupo(String unGrupo){
		comprobarGrupo(unGrupo);
		return this.grupos.get(unGrupo).cantidadTotalMensajesEnviados();
	}
	
	public ListadoDeMensajes obtenerConversacionConGrupo(String unGrupo){
		comprobarGrupo(unGrupo);
		return this.grupos.get(unGrupo).obtenerConversacion();
	}
	
	public void borrarMensajesDelGrupo(String unGrupo){
		comprobarGrupo(unGrupo);
		this.grupos.get(unGrupo).borrarConversacion();
	}
}
