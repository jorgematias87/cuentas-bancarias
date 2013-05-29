package edu.tallerweb.cuentas;

/**
 * La m�s compleja de las cuentas, �sta permite establecer una cantidad de
 * dinero a girar en descubierto. Es por ello que cada vez que se desee extraer
 * dinero, no s�lo se considera el que se posee, sino el l�mite adicional que el
 * banco estar� brindando.
 * 
 * Por supuesto esto no es gratis, ya que el banco nos cobrar� un 5% como
 * comisi�n sobre todo el monto en descubierto consumido en la operaci�n.
 * 
 * Por ejemplo, si tuvi�ramos $ 100 en la cuenta, y quisi�ramos retirar $ 200
 * (con un descubierto de $ 150), podremos hacerlo. Pasaremos a deberle al banco
 * $ 105 en total: los $ 100 que nos cubri�, m�s el 5% adicional sobre el
 * descubierto otorgado.
 */
public class CuentaCorriente extends CuentaSueldo {

	private Double descubiertoTotal = 0.0;
	private Double aux = 0.0;
	private Double comision = 0.0;

	/**
	 * Toda cuenta corriente se inicia con un l�mite total para el descubierto.
	 * 
	 * @param descubiertoTotal
	 */
	public CuentaCorriente(final Double descubiertoTotal) {

		if ( descubiertoTotal >= 0) {
			this.descubiertoTotal = descubiertoTotal;
			this.aux = descubiertoTotal;
		}

		else {
			throw new CuentaBancariaException("ingrese un monto valido");
		}

	}

	/**
	 * Todo dep�sito deber� cubrir primero el descubierto, si lo hubiera, y
	 * luego contar para el saldo de la cuenta.
	 * 
	 * @param monto
	 *            a depositar
	 */
	@Override
	public void depositar(final Double monto) {
		
		super.depositar(monto);
		
		
		
		try {
			if (monto > this.comision) {
				super.extraer(this.comision);
				this.descubiertoTotal = this.aux;
				this.comision = 0.0;
			}

			else {
				throw new CuentaBancariaException("");
			}
		} catch (CuentaBancariaException ex) {
			super.extraer(monto);
			
		}

	}

	/**
	 * Se cobrar� el 5% de comisi�n sobre el monto girado en descubierto. Por
	 * supuesto, no puede extraerse m�s que el total de la cuenta, m�s el
	 * descubierto (comisi�n inclu�da)
	 * 
	 * @param monto
	 *            a extraer
	 */
	@Override
	public void extraer(final Double monto) {

		if (monto <= (this.getSaldo() + this.descubiertoTotal)) {

			try {
				super.extraer(monto);
			} catch (RuntimeException ex) {
				this.comisionDescubierto(monto);
				this.descubiertoTotal = this.descubiertoTotal - this.comision;
				super.extraer(this.getSaldo());
			}
		}

		else {
			throw new CuentaBancariaException("El monto a extraer es mayor al (saldo + descubierto) disponible");
		}

	}

	/**
	 * Permite saber el saldo en descubierto
	 * 
	 * @return el descubierto de la cuenta
	 */
	public Double getDescubierto() {
		return this.descubiertoTotal;
	}

	public void comisionDescubierto(final Double monto) {
		Double porcentaje = 0.05;
		Double comision = monto - this.getSaldo();

		this.comision = (comision * porcentaje) + comision;
	}

	public Double getComision() {
		return comision;
	}

}
