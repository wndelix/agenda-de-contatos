package br.edu.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();
        Persistencia.carregarContatos(contatos);

        Scanner sc = new Scanner(System.in);
        boolean userContinue = true;
        int opcao;

        Utils.mostrarIntro();

        while (userContinue) {
            Utils.mostrarMenu();
            opcao = Utils.selecionarOpcao(sc);

            switch (opcao) {
                default -> System.out.println("Opção Inválida. Tente Novamente.");
                case 1  -> Agenda.adicionaContato(sc, contatos);
                case 2  -> Agenda.listarContato(contatos);
                case 3  -> Agenda.procurarContato(sc, contatos);
                case 4  -> Agenda.alterarContato(sc, contatos);
                case 5  -> Agenda.excluirContato(sc, contatos);
                case 6  -> Utils.sobre();
                case 7  -> {
                    Persistencia.salvarContatos(contatos);
                    System.out.println("Saindo...");
                    userContinue = false;
                }
            }
        }
        sc.close();
    }
}
