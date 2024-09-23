<<<<<<< HEAD
package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreRecursiva;

public class No {
    private int elemento;
    private No direita;
    private No esquerda;

    public No(int elemento){
        this.elemento = elemento;
        this.direita = null;
        this.esquerda = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
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
        return "No [elemento=" + elemento + ", direita=" + direita + ", esquerda=" + esquerda + "]";
    }

}
=======
package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreRecursiva;

public class No {
    private int elemento;
    private No direita;
    private No esquerda;

    public No(int elemento){
        this.elemento = elemento;
        this.direita = null;
        this.esquerda = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
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
        return "No [elemento=" + elemento + ", direita=" + direita + ", esquerda=" + esquerda + "]";
    }

}
>>>>>>> d5e6b924be5186bff2216002fee35627d75e0f89
