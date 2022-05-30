import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public abstract class ProyectoAgenda {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Agenda agenda = new Agenda();

		clearScreen();
		agenda.leerAgendaDisco();
		menu(keyboard, agenda);
		
		keyboard.close();
		agenda.guardarAgendaDisco();
	}
	
	public static void menu(Scanner keyboard, Agenda agenda) {
		int numero = 0;
		do {
		System.out.println("Selecciona una opcion"
				+ "\n----------"
				+ "\n1. Añadir Contacto"
				+ "\n2. Eliminar contacto"
				+ "\n3. Buscar si existe un contacto"
				+ "\n4. Mostrar todos los contactos"
				+ "\n5. Mostrar un contacto"
				+ "\n6. Salir");
		

		System.out.print("Introduzca un número");
		numero = keyboard.nextInt();
		
		if (numero == 1) {
			clearScreen();
			System.out.println("-> Añadir Contacto");
			añadirContacto(keyboard, agenda);
		
		} else if (numero == 2) {
			clearScreen(); 
			System.out.println("-> Eliminar contacto");
			eliminarContacto(keyboard, agenda);
			
		
		} else if (numero == 3) {
			clearScreen();
			System.out.println("-> Buscar si existe un contacto");
			existeContacto(keyboard, agenda);
		
		} else if (numero == 4) {
			clearScreen();
			System.out.println("-> Mostrar todos los contactos");
			mostrarContactos(keyboard, agenda);
		
		} else if (numero == 5) {
			clearScreen();
			System.out.println("-> Mostrar un contacto");
			mostrarUnContacto(keyboard, agenda);
		
		} else if (numero == 6) {
			clearScreen();
			System.out.println("-> Salir");
		}

		} while (numero !=6);
	}
	
	public static void añadirContacto(Scanner keyboard, Agenda agenda) {
		
		System.out.print("Introduzca el nombre del nuevo contacto");
		String nombre = keyboard.next();
		
		System.out.print("Introduzca el telefono del nuevo contacto");
		int telefono = keyboard.nextInt();
		
		int opcion = 0;
		do {
			System.out.println("Desea añadir una persona(1) o una empresa(2)");
			opcion = keyboard.nextInt();
		
		} while (opcion<1 && opcion>2);
		
		Contacto nuevoContacto = null;
		if (opcion == 1) {
			System.out.print("Introduzca su cumpleaños");
			String cumple = keyboard.next();
			nuevoContacto = new ContactoPersona(nombre, telefono, cumple);
		
		} else if (opcion == 2) {
			System.out.print("Introduzca su sitio web");
			String web = keyboard.next();
			nuevoContacto = new ContactoEmpresa(nombre, telefono, web);
		}
		
		//Contacto nuevoContacto = new Contacto(nombre, telefono);
		agenda.agregarContacto(nuevoContacto);
	}

	public static void eliminarContacto(Scanner keyboard, Agenda agenda) {
		
		System.out.print("Introduzca el nombre del contacto a eliminar");
		String contacto = keyboard.next();
		
		agenda.eliminarContacto(contacto);
	}
	
	public static void existeContacto(Scanner keyboard, Agenda agenda) {
		System.out.print("Introduzca el nombre del contacto");
		String contacto = keyboard.next();
		
		agenda.existeContacto(contacto);
	}
	
	public static void mostrarContactos(Scanner keyboard, Agenda agenda) {
		System.out.print("Mostrando todos los contactos:\n");
		
		agenda.listarContactos();
	}
	
	public static void mostrarUnContacto(Scanner keyboard, Agenda agenda) {
		System.out.print("Introduzca el nombre del contacto para mostrar");
		String contacto = keyboard.next();
		
		agenda.mostrarContacto(contacto);
	}
	
	public static void clearScreen() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
}

