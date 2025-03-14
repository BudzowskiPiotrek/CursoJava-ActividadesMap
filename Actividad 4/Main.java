import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Map<Libro, Integer> catalogo = new HashMap<>(); // MAPA PARA ALMACENAR LIBROS Y CANTIDAD
	private static Scanner sn = new Scanner(System.in);
	private static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	// MÉTODO QUE MUESTRA EL MENÚ PRINCIPAL Y GESTIONA LAS OPCIONES
	private static void menu() {
		while (true) { // BUCLE PARA MOSTRAR EL MENÚ HASTA QUE SE DECIDA SALIR
			System.out.println("1. Añadir un libro");
			System.out.println("2. Actualizar cantidad de copias");
			System.out.println("3. Eliminar un libro");
			System.out.println("4. Mostrar todos los libros");
			System.out.print("Seleccione una opción: ");
			int opcion = sn.nextInt();
			menuSwitch(opcion);
		}
	}

	// MÉTODO QUE GESTIONA LA OPCIÓN SELECCIONADA DEL MENÚ
	private static void menuSwitch(int opcion) {
		switch (opcion) {
		case 1:
			anadirLibro();
			break;
		case 2:
			actualizarCopias();
			break;
		case 3:
			eliminarLibro();
			break;
		case 4:
			mostrarLibros();
			break;
		default:
			System.err.println("Opcion no Valida");
		}
	}

	// MÉTODO PARA AÑADIR UN LIBRO
	private static void anadirLibro() {
		System.out.print("Cual es Titulo del Libro: ");
		String titulo = st.nextLine();
		System.out.print("Cual es el Autor del Libro: ");
		String autor = st.nextLine();
		System.out.print("Cual es el volumen: ");
		int cantidad = sn.nextInt();
		Libro n1 = new Libro(titulo, autor);
		catalogo.put(n1, cantidad); // AÑADE EL LIBRO AL CATÁLOGO
		System.out.println("Libro añadido con exito");
	}

	// MÉTODO PARA ACTUALIZAR EL NUMERO DE COPIAS
	private static void actualizarCopias() {
		System.out.print("Cual es Titulo del Libro: ");
		String titulo = st.nextLine();
		System.out.print("Cual es el Autor del Libro: ");
		String autor = st.nextLine();
		Libro l1 = new Libro(titulo, autor);
		if (catalogo.containsKey(l1)) {
			System.out.print("Cual es nuevo volumen: ");
			int nuevasCantidad = sn.nextInt();
			catalogo.put(l1, nuevasCantidad); // ACTUALIZA LAS COPIAS DEL LIBRO
			System.out.println("Cantidad actualizada con exito");
		} else {
			System.err.println("No se encontro al libro");
		}
	}

	// MÉTODO PARA ELIMINAR LIBRO
	private static void eliminarLibro() {
		System.out.print("Cual es Titulo del Libro: ");
		String titulo = st.nextLine();
		System.out.print("Cual es el Autor del Libro: ");
		String autor = st.nextLine();
		Libro l1 = new Libro(titulo, autor);
		if (catalogo.containsKey(l1)) {
			catalogo.remove(l1); // BORRA EL LIBRO DE LOS REGISTROS
			System.out.println("Libro se borro con exito");
		} else {
			System.err.println("No se encontro al libro");
		}
	}

	// MÉTODO PARA MOSTRAR LIBROS
	private static void mostrarLibros() {
		if (catalogo.isEmpty()) { // VERIFICA SI HAY LIBROS REGISTRADOS
			System.err.println("NO HAY LIBROS EN LA BIBLIOTECA");
		} else {
			System.out.println("\nLISTADO DE LIBROS DISPONIBLES:");
			for (Map.Entry<Libro, Integer> entry : catalogo.entrySet()) {
				System.out.println(entry.getKey() + " - COPIAS DISPONIBLES: " + entry.getValue());
			}
		}
	}
}
