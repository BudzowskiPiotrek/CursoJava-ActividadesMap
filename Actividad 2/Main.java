import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static Map<String, Double> productos = new TreeMap<>();
	public static Scanner sn = new Scanner(System.in);
	public static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	// MÉTODO QUE MUESTRA EL MENÚ PRINCIPAL Y GESTIONA LAS OPCIONES
	private static void menu() {
		do {
			System.out.println("1. Añadir un nuevo producto con su precio");
			System.out.println("2. Actualizar el precio del producto");
			System.out.println("3. Eliminar un producto");
			System.out.println("4. Mostrar todos los productos");
			int key = sn.nextInt();
			menuSwitch(key);
		} while (true);
	}

	// MÉTODO QUE GESTIONA LA OPCIÓN SELECCIONADA DEL MENÚ
	private static void menuSwitch(int key) {
		switch (key) {
		case 1:
			anadirProducto();
			break;
		case 2:
			actualizarPrecio();
			break;
		case 3:
			eliminarProducto();
			break;
		case 4:
			mostrarProductos();
			break;
		default:
			break;
		}
	}

	private static void mostrarProductos() {
		// MOSTRAR TODOS LOS PRODUCTOS Y SUS PRECIOS
		for (Map.Entry<String, Double> entrada : productos.entrySet()) {
			System.out.println(entrada.getKey() + ": " + entrada.getValue());
		}
	}

	private static void eliminarProducto() {
		// SOLICITAR EL NOMBRE DEL PRODUCTO A ELIMINAR
		System.out.println("Dime el nombre del producto: ");
		String nombre = st.nextLine();
		// VERIFICAR SI EL PRODUCTO EXISTE EN EL INVENTARIO
		if (productos.containsKey(nombre)) {
			productos.remove(nombre); // ELIMINAR EL PRODUCTO
			System.out.println("Producto eliminado");
		} else {
			System.out.println("No se encontro al producto");
		}
	}

	private static void actualizarPrecio() {
		// SOLICITAR EL NOMBRE DEL PRODUCTO PARA ACTUALIZAR SU PRECIO
		System.out.println("Dime el nombre del producto: ");
		String nombre = st.nextLine();

		// VERIFICAR SI EL PRODUCTO EXISTE EN EL INVENTARIO
		if (productos.containsKey(nombre)) {
			System.out.println("Producto encontrado");			
			System.out.println("Dime el nuevo precio del producto: ");
			double precio = sn.nextDouble();
			productos.put(nombre, precio); // ACTUALIZAR EL PRECIO DEL PRODUCTO
			System.out.println("Precio actualizado con exito");
		} else {
			System.out.println("No se encontro al producto");
		}
	}

	private static void anadirProducto() {
		System.out.println("Dime el nombre del producto: ");
		String nombre = st.nextLine();
		// SOLICITAR EL PRECIO DEL NUEVO PRODUCTO
		System.out.println("Dime el precio del producto: ");
		double precio = sn.nextDouble();
		productos.put(nombre, precio); // AÑADIR EL PRODUCTO AL INVENTARIO
	}
}
