package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

public class ContactoTest {

public Contacto contacto = new Contacto("Agustin");
	
	@Test
	public void	testCrearContactoConNombreGuardaCorrectamenteElNombre(){
		Contacto contacto = new Contacto("Juan");
		Assert.assertEquals("La prueba NO pasó: No devolvio el nombre correcto", "Juan", contacto.getNombre());
	}
	
	@Test
	public void testCrearContactoNoTieneConversaciones(){
		Contacto contacto = new Contacto("Juan");
		int cantidad = contacto.cantidadTotalMensajesEnviados() + contacto.cantidadTotalMensajesRecibidos();
		Assert.assertEquals("La prueba NO pasó: No devolvio cero como la cantidad de mensajes", 0, cantidad);
	}
	
	@Test
	public void testCrearContactoNoTieneGrupos(){
		Contacto contacto = new Contacto("Juan");
		Assert.assertEquals("La prueba NO pasó: No devolvio cero como la cantidad de grupos", 0, contacto.cantidadDeGrupos());
	}
	
	@Test
	public void testEnviarUnMensajeAumentaLaCantidadDeMensajesEnUno(){
		contacto.enviarMensaje("Paso a las 7");
		contacto.recibirMensajeDe("Agustin", "Ok");
		int cantidad = contacto.obtenerConversacion().cantidadDeMensajes();
		contacto.enviarMensaje("Te aviso cuando llego");
		cantidad = contacto.obtenerConversacion().cantidadDeMensajes() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes", 1, cantidad);
	}

	@Test
	public void testRecibirUnMensajeAumentaLaCantidadDeMensajesEnUno(){
		contacto.recibirMensajeDe("Agustin", "Paso a las 7");
		contacto.enviarMensaje("Ok");
		int cantidad = contacto.obtenerConversacion().cantidadDeMensajes();
		contacto.recibirMensajeDe("Agustin", "Te aviso cuando llego");
		cantidad = contacto.obtenerConversacion().cantidadDeMensajes() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes", 1, cantidad);
	}
	
	@Test
	public void testPertenceAlGrupoDevuelveFalseSiNoPerteneceAlGrupo(){
		Grupo grupo = new Grupo("Tarde");
		Assert.assertFalse("La prueba NO pasó: El contacto no deberia pertenecer al grupo", contacto.perteneceAlGrupo("Tarde"));
	}

	@Test
	public void testPertenceAlGrupoDevuelveTrueSiPerteneceAlGrupo(){
		Grupo grupo = new Grupo("Tarde");
		contacto.agregarGrupo(grupo);
		Assert.assertTrue("La prueba NO pasó: El contacto deberia pertenecer al grupo", contacto.perteneceAlGrupo("Tarde"));
	}
	
	@Test
	public void testAgregarAlGrupoAgregaAumentaEnUnoLaCantidadDeGrupos(){
		int cantidadDeGrupos = contacto.cantidadDeGrupos();
		Grupo grupo = new Grupo("Tarde");
		contacto.agregarGrupo(grupo);
		cantidadDeGrupos = contacto.cantidadDeGrupos() - cantidadDeGrupos;
		Assert.assertEquals("La prueba NO pasó: No devolvio uno", 1, cantidadDeGrupos);
	}
	
	@Test
	public void testBorrarConversacionBorraLaConversacion(){
		contacto.recibirMensajeDe("Agustin", "Paso a las 7");
		contacto.enviarMensaje("Ok");
		contacto.borrarConversacion();
		int cantidadDeMensajes = contacto.obtenerConversacion().cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: No borro la conversacion", 0, cantidadDeMensajes);
	}
	
	@Test
	public void testCantidadDeEnviadosDevuelveDos(){
		contacto.recibirMensajeDe("Agustin", "Paso a las 7");
		contacto.enviarMensaje("Ok");
		contacto.enviarMensaje("Avisame cuando llegues");
		Assert.assertEquals("La prueba NO pasó: No devolvio 2", 2, contacto.cantidadTotalMensajesEnviados());
	}
	
	@Test
	public void testCantidadDeRecibidosDevuelveUno(){
		contacto.recibirMensajeDe("Agustin", "Paso a las 7");
		contacto.enviarMensaje("Ok");
		contacto.enviarMensaje("Avisame cuando llegues");
		Assert.assertEquals("La prueba NO pasó: No devolvio 1", 1, contacto.cantidadTotalMensajesRecibidos());
	}
	
	@Test
	public void testCantidadDeGruposDevuelveLaCantidadCorrecta(){
		Grupo grupo = new Grupo("Tarde");
		contacto.agregarGrupo(grupo);
		grupo = new Grupo("Todos");
		contacto.agregarGrupo(grupo);
		Assert.assertEquals("La prueba NO pasó: No devolvio 2", 2, contacto.cantidadDeGrupos());
	}

	@Test
	public void testObtenerConversacionDevuelveUnListadoDeTamanio3(){
		contacto.recibirMensajeDe("Agustin", "Paso a las 7");
		contacto.enviarMensaje("Ok");
		contacto.enviarMensaje("Avisame cuando llegues");
		ListadoDeMensajes conversacion = contacto.obtenerConversacion();
		int cantidadDeMensajes = conversacion.cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: No devolvio 3", 3, cantidadDeMensajes);
	}
}
