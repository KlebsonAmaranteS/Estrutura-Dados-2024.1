package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class NoDuplo<T> {
    private T elemento;
    private T quantidade;
    private NoDuplo<T> proximo;
    private NoDuplo<T> anterior;

    public NoDuplo(T elemento, T quantidade) {
        this.elemento = elemento;
        this.quantidade = quantidade;
        this.proximo = null;
        this.anterior = null;
    }

    public NoDuplo(T elemento, NoDuplo<T> proximo, NoDuplo<T> anterior) {
        this.elemento = elemento;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public T getElemento() {
        return elemento;
    }

    public T getQuantidade(){
        return quantidade;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setQuantidade(T quantidade) {
        this.quantidade = quantidade;
    }

    public NoDuplo<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    public NoDuplo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo<T> anterior) {
        this.anterior = anterior;
    }
}
