package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

public class ConjuntoDeContactosTest {

	ConjuntoDeContactos contactos = new ConjuntoDeContactos();

	@Test
	public void testCrearConjuntoDeContactoLoCreaSinContactos(){
		ConjuntoDeContactos contactos = new ConjuntoDeContactos();
		Assert.assertEquals("La prueba NO pasó: El conjunto de contactos no esta vacio", 0, contactos.cantidadDeContactos());
	}

	@Test
	public void testExisteContactoDevuelveFalsoSiNoExisteElContacto(){
		Assert.assertFalse("La prueba NO pasó: No devolvio falso", contactos.existeContacto("Agustin"));
	}
	
	@Test
	public void testExisteContactoDevuelveTrueSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		Assert.assertTrue("La prueba NO pasó: No devolvio verdadero", contactos.existeContacto("Agustin"));
	}
	
	@Test
	public void testAgregarContactoAumentaEnUnoLaCantidadDeContactos(){
		contactos.agregarContacto("Agustin");
		int cantidad = contactos.cantidadDeContactos();
		contactos.agregarContacto("Ivan");
		cantidad = contactos.cantidadDeContactos() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de contactos", 1, cantidad);
	}
	
	@Test
	public void testCantidadDeContactosDevuelveLaCantidadDeContactos(){
		contactos.agregarContacto("Agustin");
		contactos.agregarContacto("Ivan");
		Assert.assertEquals("La prueba NO pasó: No devolvio 2 como cantidad de contactos", 2, contactos.cantidadDeContactos());
	}
	
	@Test
	public void testCantidadDeChatsIndividualesNoCuentaLosChatsSinMensajes(){
		contactos.agregarContacto("Agustin");
		contactos.agregarContacto("Ivan");
		contactos.enviarMensajeA("Agustin", "Hola");
		Assert.assertEquals("La prueba NO pasó: No devolvio 1 como cantidad de chats individuales", 1, contactos.cantidadDeChatsIndividuales());
	}
	
	@Test
	public void testCantidadTotalMensajesEnviadosNoCuentaLosMensajesDeLosGrupos(){
		contactos.agregarContacto("Agustin");
		contactos.agregarContacto("Ivan");
		Grupo grupo = new Grupo("Tarde");
		contactos.agregarContactoAGrupo("Ivan", grupo);
		contactos.enviarMensajeA("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Todo bien?");
		contactos.recibirMensajeDeGrupo("Tarde", "Ivan", "Che");
		grupo.enviarMensaje("Que?");
		contactos.recibirMensajeDeGrupo("Tarde", "Ivan", "Venis?");
		Assert.assertEquals("La prueba NO pasó: No devolvio 1 como cantidad de mensajes enviados", 1, contactos.cantidadTotalMensajesEnviados());
	}
	
	@Test
	public void testCantidadTotalMensajesRecibidosNoCuentaLosMensajesDeLosGrupos(){
		contactos.agregarContacto("Agustin");
		contactos.agregarContacto("Ivan");
		Grupo grupo = new Grupo("Tarde");
		contactos.agregarContactoAGrupo("Ivan", grupo);
		contactos.enviarMensajeA("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Todo bien?");
		contactos.recibirMensajeDeGrupo("Tarde", "Ivan", "Che");
		grupo.enviarMensaje("Que?");
		contactos.recibirMensajeDeGrupo("Tarde", "Ivan", "Venis?");
		Assert.assertEquals("La prueba NO pasó: No devolvio 2 como cantidad de mensajes recibidos", 2, contactos.cantidadTotalMensajesRecibidos());
	}
	
	@Test
	public void testCantidadMensajesDeCuentaLosMensajesDeLosGruposYLosChats(){
		contactos.agregarContacto("Agustin");
		contactos.agregarContacto("Ivan");
		Grupo grupo = new Grupo("Tarde");
		contactos.agregarContactoAGrupo("Agustin", grupo);
		contactos.agregarContactoAGrupo("Ivan", grupo);
		contactos.enviarMensajeA("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Todo bien?");
		contactos.recibirMensajeDeGrupo("Tarde", "Agustin", "Che");
		grupo.enviarMensaje("Que?");
		contactos.recibirMensajeDeGrupo("Tarde", "Agustin", "Vienen?");
		contactos.recibirMensajeDeGrupo("Tarde", "Ivan", "Yo no");
		Assert.assertEquals("La prueba NO pasó: No devolvio 4 como cantidad de mensajes recibidos de Agustin", 4, contactos.cantidadMensajesDe("Agustin"));
	}
	
	@Test
	public void testCantidadMensajesEnviadosANoCuentaLosMensajesDeLosGrupos(){
		contactos.agregarContacto("Agustin");
		contactos.agregarContacto("Ivan");
		Grupo grupo = new Grupo("Tarde");
		contactos.agregarContactoAGrupo("Agustin", grupo);
		contactos.agregarContactoAGrupo("Ivan", grupo);
		contactos.enviarMensajeA("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Todo bien?");
		contactos.recibirMensajeDeGrupo("Tarde", "Agustin", "Che");
		grupo.enviarMensaje("Que?");
		contactos.recibirMensajeDeGrupo("Tarde", "Agustin", "Vienen?");
		contactos.recibirMensajeDeGrupo("Tarde", "Ivan", "Yo no");
		Assert.assertEquals("La prueba NO pasó: No devolvio 1 como cantidad de mensajes enviados a Agustin", 1, contactos.cantidadMensajesEnviadosA("Agustin"));
	}
	
	@Test
	public void testRecibirMensajeDeAumentaEnUnoLaCantidadDeMensajesRecibidos(){
		contactos.agregarContacto("Agustin");
		contactos.enviarMensajeA("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Hola");
		int cantidad = contactos.cantidadTotalMensajesRecibidos();
		contactos.recibirMensajeDe("Agustin", "Todo bien?");
		cantidad = contactos.cantidadTotalMensajesRecibidos() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes recibidos", 1, cantidad);
	}
	
	@Test
	public void testEnviarMensajeAAumentaEnUnoLaCantidadDeMensajesEnviados(){
		contactos.agregarContacto("Agustin");
		contactos.enviarMensajeA("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Hola");
		int cantidad = contactos.cantidadTotalMensajesEnviados();
		contactos.enviarMensajeA("Agustin", "Todo bien?");
		cantidad = contactos.cantidadTotalMensajesEnviados() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes nviados", 1, cantidad);
	}
	
	@Test
	public void testBorrarMensajesBorraLosMensajesDelGrupo(){
		contactos.agregarContacto("Agustin");
		contactos.enviarMensajeA("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Hola");
		contactos.borrarMensajesDelContacto("Agustin");
		Assert.assertEquals("La prueba NO pasó: No borro los mensajes de la conversacion", 0, contactos.obtenerConversacionCon("Agustin").cantidadDeMensajes());
	}
	
	@Test (expected = ContactoInexistente.class)
	public void testObtenerConversacionLevantaExcepcionSiNoExisteElContacto(){
		contactos.obtenerConversacionCon("Agustin");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test
	public void testObtenerConversacionDevuelveLaConversacionSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		contactos.enviarMensajeA("Agustin", "Hola");
		contactos.recibirMensajeDe("Agustin", "Hola");
		Assert.assertEquals("La prueba NO pasó: No se obtuvo la conversacion", 2, contactos.obtenerConversacionCon("Agustin").cantidadDeMensajes());
	}
	
	@Test
	public void testAgregarContactoAGrupoAgregaAlContacto(){
		contactos.agregarContacto("Agustin");
		Grupo grupo = new Grupo("Tarde");
		int cantidad = grupo.cantidadMiembrosEnGrupo();
		contactos.agregarContactoAGrupo("Agustin", grupo);
		cantidad = grupo.cantidadMiembrosEnGrupo() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No se agrego el contacto al grupo", 1, cantidad);
	}
	
	@Test (expected = ContactoInexistente.class)
	public void testComprobarContactoLevantaExcepcionSiNoExisteElContacto(){
		contactos.comprobarContacto("Agustin");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test
	public void testComprobarContactoNoLevantaExcepcionSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		try{
			contactos.comprobarContacto("Agustin");
		}
		catch (ContactoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoInexistente a pesar de que existia");
		}
	}
	
	@Test (expected = ContactoNoPertenecienteAlGrupo.class)
	public void testComprobarPertenenciaAGrupoLevantaExcepcionSiNoPerteneceAlGrupo(){
		Grupo grupo = new Grupo("Tarde");
		contactos.agregarContacto("Agustin");
		contactos.comprobarPertenenciaAGrupo("Tarde","Agustin");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoNoPertenecienteAlGrupo");
	}
	
	@Test
	public void testComprobarPertenenciaAGrupoNoLevantaExcepcionSiPerteneceAlGrupo(){
		Grupo grupo = new Grupo("Tarde");
		contactos.agregarContacto("Agustin");
		contactos.agregarContactoAGrupo("Agustin", grupo);
		try{
			contactos.comprobarPertenenciaAGrupo("Tarde", "Agustin");;
		}
		catch (ContactoNoPertenecienteAlGrupo e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoNoPertenecienteAlGrupo a pesar de que pertenecia");
		}
	}
	
	@Test(expected = ContactoInexistente.class)
	public void testCantidadMensajesDeLevantaExcepcionSiNoExisteElContacto(){
		contactos.cantidadMensajesDe("Agustin");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test
	public void testCantidadMensajesDeNoLevantaExcepcionSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		try{
			contactos.cantidadMensajesDe("Agustin");
		}
		catch (ContactoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoInexistente a pesar que existia");
		}
	}
	
	@Test(expected = ContactoInexistente.class)
	public void testCantidadMensajesEnviadosALevantaExcepcionSiNoExisteElContacto(){
		contactos.cantidadMensajesEnviadosA("Agustin");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test
	public void testCantidadMensajesEnviadosANoLevantaExcepcionSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		try{
			contactos.cantidadMensajesEnviadosA("Agustin");
		}
		catch (ContactoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoInexistente a pesar que existia");
		}
	}
	
	@Test(expected = ContactoInexistente.class)
	public void testRecibirMensajeDeLevantaExcepcionSiNoExisteElContacto(){
		contactos.recibirMensajeDe("Agustin", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test
	public void testRecibirMensajeDeNoLevantaExcepcionSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		try{
			contactos.recibirMensajeDe("Agustin", "Hola");
		}
		catch (ContactoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoInexistente a pesar que existia");
		}
	}
	
	@Test(expected = ContactoInexistente.class)
	public void testEnviaMensajeALevantaExcepcionSiNoExisteElContacto(){
		contactos.enviarMensajeA("Agustin", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test
	public void testEnviarMensajeANoLevantaExcepcionSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		try{
			contactos.enviarMensajeA("Agustin", "Hola");
		}
		catch (ContactoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoInexistente a pesar que existia");
		}
	}
	
	@Test(expected = ContactoInexistente.class)
	public void testBorrarConversacionLevantaExcepcionSiNoExisteElContacto(){
		contactos.borrarMensajesDelContacto("Agustin");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test
	public void testBorrarConversacionNoLevantaExcepcionSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		try{
			contactos.borrarMensajesDelContacto("Agustin");
		}
		catch (ContactoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoInexistente a pesar que existia");
		}
	}
	
	@Test(expected = ContactoInexistente.class)
	public void testAgregarContactoAGrupoLevantaExcepcionSiNoExisteElContacto(){
		Grupo grupo = new Grupo("Tarde"); 
		contactos.agregarContactoAGrupo("Agustin", grupo);
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test
	public void testAgregarContactoAGrupoNoLevantaExcepcionSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		Grupo grupo = new Grupo("Tarde"); 
		try{
			contactos.agregarContactoAGrupo("Agustin", grupo);
		}
		catch (ContactoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoInexistente a pesar que existia");
		}
	}
	
	@Test(expected = ContactoInexistente.class)
	public void testRecibirMensajeDeGrupoLevantaExcepcionSiNoExisteElContacto(){
		Grupo grupo = new Grupo("Tarde"); 
		contactos.recibirMensajeDeGrupo("Tarde", "Agustin", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test
	public void testRecibirMensajeDeGrupoNoLevantaExcepcionSiExisteElContacto(){
		contactos.agregarContacto("Agustin");
		Grupo grupo = new Grupo("Tarde");
		contactos.agregarContactoAGrupo("Agustin", grupo);
		try{
			contactos.recibirMensajeDeGrupo("Tarde", "Agustin", "Hola");
		}
		catch (ContactoInexistente e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoInexistente a pesar que existia");
		}
	}
	
	@Test(expected = ContactoNoPertenecienteAlGrupo.class)
	public void testRecibirMensajeDeGrupoLevantaExcepcionSiNoPerteneceAlGrupo(){
		Grupo grupo = new Grupo("Tarde");
		contactos.agregarContacto("Agustin");
		contactos.recibirMensajeDeGrupo("Tarde", "Agustin", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoNoPertenecienteAlGrupo");
	}
	
	@Test
	public void testRecibirMensajeDeGrupoNoLevantaExcepcionSiPerteneceAlGrupo(){
		contactos.agregarContacto("Agustin");
		Grupo grupo = new Grupo("Tarde");
		contactos.agregarContactoAGrupo("Agustin", grupo);
		try{
			contactos.recibirMensajeDeGrupo("Tarde", "Agustin", "Hola");
		}
		catch (ContactoNoPertenecienteAlGrupo e){
			Assert.fail("La prueba NO pasó: levanto una excepcion del tipo ContactoNoPertenecienteAlGrupo a pesar de que pertenece");
		}
	}
}
