package com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioHash;

public class TabelaHash {
    private Nodo[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tabela = new Nodo[tamanho];
        this.tamanho = tamanho;
    }

    private int funcaoHash(int matricula) {
        return matricula % tamanho;
    }

    public String pegarValor(int matricula) {
        int posicao = funcaoHash(matricula);
        Nodo atual = tabela[posicao];

        while (atual != null) {
            if (atual.getDados().getMatricula() == matricula) {
                return atual.getDados().getNome();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void inserirValor(Aluno aluno) {
        int posicao = funcaoHash(aluno.getMatricula());
        Nodo novoNo = new Nodo(aluno);
        novoNo.setProximo(tabela[posicao]);
        tabela[posicao] = novoNo;

        System.out.println("Inserido: " + aluno.getNome() + " na posição " + posicao);
    }

    public Aluno removerValor(int matricula) {
        int posicao = funcaoHash(matricula);
        Nodo anterior = null;
        Nodo atual = tabela[posicao];

        while (atual != null) {
            if (atual.getDados().getMatricula() == matricula) {
                if (anterior == null) {
                    tabela[posicao] = atual.getProximo();
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                return atual.getDados();
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return null;
    }
}
