package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta m�s simple, ya que se rige por la premisa de que en
 * tanto y en cuanto se tenga tanto o m�s dinero en cuenta del que se quiere
 * extraer, la operaci�n se debe efectuar correctamente.
 */
public class CuentaSueldo extends AbstractCuenta {

	/**
	 * No hay reglas adicionales para el dep�sito
	 * 
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {

		if (monto > 0) {
			this.saldo += monto;
		}

		else {
			throw new CuentaBancariaException("ingrese un monto valido");
		}

	}

	/**
	 * No hay reglas adicionales para la extracci�n
	 * 
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {

		if(monto > 0){
			if (this.saldo >= monto) {
				this.saldo -= monto;
			}

			else {
				throw new CuentaBancariaException("El monto a extraer es mayor al saldo disponible");
			}
		}
		
		else {
			throw new CuentaBancariaException("No se puede extrae un monto negativo");
		}
		
	}

}
