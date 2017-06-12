package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;


public class MensajeRecibidoTest {

	@Test
	public void testAgregarMensajeConRemitenteDevuelveElMensajeAgregadoConElRemitenteTrasPedirlo() {
		MensajeRecibido mensaje = new MensajeRecibido ("Juan", "Cuando nos juntamos?");
		Assert.assertEquals("La prueba NO pasó: el mensaje no tiene el remitente agregado", "Juan: Cuando nos juntamos?", mensaje.getMensaje());
	}
	
	@Test
	public void testCantidadDeEnviadosDevuelveCeroSiEsUnMensajeRecibido(){
		MensajeRecibido mensaje = new MensajeRecibido ("Juan", "Hola");
		Assert.assertEquals("La prueba NO pasó: no devolvio cero", 0, mensaje.cantidadDeEnviados());
	}
	
	@Test
	public void testCantidadDeRecibidosDevuelveUnoSiEsUnMensajeRecibido(){
		MensajeRecibido mensaje = new MensajeRecibido ("Juan", "Hola");
		Assert.assertEquals("La prueba NO pasó: no devolvio uno", 1, mensaje.cantidadDeRecibidos());
	}

	
	@Test
	public void testRemitenteDevuelveElRemitenteDelMensaje(){
		MensajeRecibido mensaje = new MensajeRecibido ("Juan", "Hola");
		Assert.assertEquals("La prueba NO pasó: no devolvio Juan como el remitente", "Juan", mensaje.getRemitente());
	}
	
	@Test
	public void testCantidadDeMensajesDeDevuelveUnoSiElRemitenteEsElContactoPasado(){
		MensajeRecibido mensaje = new MensajeRecibido ("Juan", "Hola");
		Assert.assertEquals("La prueba NO pasó: no devolvio 1", 1, mensaje.cantidadDeMensajesDe("Juan"));
	}
	
	@Test
	public void testCantidadDeMensajesDeDevuelveCeroSiElRemitenteNoEsElContactoPasado(){
		MensajeRecibido mensaje = new MensajeRecibido ("Juan", "Hola");
		Assert.assertEquals("La prueba NO pasó: no devolvio 0", 0, mensaje.cantidadDeMensajesDe("Agustin"));
	}
}
