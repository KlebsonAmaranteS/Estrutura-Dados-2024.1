package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreBinaria;

public class Arvore {
    private No raiz;

    public Arvore(){
        this.raiz = null;
    }
    
    public void inserir(int elemento){
        raiz = inserirRecursivo(raiz, elemento);
    }

    private No inserirRecursivo(No no, int elemento){
        if(no == null){
            no = new No(elemento);
        } else if(elemento < no.getElemento()){
            no.setEsquerda(inserirRecursivo(no, elemento));
        }else{
            no.setDireita(inserirRecursivo(no, elemento));
        }

        return no;
    }

    public boolean buscar(int elemento){
        return buscarRecursivo(raiz, elemento);
    }

    private boolean buscarRecursivo(No no, int elemento){
        if(no == null){
            return false;
        } else if(elemento == no.getElemento()){
            return true;
        } else if(elemento < no.getElemento()){
            return buscarRecursivo(no.getEsquerda(), elemento);
        } else{
            return buscarRecursivo(no.getDireita(), elemento);
        }
    }

    public void remover(int elemento){
        raiz = removerRecursivo(raiz, elemento);
    }

    private No removerRecursivo(No no, int elemento){
        if(no == null){
            return null;
        } 

        if(elemento < no.getElemento()){
            no.setEsquerda(removerRecursivo(no.getEsquerda(), elemento));
        } else if(elemento > no.getElemento()){
            no.setDireita(removerRecursivo(no.getDireita(), elemento));
        }else{
             // Nó folha
             if(no.getEsquerda() == null && no.getDireita() == null){
                return null;
             }

             // Nó com apenas um filho
             if(no.getEsquerda() == null){
                return no.getDireita();
             }else if(no.getDireita() == null){
                return no.getEsquerda();
             }

             //Nó com dois filhos
             No sucessor = encontraMenor(no.getDireita());
             no.setElemento(sucessor.getElemento());
             no.setDireita(removerRecursivo(no.getDireita(), sucessor.getElemento()));
        }
        return no;
    }

    private No encontraMenor(No no){
        while(no.getEsquerda() != null){
            no = no.getEsquerda();
        }
        return no;
    }

    @Override
    public String toString() {
        return "Arvore [raiz=" + raiz + "]";
    }
}
