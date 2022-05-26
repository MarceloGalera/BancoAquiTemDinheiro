package br.com.aquiTemDinheiro.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.aquiTemDinheiro.modelo.ContaCorrente;
import br.com.aquiTemDinheiro.modelo.ContaPoupanca;
import br.com.aquiTemDinheiro.modelo.Titular;

public class TestaConta {

	public static void main(String[] args) throws IOException {

		// TESTANDO CONTA CORRENTE
		System.out.println("Parte 1");
		ContaCorrente ccMarcelo = new ContaCorrente();
		ccMarcelo.setCidade("Rio Preto");
		ccMarcelo.setAgencia("159");
		ccMarcelo.setNumeroDaConta("123");
		ContaCorrente ccJessica = new ContaCorrente();
		ccJessica.setAgencia("159");
		ccJessica.setNumeroDaConta("456-5");
		ccJessica.setCidade("Rio Preto");
		ccMarcelo.depositar(500);
		ccMarcelo.sacar(-100);
		ccMarcelo.sacar(100);
		System.out.println(ccMarcelo.getSaldo());
		
		System.out.println("\nParte 2");
		Titular marcelo = new Titular("Marcelo", "132456789-0", "Programador");
		ccMarcelo.setTitular(marcelo);           // aqui estou atribuindo o Titular marcelo para a ContaCorrente ccMarcelo
		System.out.println("O nome do titular da CC situada em " + ccMarcelo.getCidade() + ", número da conta " + ccMarcelo.getNumeroDaConta() + ", agência " + ccMarcelo.getAgencia() + 
				", é o(a) cliente " + ccMarcelo.getTitular().getNome());       // entro em Titular e peço o nome daquele titular
		
		System.out.println("\nParte 3");
		System.out.println("A agência do " + ccMarcelo.getTitular().getNome() + " é a " + ccMarcelo.getAgencia() + " e sua Conta Corrente é a " + ccMarcelo.getNumeroDaConta());
		
		System.out.println("\nParte 4");
		ccMarcelo.transferir(200, ccJessica);
		System.out.println("Saldo Jessica: R$"+ ccJessica.getSaldo());
		
		System.out.println("\nParte 5");
		ccMarcelo.depositar(0.0);
		ccMarcelo.depositar(-100.0);
		System.out.println(ccMarcelo.getSaldo());
		
		// ARRAYS
		System.out.println("\nParte 6");
		List<ContaCorrente> contasCorrentes = new ArrayList<ContaCorrente>();
		contasCorrentes.add(ccMarcelo);
		System.out.println(contasCorrentes.isEmpty());
		contasCorrentes.add(ccJessica);
		System.out.println(contasCorrentes.size());
		System.out.println("Saldo da CC do " + contasCorrentes.get(0).getTitular().getNome() + ": R$" + contasCorrentes.get(0).getSaldo());
		contasCorrentes.get(0).depositar(100);
		System.out.println("Saldo da CC do " + contasCorrentes.get(0).getTitular().getNome() + " após a transferência: R$" + contasCorrentes.get(0).getSaldo());
		
		// TESTANDO CONTA POUPANÇA
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
		System.out.println("O saldo da CP antes da aplicação é de R$" + cpMarcelo.getSaldo());
		cpMarcelo.resgatar(60);
		cpMarcelo.rendimento(20);               // inserir o número de meses para calcular o rendimento
		System.out.println("O saldo da CP após o rendimento da aplicação é de R$" + cpMarcelo.getSaldo());
		cpMarcelo.resgatar(60);
		System.out.println(cpMarcelo.getTitular().getNome());
		
		// FOR / FOREACH
		System.out.println("\nParte 9");
		ContaCorrente ccDouglas = new ContaCorrente();
		ccDouglas.setAgencia("987");
		ccDouglas.setNumeroDaConta("367-0");
		ccDouglas.setCidade("São Paulo");
		Titular douglas = new Titular("Douglas", "132456789-0", "Engenheiro");
		ccDouglas.setTitular(douglas);           // aqui estou atribuindo o Titular douglas para a ContaCorrente ccDouglas
		ContaCorrente ccAline = new ContaCorrente();
		ccAline.setAgencia("654");
		ccAline.setNumeroDaConta("329-1");
		ccAline.setCidade("Araraquara");
		Titular aline = new Titular("Aline", "369258147-0", "Médica");
		ccAline.setTitular(aline);           // aqui estou atribuindo o Titular douglas para a ContaCorrente ccDouglas
		contasCorrentes.add(ccAline);
		contasCorrentes.add(ccDouglas);
		for (ContaCorrente forNasContas : contasCorrentes) {
			System.out.println(forNasContas);
		}
		
		// WRAPPER
		System.out.println("\nParte 10");
		double transformandoStringEmDouble = Double.parseDouble(ccMarcelo.getNumeroDaConta());
		System.out.println(transformandoStringEmDouble);
		
		// WRITER
		System.out.println("\nParte 11");
		FileWriter fw = new FileWriter("C:\\Users\\Marcelo\\Desktop/Contas.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("O array contém " + contasCorrentes.size() + " contas Corrente");
		bw.close();
		

		// FLUXO DE ENTRADA DE DADOS
		System.out.println("\nParte 12");
		//InputStream fis = new FileInputStream("Teste.txt");
		//Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Teste.txt")));
		System.out.println(br.readLine());
		br.close();
		
		
		// FLUXO DE SAÍDA DE DADOS
		System.out.println("\nParte 13");
		//OutputStream fos = new FileOutputStream("Teste.txt");
		//Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Teste.txt")));
		bw2.write("O saldo da CC do " + ccDouglas.getTitular().getNome() + " é de R$" + ccDouglas.getSaldo());
		bw2.newLine();
		bw2.newLine();
		bw2.write("Teste escrita");
		bw2.newLine();
		bw2.close();

	}

}
