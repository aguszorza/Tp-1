package fiuba.algo3.ejemplo1;

public class Mensajeable {

	protected String nombre;
	protected Conversacion conversacion;
	
	public Mensajeable(String nombre){
		this.nombre = nombre;
		this.conversacion = new Conversacion();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void borrarConversacion(){
		this.conversacion.borrarConversacion();
	}
	
	public ListadoDeMensajes obtenerConversacion(){
		return this.conversacion.obtenerConversacionCon();
	}
	
	public void recibirMensajeDe(String unContacto, String unMensaje){
		this.conversacion.recibirMensajeDe(unContacto, unMensaje);
	}
	
	public void enviarMensaje(String unMensaje){
		this.conversacion.enviarMensaje(unMensaje);
	}
	
	public int cantidadTotalMensajesEnviados(){
		return this.conversacion.cantidadTotalMensajesEnviados();
	}
	
	public int cantidadTotalMensajesRecibidos(){
		return this.conversacion.cantidadTotalMensajesRecibidos();
	}
}
