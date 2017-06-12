package fiuba.algo3.ejemplo1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;


public class ListadoDeMensajes {

	private List<Mensaje> lista;

	public ListadoDeMensajes(){
		this.lista = new ArrayList<Mensaje>();
	}

	public String get(int posicion){
		if (posicion > this.lista.size() || posicion < 1){
			throw new IndexError();
		}
		return this.lista.get(posicion - 1).getMensaje();
	}

	public void add(Mensaje mensaje){
		this.lista.add(0, mensaje);
	}

	public int cantidadDeMensajesDe(String unNombre){
		int cantidad = 0;
		Iterator<Mensaje> it = this.lista.iterator();
		while(it.hasNext()){
			cantidad = cantidad + it.next().cantidadDeMensajesDe(unNombre);
		}
		return cantidad;
	}

	public int cantidadDeMensajes(){
		return this.lista.size();
	}

	private int cantidadTotalMensajes(Function<Mensaje, Integer> funcion){
		int cantidad = 0;
		Iterator<Mensaje> it = this.lista.iterator();
		while(it.hasNext()){
			cantidad = cantidad + funcion.apply(it.next());
		}
		return cantidad;
	}

	public int cantidadTotalMensajesRecibidos(){
		Function<Mensaje, Integer> cantidad = (Mensaje mensaje) -> {return mensaje.cantidadDeRecibidos();}; 
		return cantidadTotalMensajes(cantidad);
	}

	public int cantidadTotalMensajesEnviados(){
		Function<Mensaje, Integer> cant = (Mensaje mensaje) -> {return mensaje.cantidadDeEnviados();}; 
		return cantidadTotalMensajes(cant);
	}
}
