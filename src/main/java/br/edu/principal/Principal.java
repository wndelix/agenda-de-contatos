package br.edu.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		List<String> nomesContatos = new ArrayList<>();
		List<String> numerosContatos = new ArrayList<>();
		List<String> emailsContatos = new ArrayList<>();
		Persistencia.carregarContatos(nomesContatos, numerosContatos, emailsContatos);
		
		Scanner userInput = new Scanner(System.in);
		boolean userContinue = true;
		int opcao;
		
		Utils.mostrarIntro();

		while(userContinue) {
			Utils.mostrarMenu();
			opcao = Utils.selecionarOpcao(userInput);

			switch(opcao) {
				default -> System.out.println("Opção Inválida. Tente Novamente.");
				case 1  -> Agenda.adicionaContato(userInput, nomesContatos, numerosContatos, emailsContatos);
				case 2  -> Agenda.listarContato(nomesContatos, numerosContatos, emailsContatos);
				case 3  -> Agenda.procurarContato(userInput, nomesContatos, numerosContatos, emailsContatos);
				case 4  -> Agenda.alterarContato(userInput, nomesContatos, numerosContatos, emailsContatos);
				case 5  -> Agenda.excluirContato(userInput, nomesContatos, numerosContatos, emailsContatos);
				case 6  -> Utils.sobre();
				case 7  -> {
					Persistencia.salvarContatos(nomesContatos, numerosContatos, emailsContatos);
					System.out.println("Saindo...");
					userContinue = false;
				}
			}
		}
		userInput.close();
	}
}
