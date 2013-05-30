package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la quinta extracción de
 * dinero se cobre un costo adicional por extracción de $ 6
 */
public class CajaAhorros extends AbstractCuenta {

	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */

	private int cont = 0;
	private int extraccion = 5;
	private Double costoAdicional = 6.0;

	/**
	 * Se cobran $6 adicionales por cada extracción luego de la quinta.
	 * @param monto a extraer
	 */
	@Override
	public void extraer(final Double monto) {

		cont++;

		if (cont > extraccion) {
			super.extraer(monto);
			super.extraer(costoAdicional);
		}

		else {
			super.extraer(monto);
		}

	}

}
