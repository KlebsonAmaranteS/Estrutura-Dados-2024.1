package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvorePV;

public class No {
    private int dado;
    private No pai;
    private No direito;
    private No esquerdo;
    private boolean cor;

    No(int dado){
        this.dado = dado;
        this.cor = true;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public boolean isCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }
}