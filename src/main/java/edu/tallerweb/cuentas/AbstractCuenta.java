package edu.tallerweb.cuentas;

public abstract class AbstractCuenta {

	protected Double saldo = 0.0;

	public abstract void depositar(final Double monto);

	public abstract void extraer(final Double monto);

	public Double getSaldo() {
		return saldo;
	}

}
