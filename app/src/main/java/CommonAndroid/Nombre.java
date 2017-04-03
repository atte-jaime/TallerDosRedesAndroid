package CommonAndroid;

import java.io.Serializable;

public class Nombre implements Serializable {

	private String nombre;
	private int emisor;
	private int personaje;

	public Nombre(String nombre, int personaje, int emisor) {
		this.nombre = nombre;
		this.emisor = emisor;
		this.personaje=personaje;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEmisor() {
		return emisor;
	}

	public int getPersonaje() {
		return personaje;
	}

	public void setPersonaje(int personaje) {
		this.personaje = personaje;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmisor(int emisor) {
		this.emisor = emisor;
	}

}
