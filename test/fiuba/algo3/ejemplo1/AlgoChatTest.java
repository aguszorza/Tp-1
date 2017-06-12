package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

public class AlgoChatTest {

	AlgoChat algoChat = new AlgoChat("Carlos");

	@Test
	public void testAgregarContactoAumenteEnUnoLaCantidadDeContactos(){
		int cantidad = algoChat.cantidadDeContactos();
		algoChat.agregarContacto("Ivan");
		cantidad = algoChat.cantidadDeContactos() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de contactos", 1, cantidad);
	}
	
	@Test
	public void testExisteContactoDevuelveFalseSiElContactoNoExiste(){
		Assert.assertFalse("La prueba NO pasó: No devolvio falso", algoChat.existeContacto("Ivan"));
	}
	
	@Test
	public void testExisteContactoDevuelveTrueSiElContactoExiste(){
		algoChat.agregarContacto("Ivan");
		Assert.assertTrue("La prueba NO pasó: No devolvio falso", algoChat.existeContacto("Ivan"));
	}
	
	//PRUEBAS DE INICIALIZACION
	
	@Test
	public void testCantidadDeChatsGrupalesDevuelveCeroTrasCrearAlgoChat(){
		AlgoChat algoChat = new AlgoChat("Agustin");
		Assert.assertEquals("La prueba NO pasó: No devolvio cero como la cantidad de chats grupales", 0, algoChat.cantidadDeChatsGrupales());
	}
	
	@Test
	public void testCantidadDeChatsIndividualesDevuelveCeroTrasCrearAlgoChat(){
		AlgoChat algoChat = new AlgoChat("Agustin");
		Assert.assertEquals("La prueba NO pasó: No devolvio cero como la cantidad de chats individuales", 0, algoChat.cantidadDeChatsIndividuales());
	}

	@Test
	public void testCantidadDeContactosDevuelveCeroTrasCrearAlgoChat(){
		AlgoChat algoChat = new AlgoChat("Agustin");
		Assert.assertEquals("La prueba NO pasó: No devolvio cero como la cantidad de contactos", 0, algoChat.cantidadDeContactos());
	}
	
	@Test
	public void testCantidadDeGruposDevuelveCeroTrasCrearAlgoChat(){
		AlgoChat algoChat = new AlgoChat("Agustin");
		Assert.assertEquals("La prueba NO pasó: No devolvio cero como la cantidad de grupos", 0, algoChat.cantidadDeGrupos());
	}
	
	@Test
	public void testCantidadDeMensajesEnviadosDevuelveCeroTrasCrearAlgoChat(){
		AlgoChat algoChat = new AlgoChat("Agustin");
		Assert.assertEquals("La prueba NO pasó: No devolvio cero la cantidad de mensajes enviados", 0, algoChat.cantidadDeMensajesEnviados());
	}
	
	@Test
	public void testCantidadTotalMensajesEnviadosDevuelveCeroTrasCrearAlgoChat(){
		AlgoChat algoChat = new AlgoChat("Agustin");
		Assert.assertEquals("La prueba NO pasó: No devolvio cero la cantidad total de mensajes enviados", 0, algoChat.cantidadTotalMensajesEnviados());
	}
	
	@Test
	public void testCantidadTotalMensajesRecibidosDevuelveCeroTrasCrearAlgoChat(){
		AlgoChat algoChat = new AlgoChat("Agustin");
		Assert.assertEquals("La prueba NO pasó: No devolvio cero la cantidad total de mensajes recibidos", 0, algoChat.cantidadTotalMensajesRecibidos());
	}
	
	@Test
	public void testNombreUsuarioDevuelveNombre(){
		Assert.assertEquals("La prueba NO pasó: No devolvio el nombre de usuario correcto", "Carlos", algoChat.nombreUsuario());
	}

	//PRUEBAS SOBRE UNA CONVERSACION
	
	@Test
	public void testBorrarMensajesDelContactoBorraLosMensajesDelContacto(){
		algoChat.agregarContacto("Diego");
		algoChat.recibirMensajeDe("Diego", "Paso a las 7");
		algoChat.enviarMensajeA("Diego", "Ok");
		algoChat.recibirMensajeDe("Diego", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Diego", "Te dije que si...");
		algoChat.borrarMensajesDelContacto("Diego");
		Assert.assertEquals("La prueba NO pasó: No se borraron los mensajes de Diego", 0, algoChat.obtenerConversacionCon("Diego").cantidadDeMensajes());
	}

	@Test
	public void testCantidadDeChatsIndividualesNoCuentaLosQueNoTienenMensajes(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.recibirMensajeDe("Agustin", "Hola");
		Assert.assertEquals("La prueba NO pasó: No devolvio 1 como la cantidad de chats individuales", 1, algoChat.cantidadDeChatsIndividuales());
	}

	@Test
	public void testCantidadDeMensajesEnviadosDevuelveLoMismoQueCantidadTotalMensajesEnviados(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Estas en tu casa?");
		algoChat.enviarMensajeA("Agustin", "Hoy no");
		algoChat.recibirMensajeDe("Agustin", "Ok");
		int cantidad1 = algoChat.cantidadDeMensajesEnviados();
		int cantidad2 = algoChat.cantidadTotalMensajesEnviados();
		Assert.assertEquals("La prueba NO pasó: cantidad de mensajes enviados no devolvio lo mismo que cantidad total de mensajes enviados", cantidad1, cantidad2);
	}

	@Test
	public void testCantidadMensajesEnviadosADevuelveUno(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Diego");
		algoChat.recibirMensajeDe("Agustin", "Estas en tu casa?");
		algoChat.enviarMensajeA("Agustin", "Hoy no");
		algoChat.enviarMensajeA("Diego", "Hola");
		algoChat.recibirMensajeDe("Agustin", "Ok");
		Assert.assertEquals("La prueba NO pasó: No devolvio uno", 1, algoChat.cantidadMensajesEnviadosA("Agustin"));
	}

	@Test
	public void testCantidadMensajesDeDevuelveDos(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Diego");
		algoChat.recibirMensajeDe("Agustin", "Estas en tu casa?");
		algoChat.enviarMensajeA("Agustin", "Hoy no");
		algoChat.enviarMensajeA("Diego", "Hola");
		algoChat.recibirMensajeDe("Agustin", "Ok");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, algoChat.cantidadMensajesDe("Agustin"));
	}

	@Test
	public void testCantidadTotalMensajesEnviadosDevuelveDos(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Diego");
		algoChat.recibirMensajeDe("Agustin", "Estas en tu casa?");
		algoChat.enviarMensajeA("Agustin", "Hoy no");
		algoChat.enviarMensajeA("Diego", "Hola");
		algoChat.recibirMensajeDe("Agustin", "Ok");
		algoChat.recibirMensajeDe("Diego", "Hola");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, algoChat.cantidadTotalMensajesEnviados());
	}
	
	@Test
	public void testCantidadTotalMensajesRecibidosDevuelveTres(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Diego");
		algoChat.recibirMensajeDe("Agustin", "Estas en tu casa?");
		algoChat.enviarMensajeA("Agustin", "Hoy no");
		algoChat.enviarMensajeA("Diego", "Hola");
		algoChat.recibirMensajeDe("Agustin", "Ok");
		algoChat.recibirMensajeDe("Diego", "Hola");
		Assert.assertEquals("La prueba NO pasó: No devolvio tres", 3, algoChat.cantidadTotalMensajesRecibidos());
	}
	
	@Test
	public void testEnviarUnMensajeAumentaEnUnoLaCantidadDeMensajesEnviadosAlContacto(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Estas en tu casa?");
		int cantidad = algoChat.cantidadMensajesEnviadosA("Agustin");
		algoChat.enviarMensajeA("Agustin", "Hoy no");
		cantidad = algoChat.cantidadMensajesEnviadosA("Agustin") - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes enviados", 1, cantidad);
	}
	
	@Test
	public void testRecibirUnMensajeAumentaEnUnoLaCantidadDeMensajesDelContacto(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Estas en tu casa?");
		algoChat.enviarMensajeA("Agustin", "Hoy no");
		int cantidad = algoChat.cantidadMensajesDe("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Ok");
		cantidad = algoChat.cantidadMensajesDe("Agustin") - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de mensajes recibidos", 1, cantidad);
	}
	
	@Test
	public void testEnviarUnMensajeAumentaEnUnoLaCantidadTotalDeMensajesEnviados(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Diego");
		algoChat.recibirMensajeDe("Agustin", "Estas en tu casa?");
		algoChat.enviarMensajeA("Agustin", "Hoy no");
		int cantidad = algoChat.cantidadTotalMensajesEnviados();
		algoChat.enviarMensajeA("Diego", "Hola");
		algoChat.recibirMensajeDe("Diego", "Hola");
		cantidad = algoChat.cantidadTotalMensajesEnviados() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad total de mensajes enviados", 1, cantidad);
	}
	
	@Test
	public void testRecibirUnMensajeAumentaEnUnoLaCantidadTotalDeMensajesRecibidos(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Diego");
		algoChat.recibirMensajeDe("Agustin", "Estas en tu casa?");
		int cantidad = algoChat.cantidadTotalMensajesRecibidos();
		algoChat.enviarMensajeA("Agustin", "Hoy no");
		algoChat.enviarMensajeA("Diego", "Hola");
		algoChat.recibirMensajeDe("Diego", "Hola");
		cantidad = algoChat.cantidadTotalMensajesRecibidos() - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad total de mensajes recibidos", 1, cantidad);
	}

	@Test
	public void testObtenerConversacionEnPosicionUnoDevuelveElUltimoMensaje(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Paso a las 7");
		algoChat.enviarMensajeA("Agustin", "Ok");
		algoChat.recibirMensajeDe("Agustin", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Agustin", "Te dije que si");
		String mensaje = algoChat.obtenerConversacionCon("Agustin").get(1);
		Assert.assertEquals("La prueba NO pasó: No devolvio el ultimo elemento", "Yo: Te dije que si", mensaje);
	}
	
	@Test
	public void testObtenerConversacionEnPosicionDosDevuelveElUltimoMensaje(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Paso a las 7");
		algoChat.enviarMensajeA("Agustin", "Ok");
		algoChat.recibirMensajeDe("Agustin", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Agustin", "Te dije que si");
		String mensaje = algoChat.obtenerConversacionCon("Agustin").get(2);
		Assert.assertEquals("La prueba NO pasó: No devolvio el ante ultimo elemento", "Agustin: Avisame si vas a estar", mensaje);
	}
	
	@Test (expected = ContactoInexistente.class)
	public void testEnviarUnMensajeAUnContactoInexistenteLevantaUnaExcepcion(){
		algoChat.enviarMensajeA("Agustin", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	@Test (expected = ContactoInexistente.class)
	public void testRecibirUnMensajeDeUnContactoInexistenteLevantaUnaExcepcion(){
		algoChat.recibirMensajeDe("Agustin", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}
	
	//PRUEBAS SOBRE UN GRUPO

	@Test
	public void testAgregarUnContactoAUnGrupoAumentaEnUnoLaCantidadDeMiembrosDelGrupo(){
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Tarde");
		int cantidad = algoChat.cantidadMiembrosEnGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		cantidad = algoChat.cantidadMiembrosEnGrupo("Tarde") - cantidad;
		Assert.assertEquals("La prueba NO pasó: No aumento en uno la cantidad de miembros", 1, cantidad);
	}
	
	@Test
	public void testBorrarConversacionDelGrupoBorraLosMensajesDelGrupo(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.borrarMensajesDelGrupo("Tarde");
		int cantidad = algoChat.obtenerConversacionConGrupo("Tarde").cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: No borro la conversacion del grupo", 0, cantidad);
	}
	
	@Test
	public void testCantidadDeChatsGrupalesNoCuentaLosGruposSinMensajes(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.crearGrupo("Todos");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Todos");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		Assert.assertEquals("La prueba NO pasó: No devolvio uno", 1, algoChat.cantidadDeChatsGrupales());
	}

	@Test
	public void testCantidadDeGruposCuentaLosGruposSinMensajes(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.crearGrupo("Todos");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Todos");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, algoChat.cantidadDeGrupos());
	}
	
	@Test
	public void testCantidadMensajesEnviadosAlGrupoDevuelveDos(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.enviarMensajeAGrupo("Tarde", "Pero creo que Mati si");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, algoChat.cantidadMensajesEnviadosAlGrupo("Tarde"));
	}

	@Test
	public void testCantidadMensajesEnviadosDeAgustinDevuelveUno(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.enviarMensajeAGrupo("Tarde", "Pero creo que Mati si");
		Assert.assertEquals("La prueba NO pasó: No devolvio uno", 1, algoChat.cantidadMensajesDe("Agustin"));
	}

	@Test
	public void testCantidadMensajesRecibidosAlGrupoDevuelveDos(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, algoChat.cantidadMensajesRecibidosDelGrupo("Tarde"));
	}

	@Test
	public void testCantidadTotalMensajesEnviadosDevuelveUno(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		Assert.assertEquals("La prueba NO pasó: No devolvio uno", 1, algoChat.cantidadTotalMensajesEnviados());
	}

	@Test
	public void testCantidadTotalMensajesRecibidosDevuelveDos(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, algoChat.cantidadTotalMensajesRecibidos());
	}

	@Test
	public void testCrearGrupoCreaUnGrupoConUnMiembro(){
		algoChat.crearGrupo("Tarde");
		Assert.assertEquals("La prueba NO pasó: No tiene un miembro", 1, algoChat.cantidadMiembrosEnGrupo("Tarde"));
	}

	@Test
	public void testCrearGrupoCreaUnGrupoSinMensajes(){
		algoChat.crearGrupo("Tarde");
		int cantidad = algoChat.obtenerConversacionConGrupo("Tarde").cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: No esta vacia la conversacion", 0, cantidad);
	}

	@Test
	public void testExisteGrupoDevuelveFalseSiNoExistElGrupo(){
		Assert.assertFalse("La prueba NO pasó: no devolvio falso", algoChat.existeGrupo("Tarde"));
	}

	@Test
	public void testExisteGrupoDevuelveTrueSiExistElGrupo(){
		algoChat.crearGrupo("Tarde");
		Assert.assertTrue("La prueba NO pasó: no devolvio falso", algoChat.existeGrupo("Tarde"));
	}

	@Test
	public void testObtenerConversacionDelGrupoDevuelveUnaListaDeTamanioTres(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		int tamanio = algoChat.obtenerConversacionConGrupo("Tarde").cantidadDeMensajes();
		Assert.assertEquals("La prueba NO pasó: No devolvio una lista de tamanio 3", 3, tamanio);
	}
	
	@Test
	public void testObtenerConversacionDelGrupoEnLaPosicionUnoDevuelveElUltimoMensaje(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		String mensaje = algoChat.obtenerConversacionConGrupo("Tarde").get(1);
		Assert.assertEquals("La prueba NO pasó: No devolvio el ultimo mensaje", "Ivan: No. Que cosa?", mensaje);
	}

	@Test
	public void testObtenerConversacionDelGrupoEnLaPosicionDosDevuelveElAnteUltimoMensaje(){
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		String mensaje = algoChat.obtenerConversacionConGrupo("Tarde").get(2);
		Assert.assertEquals("La prueba NO pasó: No devolvio el ultimo mensaje", "Yo: Yo no", mensaje);
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testEnviarMensajeAGrupoInexistenteLevantaUnaExcepcion(){
		algoChat.enviarMensajeAGrupo("Tarde", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}
	
	@Test (expected = GrupoInexistente.class)
	public void testRecibirMensajeAGrupoInexistenteLevantaUnaExcepcion(){
		algoChat.agregarContacto("Ivan");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo GrupoInexistente");
	}

	@Test (expected = ContactoNoPertenecienteAlGrupo.class)
	public void testRecibirMensajeAlGrupoDeUnContactoNoPertenecienteLevantaUnaExcepcion(){
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "Hola");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoNoPertenecienteAlGrupo");
	}
	
	@Test (expected = ContactoInexistente.class)
	public void testAgregarContactoInexistenteAlGrupoLevantaUnaExcepcion(){
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		Assert.fail("La prueba NO pasó: no levanto una excepcion del tipo ContactoInexistente");
	}

	//PRUEBAS SOBRE GRUPOS Y CONVERSACIONES
	
	@Test 
	public void testBorrarMensajesDeUnContactoNoBorraSusMensajesDeGrupos(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Paso a las 7");
		algoChat.enviarMensajeA("Agustin", "Ok");
		algoChat.recibirMensajeDe("Agustin", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Agustin", "Te dije que si");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		algoChat.borrarMensajesDelContacto("Agustin");
		Assert.assertEquals("La prueba NO pasó: No devolvio uno", 1, algoChat.cantidadMensajesDe("Agustin"));
	}

	@Test 
	public void testBorrarMensajesDelGrupoNoBorraLosMensajesIndividuales(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Paso a las 7");
		algoChat.enviarMensajeA("Agustin", "Ok");
		algoChat.recibirMensajeDe("Agustin", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Agustin", "Te dije que si");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		algoChat.borrarMensajesDelGrupo("Tarde");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, algoChat.cantidadMensajesDe("Agustin"));
	}

	@Test 
	public void testCantidadMensajesDeUnContactoCuentaLosMensajesDeGrupos(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Paso a las 7");
		algoChat.enviarMensajeA("Agustin", "Ok");
		algoChat.recibirMensajeDe("Agustin", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Agustin", "Te dije que si");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		Assert.assertEquals("La prueba NO pasó: No devolvio tres", 3, algoChat.cantidadMensajesDe("Agustin"));
	}
	
	@Test 
	public void testCantidadTotalDeMensajesEnviadosCuentaLosMensajesDeGrupos(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Paso a las 7");
		algoChat.enviarMensajeA("Agustin", "Ok");
		algoChat.recibirMensajeDe("Agustin", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Agustin", "Te dije que si");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		Assert.assertEquals("La prueba NO pasó: No devolvio tres", 3, algoChat.cantidadTotalMensajesEnviados());
	}
	
	@Test 
	public void testCantidadTotalDeMensajesRecibidosCuentaLosMensajesDeGrupos(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Paso a las 7");
		algoChat.enviarMensajeA("Agustin", "Ok");
		algoChat.recibirMensajeDe("Agustin", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Agustin", "Te dije que si");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		Assert.assertEquals("La prueba NO pasó: No devolvio cuatro", 4, algoChat.cantidadTotalMensajesRecibidos());
	}

	@Test 
	public void testCantidadMensajesEnviadosAlGrupoDevuelveSoloLosMensajesEnviadosDelGrupos(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Paso a las 7");
		algoChat.enviarMensajeA("Agustin", "Ok");
		algoChat.recibirMensajeDe("Agustin", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Agustin", "Te dije que si");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		Assert.assertEquals("La prueba NO pasó: No devolvio uno", 1, algoChat.cantidadMensajesEnviadosAlGrupo("Tarde"));
	}
	
	@Test 
	public void testCantidadMensajesRecibidosAlGrupoDevuelveSoloLosMensajesRecibidosDelGrupos(){
		algoChat.agregarContacto("Agustin");
		algoChat.recibirMensajeDe("Agustin", "Paso a las 7");
		algoChat.enviarMensajeA("Agustin", "Ok");
		algoChat.recibirMensajeDe("Agustin", "Avisame si vas a estar");
		algoChat.enviarMensajeA("Agustin", "Te dije que si");
		algoChat.agregarContacto("Ivan");
		algoChat.crearGrupo("Tarde");
		algoChat.agregarContactoAGrupo("Agustin", "Tarde");
		algoChat.agregarContactoAGrupo("Ivan", "Tarde");
		algoChat.recibirMensajeDeGrupo("Tarde", "Agustin", "Alguien aviso a Ivan?");
		algoChat.enviarMensajeAGrupo("Tarde", "Yo no");
		algoChat.recibirMensajeDeGrupo("Tarde", "Ivan", "No. Que cosa?");
		Assert.assertEquals("La prueba NO pasó: No devolvio dos", 2, algoChat.cantidadMensajesRecibidosDelGrupo("Tarde"));
	}
}
