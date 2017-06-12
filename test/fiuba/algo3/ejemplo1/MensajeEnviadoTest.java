package fiuba.algo3.ejemplo1;

import org.junit.Test;
import org.junit.Assert;

public class MensajeEnviadoTest {

	@Test
	public void testAgregarMensajeConRemitenteDevuelveElMensajeAgregadoConElRemitenteTrasPedirlo() {
		MensajeEnviado mensaje = new MensajeEnviado ("Juan", "Cuando nos juntamos?");
		Assert.assertEquals("La prueba NO pasó: el mensaje no tiene el remitente agregado", "Juan: Cuando nos juntamos?", mensaje.getMensaje());
	}
	
	@Test
	public void testCantidadDeEnviadosDevuelveUnoSiEsUnMensajeEnviado(){
		MensajeEnviado mensaje = new MensajeEnviado ("Juan", "Hola");
		Assert.assertEquals("La prueba NO pasó: no devolvio uno", 1, mensaje.cantidadDeEnviados());
	}
	
	@Test
	public void testCantidadDeRecibidosDevuelveCeroSiEsUnMensajeEnviado(){
		MensajeEnviado mensaje = new MensajeEnviado ("Juan", "Hola");
		Assert.assertEquals("La prueba NO pasó: no devolvio cero", 0, mensaje.cantidadDeRecibidos());
	}

	
	@Test
	public void testRemitenteDevuelveElRemitenteDelMensaje(){
		MensajeEnviado mensaje = new MensajeEnviado ("Juan", "Hola");
		Assert.assertEquals("La prueba NO pasó: no devolvio Juan como el remitente", "Juan", mensaje.getRemitente());
	}
	
	@Test
	public void testCantidadDeMensajesDeDevuelveCero(){
		MensajeEnviado mensaje = new MensajeEnviado ("Yo", "Hola");
		Assert.assertEquals("La prueba NO pasó: no devolvio 0", 0, mensaje.cantidadDeMensajesDe("Yo"));
	}
}
