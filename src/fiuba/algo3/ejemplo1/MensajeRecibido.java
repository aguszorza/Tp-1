package fiuba.algo3.ejemplo1;

public class MensajeRecibido extends Mensaje {

	public MensajeRecibido(String texto, String remitente){
		super(texto, remitente);
	}
	
	public int cantidadDeRecibidos(){
		return 1;
	}

	public int cantidadDeEnviados(){
		return 0;
	}
	
	public int cantidadDeMensajesDe(String unNombre){
		if (this.remitente.equals(unNombre)){
			return 1;
		}
		return 0;
	}
}
