package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvore;

public class No {
    private int item;
    private No direita;
    private No esquerda;

    public long getItem() {
        return item;
    }
    public void setItem(int item) {
        this.item = item;
    }
    public No getDireita() {
        return direita;
    }
    public void setDireita(No direita) {
        this.direita = direita;
    }
    public No getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    @Override
    public String toString() {
        return "No item=" + item + "]" + " [direita=" + direita + "]" + "[esquerda=" + esquerda + "]";
    }
    
}
