package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreOrdem;

public class Arvore {
    private No raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void adicionar(int elemento){
        raiz = adicionarRecursivo(raiz, elemento);
    }

    private No adicionarRecursivo(No noAtual, int elemento) {
        if (noAtual == null) {
            return new No(elemento);
        }

        if (elemento < noAtual.getElemento()) {
            noAtual.setEsq(adicionarRecursivo(noAtual.getEsq(), elemento));
        } else if (elemento > noAtual.getElemento()) {
            noAtual.setDir(adicionarRecursivo(noAtual.getDir(), elemento));
        }

        return noAtual;
    }


    public void remover(int elemento) {
        raiz = removerRecursivo(raiz, elemento);
    }

    private No removerRecursivo(No noAtual, int valor) {
        if (noAtual == null) {
            return null;
        }

        if (valor < noAtual.getElemento()) {
            noAtual.setEsq(removerRecursivo(noAtual.getEsq(), valor));
        } else if (valor > noAtual.getElemento()) {
            noAtual.setDir(removerRecursivo(noAtual.getDir(), valor));
        } else {
            if (noAtual.getEsq() == null && noAtual.getDir() == null) {
                return null;
            }


            if (noAtual.getEsq() == null) {
                return noAtual.getDir();
            }

            if (noAtual.getDir() == null) {
                return noAtual.getEsq();
            }


            No menorValorDireita = encontrarMenorValor(noAtual.getDir());
            noAtual.setElemento(menorValorDireita.getElemento());

            noAtual.setDir(removerRecursivo(noAtual.getDir(), menorValorDireita.getElemento()));
        }

        return noAtual;
    }

    private No encontrarMenorValor(No noAtual) {
        return noAtual.getEsq() == null ? noAtual : encontrarMenorValor(noAtual.getEsq());
    }


    public boolean busca(int valor) {
        return buscaRecursiva(raiz, valor);
    }

    private boolean buscaRecursiva(No noAtual, int valor) {
        if (noAtual == null) {
            return false;
        }

        if (noAtual.getElemento() == valor) {
            return true;
        }

        if (valor < noAtual.getElemento()) {
            return buscaRecursiva(noAtual.getEsq(), valor);
        } else {
            return buscaRecursiva(noAtual.getDir(), valor);
        }
    }


    public void imprimirPreOrdem(No no){
        if(no == null){
            return;
        }

        System.out.println(no.getElemento() + " ");

        imprimirPreOrdem(no.getEsq());

        imprimirPreOrdem(no.getDir());
    }

    public void imprimirEmOrdem(No no){
        if(no == null){
            return;
        }
        imprimirEmOrdem(no.getEsq());

        System.out.println(no.getElemento() + " ");

        imprimirEmOrdem(no.getDir());
    }

    public void imprimirPosOrdem(No no){
        if(no == null){
            return;
        }

        imprimirPosOrdem(no.getEsq());

        imprimirPosOrdem(no.getDir());

        System.out.println(no.getElemento() + " ");
    }

    public No getRaiz() {
        return raiz;
    }
}
