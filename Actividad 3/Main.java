import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Map<String, String> usuarios = new LinkedHashMap<>();
	private static Scanner sn = new Scanner(System.in);
	private static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	// MÉTODO QUE MUESTRA EL MENÚ PRINCIPAL Y GESTIONA LAS OPCIONES
	private static void menu() {
		while (true) { // BUCLE INFINITO PARA MOSTRAR EL MENÚ HASTA QUE EL USUARIO DECIDA SALIR
			System.out.println("\nSISTEMA DE AUTENTICACION");
			System.out.println("1. Registrar usuario");
			System.out.println("2. Iniciar sesión");
			System.out.println("3. Eliminar usuario");
			System.out.println("4. Mostrar usuarios");
			System.out.println("5. Salir");
			int opcion = sn.nextInt();
			menuSwitch(opcion);
		}
	}

	// MÉTODO QUE GESTIONA LA OPCIÓN SELECCIONADA DEL MENÚ
	private static void menuSwitch(int opcion) {
		switch (opcion) {
		case 1:
			registrarUsuario();
			break;
		case 2:
			iniciarSesion();
			break;
		case 3:
			eliminarUsuario();
			break;
		case 4:
			mostrarUsuarios();
			break;
		case 5:
			System.out.println("Saliendo");
			return;
		default:
			System.err.println("Opcion no valida. Intente de nuevo");
		}

	}

	// MÉTODO PARA REGISTRAR USUARIOS
	private static void registrarUsuario() {
		System.out.print("Ingrese un nombre de usuario: ");
		String usuario = st.nextLine();
		if (usuarios.containsKey(usuario)) { // VERIFICA SI EL USUARIO YA EXISTE
			System.err.println("El usuario ya existe");
			return;
		}
		System.out.print("Ingrese una contraseña: ");
		String contraseña = st.nextLine();
		usuarios.put(usuario, contraseña); // AGREGA EL USUARIO AL MAPA
		System.out.println("Usuario registrado exitosamente");
	}

	// MÉTODO PARA INICIAR SESION
	private static void iniciarSesion() {
		System.out.print("Ingrese su nombre de usuario: ");
		String usuario = st.nextLine();
		if (!usuarios.containsKey(usuario)) { // VERIFICA SI EL USUARIO EXISTE EN EL MAPA
			System.err.println("Usuario no encontrado");
			return;
		}
		System.out.print("Ingrese tu contraseña: ");
		String contraseña = st.nextLine();
		if (usuarios.get(usuario).equals(contraseña)) { // COMPARA LA CONTRASEÑA INGRESADA CON LA ALMACENADA
			System.out.println("¡Bienvenido " + usuario + "!");
		} else {
			System.err.println("Contraseña incorrecta");
		}
	}

	// MÉTODO PARA ELIMINAR USUARIO
	private static void eliminarUsuario() {
		System.out.print("Ingrese el nombre del usuario a eliminar: ");
		String usuario = st.nextLine();
		if (usuarios.remove(usuario) != null) { // ELIMINA EL USUARIO SI EXISTE EN EL MAPA
			System.out.println("Usuario eliminado");
		} else {
			System.err.println("Usuario no encontrado");
		}
	}

	// MÉTODO PARA MOSTRAR USUARIOS
	private static void mostrarUsuarios() {
		if (usuarios.isEmpty()) { // VERIFICA SI HAY USUARIOS REGISTRADOS
			System.err.println("No hay usuarios registrados");
		} else {
			System.out.println("\nListado de usuarios registrados:");
			for (String usuario : usuarios.keySet()) {
				System.out.println("* " + usuario);
			}
		}
	}
}
