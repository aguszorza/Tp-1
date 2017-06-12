package fiuba.algo3.ejemplo1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlgoChatTests {

	 @Test
	    public void test01NuevoClienteChat() {

	        AlgoChat algoChat = new AlgoChat("Carlos");

	        assertEquals(0, algoChat.cantidadDeChatsIndividuales());
	        assertEquals(0, algoChat.cantidadDeContactos());
	        assertEquals(0, algoChat.cantidadDeChatsGrupales());
	        assertEquals(0, algoChat.cantidadDeGrupos());
	        assertEquals(0, algoChat.cantidadDeMensajesEnviados());
	        assertEquals("Carlos", algoChat.nombreUsuario());
	    }

	    @Test
	    public void test02AgregarContactos() {

	        AlgoChat algoChat = new AlgoChat("Carlos");

	        algoChat.agregarContacto("Marcio");
	        algoChat.agregarContacto("Diego");
	        algoChat.agregarContacto("Eugenio");
	        algoChat.agregarContacto("Tomas");

	        assertEquals(4, algoChat.cantidadDeContactos());
	        assertTrue(algoChat.existeContacto("Diego"));
	    }

	    @Test
	    public void test03RecibirMensaje() {

	        AlgoChat algoChat = new AlgoChat("Carlos");

	        algoChat.agregarContacto("Marcio");
	        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");

	        assertEquals(1, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(1, algoChat.cantidadMensajesDe("Marcio"));

	        algoChat.agregarContacto("Diego");
	        algoChat.recibirMensajeDe("Diego", "Paso a las 7");
	        algoChat.recibirMensajeDe("Diego", "Avisame si vas a estar");

	        assertEquals(3, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(1, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(2, algoChat.cantidadMensajesDe("Diego"));
	    }

	    @Test
	    public void test04Conversar() {

	        AlgoChat algoChat = new AlgoChat("Carlos");

	        algoChat.agregarContacto("Marcio");
	        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
	        algoChat.enviarMensajeA("Marcio", "Hoy no.");

	        assertEquals(1, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(1, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(1, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(1, algoChat.cantidadMensajesEnviadosA("Marcio"));

	        algoChat.agregarContacto("Diego");
	        algoChat.recibirMensajeDe("Diego", "Paso a las 7");
	        algoChat.enviarMensajeA("Diego", "OK");
	        algoChat.recibirMensajeDe("Diego", "Avisame si vas a estar");
	        algoChat.enviarMensajeA("Diego", "Te dije que si...");

	        assertEquals(3, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(2, algoChat.cantidadMensajesDe("Diego"));
	        assertEquals(3, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(2, algoChat.cantidadMensajesEnviadosA("Diego"));

	        assertEquals("Yo: Te dije que si...", algoChat.obtenerConversacionCon("Diego").get(1));
	        assertEquals("Diego: Avisame si vas a estar", algoChat.obtenerConversacionCon("Diego").get(2));
	        assertEquals("Yo: OK", algoChat.obtenerConversacionCon("Diego").get(3));
	    }

	    @Test
	    public void test05ArmarGrupo() {

	        AlgoChat algoChat = new AlgoChat("Carlos");

	        algoChat.agregarContacto("Marcio");
	        algoChat.agregarContacto("Diego");
	        algoChat.agregarContacto("Eugenio");
	        algoChat.agregarContacto("Tomas");

	        algoChat.crearGrupo("Tarde");
	        algoChat.agregarContactoAGrupo("Marcio", "Tarde");
	        algoChat.agregarContactoAGrupo("Eugenio", "Tarde");

	        assertEquals(3, algoChat.cantidadMiembrosEnGrupo("Tarde"));
	        assertTrue(algoChat.existeGrupo("Tarde"));

	        algoChat.crearGrupo("Todos");
	        algoChat.agregarContactoAGrupo("Marcio", "Todos");
	        algoChat.agregarContactoAGrupo("Eugenio", "Todos");
	        algoChat.agregarContactoAGrupo("Diego", "Todos");
	        algoChat.agregarContactoAGrupo("Tomas", "Todos");

	        assertEquals(5, algoChat.cantidadMiembrosEnGrupo("Todos"));
	        assertTrue(algoChat.existeGrupo("Todos"));
	    }

	    @Test
	    public void test06ConversarEnGrupo() {

	        AlgoChat algoChat = new AlgoChat("Carlos");

	        algoChat.agregarContacto("Marcio");
	        algoChat.agregarContacto("Diego");
	        algoChat.agregarContacto("Eugenio");
	        algoChat.agregarContacto("Tomas");

	        algoChat.crearGrupo("Tarde");
	        algoChat.agregarContactoAGrupo("Marcio", "Tarde");
	        algoChat.agregarContactoAGrupo("Eugenio", "Tarde");

	        algoChat.crearGrupo("Todos");
	        algoChat.agregarContactoAGrupo("Marcio", "Todos");
	        algoChat.agregarContactoAGrupo("Eugenio", "Todos");
	        algoChat.agregarContactoAGrupo("Diego", "Todos");
	        algoChat.agregarContactoAGrupo("Tomas", "Todos");

	        algoChat.recibirMensajeDeGrupo("Tarde", "Marcio", "Nos juntamos el lunes?");
	        algoChat.enviarMensajeAGrupo("Tarde", "Yo puedo");
	        algoChat.recibirMensajeDeGrupo("Tarde", "Eugenio", "Me too");
	        algoChat.enviarMensajeAGrupo("Tarde", "bien, yo llevo las medialunas...");

	        assertEquals(2, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(1, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(2, algoChat.cantidadMensajesRecibidosDelGrupo("Tarde"));
	        assertEquals(2, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(2, algoChat.cantidadMensajesEnviadosAlGrupo("Tarde"));

	        assertEquals("Yo: bien, yo llevo las medialunas...", algoChat.obtenerConversacionConGrupo("Tarde").get(1));
	        assertEquals("Eugenio: Me too", algoChat.obtenerConversacionConGrupo("Tarde").get(2));
	        assertEquals("Marcio: Nos juntamos el lunes?", algoChat.obtenerConversacionConGrupo("Tarde").get(4));

	        algoChat.recibirMensajeDeGrupo("Todos", "Marcio", "Alguien aviso a Pablo?");
	        algoChat.enviarMensajeAGrupo("Todos", "Yo no");
	        algoChat.recibirMensajeDeGrupo("Todos", "Diego", "Yo tampoco");
	        algoChat.recibirMensajeDeGrupo("Todos", "Tomas", "Me neither");
	        algoChat.enviarMensajeAGrupo("Todos", "sonamos...");

	        assertEquals(5, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(2, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(3, algoChat.cantidadMensajesRecibidosDelGrupo("Todos"));
	        assertEquals(4, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(2, algoChat.cantidadMensajesEnviadosAlGrupo("Tarde"));

	        assertEquals("Yo: sonamos...", algoChat.obtenerConversacionConGrupo("Todos").get(1));
	        assertEquals("Tomas: Me neither", algoChat.obtenerConversacionConGrupo("Todos").get(2));
	        assertEquals("Diego: Yo tampoco", algoChat.obtenerConversacionConGrupo("Todos").get(3));

	    }

	    @Test
	    public void test07OperarSobreConversaciones() {

	        AlgoChat algoChat = new AlgoChat("Carlos");

	        algoChat.agregarContacto("Marcio");
	        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
	        algoChat.enviarMensajeA("Marcio", "hoy no");

	        assertEquals(1, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(1, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(1, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(1, algoChat.cantidadMensajesEnviadosA("Marcio"));

	        algoChat.agregarContacto("Diego");
	        algoChat.recibirMensajeDe("Diego", "Paso a las 7");
	        algoChat.enviarMensajeA("Diego", "OK");
	        algoChat.recibirMensajeDe("Diego", "Avisame si vas a estar");
	        algoChat.enviarMensajeA("Diego", "Te dije que si...");

	        assertEquals(3, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(2, algoChat.cantidadMensajesDe("Diego"));
	        assertEquals(3, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(2, algoChat.cantidadMensajesEnviadosA("Diego"));

	        algoChat.borrarMensajesDelContacto("Marcio");

	        assertEquals(2, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(2, algoChat.cantidadMensajesDe("Diego"));
	        assertEquals(0, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(2, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(2, algoChat.cantidadMensajesEnviadosA("Diego"));
	        assertEquals(0, algoChat.cantidadMensajesEnviadosA("Marcio"));
	    }

	    @Test
	    public void test08OperarSobreGrupos() {

	        AlgoChat algoChat = new AlgoChat("Carlos");

	        algoChat.agregarContacto("Marcio");
	        algoChat.agregarContacto("Diego");
	        algoChat.agregarContacto("Eugenio");
	        algoChat.agregarContacto("Tomas");

	        algoChat.crearGrupo("Tarde");
	        algoChat.agregarContactoAGrupo("Marcio", "Tarde");
	        algoChat.agregarContactoAGrupo("Eugenio", "Tarde");

	        algoChat.crearGrupo("Todos");
	        algoChat.agregarContactoAGrupo("Marcio", "Todos");
	        algoChat.agregarContactoAGrupo("Eugenio", "Todos");
	        algoChat.agregarContactoAGrupo("Diego", "Todos");
	        algoChat.agregarContactoAGrupo("Tomas", "Todos");

	        algoChat.recibirMensajeDeGrupo("Tarde", "Marcio", "Nos juntamos el lunes?");
	        algoChat.enviarMensajeAGrupo("Tarde", "Yo puedo");
	        algoChat.recibirMensajeDeGrupo("Tarde", "Eugenio", "Me too");
	        algoChat.enviarMensajeAGrupo("Tarde", "bien, yo llevo las medialunas...");

	        assertEquals(2, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(1, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(2, algoChat.cantidadMensajesRecibidosDelGrupo("Tarde"));
	        assertEquals(2, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(2, algoChat.cantidadMensajesEnviadosAlGrupo("Tarde"));

	        algoChat.recibirMensajeDeGrupo("Todos", "Marcio", "Alguien aviso a Pablo?");
	        algoChat.enviarMensajeAGrupo("Todos", "Yo no");
	        algoChat.recibirMensajeDeGrupo("Todos", "Diego", "Yo tampoco");
	        algoChat.recibirMensajeDeGrupo("Todos", "Tomas", "Me neither");
	        algoChat.enviarMensajeAGrupo("Todos", "sonamos...");

	        assertEquals(5, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(2, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(3, algoChat.cantidadMensajesRecibidosDelGrupo("Todos"));
	        assertEquals(4, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(2, algoChat.cantidadMensajesEnviadosAlGrupo("Tarde"));

	        algoChat.borrarMensajesDelGrupo("Todos");

	        assertEquals(2, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(1, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(0, algoChat.cantidadMensajesRecibidosDelGrupo("Todos"));
	        assertEquals(2, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(2, algoChat.cantidadMensajesEnviadosAlGrupo("Tarde"));
	    }

}
