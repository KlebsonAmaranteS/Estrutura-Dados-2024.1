package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvorePV;

public class ArvorePV {
    private No raiz;
    private No nulo;

    public ArvorePV(){
        nulo = new No(0);
        nulo.setCor(false);
        nulo.setEsquerdo(null);
        nulo.setDireito(null);
        raiz = nulo;
    }

    private void preOrdem(No no){
        if(no != nulo){
            System.out.println(no.getDado() + " ");
            preOrdem(no.getEsquerdo());
            preOrdem(no.getDireito());
        }
    }

    private void emOrdem(No no){
        if(no != null){
            emOrdem(no.getEsquerdo());
            System.out.println(no.getDado());
            emOrdem(no.getDireito());
        }
    }

    private void posOrdem(No no){
        if(no != nulo){
            posOrdem(no.getEsquerdo());
            posOrdem(no.getDireito());
            System.out.println(no.getDado() + " ");
        }
    }

    private void corrigirExclusao(No x) {
        No s;
        while (x != raiz && x.isCor() == false) {
            if (x == x.getPai().getEsquerdo()) {
                s = x.getPai().getDireito();
                if (s.isCor() == true) {
                    s.setCor(false);
                    x.getPai().setCor(true);
                    rotacaoEsquerda(x.getPai());
                    s = x.getPai().getDireito();
                }
                if (s.getEsquerdo().isCor() == false && s.getDireito().isCor() == false) {
                    s.setCor(true);
                    x = x.getPai();
                } else {
                    if (s.getDireito().isCor() == false) {
                        s.getEsquerdo().setCor(false);
                        s.setCor(true);
                        rotacaoDireita(s);
                        s = x.getPai().getDireito();
                    }
                    s.setCor(x.getPai().isCor());
                    x.getPai().setCor(false);
                    s.getDireito().setCor(false);
                    rotacaoEsquerda(x.getPai());
                    x = raiz;
                }
            } else {
                s = x.getPai().getEsquerdo();
                if (s.isCor() == true) {
                    s.setCor(false);
                    x.getPai().setCor(true);
                    rotacaoDireita(x.getPai());
                    s = x.getPai().getEsquerdo();
                }

                if (s.getEsquerdo().isCor() == false && s.getDireito().isCor() == false) {
                    s.setCor(true);
                    x = x.getPai();
                } else {
                    if (s.getEsquerdo().isCor() == false) {
                        s.getDireito().setCor(false);
                        s.setCor(true);
                        rotacaoEsquerda(s);
                        s = x.getPai().getEsquerdo();
                    }

                    s.setCor(x.getPai().isCor());
                    x.getPai().setCor(false);
                    s.getEsquerdo().setCor(false);
                    rotacaoDireita(x.getPai());
                    x = raiz;
                }
            }
        }
        x.setCor(false);
    }

    private void rbTransplantar(No u, No v) {
        if (u.getPai() == null) {
            raiz = v;
        } else if (u == u.getPai().getEsquerdo()) {
            u.getPai().setEsquerdo(v);
        } else {
            u.getPai().setDireito(v);
        }
        v.setPai(u.getPai());
    }

    private void rotacaoEsquerda(No x) {
        No y = x.getDireito();
        x.setDireito(y.getEsquerdo());
        if (y.getEsquerdo() != nulo) {
            y.getEsquerdo().setPai(x);
        }
        y.setPai(x.getPai());
        if (x.getPai() == null) {
            raiz = y;
        } else if (x == x.getPai().getEsquerdo()) {
            x.getPai().setEsquerdo(y);
        } else {
            x.getPai().setDireito(y);
        }
        y.setEsquerdo(x);
        x.setPai(y);
    }


    private void rotacaoDireita(No x) {
        No y = x.getEsquerdo();
        x.setEsquerdo(y.getDireito());
        if (y.getDireito() != nulo) {
            y.getDireito().setPai(x);
        }
        y.setPai(x.getPai());
        if (x.getPai() == null) {
            raiz = y;
        } else if (x == x.getPai().getDireito()) {
            x.getPai().setDireito(y);
        } else {
            x.getPai().setEsquerdo(y);
        }
        y.setDireito(x);
        x.setPai(y);
    }

    private void corrigirInsercao(No k) {
        No u;
        while (k.getPai().isCor()) {
            if (k.getPai() == k.getPai().getPai().getEsquerdo()) {
                u = k.getPai().getPai().getDireito(); // Tio
                if (u.isCor()) {

                    k.getPai().setCor(false);
                    u.setCor(false);
                    k.getPai().getPai().setCor(true);
                    k = k.getPai().getPai();
                } else {

                    if (k == k.getPai().getDireito()) {
                        k = k.getPai();
                        rotacaoEsquerda(k);
                    }

                    k.getPai().setCor(false);
                    k.getPai().getPai().setCor(true);
                    rotacaoDireita(k.getPai().getPai());
                }
            } else {
                u = k.getPai().getPai().getEsquerdo();
                if (u.isCor()) {

                    k.getPai().setCor(false);
                    u.setCor(false);
                    k.getPai().getPai().setCor(true);
                    k = k.getPai().getPai();
                } else {

                    if (k == k.getPai().getEsquerdo()) {
                        k = k.getPai();
                        rotacaoDireita(k);
                    }

                    k.getPai().setCor(false);
                    k.getPai().getPai().setCor(true);
                    rotacaoEsquerda(k.getPai().getPai());
                }
            }
            if (k == raiz) {
                break;
            }
        }
        raiz.setCor(false);
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        novoNo.setPai(null);
        novoNo.setEsquerdo(nulo);
        novoNo.setDireito(nulo);
        novoNo.setCor(true);

        No y = null;
        No x = raiz;

        while (x != nulo) {
            y = x;
            if (novoNo.getDado() < x.getDado()) {
                x = x.getEsquerdo();
            } else {
                x = x.getDireito();
            }
        }

        novoNo.setPai(y);
        if (y == null) {
            raiz = novoNo;
        } else if (novoNo.getDado() < y.getDado()) {
            y.setEsquerdo(novoNo);
        } else {
            y.setDireito(novoNo);
        }

        if (novoNo.getPai() == null) {
            novoNo.setCor(false);
            return;
        }

        if (novoNo.getPai().getPai() == null) {
            return;
        }

        corrigirInsercao(novoNo);
    }

    private No minimo(No no) {
        while (no.getEsquerdo() != nulo) {
            no = no.getEsquerdo();
        }
        return no;
    }

    public void remover(int valor) {
        No z = buscar(raiz, valor);
        if (z == nulo) {
            System.out.println("Valor não encontrado na árvore.");
            return;
        }

        No y = z;
        No x;
        boolean corOriginalY = y.isCor();

        if (z.getEsquerdo() == nulo) {
            x = z.getDireito();
            rbTransplantar(z, z.getDireito());
        } else if (z.getDireito() == nulo) {
            x = z.getEsquerdo();
            rbTransplantar(z, z.getEsquerdo());
        } else {
            y = minimo(z.getDireito());
            corOriginalY = y.isCor();
            x = y.getDireito();
            if (y.getPai() == z) {
                x.setPai(y);
            } else {
                rbTransplantar(y, y.getDireito());
                y.setDireito(z.getDireito());
                y.getDireito().setPai(y);
            }
            rbTransplantar(z, y);
            y.setEsquerdo(z.getEsquerdo());
            y.getEsquerdo().setPai(y);
            y.setCor(z.isCor());
        }

        if (!corOriginalY) {
            corrigirExclusao(x);
        }
    }

    private No buscar(No no, int valor) {
        if (no == nulo || valor == no.getDado()) {
            return no;
        }

        if (valor < no.getDado()) {
            return buscar(no.getEsquerdo(), valor);
        }

        return buscar(no.getDireito(), valor);
    }
}

