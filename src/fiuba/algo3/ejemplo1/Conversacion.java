package fiuba.algo3.ejemplo1;

public class Conversacion {

	private ListadoDeMensajes mensajes;
	
	public Conversacion(){
		this.mensajes = new ListadoDeMensajes();
	}
	
	public void recibirMensajeDe(String unContacto, String unMensaje){
		MensajeRecibido mensaje = new MensajeRecibido(unContacto, unMensaje);
		this.mensajes.add(mensaje);
	}
	
	public void enviarMensaje(String unMensaje){
		MensajeEnviado mensaje = new MensajeEnviado("Yo", unMensaje);
		this.mensajes.add(mensaje);
	}
	
	public ListadoDeMensajes obtenerConversacionCon(){
		return this.mensajes;
	}
	
	public void borrarConversacion(){
		this.mensajes = new ListadoDeMensajes();
	}
	
	public int cantidadTotalMensajesRecibidos(){
		return this.mensajes.cantidadTotalMensajesRecibidos();
	}
	
	public int cantidadTotalMensajesEnviados(){
		return this.mensajes.cantidadTotalMensajesEnviados();
	}
}
