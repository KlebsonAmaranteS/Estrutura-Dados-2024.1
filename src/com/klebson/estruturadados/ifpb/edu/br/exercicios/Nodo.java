package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class Nodo<T> {

    private T elemento;
    private Nodo<T> proximo;
    private int data;

    public Nodo(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public Nodo(T elemento, Nodo<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("No [elemento=").append(elemento).append(", proximo=").append(proximo).append("]");
        return builder.toString();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
