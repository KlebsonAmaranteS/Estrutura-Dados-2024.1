package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreBinaria;

public class No {
    int elemento;
    No esquerda;
    No direita;

    public No(int elemento){
        this.elemento = elemento;
    }

    public int getElemento() {
        return elemento;
    }
    public void setElemento(int elemento) {
        this.elemento = elemento;
    }
    public No getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
    public No getDireita() {
        return direita;
    }
    public void setDireita(No direita) {
        this.direita = direita;
    }

    @Override
    public String toString() {
        return "No [elemento=" + elemento + ", esquerda=" + esquerda + ", direita=" + direita + "]";
    }
}
