package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreAVL;

public class ArvoreAVL {
    No raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public int altura(No n) {
        if (n == null) {
            return 0;
        }
        return n.getAltura();
    }

    public int obterBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    private int maior(int a, int b) {
        return (a > b) ? a : b;
    }

    public No rotacaoDireita(No y) {
        No x = y.getEsquerda();
        No z = x.getDireita();

        x.setDireita(y);
        y.setEsquerda(z);

        y.setAltura(maior(altura(y.getEsquerda()), altura(y.getDireita())) + 1);
        x.setAltura(maior(altura(x.getEsquerda()), altura(x.getDireita())) + 1);

        return x;
    }

    public No rotacaoEsquerda(No x) {
        No y = x.getDireita();
        No z = y.getEsquerda();

        y.setEsquerda(x);
        x.setDireita(z);

        x.setAltura(1 + maior(altura(x.getEsquerda()), altura(x.getDireita())));
        y.setAltura(1 + maior(altura(y.getEsquerda()), altura(y.getDireita())));

        return y;
    }

    public No inserir(No no, int chave) {
        if (no == null) {
            return new No(chave);
        }

        if (chave < no.getValor()) {
            no.setEsquerda(inserir(no.getEsquerda(), chave));
        } else if (chave > no.getValor()) {
            no.setDireita(inserir(no.getDireita(), chave));
        } else {
            return no;
        }

        no.setAltura(1 + maior(altura(no.getEsquerda()), altura(no.getDireita())));

        int balanceamento = obterBalanceamento(no);

        if (balanceamento > 1 && chave < no.getEsquerda().getValor()) {
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && chave > no.getDireita().getValor()) {
            return rotacaoEsquerda(no);
        }

        if (balanceamento > 1 && chave > no.getEsquerda().getValor()) {
            no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && chave < no.getDireita().getValor()) {
            no.setDireita(rotacaoDireita(no.getDireita()));
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public No remover(No atual, int valor) {
        if (atual == null) {
            return atual;
        }

        if (valor < atual.getValor()) {
            atual.setEsquerda(remover(atual.getEsquerda(), valor));
        } else if (valor > atual.getValor()) {
            atual.setDireita(remover(atual.getDireita(), valor));
        } else {
            if (atual.getEsquerda() == null || atual.getDireita() == null) {
                No aux = (atual.getEsquerda() != null) ? atual.getEsquerda() : atual.getDireita();

                if (aux == null) {
                    atual = null;
                } else {
                    atual = aux;
                }
            } else {
                No temp = getMenorNo(atual.getDireita());

                atual.setValor(temp.getValor());

                atual.setDireita(remover(atual.getDireita(), temp.getValor()));
            }
        }

        if (atual == null) {
            return atual;
        }

        atual.setAltura(1 + maior(altura(atual.getEsquerda()), altura(atual.getDireita())));

        int balanceamento = obterBalanceamento(atual);

        if (balanceamento > 1 && obterBalanceamento(atual.getEsquerda()) >= 0) {
            return rotacaoDireita(atual);
        }

        if (balanceamento > 1 && obterBalanceamento(atual.getEsquerda()) < 0) {
            atual.setEsquerda(rotacaoEsquerda(atual.getEsquerda()));
            return rotacaoDireita(atual);
        }

        if (balanceamento < -1 && obterBalanceamento(atual.getDireita()) <= 0) {
            return rotacaoEsquerda(atual);
        }

        if (balanceamento < -1 && obterBalanceamento(atual.getDireita()) > 0) {
            atual.setDireita(rotacaoDireita(atual.getDireita()));
            return rotacaoEsquerda(atual);
        }

        return atual;
    }

    private No getMenorNo(No no) {
        No atual = no;

        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }

        return atual;
    }

    public No buscar(No no, int valor) {
        if (no == null || no.getValor() == valor) {
            return no;
        }

        if (valor < no.getValor()) {
            return buscar(no.getEsquerda(), valor);
        }

        return buscar(no.getDireita(), valor);
    }

    public void preOrder(No no) {
        if (no != null) {
            System.out.print(no.getValor() + " ");
            preOrder(no.getEsquerda());
            preOrder(no.getDireita());
        }
    }

    public void inOrder(No no) {
        if (no != null) {
            inOrder(no.getEsquerda());
            System.out.print(no.getValor() + " ");
            inOrder(no.getDireita());
        }
    }

    public void postOrder(No no) {
        if (no != null) {
            postOrder(no.getEsquerda());
            postOrder(no.getDireita());
            System.out.print(no.getValor() + " ");
        }
    }
}
