package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreB;

public class ArvoreB {
    private No raiz;
    private int ordem;

    public ArvoreB(int ordem) {
        this.raiz = null;
        this.ordem = ordem;
    }

    public void percorrer() {
        if (raiz != null) {
            raiz.percorrer();
        }
    }

    public No buscar(int chave) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.buscar(chave);
        }
    }

    public void inserir(int chave) {
        if (raiz == null) {
            raiz = new No(ordem, true);
            raiz.chaves[0] = chave;
            raiz.numChaves = 1;
        } else {
            if (raiz.numChaves == 2 * ordem - 1) {
                No s = new No(ordem, false);
                s.filhos[0] = raiz;
                s.dividirFilho(0, raiz);
                int i = 0;
                if (s.chaves[0] < chave) {
                    i++;
                }
                s.filhos[i].inserirNaoCheio(chave);
                raiz = s;
            } else {
                raiz.inserirNaoCheio(chave);
            }
        }
    }

    public void remover(int chave) {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        raiz.remover(chave);

        if (raiz.numChaves == 0) {
            if (raiz.folha) {
                raiz = null;
            } else {
                raiz = raiz.filhos[0];
            }
        }
    }
}
