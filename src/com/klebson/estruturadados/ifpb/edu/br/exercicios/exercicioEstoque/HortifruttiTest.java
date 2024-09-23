package com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioEstoque;

import com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioEstoque.ListaDuplaEncadeadaProduto;

import java.util.Scanner;

public class HortifruttiTest {
    public static void main(String[] args) {
        ListaDuplaEncadeadaProduto estoque = new ListaDuplaEncadeadaProduto();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Retirar produto");
            System.out.println("4 - Checar existência de produto");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // consumir a nova linha
                    estoque.adicionarProduto(nome, quantidade);
                    break;
                case 2:
                    estoque.listarProdutos();
                    break;
                case 3:
                    System.out.print("Nome do produto: ");
                    nome = scanner.nextLine();
                    System.out.print("Quantidade a retirar: ");
                    quantidade = scanner.nextInt();
                    scanner.nextLine(); // consumir a nova linha
                    estoque.retirarProduto(nome, quantidade);
                    break;
                case 4:
                    System.out.print("Nome do produto: ");
                    nome = scanner.nextLine();
                    estoque.checarProduto(nome);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}

