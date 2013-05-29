package edu.tallerweb.cuentas;

public class CuentaSueldo extends AbstractCuenta {

	public void depositar(final Double monto) {

		if (monto > 0) {
			this.saldo += monto;
		}

		else {
			throw new RuntimeException("ingrese un monto valido");
		}

	}

	public void extraer(final Double monto) {

		if (this.saldo >= monto) {
			this.saldo -= monto;
		}

		else {
			throw new RuntimeException(
					"El monto a extraer es mayor al saldo disponible");
		}
	}

}
