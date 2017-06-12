package fiuba.algo3.ejemplo1;

public class AlgoChat {

	private String nombre;
	private ConjuntoDeGrupos grupos;
	private ConjuntoDeContactos contactos;
	
	public AlgoChat(String nombre){
		this.nombre = nombre;
		this.grupos = new ConjuntoDeGrupos();
		this.contactos = new ConjuntoDeContactos();
	}
	
	public int cantidadDeContactos(){
		return this.contactos.cantidadDeContactos();
	}
	
	public int cantidadDeChatsIndividuales(){
		return this.contactos.cantidadDeChatsIndividuales();
	}
	
	public int cantidadDeGrupos(){
		return this.grupos.cantidadDeGrupos();
	}
	
	public int cantidadDeChatsGrupales(){
		return this.grupos.cantidadDeChatsGrupales();
	}
	
	public String nombreUsuario(){
		return this.nombre;
	}
	
	public int cantidadTotalMensajesEnviados(){
		int cantidad = this.contactos.cantidadTotalMensajesEnviados();
		cantidad = cantidad + this.grupos.cantidadTotalMensajesEnviados();
		return cantidad;
	}
	
	public int cantidadTotalMensajesRecibidos(){
		int cantidad = this.contactos.cantidadTotalMensajesRecibidos();
		cantidad = cantidad + this.grupos.cantidadTotalMensajesRecibidos();
		return cantidad;
	}
	
	public int cantidadDeMensajesEnviados(){
		return this.cantidadTotalMensajesEnviados();
	}
	
	public int cantidadMensajesDe(String unContacto){
		return this.contactos.cantidadMensajesDe(unContacto);
	}
	
	public int cantidadMensajesEnviadosA(String unContacto){
		return this.contactos.cantidadMensajesEnviadosA(unContacto);
	}
	
	public void agregarContacto(String unContacto){
		this.contactos.agregarContacto(unContacto);
	}
	
	public Boolean existeContacto(String unContacto){
		return this.contactos.existeContacto(unContacto);
	}
	
	public void recibirMensajeDe(String unContacto, String unMensaje){
		this.contactos.recibirMensajeDe(unContacto, unMensaje);
	}
	
	public void enviarMensajeA(String unContacto, String unMensaje){
		this.contactos.enviarMensajeA(unContacto, unMensaje);
	}
	
	public ListadoDeMensajes obtenerConversacionCon(String unContacto){
		return this.contactos.obtenerConversacionCon(unContacto);
	}
	
	public void borrarMensajesDelContacto(String unContacto){
		this.contactos.borrarMensajesDelContacto(unContacto);
	}
	
	public void crearGrupo(String unGrupo){
		this.grupos.crearGrupo(unGrupo);
	}
	
	public Boolean existeGrupo(String unGrupo){
		return this.grupos.existeGrupo(unGrupo);
	}
	
	public void agregarContactoAGrupo(String unContacto, String unGrupo){
		Grupo grupo = this.grupos.get(unGrupo);
		this.contactos.agregarContactoAGrupo(unContacto, grupo);
	}
	
	public int cantidadMiembrosEnGrupo(String unGrupo){
		return this.grupos.cantidadMiembrosEnGrupo(unGrupo);
	}
	
	public void recibirMensajeDeGrupo(String unGrupo, String unContacto, String unMensaje){
		this.grupos.comprobarGrupo(unGrupo);
		this.contactos.recibirMensajeDeGrupo(unGrupo, unContacto, unMensaje);
	}
	
	public void enviarMensajeAGrupo(String unGrupo, String unMensaje){
		this.grupos.enviarMensajeAGrupo(unGrupo, unMensaje);
	}
	
	public int cantidadMensajesRecibidosDelGrupo(String unGrupo){
		return this.grupos.cantidadMensajesRecibidosDelGrupo(unGrupo);
	}
	
	public int cantidadMensajesEnviadosAlGrupo(String unGrupo){
		return this.grupos.cantidadMensajesEnviadosAlGrupo(unGrupo);
	}
	
	public ListadoDeMensajes obtenerConversacionConGrupo(String unGrupo){
		return this.grupos.obtenerConversacionConGrupo(unGrupo);
	}
	
	public void borrarMensajesDelGrupo(String unGrupo){
		this.grupos.borrarMensajesDelGrupo(unGrupo);
	}
}
