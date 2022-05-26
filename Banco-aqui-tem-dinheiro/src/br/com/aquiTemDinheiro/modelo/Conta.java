package br.com.aquiTemDinheiro.modelo;

public class Conta {

	private String cidade;
	private String agencia;
	private String numeroDaConta;
	private Titular titular;
	
	
	// GETTERS & SETTERS
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	
	@Override
	public String toString() {
		return "Numero da Conta: " + this.numeroDaConta + ", Agência: " + this.agencia + ", Cidade: " + this.cidade;
	}

}
