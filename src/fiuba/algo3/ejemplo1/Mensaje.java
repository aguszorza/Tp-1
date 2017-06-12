package fiuba.algo3.ejemplo1;

public abstract class Mensaje {

	protected String texto;
	protected String remitente;
	
	public Mensaje(String remitente, String texto){
		this.remitente = remitente;
		this.texto = remitente + ": " + texto;
	}
	
	public String getMensaje(){
		return this.texto;
	}
	
	public String getRemitente(){
		return this.remitente;
	}
	
	public abstract int cantidadDeMensajesDe(String unNombre);
	
	public abstract int cantidadDeRecibidos();

	public abstract int cantidadDeEnviados();

	
}
