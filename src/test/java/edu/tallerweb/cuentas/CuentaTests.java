package edu.tallerweb.cuentas;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTests {

	@Test
	public void queVerifiqueLaConsigna() {
		/*
		 * CuentaSueldo cuenta = new CuentaSueldo(); cuenta.depositar(4000.0);
		 * 
		 * Assert.assertEquals(
		 * "al depositar $ 4000.0 en una cuenta vacía, tiene $ 4000.0", 4000.0,
		 * cuenta.getSaldo(), 0.0);
		 * 
		 * cuenta.extraer(2000.0);
		 * 
		 * Assert.assertEquals(
		 * "al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
		 * 2000.0, cuenta.getSaldo(), 0.0);
		 */

		CajaAhorros ahorro = new CajaAhorros();
		CuentaCorriente corriente = new CuentaCorriente(200.0);

		ahorro.depositar(7000.0);

		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);

		corriente.depositar(100.0);

		corriente.extraer(250.0);
		corriente.extraer(49.0);

		System.out.println("Saldo Caja de Ahorro: $" + ahorro.getSaldo());

		System.out.printf("Saldo cuenta corriente: $%.2f\n",
				corriente.getSaldo());
		System.out.printf("Saldo Descubierto: $%.2f\n",
				corriente.getDescubierto());
		System.out
				.printf("Descubierto consumido: $%.2f\n", corriente.getDebe());
	}

	/*
	 * @Test(expected=CuentaBancariaException.class) public void
	 * queVerifiqueLaConsignaException() { CuentaSueldo cuenta = new
	 * CuentaSueldo(); cuenta.depositar(3500.0);
	 * 
	 * cuenta.extraer(4000.0); }
	 */

}
