package br.edu.principal;

import java.util.List;
import java.util.Scanner;

public class Agenda {

    public static void adicionaContato(Scanner sc, List<Contato> contatos) {
        System.out.println("═════════════ Adicionar Contato ═════════════");

        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o celular: ");
        String celular = sc.nextLine();

        System.out.print("Digite o e-mail: ");
        String email = sc.nextLine();

        Contato contato = new Contato();
        contato.nome = nome;
        contato.celular = celular;
        contato.email = email;

        contatos.add(contato);

        System.out.println("Contato " + nome + " foi adicionado com sucesso.");
    }

    public static void listarContato(List<Contato> contatos) {
        System.out.println("══════════════ Listar Contatos ══════════════");

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            for (Contato contato : contatos) {
                System.out.println("-".repeat(45));
                System.out.println("   Nome: " + contato.nome);
                System.out.println("Celular: " + contato.celular);
                System.out.println(" E-mail: " + contato.email);
            }
            System.out.println("-".repeat(45));
        }
    }

    public static void procurarContato(Scanner sc, List<Contato> contatos) {
        System.out.println("══════════════ Procurar Contato ═════════════");

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            System.out.print("Digite o nome que deseja procurar: ");
            String contatoNomeBusca = sc.nextLine();
            boolean contatoEncontrado = false;

            for (Contato contato : contatos) {
                if (contato.nome.equalsIgnoreCase(contatoNomeBusca)) {
                    System.out.println("-".repeat(45));
                    System.out.println("   Nome: " + contato.nome);
                    System.out.println("Celular: " + contato.celular);
                    System.out.println(" E-mail: " + contato.email);
                    System.out.println("-".repeat(45));

                    contatoEncontrado = true;
                }
            }

            if (!contatoEncontrado) {
                System.out.println("Contato não encontrado.");
            }
        }
    }

    public static void alterarContato(Scanner sc, List<Contato> contatos) {
        System.out.println("══════════════ Alterar Contato ══════════════");

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        System.out.print("Digite o nome que deseja procurar: ");
        String contatoNomeBusca = sc.nextLine();
        Contato contatoEncontrado = null;

        for (Contato contato : contatos) {
            if (contato.nome.equalsIgnoreCase(contatoNomeBusca)) {
                contatoEncontrado = contato;
                break;
            }
        }

        if (contatoEncontrado != null) {
            System.out.print("Digite o novo nome: ");
            contatoEncontrado.nome = sc.nextLine();

            System.out.print("Digite o novo celular: ");
            contatoEncontrado.celular = sc.nextLine();

            System.out.print("Digite o novo e-mail: ");
            contatoEncontrado.email = sc.nextLine();

            System.out.println("Contato alterado com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public static void excluirContato(Scanner sc, List<Contato> contatos) {
        System.out.println("══════════════ Excluir Contato ══════════════");

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            System.out.print("Digite o nome do contato que deseja excluir: ");
            String contatoNomeBusca = sc.nextLine();
            Contato contatoExcluir = null;

            for (Contato contato : contatos) {
                if (contato.nome.equalsIgnoreCase(contatoNomeBusca)) {
                    contatoExcluir = contato;
                    break;
                }
            }

            if (contatoExcluir == null) {
                System.out.println("Nenhum contato encontrado.");
            } else {
                contatos.remove(contatoExcluir);
                System.out.println("Contato excluído com sucesso.");
            }
        }
    }
}
