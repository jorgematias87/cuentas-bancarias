package edu.tallerweb.cuentas;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTests {

	@Test
	public void queVerifiqueLaConsigna() {
		
		 CuentaSueldo cuenta = new CuentaSueldo(); cuenta.depositar(4000.0);
		  
		 Assert.assertEquals(
		 "al depositar $ 4000.0 en una cuenta vacía, tiene $ 4000.0", 4000.0,
		 cuenta.getSaldo(), 0.0);
		  
		 cuenta.extraer(500.0);
		  
		 Assert.assertEquals(
		 "al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
		 3500.0, cuenta.getSaldo(), 0.0);
		 

		CajaAhorros ahorro = new CajaAhorros();
		CuentaCorriente corriente = new CuentaCorriente(500.0);

		ahorro.depositar(7000.0);

		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);
		
		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);

		corriente.depositar(1000.0);
		
		corriente.extraer(1476.0);
		
		Assert.assertEquals(
				 "al extraer $ 1476.0 de una cuenta con $ 1000.0 de saldo y descubierto 500 se obtienen $ 0.2 de descubierto",
				 0.2, corriente.getDescubierto(), 0.0);

	}

	/*
	 * @Test(expected=CuentaBancariaException.class) public void
	 * queVerifiqueLaConsignaException() { CuentaSueldo cuenta = new
	 * CuentaSueldo(); cuenta.depositar(3500.0);
	 * 
	 * cuenta.extraer(4000.0); }
	 */

}
