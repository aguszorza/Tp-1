package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

public class GrupoTest {

	Grupo grupo = new Grupo("Tarde");
	Contacto Juan = new Contacto("Juan");
	Contacto Ivan = new Contacto("Ivan");
	
	@Test
	public void testCrearGrupoCreaUnGrupoConUnMiembro(){
		Grupo grupo = new Grupo("Todos");
		Assert.assertEquals("La prueba NO pasó: No devolvio uno como la cantidad de miembros del grupo", 1, grupo.cantidadMiembrosEnGrupo());
	}
	
	@Test
	public void testCrearGrupoCreaUnGrupoSinMensajes(){
		Grupo grupo = new Grupo("Todos");
		int cantidad = grupo.obtenerConversacion().cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: El grupo se inicializo con mensajes", 0, cantidad);
	}
	
	@Test
	public void testGetNombreDevuelveElNombreDelGrupo(){
		Grupo grupo = new Grupo("Todos");
		Assert.assertEquals("La prueba NO pasó: No devolvio el nombre del grupo", "Todos", grupo.getNombre());
	}
	
	@Test
	public void testCantidadDeMensajesDeDevuelveElNumeroCorrecto() {
		grupo.recibirMensajeDe("Juan", "Che, vienen el viernes?");
		grupo.recibirMensajeDe("Matias", "No se. Despues te confirmo");
		grupo.recibirMensajeDe("Ivan", "Si");
		grupo.recibirMensajeDe("Juan", "Ok");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, grupo.cantidadDeMensajesDe("Juan"));	
	}
	
	@Test
	public void testCantidadMiembrosDevuelveLaCantidadDeMiembrosDelGrupo(){
		grupo.agregarContactoAGrupo(Juan);
		grupo.agregarContactoAGrupo(Ivan);
		Assert.assertEquals("La prueba NO pasó: No devolvio tres como la cantidad de miembros del grupo", 3, grupo.cantidadMiembrosEnGrupo());
	}
	
	@Test
	public void testAgregarUnContactoAumentaEnUnoLaCantidadDeMiembros(){
		grupo.agregarContactoAGrupo(Juan);
		int cantidadMiembros = grupo.cantidadMiembrosEnGrupo();
		grupo.agregarContactoAGrupo(Ivan);
		cantidadMiembros = grupo.cantidadMiembrosEnGrupo() - cantidadMiembros;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de miembros", 1, cantidadMiembros);
	}
	
	@Test
	public void	testEnviarUnMensajeYObtenerElMensajeEnviado(){
		grupo.enviarMensaje("Hola, ¿como estas?");
		Assert.assertEquals("La prueba NO pasó: No se obtuvo el mensaje enviado", "Yo: Hola, ¿como estas?", grupo.obtenerConversacion().get(1));
	}
	
	@Test
	public void	testRecibirUnMensajeYObtenerElMensajeRecibido(){
		grupo.recibirMensajeDe("Juan", "Hola, ¿como estas?");
		Assert.assertEquals("La prueba NO pasó: No se obtuvo el mensaje recibido", "Juan: Hola, ¿como estas?", grupo.obtenerConversacion().get(1));
	}
	
	@Test
	public void	testObtenerConversacionDevuelveListaVaciaTrasCrearlo(){
		Grupo grupo = new Grupo("Todos");
		ListadoDeMensajes conversacion = grupo.obtenerConversacion();
		int cantidad = conversacion.cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: No devolvio una lista vacia", 0, cantidad);
		
	}

	@Test
	public void	testObtenerConversacionDevuelveLosDosMensajesEnOrdenInversoDeLlegada(){
		grupo.recibirMensajeDe("Juan", "Estas en tu casa?");
		grupo.enviarMensaje("No");
		ListadoDeMensajes conversacion = grupo.obtenerConversacion();
		Boolean condicion = ("Yo: No").equals(conversacion.get(1));
		condicion = condicion && ("Juan: Estas en tu casa?").equals(conversacion.get(2));
		Assert.assertTrue("La prueba NO pasó: Los mensajes no se devuelve en orden inverso al de llegada", condicion);
	}
	
	@Test
	public void	testCantidadMensajesRecibidosDevuelveElNumeroCorrecto(){
		grupo.recibirMensajeDe("Juan", "Che, vienen el viernes?");
		grupo.enviarMensaje("No se. Despues te confirmo");
		grupo.recibirMensajeDe("Ivan", "Si");
		grupo.recibirMensajeDe("Juan", "Ok");
		Assert.assertEquals("La prueba NO pasó: No se obtuvo tres como la cantidad de mensajes recibidos", 3, grupo.cantidadTotalMensajesRecibidos());
	}
	
	@Test
	public void	testCantidadMensajesEnviadosDevuelveElNumeroCorrecto(){
		grupo.recibirMensajeDe("Juan", "Che, vienen el viernes?");
		grupo.enviarMensaje("No se. Despues te confirmo");
		grupo.recibirMensajeDe("Ivan", "Si");
		grupo.recibirMensajeDe("Juan", "Ok");
		Assert.assertEquals("La prueba NO pasó: No se obtuvo uno como la cantidad de mensajes enviados", 1, grupo.cantidadTotalMensajesEnviados());
	}
	
	@Test
	public void	testBorrarMensajesBorraLosMensajes(){
		int cantidadMensajes;
		grupo.recibirMensajeDe("Juan", "Che, vienen el viernes?");
		grupo.enviarMensaje("No se. Despues te confirmo");
		grupo.borrarConversacion();
		cantidadMensajes = grupo.obtenerConversacion().cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: La conversacion no se borro", 0, cantidadMensajes);
	}
	
	@Test
	public void	testEnviarUnMensajeAumentaEnUnoLaCantidadDeMensajes(){
		grupo.recibirMensajeDe("Juan", "Paso a las 7");
		grupo.enviarMensaje("Ok");
		int cantidad = grupo.obtenerConversacion().cantidadDeMensajes();
		grupo.enviarMensaje("Avisame cuando llegues");
		cantidad = grupo.obtenerConversacion().cantidadDeMensajes() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes", 1, cantidad);
	}
	
	@Test
	public void	testRecibirUnMensajeAumentaEnUnoLaCantidadDeMensajes(){
		grupo.recibirMensajeDe("Juan", "Paso a las 7");
		grupo.enviarMensaje("Ok");
		int cantidad = grupo.obtenerConversacion().cantidadDeMensajes();
		grupo.recibirMensajeDe("Juan", "Avisame si vas a estar");
		cantidad = grupo.obtenerConversacion().cantidadDeMensajes() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes", 1, cantidad);
	}

}
