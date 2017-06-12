package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

public class ListadoDeMensajesTest {

	ListadoDeMensajes lista = new ListadoDeMensajes();
	MensajeRecibido mensaje1 = new MensajeRecibido("Juan", "Hola");
	MensajeEnviado mensaje2 = new MensajeEnviado("Agustin", "Hola, como estas?");
	MensajeRecibido mensaje3 = new MensajeRecibido("Juan", "Bien, y vos?");
	
	@Test
	public void testCrearUnListadoDeMensajesInicializaVacio() {
		ListadoDeMensajes lista = new ListadoDeMensajes();
		Assert.assertEquals("La prueba NO pasó: no se inicializo vacio", 0, lista.cantidadDeMensajes());
	}
	
	@Test
	public void testAgregarUnMensajeAumentaEnUnoLaCantidadDeMensajes() {
		int cantidad = 0;
		lista.add(mensaje1);
		lista.add(mensaje2);
		cantidad = cantidad + lista.cantidadDeMensajes();
		lista.add(mensaje3);
		cantidad = lista.cantidadDeMensajes() - cantidad;
		Assert.assertEquals("La prueba NO pasó: no aumento en uno la cantitad de mensajs al agregar un mensaje", 1, cantidad);
	}
	
	@Test
	public void testCantidadDeMensajesDevuelveLaCantidadCorrectaDeMensajesEnLaLista(){
		lista.add(mensaje1);
		lista.add(mensaje2);
		lista.add(mensaje3);
		Assert.assertEquals("La prueba NO pasó: No devolvio tres", 3, lista.cantidadDeMensajes());
	}
	
	@Test
	public void testElementoEnPosicionUnoDevuelveElUltimoAgregado() {
		ListadoDeMensajes lista = new ListadoDeMensajes();
		lista.add(mensaje1);
		lista.add(mensaje2);
		lista.add(mensaje3);
		Assert.assertEquals("La prueba NO pasó: no devolvio el último mensaje enviado", "Juan: Bien, y vos?", lista.get(1));
	}

	@Test
	public void testElementoEnPosicionDosDevuelveElAnteUltimoAgregado() {
		lista.add(mensaje1);
		lista.add(mensaje2);
		lista.add(mensaje3);
		Assert.assertEquals("La prueba NO pasó: no devolvio el ante último mensaje enviado", "Agustin: Hola, como estas?", lista.get(2));
	}
	
	@Test (expected = IndexError.class)
	public void testElementoEnPosicionIgualALaLongitudMasUnoDevuelveIndexError() {
		int longitud;
		lista.add(mensaje1);
		lista.add(mensaje2);
		longitud = lista.cantidadDeMensajes();
		lista.get(longitud + 1);
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo IndexError al intentar acceder a una posicion invalida");
	}
	
	@Test (expected = IndexError.class)
	public void testElementoEnPosicionCeroDevuelveIndexError() {
		lista.add(mensaje1);
		lista.add(mensaje2);
		lista.get(0);
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo IndexError al intentar acceder a la posicion cero");
	}
	
	@Test
	public void testCantidadDeEnviadosDevuelveUno() {
		lista.add(mensaje1);
		lista.add(mensaje2);
		lista.add(mensaje3);
		Assert.assertEquals("La prueba NO pasó: no devolvio uno como cantidad de mensajes enviado", 1, lista.cantidadTotalMensajesEnviados());
	}
	
	@Test
	public void testCantidadDeRecibidosDevuelveDos() {
		lista.add(mensaje1);
		lista.add(mensaje2);
		lista.add(mensaje3);
		Assert.assertEquals("La prueba NO pasó: no devolvio dos como cantidad de mensajes Recividos", 2, lista.cantidadTotalMensajesRecibidos());
	}
	
	@Test
	public void testCantidadDeMensajesDeDevuelveElNumeroCorrecto() {
		lista.add(mensaje1);
		lista.add(mensaje2);
		lista.add(mensaje3);
		Assert.assertEquals("La prueba NO pasó: no devolvio dos como la cantidad de mensajes enviados por Juan", 2, lista.cantidadDeMensajesDe("Juan"));
	}
}
