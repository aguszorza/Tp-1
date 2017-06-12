package fiuba.algo3.ejemplo1;

public class MensajeEnviado extends Mensaje{
	
	public MensajeEnviado(String texto, String remitente){
		super(texto, remitente);
	}
	
	public int cantidadDeRecibidos(){
		return 0;
	}

	public int cantidadDeEnviados(){
		return 1;
	}
	
	public int cantidadDeMensajesDe(String unNombre){
		return 0;
	}
}
