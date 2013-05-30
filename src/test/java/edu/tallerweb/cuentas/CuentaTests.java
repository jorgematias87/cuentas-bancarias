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
		CuentaCorriente corriente = new CuentaCorriente(200.0);

		ahorro.depositar(7000.0);

		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);
		ahorro.extraer(1000.0);

		corriente.depositar(25.0);
		corriente.depositar(25.0);
		corriente.depositar(25.0);
		corriente.depositar(25.0);

		corriente.extraer(250.0);
		
		Assert.assertEquals(
				 "al extraer $ 250.0 de una cuenta corriente con saldo $ 100.0 y descubiertoInicial $ 200 se obtienen descubiertoTotal$ 42.5 (descubierto utilizado 150 + %5)",
				 42.5, corriente.getDescubierto(), 0.0);
		
		corriente.extraer(40.0);
		
		Assert.assertEquals(
				 "al extraer $ 40.0 de una cuenta corriente con saldo $ 0.0 y descubiertoTotal $ 42.5 se obtienen descubiertoTotal$ 0.5 (descubierto utilizado 40.0 + %5)",
				 0.5, corriente.getDescubierto(), 0.0);
		
		corriente.depositar(20.0);
		
		Assert.assertEquals(
				 "al depositar $ 20.0 de una cuenta corriente con saldo $ 0.0 y descubiertoTotal $ 0.5 se obtienen descubiertoTotal$ 20.5",
				 20.5, corriente.getDescubierto(), 0.0);
		
		corriente.depositar(190.0);
		
		Assert.assertEquals(
				 "al depositar $ 190.0 de una cuenta corriente con saldo $ 0.0 y descubiertoTotal $ 20.5 se obtienen descubiertoTotal $ 200 y Saldo $ 10.5",
				 10.5, corriente.getSaldo(), 0.0);
		
//		Assert.assertEquals(
//				 "al depositar $ 200.0 de una cuenta corriente con saldo $ 0.0 y descubiertoTotal $ 20.5 se obtienen descubiertoTotal $ 200 y Saldo $ 20.5",
//				 20.5, corriente.getSaldo(), 0.0);
		
	}

	/*
	 * @Test(expected=CuentaBancariaException.class) public void
	 * queVerifiqueLaConsignaException() { CuentaSueldo cuenta = new
	 * CuentaSueldo(); cuenta.depositar(3500.0);
	 * 
	 * cuenta.extraer(4000.0); }
	 */

}
