
public class ContactoEmpresa extends Contacto {

	private String sitioWeb;
	
	public ContactoEmpresa(String nombre, int telefono, String sitioWeb) {
		super(nombre, telefono);
		this.sitioWeb = sitioWeb;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", telefono: " + telefono + ", web: " + sitioWeb + " (Empresa)" ;
	}
	
	
}
