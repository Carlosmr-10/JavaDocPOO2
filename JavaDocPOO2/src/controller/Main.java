package controller;

import java.util.ArrayList;

import model.Coche;
import model.Concesionario;

/**
 * Clase principal que ejecuta la prueba de funcionamiento
 * del sistema de gestión de un concesionario.
 * Permite comprobar la creación de objetos, uso de getters y setters,
 * gestión de inventario y simulación de ventas.
 * 
 * @author Carlos Michelena Rueda
 * @since 18/02/2026
 * @version 1.0.0
 */
public class Main {

    /**
     * Método principal de la aplicación.
     * Ejecuta una secuencia de pruebas que incluyen:
     * <ul>
     *     <li>Creación de un concesionario</li>
     *     <li>Modificación de su nombre</li>
     *     <li>Creación y agregado de coches al stock</li>
     *     <li>Venta de coches (existentes y no existentes)</li>
     *     <li>Consulta y vaciado del inventario</li>
     * </ul>
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        System.out.println("--- PRUEBA DE GESTIÓN DE CONCESIONARIO ---");

        /**
         * Creación del concesionario con nombre inicial
         */
        Concesionario miConcesionario = new Concesionario("Motor Global S.L.");
        System.out.println("\nConcesionario creado: " + miConcesionario.getNombre());

        /**
         * Modificación del nombre mediante setter
         */
        miConcesionario.setNombre("Grandes Coches de Java");
        System.out.println("Nombre actualizado: " + miConcesionario.getNombre());

        /**
         * Creación de objetos Coche
         */
        Coche c1 = new Coche("Renault", "Clio", 12000.00);
        Coche c2 = new Coche("Seat", "Leon", 17500.00);
        Coche c3 = new Coche("BMW", "X1", 35000.00);
        Coche c4 = new Coche("Audi", "A4", 28000.00);

        /**
         * Agregado de coches al stock
         */
        System.out.println("\n--- AGREGANDO COCHES ---");
        miConcesionario.agregarCoche(c1);
        miConcesionario.agregarCoche(c2);
        miConcesionario.agregarCoche(c3);
        miConcesionario.agregarCoche(c4);

        /**
         * Mostrar inventario inicial
         */
        miConcesionario.mostrarInventario();

        /**
         * Intento de venta de un coche existente
         */
        System.out.println("--- INTENTO DE VENTA (EXISTE) ---");
        double ventaExitosa = miConcesionario.venderCoche("X1");
        if (ventaExitosa > 0.0) {
            System.out.printf("Venta exitosa! Ingreso: %.2f€%n", ventaExitosa);
        }

        /**
         * Intento de venta de un coche inexistente
         */
        System.out.println("\n--- INTENTO DE VENTA (NO EXISTE) ---");
        double ventaFallida = miConcesionario.venderCoche("Focus");
        if (ventaFallida == 0.0) {
            System.out.println("No se generó ingreso por esta venta (coche no encontrado).");
        }

        /**
         * Mostrar inventario final tras la venta
         */
        miConcesionario.mostrarInventario();

        /**
         * Comprobación del número de coches en stock
         */
        System.out.println("--- PRUEBA DE GETTER Y SETTER DE STOCK ---");
        System.out.println("Coches restantes en stock: " + miConcesionario.getCochesEnStock().size());

        /**
         * Vaciado del stock mediante setter
         */
        miConcesionario.setCochesEnStock(new ArrayList<>());
        System.out.println("Stock vaciado.");

        /**
         * Mostrar inventario vacío
         */
        miConcesionario.mostrarInventario();
    }
}
