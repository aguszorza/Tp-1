package fiuba.algo3.ejemplo1;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.function.Function;

public class ConjuntoDeMensajeables {

	protected Hashtable mensajeables;
	
	//public ConjuntoDeMensajeables(){
		//this.mensajeables = new Hashtable ();
	//}
	
	public int cantidadDeMensajeables(){
		return this.mensajeables.size();
	}
	
	private int cantidadTotalMensajes(Function<Mensajeable, Integer> funcion){
		int cantidad = 0;
		Iterator <Mensajeable> iter = this.mensajeables.values().iterator();
		while (iter.hasNext()){
			cantidad = cantidad + funcion.apply(iter.next());
		}
		return cantidad;
	}
	
	public int cantidadTotalMensajesEnviados(){
		/*int cantidad = 0;
		Iterator <Grupo> iter = this.grupos.values().iterator();
		while (iter.hasNext()){
			cantidad = cantidad + iter.next().cantidadTotalMensajesEnviados();
		}
		return cantidad;*/
		Function<Mensajeable, Integer> cantidad = (Mensajeable mensajeable) -> {
			return mensajeable.cantidadTotalMensajesEnviados();
		}; 
		return cantidadTotalMensajes(cantidad);
	}
	
	public int cantidadTotalMensajesRecibidos(){
		/*int cantidad = 0;
		Iterator <Grupo> iter = this.grupos.values().iterator();
		while (iter.hasNext()){
			cantidad = cantidad + iter.next().cantidadTotalMensajesRecibidos();
		}
		return cantidad;*/
		Function<Mensajeable, Integer> cantidad = (Mensajeable mensajeable) -> {
			return mensajeable.cantidadTotalMensajesRecibidos();
		}; 
		return cantidadTotalMensajes(cantidad);
	}
	
	public Boolean existeMensajeable(String unMensajeable){
		return this.mensajeables.containsKey(unMensajeable);
	}		
	
	public int cantidadDeChats(){
		int cantidad = 0;
		Iterator <Mensajeable> iter = this.mensajeables.values().iterator();
		while (iter.hasNext()){
			if(iter.next().obtenerConversacion().cantidadDeMensajes() != 0){
				cantidad = cantidad + 1;
			}
		}
		return cantidad;
	}
	
	
}
