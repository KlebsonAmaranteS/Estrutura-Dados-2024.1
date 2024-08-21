package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreAVL;

public class ArvoreAVL {
    private No raiz;

    public ArvoreAVL(){
        this.raiz = null;
    }

    public int altura(No n){
        if(n == null){
            return 0;
        }
        return n.getAltura();
    }

    public int obterBalanceamento(No no){
        if(no == null){
            return 0;
        }
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    private int maior(int a, int b) {
        return (a > b) ? a : b;
    }

    public No rotacaoDireita(No y){
        No x = y.getEsquerda();
        No z = x.getDireita();

        x.setDireita(y);
        y.setEsquerda(z);

        y.setAltura(maior(altura(y.getEsquerda()), altura(y.getDireita())) + 1);
        x.setAltura(maior(altura(x.getEsquerda()), altura(x.getDireita())) + 1);

        return x;
    }

    public No rotacaoEsquerda(No x){
        No y = x.getDireita();
        No z = y.getEsquerda();

        y.setEsquerda(x);
        x.setDireita(z);

        x.setAltura(maior(altura(x.getEsquerda()), altura(x.getDireita())));
        y.setAltura(maior(altura(y.getEsquerda()), altura(y.getDireita())));

        return y;
    }

    public No inserir(No no, int chave){
        if(no == null){
            return new No(chave);
        }

        if(chave < no.getValor()){
            no.setEsquerda(inserir(no.getEsquerda(), chave));
        } else if(chave > no.getValor()){
            no.setDireita(inserir(no.getDireita(), chave));
        }else{
            return no;
        }

        no.setAltura(1 + maior(altura(no.getEsquerda()), altura(no.getDireita())));

        int balanceamento = obterBalanceamento(no);

        //caso LL
        if(balanceamento > 1 && chave < no.getEsquerda().getValor()){
            return rotacaoDireita(no);
        }

        //caso RR
        if(balanceamento < -1 && chave > no.getDireita().getValor()){
            return rotacaoEsquerda(no);
        }

        //caso LR
        if(balanceamento > 1 && chave > no.getEsquerda().getValor()){
            no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            return rotacaoDireita(no);
        }

        //caso RL
        if(balanceamento < -1 && chave < no.getDireita().getValor()){
            no.setDireita(rotacaoDireita(no.getDireita()));
            return rotacaoEsquerda(no);
        }

        return no;
    }


}
