package edu.tallerweb.cuentas;

/**
 * Modela el concepto de Cuenta. Esta clase abstracta sirve como base para una
 * posible jerarquía (si fuese necesaria)
 * Es probable que la tarea se facilite otorgando una imple- mentación a los
 * métodos proporcionados.
 */
public abstract class AbstractCuenta {

	protected Double saldo = 0.0;

	/**
	 * Agrega a la cuenta el monto determinado
	 * @param monto a depositar
	 */

	public void depositar(final Double monto) {
		this.montoNegativo(monto);
		this.saldo += monto;
	}

	/**
	 * Retira de la cuenta el monto determinado
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {

		this.montoNegativo(monto);

		if (this.saldo >= monto) {
			this.saldo -= monto;
		} else {
			throw new CuentaBancariaException("El monto a extraer es mayor al saldo disponible");
		}

	}

	public void montoNegativo(final Double monto) {

		if (monto > 0) {
			;
		} else {
			throw new CuentaBancariaException("Monto Invalido");
		}
	}

	/**
	 * Permite saber el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		return saldo;
	}

}
