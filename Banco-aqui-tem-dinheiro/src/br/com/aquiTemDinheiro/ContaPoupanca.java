package br.com.aquiTemDinheiro;

public class ContaPoupanca extends Conta {

	private double saldo;
	//double i;                // quantidade de meses
	
	// GETTERS & SETTERS
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	// MÉTODOS
	public boolean depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		} else if (valor == 0) {
			System.out.println("Insira algum valor para depósito.\nSaldo atual: R$" + saldo
					+ ". Tentativa de depósito: R$" + valor + ".");
		} else if(valor < 0) {
			System.out.println("Não pode depositar valor negativo.\nSaldo atual: R$" + saldo
					+ ". Tentativa de depósito: R$" + valor + ".");
		}
		return false;
	}
	
	public boolean resgatar(double valor) {
		if (this.saldo >= valor && valor > 0) {
			this.saldo -= valor;
			System.out.println("Resgate efetuado com sucesso no valor de R$" + valor);
		} else if(this.saldo >= valor && valor < 0) {
			System.out.println("Não pode Resgatar valor negativo.\nSaldo atual: R$" + saldo
					+ ". Tentativa de resgate: R$" + valor + ".");
		} else if (this.saldo < valor) {
			System.out.println("Desculpe, saldo insuficiente.\nSaldo atual: R$" + saldo
					+ ". Tentativa de resgate: R$" + valor + ".");
		} else {
			System.out.println("Insira algum valor para resgatar.\nSaldo atual: R$" + saldo + ". Tentativa de resgate: R$"
					+ valor + ".");
		}
		return false;
	}
	
	public void rendimento(double i) {
		this.saldo += (this.saldo * (i/100));
	}

}
