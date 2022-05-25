package br.com.aquiTemDinheiro;

public class ContaCorrente extends Conta {

	private double saldo;

	// GETTERS & SETTERS
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	// M�TODOS
	public boolean depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		} else if (valor == 0) {
			System.out.println("Insira algum valor para dep�sito.\nSaldo atual: R$" + saldo
					+ ". Tentativa de dep�sito: R$" + valor + ".");
		} else if(valor < 0) {
			System.out.println("N�o pode depositar valor negativo.\nSaldo atual: R$" + saldo
					+ ". Tentativa de dep�sito: R$" + valor + ".");
		}
		return false;
	}

	public void saldoInsuciente() {
		System.out.println("Saldo Insuficiente, tente novamente");
	}

	public boolean sacar(double valor) {
		if (this.saldo >= valor && valor > 0) {
			this.saldo -= valor;
			System.out.println("Saque efetuado com sucesso no valor de R$" + valor);
		} else if(this.saldo >= valor && valor < 0) {
			System.out.println("N�o pode sacar valor negativo.\nSaldo atual: R$" + saldo
					+ ". Tentativa de saque: R$" + valor + ".");
		} else if (this.saldo < valor) {
			System.out.println("Desculpe, saldo insuficiente.\nSaldo atual: R$" + saldo
					+ ". Tentativa de saque: R$" + valor + ".");
		} else {
			System.out.println("Insira algum valor para sacar.\nSaldo atual: R$" + saldo + ". Tentativa de saque: R$"
					+ valor + ".");
		}
		return false;
	}

	public boolean transferir(double valor, ContaCorrente destino) {
		if(valor > 0 && valor <= this.saldo) {
			this.sacar(valor);
			destino.depositar(valor);
			System.out.println("Transfer�ncia efetuada com sucesso. Saldo atual da conta: R$" + this.saldo);
		} else if(valor > this.saldo) {
			System.out.println("Saldo insuficiente.");
		} else if(valor < 0) {
			System.out.println("Valor para transfer�ncia n�o pode ser negativo.");
		} else if(valor == 0) {
			System.out.println("Insira algum valor para transfer�ncia.");
		}
		return false;
	}
	
	public boolean investir(double valor, ContaPoupanca destino) {
		if(valor > 0 && valor <= this.saldo) {
			this.sacar(valor);
			destino.depositar(valor);
			System.out.println("Transfer�ncia efetuada com sucesso. Saldo atual da conta: R$" + this.saldo);
		} else if(valor > this.saldo) {
			System.out.println("Saldo insuficiente.");
		} else if(valor < 0) {
			System.out.println("Valor para transfer�ncia n�o pode ser negativo.");
		} else if(valor == 0) {
			System.out.println("Insira algum valor para transfer�ncia.");
		}
		return false;
	}

}
