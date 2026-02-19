package model;

/**
 * Clase que representa un coche con información básica
 * como marca, modelo y precio base.
 * Permite calcular el precio final aplicando el IVA.
 * 
 * @author Carlos Michelena Rueda
 * @since 18/02/2026
 * @version 1.0.0
 */
public class Coche {

	/**
	 * Marca del coche
	 */
	private String marca;

	/**
	 * Modelo del coche
	 */
	private String modelo;

	/**
	 * Precio base del coche sin impuestos
	 */
	private double precioBase;

	/**
	 * Constante que representa el IVA aplicado (21%)
	 */
	private static final double IVA = 0.21;

	/**
	 * Constructor por defecto.
	 * Inicializa el coche con valores genéricos.
	 */
	public Coche() {
		this.marca = "Desconocida";
		this.modelo = "Desconocido";
		this.precioBase = 0.0;
	}

	/**
	 * Constructor con todos los atributos.
	 * @param marca Marca del coche
	 * @param modelo Modelo del coche
	 * @param precioBase Precio base sin IVA
	 */
	public Coche(String marca, String modelo, double precioBase) {
		this.marca = marca;
		this.modelo = modelo;
		this.precioBase = precioBase;
	}

	/**
	 * Obtiene la marca del coche.
	 * @return marca del coche
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Obtiene el modelo del coche.
	 * @return modelo del coche
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Obtiene el precio base del coche.
	 * @return precio base sin IVA
	 */
	public double getPrecioBase() {
		return precioBase;
	}

	/**
	 * Establece la marca del coche.
	 * @param marca Nueva marca del coche
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Establece el modelo del coche.
	 * @param modelo Nuevo modelo del coche
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Establece el precio base del coche.
	 * @param precioBase Nuevo precio base sin IVA
	 */
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	/**
	 * Calcula el precio final de venta aplicando el IVA.
	 * @return precio final con IVA incluido
	 */
	public double calcularPrecioVentaFinal() {
		return this.precioBase * (1 + IVA);
	}

	/**
	 * Devuelve una representación en texto del coche.
	 * @return cadena con los datos del coche
	 */
	@Override
	public String toString() {
		return "Coche [Marca=" + marca + ", Modelo=" + modelo + ", Precio Base=" + precioBase + "€]";
	}
}
