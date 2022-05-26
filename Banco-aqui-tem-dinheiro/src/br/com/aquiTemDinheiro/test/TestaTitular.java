package br.com.aquiTemDinheiro.test;

import br.com.aquiTemDinheiro.modelo.Titular;

public class TestaTitular {
	public static void main(String[] args) {
		
		Titular marcelo = new Titular("Marcelo", "123456789-10", "Programador");
		System.out.println("Nome: " + marcelo.getNome() + ", Profissão: " + marcelo.getProfissao() + ", inscrito no CPF: " + marcelo.getCpf());
		
		// Exception
		try {
			Titular jessica = (Titular) new Object();
		} catch (Exception ex) {
			System.out.println("Deu a exception classCastException: " + ex.getMessage());
		}
		
	}
	
}
