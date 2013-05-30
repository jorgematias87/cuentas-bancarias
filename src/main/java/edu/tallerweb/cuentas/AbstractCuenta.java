package edu.tallerweb.cuentas;

/**
 * Modela el concepto de Cuenta. Esta clase abstracta sirve como base para una
 * posible jerarqu�a (si fuese necesaria)
 * 
 * Es probable que la tarea se facilite otorgando una imple- mentaci�n a los
 * m�todos proporcionados.
 */
public abstract class AbstractCuenta {

	protected Double saldo = 0.0;

	/**
	 * Agrega a la cuenta el monto determinado
	 * 
	 * @param monto
	 *            a depositar
	 */

	public abstract void depositar(final Double monto);

	/**
	 * Retira de la cuenta el monto determinado
	 * 
	 * @param monto
	 *            a extraer
	 */
	public abstract void extraer(final Double monto);

	public void montoNegativo(final Double monto) {

		if (monto > 0) {
		}

		else {
			throw new CuentaBancariaException("Monto Invalido");
		}
	}

	/**
	 * Permite saber el saldo de la cuenta
	 * 
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		return saldo;
	}

}
