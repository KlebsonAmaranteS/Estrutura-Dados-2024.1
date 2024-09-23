package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvore;

public class ArvoreBinaria {
    private No raiz;
    private No atual;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    private void insereNo(No atual, No novoNo) {
        if (novoNo.getItem() <= atual.getItem()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
            } else {
                insereNo(atual.getEsquerda(), novoNo);
            }
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
            } else {
                insereNo(atual.getDireita(), novoNo);
            }
        }
    }

    public void inserir(int elemento) {
        No novoNo = new No();
        novoNo.setItem(elemento);
    
        if (raiz == null) {
            raiz = novoNo;
        } else {
            insereNo(raiz, novoNo);
        }
    }

    public boolean remover(int elemento) {
        No atual = raiz;
        No paiAtual = null;

        // Encontra o nó a ser removido
        while (atual != null && atual.getItem() != elemento) {
            paiAtual = atual;
            if (elemento < atual.getItem()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        // Nó não encontrado
        if (atual == null) {
            return false;
        }

        // Caso 1: Nó com dois filhos
        if (atual.getEsquerda() != null && atual.getDireita() != null) {
            No substituto = atual.getDireita();
            No paiSubstituto = atual;

            while (substituto.getEsquerda() != null) {
                paiSubstituto = substituto;
                substituto = substituto.getEsquerda();
            }

            atual.setItem((int) substituto.getItem());
            atual = substituto;
            paiAtual = paiSubstituto;
        }

        // Caso 2: Nó com um ou nenhum filho
        No filho = (atual.getEsquerda() != null) ? atual.getEsquerda() : atual.getDireita();

        if (paiAtual == null) {
            raiz = filho;
        } else if (atual == paiAtual.getEsquerda()) {
            paiAtual.setEsquerda(filho);
        } else {
            paiAtual.setDireita(filho);
        }

        return true;
    }

    public boolean removerInicio() {
        if (raiz == null) {
            return false; 
        }
    
        No pai = null;
        No atual = raiz;
    
        // Encontra o nó com o menor valor
        while (atual.getEsquerda() != null) {
            pai = atual;
            atual = atual.getEsquerda();
        }
    
        // Atualiza a raiz se o nó a ser removido for a raiz
        if (pai == null) {
            raiz = atual.getDireita();
        } else {
            pai.setEsquerda(atual.getDireita());
        }
    
        return true;
    }

    public boolean removerFim() {
        if (raiz == null) {
            return false; 
        }
    
        No pai = null;
        No atual = raiz;
    
        // Encontra o nó com o maior valor
        while (atual.getDireita() != null) {
            pai = atual;
            atual = atual.getDireita();
        }
    
        // Atualiza a raiz se o nó a ser removido for a raiz
        if (pai == null) {
            raiz = atual.getEsquerda();
        } else {
            pai.setDireita(atual.getEsquerda());
        }
    
        return true;
    }
    

    @Override
    public String toString() {
        return "ArvoreBinaria [raiz=" + raiz + ", atual=" + atual + "]";
    }
}
