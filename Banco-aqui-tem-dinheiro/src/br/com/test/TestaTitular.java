package br.com.test;

import br.com.aquiTemDinheiro.Titular;

public class TestaTitular {
	public static void main(String[] args) {
		
		Titular marcelo = new Titular("Marcelo", "123456789-10", "Programador");
		System.out.println("Nome: " + marcelo.getNome() + ", Profiss�o: " + marcelo.getProfissao() + ", inscrito no CPF: " + marcelo.getCpf());
		
		try {
			Titular jessica = (Titular) new Object();
		} catch (Exception classCasException) {
			System.out.println("Deu a exception (classCasException)");
		}
		
	}
	
}
