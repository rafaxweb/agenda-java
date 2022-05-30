import java.time.LocalDate;

public class ContactoPersona extends Contacto {

	String cumpleañosDate;
	
	public ContactoPersona(String nombre, int telefono, String cumpleaños) {
		
		super(nombre, telefono);
		this.cumpleañosDate = cumpleaños;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", telefono: " + telefono + ", cumpleaños: " + cumpleañosDate + " (Persona)" ;
	}

	// // Getters y Setters
	public String getCumpleañosDate() {
		return cumpleañosDate;
	}

	public void setCumpleañosDate(String cumpleañosDate) {
		this.cumpleañosDate = cumpleañosDate;
	}
	
}
