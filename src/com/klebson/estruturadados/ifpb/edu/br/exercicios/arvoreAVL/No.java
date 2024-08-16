package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreAVL;

public class No {
    private int elemento;
    private No esq;
    private No dir;

    public No(int elemento){
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }
}
