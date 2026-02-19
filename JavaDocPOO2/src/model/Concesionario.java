package model;

import java.util.ArrayList;

/**
 * Clase que representa un concesionario de coches.
 * 
 * Gestiona un conjunto de vehículos en stock y permite realizar
 * operaciones como agregar coches, venderlos y mostrar el inventario.
 * 
 * @author Carlos Michelena Rueda
 * @since 18/02/2026
 * @version 1.0.0
 */
public class Concesionario {

	/**
	 * Nombre del concesionario
	 */
	private String nombre;

	/**
	 * Lista de coches disponibles en el stock
	 */
	private ArrayList<Coche> cochesEnStock;

	/**
	 * Constructor que inicializa el concesionario con un nombre
	 * y crea una lista vacía para el stock.
	 * 
	 * @param nombre Nombre del concesionario
	 */
	public Concesionario(String nombre) {
		this.nombre = nombre;
		this.cochesEnStock = new ArrayList<>();
	}

	// ===================================
	// Getters y Setters
	// ===================================

	/**
	 * Obtiene el nombre del concesionario.
	 * @return nombre del concesionario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del concesionario.
	 * @param nombre Nuevo nombre del concesionario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la lista de coches en stock.
	 * @return lista de coches disponibles
	 */
	public ArrayList<Coche> getCochesEnStock() {
		return cochesEnStock;
	}

	/**
	 * Establece una nueva lista de coches en stock.
	 * @param cochesEnStock Nueva lista de coches
	 */
	public void setCochesEnStock(ArrayList<Coche> cochesEnStock) {
		this.cochesEnStock = cochesEnStock;
	}

	// ===================================
	// Métodos de Gestión del Concesionario
	// ===================================

	/**
	 * Añade un coche al stock del concesionario.
	 * @param c Coche que se desea agregar
	 */
	public void agregarCoche(Coche c) {
		this.cochesEnStock.add(c);
		System.out.println("Coche agregado al stock: " + c.getMarca() + " " + c.getModelo());
	}

	/**
	 * Vende un coche buscando por su modelo.
	 * Si el coche existe en el stock:
	 * <ul>
	 *     <li>Calcula el precio final de venta</li>
	 *     <li>Lo elimina del inventario</li>
	 *     <li>Devuelve el precio de venta</li>
	 * </ul>
	 * Si no existe, devuelve 0.0
	 * @param modelo Modelo del coche a vender
	 * @return Precio final de venta o 0.0 si no se encuentra
	 */
	public double venderCoche(String modelo) {

		for (int i = cochesEnStock.size() - 1; i >= 0; i--) {
			Coche c = cochesEnStock.get(i);

			if (c.getModelo().equalsIgnoreCase(modelo)) {
				double precioVenta = c.calcularPrecioVentaFinal();
				cochesEnStock.remove(i);

				System.out.println("VENTA REALIZADA: " + c.getMarca() + " " + c.getModelo() + " ha sido vendido.");
				return precioVenta;
			}
		}

		System.out.println("ERROR: No se encontró ningún coche con el modelo '" + modelo + "'.");
		return 0.0;
	}

	/**
	 * Muestra por consola el inventario completo del concesionario.
	 * Si el stock está vacío, se informa al usuario.
	 */
	public void mostrarInventario() {
		System.out.println("\n--- INVENTARIO DE " + this.nombre + " ---");

		if (cochesEnStock.isEmpty()) {
			System.out.println("El stock está vacío. No hay coches para mostrar.");
			return;
		}

		for (Coche coche : cochesEnStock) {
			double precioFinal = coche.calcularPrecioVentaFinal();
			System.out.printf(" - %s Precio Final con IVA: %.2f€)%n", coche.toString(), precioFinal);
		}

		System.out.println("--------------------------------------\n");
	}
}
