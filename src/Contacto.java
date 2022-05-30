
public class Contacto {

	// // Atributos
	protected String nombre;
	protected int telefono;
	
	// // Constructor
	public Contacto(String nombre, int telefono) {

		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	// // Métodos
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", telefono: " + telefono;
	}
	
	// // Getters y Setters

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	
}
