package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

public class ConjuntoDeGruposTest {

	ConjuntoDeGrupos grupos = new ConjuntoDeGrupos();
	
	@Test
	public void testCrearConjuntoDeGruposLoCreaSinGrupos(){
		ConjuntoDeGrupos grupos = new ConjuntoDeGrupos();
		Assert.assertEquals("La prueba NO pasó: El conjunto de grupos no esta vacio", 0, grupos.cantidadDeGrupos());
	}

	@Test
	public void testExisteGrupoDevuelveFalsoSiNoExisteElGrupo(){
		Assert.assertFalse("La prueba NO pasó: No devolvio falso", grupos.existeGrupo("Tarde"));
	}
	
	@Test
	public void testExisteGrupoDevuelveTrueSiExisteElGrupo(){
		grupos.crearGrupo("Tarde");
		Assert.assertTrue("La prueba NO pasó: No devolvio verdadero", grupos.existeGrupo("Tarde"));
	}
	
	@Test
	public void testCrearGrupoAumentaEnUnoLaCantidadDeGrupos(){
		grupos.crearGrupo("Tarde");
		int cantidad = grupos.cantidadDeGrupos();
		grupos.crearGrupo("Todos");
		cantidad = grupos.cantidadDeGrupos() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de grupos", 1, cantidad);
	}
	
	@Test
	public void testGetDevuelveElGrupo(){
		grupos.crearGrupo("Tarde");
		grupos.crearGrupo("Todos");
		Assert.assertEquals("La prueba NO pasó: No devolvio el grupo solicitado", "Tarde", grupos.get("Tarde").getNombre());
	}
	
	@Test
	public void testCantidadDeGruposDevuelveLaCantidadDeGrupos(){
		grupos.crearGrupo("Tarde");
		grupos.crearGrupo("Todos");
		Assert.assertEquals("La prueba NO pasó: No devolvio 2 como el numero de grupos", 2, grupos.cantidadDeGrupos());
	}
	
	@Test
	public void testCantidadDeChatsGrupalesNoCuentaLosGruposSinMensajes(){
		grupos.crearGrupo("Tarde");
		grupos.crearGrupo("Todos");
		grupos.enviarMensajeAGrupo("Tarde", "Hola");
		Assert.assertEquals("La prueba NO pasó: No devolvio 1 como la cantidad de chat grupales", 1, grupos.cantidadDeChatsGrupales());
	}
	
	@Test
	public void testCantidadDeMiembrosDevuelveElNumeroCorrecto(){
		Contacto contacto = new Contacto("Agustin");
		grupos.crearGrupo("Tarde");
		grupos.get("Tarde").agregarContactoAGrupo(contacto);
		Assert.assertEquals("La prueba NO pasó: No devolvio dos como cantidad de miembros", 2, grupos.cantidadMiembrosEnGrupo("Tarde"));
	}
	
	@Test
	public void testCantidadDeMensajesRecibidosDelGrupoDevuelveElNumeroCorrecto(){
		grupos.crearGrupo("Tarde");
		Contacto contacto = new Contacto("Agustin");
		grupos.get("Tarde").agregarContactoAGrupo(contacto);
		grupos.enviarMensajeAGrupo("Tarde", "Che");
		grupos.enviarMensajeAGrupo("Tarde", "Pueden venir?");
		grupos.get("Tarde").recibirMensajeDe("Agustin", "Si");
		Assert.assertEquals("La prueba NO pasó: No devolvio 1 como cantidad de mensajes recibidos", 1, grupos.cantidadMensajesRecibidosDelGrupo("Tarde"));
	}
	
	@Test
	public void testCantidadDeMensajesEnviadosAlGrupoDevuelveElNumeroCorrecto(){
		grupos.crearGrupo("Tarde");
		Contacto contacto = new Contacto("Agustin");
		grupos.get("Tarde").agregarContactoAGrupo(contacto);
		grupos.enviarMensajeAGrupo("Tarde", "Che");
		grupos.enviarMensajeAGrupo("Tarde", "Pueden venir?");
		grupos.get("Tarde").recibirMensajeDe("Agustin", "Si");
		Assert.assertEquals("La prueba NO pasó: No devolvio 2 como cantidad de mensajes enviados", 2, grupos.cantidadMensajesEnviadosAlGrupo("Tarde"));
	}
	
	@Test
	public void testCantidadTotalMensajesEnviadosDevuelveElNumeroCorrecto(){
		grupos.crearGrupo("Tarde");
		grupos.crearGrupo("Todos");
		Contacto contacto = new Contacto("Agustin");
		grupos.get("Tarde").agregarContactoAGrupo(contacto);
		grupos.enviarMensajeAGrupo("Tarde", "Che");
		grupos.enviarMensajeAGrupo("Tarde", "Pueden venir?");
		grupos.get("Tarde").recibirMensajeDe("Agustin", "Si");
		grupos.enviarMensajeAGrupo("Todos", "Hola");
		Assert.assertEquals("La prueba NO pasó: No devolvio 3 como cantidad total de mensajes enviados", 3, grupos.cantidadTotalMensajesEnviados());
	}
	
	@Test
	public void testEnviarMensajeAGrupoAumentaEnUnoLaCantidadDeMensajesEnviados(){
		grupos.crearGrupo("Tarde");
		grupos.enviarMensajeAGrupo("Tarde", "Che");
		int cantidad = grupos.cantidadMensajesEnviadosAlGrupo("Tarde");
		grupos.enviarMensajeAGrupo("Tarde", "Pueden venir?");
		cantidad = grupos.cantidadMensajesEnviadosAlGrupo("Tarde") - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes enviados", 1, cantidad);
	}
	
	@Test
	public void testBorrarMensajesDelGrupoBorraLosMensajesDelGrupo(){
		grupos.crearGrupo("Tarde");
		Contacto contacto = new Contacto("Agustin");
		grupos.get("Tarde").agregarContactoAGrupo(contacto);
		grupos.enviarMensajeAGrupo("Tarde", "Che");
		grupos.get("Tarde").recibirMensajeDe("Agustin", "Que?");
		grupos.borrarMensajesDelGrupo("Tarde");
		Assert.assertEquals("La prueba NO pasó: No devolvio 0 como cantidad de mensajes", 0, grupos.obtenerConversacionConGrupo("Tarde").cantidadDeMensajes());
	}
	
	@Test
	public void testObtenerConversacionDevuelveLaConversacion(){
		grupos.crearGrupo("Tarde");
		Contacto contacto = new Contacto("Agustin");
		grupos.get("Tarde").agregarContactoAGrupo(contacto);
		grupos.enviarMensajeAGrupo("Tarde", "Che");
		grupos.get("Tarde").recibirMensajeDe("Agustin", "Que?");
		Assert.assertEquals("La prueba NO pasó: No se obtuvo la conversacion", 2, grupos.obtenerConversacionConGrupo("Tarde").cantidadDeMensajes());
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testComprobarGrupoLevantaExcepcionSiNoExisteElGrupo(){
		grupos.comprobarGrupo("Tarde");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}
	
	@Test
	public void testComprobarGrupoNoLevantaExcepcionSiExisteElGrupo(){
		grupos.crearGrupo("Tarde");
		try{
			grupos.comprobarGrupo("Tarde");
		}
		catch (GrupoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo GrupoInexistente a pesar de que el grupo existe");
		}
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testGetGrupoLevantaExcepcionSiNoExisteElGrupo(){
		grupos.get("Tarde");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}
	
	@Test
	public void testGetGrupoNoLevantaExcepcionSiExisteElGrupo(){
		grupos.crearGrupo("Tarde");
		try{
			grupos.get("Tarde");
		}
		catch (GrupoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo GrupoInexistente a pesar de que existe");
		}
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testCantidadDeMiembrosEnGruposLevantaExcepcionSiNoExisteElGrupo(){
		grupos.cantidadMiembrosEnGrupo("Tarde");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}
	
	@Test
	public void testCantidadDeMiembrosEnGruposNoLevantaExcepcionSiExisteElGrupo(){
		grupos.crearGrupo("Tarde");
		try{
			grupos.cantidadMiembrosEnGrupo("Tarde");
		}
		catch (GrupoInexistente e){
			Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente a pesar de que existe");
		}
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testEnviarMensajeAGrupoLevantaExcepcionSiNoExisteElGrupo(){
		grupos.enviarMensajeAGrupo("Tarde", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}
	
	@Test
	public void testEnviarMensajeAGrupoNoLevantaExcepcionSiExisteElGrupo(){
		grupos.crearGrupo("Tarde");
		try{
			grupos.enviarMensajeAGrupo("Tarde", "Hola");
		}
		catch (GrupoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo GrupoInexistente a pesar de que existe");
		}
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testCantidadMensajesRecibidosDelGrupoLevantaExcepcionSiNoExisteElGrupo(){
		grupos.cantidadMensajesRecibidosDelGrupo("Tarde");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}
	
	@Test
	public void testCantidadMensajesRecibidosDelGrupoNoLevantaExcepcionSiExisteElGrupo(){
		grupos.crearGrupo("Tarde");
		try{
			grupos.cantidadMensajesRecibidosDelGrupo("Tarde");
		}
		catch (GrupoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo GrupoInexistente a pesar de que existe");
		}
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testCantidadMensajesEnviadosAlGrupoLevantaExcepcionSiNoExisteElGrupo(){
		grupos.cantidadMensajesEnviadosAlGrupo("Tarde");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}
	
	@Test
	public void testCantidadMensajesEnviadosAlGrupoNoLevantaExcepcionSiExisteElGrupo(){
		grupos.crearGrupo("Tarde");
		try{
			grupos.cantidadMensajesEnviadosAlGrupo("Tarde");
		}
		catch (GrupoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo GrupoInexistente a pesar de que existe");
		}
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testObtenerConversacionLevantaExcepcionSiNoExisteElGrupo(){
		grupos.obtenerConversacionConGrupo("Tarde");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}
	
	@Test
	public void testObtenerConversacionNoLevantaExcepcionSiExisteElGrupo(){
		grupos.crearGrupo("Tarde");
		try{
			grupos.obtenerConversacionConGrupo("Tarde");
		}
		catch (GrupoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo GrupoInexistente a pesar de que existe");
		}
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testBorrarMensajesDelGrupoLevantaExcepcionSiNoExisteElGrupo(){
		grupos.borrarMensajesDelGrupo("Tarde");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}
	
	@Test
	public void testBorrarMensajesDelGrupoNoLevantaExcepcionSiExisteElGrupo(){
		grupos.crearGrupo("Tarde");
		try{
			grupos.borrarMensajesDelGrupo("Tarde");
		}
		catch (GrupoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo GrupoInexistente a pesar de que existe");
		}
	}
}
