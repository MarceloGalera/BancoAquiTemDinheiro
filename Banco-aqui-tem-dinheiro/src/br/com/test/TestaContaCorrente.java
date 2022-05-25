package br.com.test;

import java.util.ArrayList;
import java.util.List;

import br.com.aquiTemDinheiro.ContaCorrente;
import br.com.aquiTemDinheiro.ContaPoupanca;
import br.com.aquiTemDinheiro.Titular;

public class TestaContaCorrente {

	public static void main(String[] args) {

		System.out.println("Parte 1");
		ContaCorrente ccJessica = new ContaCorrente();
		ContaCorrente ccMarcelo = new ContaCorrente();
		ccMarcelo.setCidade("Rio Preto");
		ccMarcelo.setAgencia("159");
		ccMarcelo.setNumeroDaConta("123");
		ccMarcelo.depositar(500);
		ccMarcelo.sacar(-100);
		ccMarcelo.sacar(100);
		System.out.println(ccMarcelo.getSaldo());
		
		System.out.println("\nParte 2");
		Titular marcelo = new Titular("Marcelo", "132456789-0", "Programador");
		ccMarcelo.setTitular(marcelo);           // aqui estou atribuindo o Titular marcelo para a ContaCorrente ccMarcelo
		System.out.println(ccMarcelo.getTitular().getNome());       // entro em Titular e peço o nome daquele titular
		
		System.out.println("\nParte 3");
		System.out.println("A agência do " + ccMarcelo.getTitular().getNome() + " é a " + ccMarcelo.getAgencia() + " e sua Conta Corrente é a " + ccMarcelo.getNumeroDaConta());
		
		System.out.println("\nParte 4");
		ccMarcelo.transferir(200, ccJessica);
		System.out.println("Saldo Jessica: R$"+ ccJessica.getSaldo());
		
		System.out.println("\nParte 5");
		ccMarcelo.depositar(0.0);
		ccMarcelo.depositar(-100.0);
		System.out.println(ccMarcelo.getSaldo());
		
		System.out.println("\nParte 6");
		List<ContaCorrente> contasCorrentes = new ArrayList<ContaCorrente>();
		contasCorrentes.add(ccMarcelo);
		System.out.println(contasCorrentes.isEmpty());
		contasCorrentes.add(ccJessica);
		System.out.println(contasCorrentes.size());
		System.out.println("Saldo da CC do " + contasCorrentes.get(0).getTitular().getNome() + ": R$" + contasCorrentes.get(0).getSaldo());
		contasCorrentes.get(0).depositar(100);
		System.out.println("Saldo da CC do " + contasCorrentes.get(0).getTitular().getNome() + " após a transferência: R$" + contasCorrentes.get(0).getSaldo());
		
		System.out.println("\nParte 7");
		ContaPoupanca cpMarcelo = new ContaPoupanca();
		cpMarcelo.setTitular(marcelo);
		cpMarcelo.setAgencia("159");
		cpMarcelo.setNumeroDaConta("123-X");
		ccMarcelo.investir(100, cpMarcelo);
		System.out.println("Saldo da CC: R$" + ccMarcelo.getSaldo() + ". Saldo da Poupança: R$" + cpMarcelo.getSaldo());
		cpMarcelo.resgatar(-101);
		cpMarcelo.resgatar(0);
		cpMarcelo.resgatar(50);
		System.out.println("Saldo da CP: R$" + cpMarcelo.getSaldo());
		
		System.out.println("\nParte 8");
		cpMarcelo.rendimento(20);               // inserir o número de meses para calcular o rendimento
		System.out.println("O saldo da CP após o rendimento da aplicação é de R$" + cpMarcelo.getSaldo());
	}

}
