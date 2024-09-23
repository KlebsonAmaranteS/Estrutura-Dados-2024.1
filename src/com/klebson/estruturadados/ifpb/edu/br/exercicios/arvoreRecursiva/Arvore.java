package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreRecursiva;

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
            noAtual.setEsquerda(adicionarRecursivo(noAtual.getEsquerda(), elemento));
        } else if (elemento > noAtual.getElemento()) { 
            noAtual.setDireita(adicionarRecursivo(noAtual.getDireita(), elemento));
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
            noAtual.setEsquerda(removerRecursivo(noAtual.getEsquerda(), valor));
        } else if (valor > noAtual.getElemento()) { 
            noAtual.setDireita(removerRecursivo(noAtual.getDireita(), valor));
        } else { 
            if (noAtual.getEsquerda() == null && noAtual.getDireita() == null) {
                return null;
            }

        
            if (noAtual.getEsquerda() == null) {
                return noAtual.getDireita();
            }

            if (noAtual.getDireita() == null) {
                return noAtual.getEsquerda();
            }

            
            No menorValorDireita = encontrarMenorValor(noAtual.getDireita());
            noAtual.setElemento(menorValorDireita.getElemento());

            noAtual.setDireita(removerRecursivo(noAtual.getDireita(), menorValorDireita.getElemento()));
        }

        return noAtual;
    }

    private No encontrarMenorValor(No noAtual) {
        return noAtual.getEsquerda() == null ? noAtual : encontrarMenorValor(noAtual.getEsquerda());
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
            return buscaRecursiva(noAtual.getEsquerda(), valor);
        } else {
            return buscaRecursiva(noAtual.getDireita(), valor);
        }
    }

    @Override
    public String toString() {
        return "Arvore [raiz=" + raiz + "]";
    }

    
}
