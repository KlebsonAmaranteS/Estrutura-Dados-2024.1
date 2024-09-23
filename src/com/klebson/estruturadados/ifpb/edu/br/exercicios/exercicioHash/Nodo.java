package com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioHash;

public class Nodo {
    Aluno dados;
    Nodo proximo;

    public Nodo(Aluno dados) {
        this.dados = dados;
        this.proximo = null;
    }

    public Aluno getDados(){
        return dados;
    }

    public Nodo getProximo(){
        return proximo;
    }

    public void setProximo(Nodo proximo){
        this.proximo = proximo;
    }
    
}
