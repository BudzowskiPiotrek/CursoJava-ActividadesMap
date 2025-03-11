import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static Map<String, Double> notasEstudiantes = new HashMap<>();
	public static Scanner sn = new Scanner(System.in);
	public static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	// MÉTODO QUE MUESTRA EL MENÚ PRINCIPAL Y GESTIONA LAS OPCIONES
	private static void menu() {
		do {
			System.out.println("1.Añadir un nuevo estudiante y su calificación");
			System.out.println("2.Actualizar la calificación de un estudiante.");
			System.out.println("3.Eliminar un estudiante.");
			System.out.println("4.Mostrar todos los estudiantes y sus calificaciones");
			int key = sn.nextInt();  
			menuSwitch(key);  
		} while (true);  // BUCLE INFINITO
	}

	// MÉTODO QUE GESTIONA LA OPCIÓN SELECCIONADA DEL MENÚ
	private static void menuSwitch(int key) {
		switch (key) {
		case 1:  
			anadirEstudiante();
			break;
		case 2:  
			actualizarNota();
			break;
		case 3: 
			eliminarEstudiante();
			break;
		case 4:  
			mostrarEstudiantes();
			break;
		default:  
			break;
		}
	}

	// MÉTODO PARA MOSTRAR LA LISTA DE ESTUDIANTES Y SUS CALIFICACIONES
	private static void mostrarEstudiantes() {
		for (Map.Entry<String, Double> entrada : notasEstudiantes.entrySet()) {  // ITERAR SOBRE CADA ENTRADA EN EL MAPA
			System.out.println(entrada.getKey() + ": " + entrada.getValue());  // IMPRIMIR EL NOMBRE Y LA CALIFICACIÓN
		}
	}

	// MÉTODO PARA ELIMINAR UN ESTUDIANTE
	private static void eliminarEstudiante() {
		System.out.println("Dime nombre del estudiante: ");
		String nombre = st.nextLine();  

		// COMPROBAR SI EL ESTUDIANTE EXISTE EN EL MAPA
		if (notasEstudiantes.containsKey(nombre)) {
			notasEstudiantes.remove(nombre);  // ELIMINAR EL ESTUDIANTE
			System.out.println("Estudiante fue eliminado");
		} else {
			System.out.println("No se encontro el alumno");
		}
	}

	// MÉTODO PARA ACTUALIZAR LA CALIFICACIÓN DE UN ESTUDIANTE
	private static void actualizarNota() {
		System.out.println("Dime nombre del estudiante: ");
		String nombre = st.nextLine();  

		// COMPROBAR SI EL ESTUDIANTE EXISTE EN EL MAPA
		if (notasEstudiantes.containsKey(nombre)) {
			System.out.println("Estudiante encontrado/a");
			System.out.println("Dime la nota del estudiante: ");
			double nota = sn.nextDouble(); 
			notasEstudiantes.put(nombre, nota);  // ACTUALIZAR LA CALIFICACIÓN
			System.out.println("Estudiante y su nota fue actualizada");
		} else {
			System.out.println("No se encontro el alumno");
		}
	}

	// MÉTODO PARA AÑADIR UN NUEVO ESTUDIANTE Y SU CALIFICACIÓN
	private static void anadirEstudiante() {
		System.out.println("Dime nombre del estudiante: ");
		String nombre = st.nextLine();  
		System.out.println("Dime la nota del estudiante: ");
		double nota = sn.nextDouble();  // LEER LA CALIFICACIÓN DEL ESTUDIANTE
		notasEstudiantes.put(nombre, nota);  // AÑADIR AL MAPA
	}
}
