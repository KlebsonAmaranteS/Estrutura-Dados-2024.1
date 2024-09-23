package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class ListaEncadeadaOrdenada {
    private NodoOrdenado cabeca;
    private int tamanho;

    public ListaEncadeadaOrdenada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void adicionar(int valor) {
        NodoOrdenado novoNodo = new NodoOrdenado(valor);
        if (cabeca == null || cabeca.valor >= valor) {
            novoNodo.proximo = cabeca;
            cabeca = novoNodo;
        } else {
            NodoOrdenado atual = cabeca;
            while (atual.proximo != null && atual.proximo.valor < valor) {
                atual = atual.proximo;
            }
            novoNodo.proximo = atual.proximo;
            atual.proximo = novoNodo;
        }
        tamanho++;
    }

    public int removerPorIndex(int index) {
        if (index < 0 || index >= tamanho) {
            return 1;
        }
        if (index == 0) {
            cabeca = cabeca.proximo;
        } else {
            NodoOrdenado atual = cabeca;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
        return 0;
    }

    public int remover() {
        if (cabeca == null) {
            return 1;
        }
        cabeca = cabeca.proximo;
        tamanho--;
        return 0;
    }

    public Integer getNodo(int index) {
        if (index < 0 || index >= tamanho) {
            return null;
        }
        NodoOrdenado atual = cabeca;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    public int tamanho() {
        return tamanho;
    }
}
