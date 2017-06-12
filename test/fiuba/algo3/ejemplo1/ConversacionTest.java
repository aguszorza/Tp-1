package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;


public class ConversacionTest {

	Conversacion conversacion = new Conversacion();

	@Test
	public void testCrearConversacionCreaUnaConversacionSinMensajes(){
		Conversacion conversacion = new Conversacion();
		int cantidadMensajes = conversacion.obtenerConversacionCon().cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: La conversacion no esta vacia", 0, cantidadMensajes);
	}
	
	@Test
	public void testBorrarMensajesBorraLosMensajes(){
		int cantidad;
		conversacion.recibirMensajeDe("Juan", "Estas en tu casa?");
		conversacion.enviarMensaje("No");
		conversacion.borrarConversacion();
		cantidad = conversacion.obtenerConversacionCon().cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: No se borraron los mensajes", 0, cantidad);
	}
	
	@Test
	public void testCantidadTotalMensajesEnviadosDevuelveElNumeroCorrecto() {
		conversacion.recibirMensajeDe("Juan", "Paso a las 7");
		conversacion.enviarMensaje("Ok");
		conversacion.recibirMensajeDe("Juan", "Avisame si vas a estar");
		Assert.assertEquals("La prueba NO pasó: No devolvio uno", 1, conversacion.cantidadTotalMensajesEnviados());	
	}

	@Test
	public void testCantidadTotalMensajesRecibidosDevuelveElNumeroCorrecto() {
		conversacion.recibirMensajeDe("Juan", "Paso a las 7");
		conversacion.enviarMensaje("Ok");
		conversacion.recibirMensajeDe("Juan", "Avisame si vas a estar");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, conversacion.cantidadTotalMensajesRecibidos());	
	}
	
	@Test
	public void	testEnviarUnMensajeYObtenerElMensajeEnviado(){
		conversacion.enviarMensaje("Hola, ¿como estas?");
		Assert.assertEquals("La prueba NO pasó: No se obtuvo el mensaje enviado", "Yo: Hola, ¿como estas?", conversacion.obtenerConversacionCon().get(1));
	}
	
	@Test
	public void	testRecibirUnMensajeYObtenerElMensajeRecibido(){
		conversacion.recibirMensajeDe("Juan", "Hola, ¿como estas?");
		Assert.assertEquals("La prueba NO pasó: No se obtuvo el mensaje recibido", "Juan: Hola, ¿como estas?", conversacion.obtenerConversacionCon().get(1));
	}
	
	@Test
	public void	testEnviarUnMensajeAumentaEnUnoLaCantidadDeMensajes(){
		conversacion.recibirMensajeDe("Juan", "Paso a las 7");
		conversacion.enviarMensaje("Ok");
		int cantidad = conversacion.obtenerConversacionCon().cantidadDeMensajes();
		conversacion.enviarMensaje("Avisame cuando llegues");
		cantidad = conversacion.obtenerConversacionCon().cantidadDeMensajes() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes", 1, cantidad);
	}
	
	@Test
	public void	testRecibirUnMensajeAumentaEnUnoLaCantidadDeMensajes(){
		conversacion.recibirMensajeDe("Juan", "Paso a las 7");
		conversacion.enviarMensaje("Ok");
		int cantidad = conversacion.obtenerConversacionCon().cantidadDeMensajes();
		conversacion.recibirMensajeDe("Juan", "Avisame si vas a estar");
		cantidad = conversacion.obtenerConversacionCon().cantidadDeMensajes() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes", 1, cantidad);
	}
	
	@Test
	public void	testObtenerConversacionDevuelveLosDosMensajesEnOrdenInversoDeLlegada(){
		conversacion.recibirMensajeDe("Juan", "Estas en tu casa?");
		conversacion.enviarMensaje("No");
		ListadoDeMensajes mensajes = conversacion.obtenerConversacionCon();
		Boolean condicion = ("Yo: No").equals(mensajes.get(1));
		condicion = condicion && ("Juan: Estas en tu casa?").equals(mensajes.get(2));
		Assert.assertTrue("La prueba NO pasó: Los mensajes no se devuelve en orden inverso al de llegada", condicion);
	}
}
