package edu.tallerweb.cuentas;

/**
 * La más compleja de las cuentas, ésta permite establecer una cantidad de
 * dinero a girar en descubierto. Es por ello que cada vez que se desee extraer
 * dinero, no sólo se considera el que se posee, sino el límite adicional que el
 * banco estará brindando.
 * Por supuesto esto no es gratis, ya que el banco nos cobrará un 5% como
 * comisión sobre todo el monto en descubierto consumido en la operación.
 * Por ejemplo, si tuviéramos $ 100 en la cuenta, y quisiéramos retirar $ 200
 * (con un descubierto de $ 150), podremos hacerlo. Pasaremos a deberle al banco
 * $ 105 en total: los $ 100 que nos cubrió, más el 5% adicional sobre el
 * descubierto otorgado.
 */
public class CuentaCorriente extends AbstractCuenta {

	private Double descubiertoTotal = 0.0;
	private Double descubiertoInicial = 0.0;
	private Double comision = 0.0;

	/**
	 * Toda cuenta corriente se inicia con un límite total para el descubierto.
	 * @param descubiertoTotal
	 */
	public CuentaCorriente(final Double descubiertoTotal) {

		if (descubiertoTotal >= 0) {
			this.descubiertoTotal = descubiertoTotal;
			this.descubiertoInicial = descubiertoTotal; 
		} else {
			throw new CuentaBancariaException("Monto Invalido");
		}

	}

	/**
	 * Todo depósito deberá cubrir primero el descubierto, si lo hubiera, y
	 * luego contar para el saldo de la cuenta.
	 * @param monto a depositar
	 */
	@Override
	public void depositar(final Double monto) {

		super.montoNegativo(monto);

		if (this.comision == 0) {

			super.depositar(monto);
		} else {
			this.restaurarDescubierto(monto);
		}

	}

	/**
	 * Se cobrará el 5% de comisión sobre el monto girado en descubierto. Por
	 * supuesto, no puede extraerse más que el total de la cuenta, más el
	 * descubierto (comisión incluída)
	 * @param monto a extraer
	 */
	@Override
	public void extraer(final Double monto) {

		super.montoNegativo(monto);

		if (monto <= (super.getSaldo() + this.descubiertoTotal)) {

			try {
				super.extraer(monto);
			} catch (CuentaBancariaException ex) {
				this.extraerEnDescubierto(monto);
			}
		} else {
			throw new CuentaBancariaException(
					"El monto a extraer es mayor al (saldo + descubierto) disponible");
		}

	}

	public void restaurarDescubierto(final Double monto) {

		if ((monto + this.descubiertoTotal) < this.descubiertoInicial) {
			this.descubiertoTotal += monto;
		} else {
			if (monto == this.descubiertoInicial) {
				super.depositar(this.descubiertoTotal);
				this.descubiertoTotal = this.descubiertoInicial;
			} else {
				super.depositar((monto + this.descubiertoTotal)
						- this.descubiertoInicial);
				this.descubiertoTotal = this.descubiertoInicial;
			}
		}
	}

	public void extraerEnDescubierto(final Double monto) {

		this.comisionDescubierto(monto);

		if ((this.descubiertoTotal - this.comision) < 0) {
			throw new CuentaBancariaException(
					"El monto a extraer es mayor al descubierto con impuesto disponible");
		} else {
			this.descubiertoTotal -= this.comision;
			super.saldo = 0.0;
		}

	}

	/**
	 * Permite saber el saldo en descubierto
	 * @return el descubierto de la cuenta
	 */
	public Double getDescubierto() {
		return this.descubiertoTotal;
	}

	public void comisionDescubierto(final Double monto) {
		final Double porcentaje = 0.05;
		Double comision = monto - this.getSaldo();

		this.comision = comision * porcentaje + comision;

	}

	public Double getComision() {
		return this.comision;
	}

}
