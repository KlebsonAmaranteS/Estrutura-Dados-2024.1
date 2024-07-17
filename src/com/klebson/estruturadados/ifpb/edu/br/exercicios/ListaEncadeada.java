package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class ListaEncadeada<T> {

    private Nodo<T> inicio;
    private Nodo<T> ultimo;
    private int tamanho = 0;

    private final int NAO_ENCONTRADO = -1;
    private final String NAO_EXISTE = "Posição não existe.";
    private final String LISTA_VAZIA = "Lista vazia.";

    public void adiciona(T elemento){
        Nodo<T> celula = new Nodo<T>(elemento);
        if(this.tamanho == 0){
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public void adicionaInicio(T elemento){
        if(this.tamanho == 0){
            Nodo<T> novoNo = new Nodo<>(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
        }else{
            Nodo<T> novoNo = new Nodo<>(elemento,this.inicio);
            this.inicio = novoNo;
            
        }
    }

    public void adiciona(int posicao, T elemento){

        if(this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        if(this.tamanho == 0){ //está vazia
            this.adicionaInicio(elemento);
        } else if(posicao == this.tamanho){ // adiciona
            this.adiciona(elemento);
        } else { // meio
            Nodo<T> noAnterior = this.buscaNo(posicao);
            Nodo<T> proximoNo = noAnterior.getProximo();
            Nodo<T> novoNo = new Nodo<>(elemento, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    public boolean posicaoNaoExiste(int posicao){
        return !(posicao >= 0 && posicao <= this.tamanho);
    }

    public T remove(int posicao){

        if(this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        if(posicao == 0){
            return this.removeInicio();
        }
        if(posicao == this.tamanho - 1){
            return this.removeFinal();
        }
        Nodo<T> noAnterior = this.buscaNo(posicao - 1);
        Nodo<T> atual = noAnterior.getProximo();
        Nodo<T> proximo = atual.getProximo();
        noAnterior.setProximo(proximo);
        atual.setProximo(null);
        this.tamanho--;
        return null;
    }

    public T removeInicio(){
        if(this.tamanho == 0){
            throw new RuntimeException(LISTA_VAZIA);
        }
        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if(this.tamanho == 0){
            this.ultimo = null;
        }

        return removido;
    }

    public T removeFinal(){
        if(this.tamanho == 0){
            throw new RuntimeException(LISTA_VAZIA);
        }
        if(this.tamanho == 1){
            return this.removeInicio();
        }
        Nodo<T> penultimoNo = this.buscaNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;
        return null;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public void limpa(){

        for(Nodo<T> atual = this.inicio; atual != null;){
            Nodo<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    private Nodo<T> buscaNo(int posicao) {

        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        Nodo<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }

        return noAtual;
    }


    public T buscaPorPosicao(int posicao) {
        return this.buscaNo(posicao).getElemento();
    }

    public int busca(T elemento) {

        Nodo<T> noAtual = this.inicio;
        int pos = 0;

        while (noAtual != null) {

            if (noAtual.getElemento().equals(elemento)) {
                return pos;
            }
            pos++;
            noAtual = noAtual.getProximo();
        }

        return NAO_ENCONTRADO;
    }


    @Override
    public String toString() {
        
        if(this.tamanho == 0){
            return "[]";
        }


        StringBuilder builder = new StringBuilder("[");

        Nodo<T> atual = this.inicio;

        for(int i = 0; i < this.tamanho - 1; i++){
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }

        builder.append(atual.getElemento()).append("]");

        return builder.toString();
    }
}
