import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Agenda {

	// // Atributos
	private HashMap<String, Contacto> contactos = new HashMap<String, Contacto>();

	public Agenda() {
	}

	// // Métodos
	public void agregarContacto(Contacto c) {

		if (this.contactos.containsKey(c.getNombre())) {
			System.out.println("Ya existe un contacto con ese nombre");
			return;
		}

		if (this.contactos.containsValue(c)) {
			System.out.println("Ya existe un contacto igual");
			return;
		}

		contactos.put(c.getNombre(), c);
		guardarAgendaDisco();
	}

	public void eliminarContacto(String nombre) {
		if (this.contactos.containsKey(nombre)) {
			this.contactos.remove(nombre);
			System.out.printf("Se ha eliminado el contacto %s", nombre).println();

		} else {
			System.out.printf("No se ha podido eliminar; no existe el contacto con nombre %s", nombre).println();
		}
		guardarAgendaDisco();
	}

	public boolean existeContacto(String nombre) {
		return contactos.containsKey(nombre) ? true : false;
	}

	public void listarContactos() {

		SortedSet<String> keys = new TreeSet<>(this.contactos.keySet());
		for (String key : keys) {
			mostrarContacto(key);
		}

	}

	public void mostrarContacto(String nombre) {
		if (this.contactos.containsKey(nombre)) {
			System.out.println(this.contactos.get(nombre) );
		}
	}

	public void guardarAgendaDisco() {

		// inicialización de la librería gson
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// conversión objeto Java (Agenda) a string en formato JSON
		String contenidoJSON = gson.toJson(this);

		try {
			FileWriter fileWriter = new FileWriter("agenda.json");
			fileWriter.write(contenidoJSON);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void leerAgendaDisco() {

		try {
			String contenidoJSON = new String(Files.readAllBytes(Paths.get("agenda.json")));

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Agenda agenda = gson.fromJson(contenidoJSON, this.getClass());
			this.contactos = agenda.getContactos();

		} catch (NoSuchFileException e) {
			System.out.println("No existe el archivo de contactos, generando archivo...");
			guardarAgendaDisco();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public HashMap<String, Contacto> getContactos() {
		return contactos;
	}

}