package br.com.fiap.missaobanco;

public class Conta {

	private double saldo;

	public Conta(double saldoInicial) {
		this.saldo = saldoInicial;
	}

	public void depositar(double valor) throws ValorNegativoException {
		if (valor < 0) {
			throw new ValorNegativoException("Não é permitido realizar depósitos com valores negativos.");
		}
		saldo += valor;
	}

	public void sacar(double valor) throws SaldoInsuficienteException, ValorNegativoException {
		if (valor < 0) {
			throw new ValorNegativoException("Não é permitido realizar saques com valores negativos.");
		}
		if (valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
		}
		saldo -= valor;
	}

	public void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorNegativoException {
		if (valor < 0) {
			throw new ValorNegativoException("Não é permitido realizar transferências com valores negativos.");
		}
		if (valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transferência.");
		}
		saldo -= valor;
		destino.depositar(valor);
	}

}
