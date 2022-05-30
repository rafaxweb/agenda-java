import java.time.LocalDate;

public class ContactoPersona extends Contacto {

	String cumplea�osDate;
	
	public ContactoPersona(String nombre, int telefono, String cumplea�os) {
		
		super(nombre, telefono);
		this.cumplea�osDate = cumplea�os;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", telefono: " + telefono + ", cumplea�os: " + cumplea�osDate + " (Persona)" ;
	}

	// // Getters y Setters
	public String getCumplea�osDate() {
		return cumplea�osDate;
	}

	public void setCumplea�osDate(String cumplea�osDate) {
		this.cumplea�osDate = cumplea�osDate;
	}
	
}
