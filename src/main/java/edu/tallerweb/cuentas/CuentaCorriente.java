package edu.tallerweb.cuentas;

public class CuentaCorriente extends CuentaSueldo {

	private Double descubiertoTotal = 0.0;
	private Double aux = 0.0;
	private Double debe = 0.0;

	public CuentaCorriente(final Double descubiertoTotal) {

		if (descubiertoTotal >= 0) {
			this.descubiertoTotal = descubiertoTotal;
			this.aux = descubiertoTotal;
		}

		else {
			throw new RuntimeException("ingrese un monto valido");
		}

	}

	@Override
	public void depositar(final Double monto) {

		super.depositar(monto);

		try {
			if (monto > this.debe) {
				super.extraer(this.debe);
				this.descubiertoTotal = this.aux;
				this.debe = 0.0;
			}

			else {
				throw new RuntimeException();
			}
		} catch (RuntimeException ex) {
			super.extraer(monto);
			throw new RuntimeException(
					"Monto menor al monto descubierto consumido");
		}

	}

	@Override
	public void extraer(final Double monto) {

		if (monto <= (this.getSaldo() + this.descubiertoTotal)) {

			try {
				super.extraer(monto);
			} catch (RuntimeException ex) {
				this.comisionDebe(monto);
				this.descubiertoTotal = this.descubiertoTotal
						- (monto - this.getSaldo());
				super.extraer(this.getSaldo());
			}
		}

		else {
			throw new RuntimeException(
					"El monto a extraer es mayor al (saldo + descubierto) disponible");
		}

	}

	public Double getDescubierto() {
		return this.descubiertoTotal;
	}

	public void comisionDebe(final Double monto) {
		Double porcentaje = 0.05;
		Double debe = monto - this.getSaldo();

		this.debe += (debe * porcentaje) + debe;
	}

	public Double getDebe() {
		return debe;
	}

}
