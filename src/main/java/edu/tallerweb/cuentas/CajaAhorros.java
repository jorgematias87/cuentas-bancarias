package edu.tallerweb.cuentas;

public class CajaAhorros extends CuentaSueldo {

	private int cont = 0;

	@Override
	public void extraer(final Double monto) {

		cont++;

		if (cont > 5) {

			super.extraer(monto);
			super.extraer(6.0);
		}

		else {
			super.extraer(monto);
		}

	}

}
