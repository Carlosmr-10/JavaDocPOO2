package controller;

import model.Coche;

/**
 * Clase de prueba para verificar el funcionamiento de la clase Coche. Permite
 * comprobar el uso de constructores, setters y el cálculo del precio final con
 * IVA.
 * 
 * @author Carlos Michelena Rueda
 * @since 18/02/2026
 * @version 1.0.0
 */
public class MainCoche {

	/**
	 * Método principal que ejecuta pruebas básicas sobre la clase Coche. Se
	 * realizan las siguientes acciones:
	 * <ul>
	 * <li>Creación de un coche usando el constructor con parámetros</li>
	 * <li>Impresión de su información</li>
	 * <li>Cálculo del precio final con IVA</li>
	 * <li>Creación de un coche usando el constructor por defecto</li>
	 * <li>Asignación de valores mediante setters</li>
	 * <li>Cálculo del precio final del segundo coche</li>
	 * </ul>
	 * 
	 * @param args Argumentos de línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {

		/**
		 * Creación de un coche usando el constructor con argumentos
		 */
		Coche miCoche = new Coche("Toyota", "Corolla", 18500.00);
		System.out.println("Información del Coche:");
		System.out.println(miCoche.toString());

		/**
		 * Cálculo y muestra del precio final con IVA
		 */
		double precioFinal = miCoche.calcularPrecioVentaFinal();
		System.out.printf("Precio de Venta Final (con IVA del 21%%): %.2f€%n", precioFinal);

		System.out.println("-------------------------");

		/**
		 * Creación de un coche usando el constructor por defecto
		 */
		Coche cocheNuevo = new Coche();

		/**
		 * Asignación de valores mediante setters
		 */
		cocheNuevo.setMarca("Ford");
		cocheNuevo.setModelo("Focus");
		cocheNuevo.setPrecioBase(15000.00);

		System.out.println("Información del Coche Nuevo:");
		System.out.println(cocheNuevo.toString());

		/**
		 * Cálculo y muestra del precio final con IVA
		 */
		double precioFinalNuevo = cocheNuevo.calcularPrecioVentaFinal();
		System.out.printf("Precio de Venta Final (con IVA del 21%%): %.2f€%n", precioFinalNuevo);
	}
}
