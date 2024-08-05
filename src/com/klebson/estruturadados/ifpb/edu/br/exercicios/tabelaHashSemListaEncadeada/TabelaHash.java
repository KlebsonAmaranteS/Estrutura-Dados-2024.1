package com.klebson.estruturadados.ifpb.edu.br.exercicios.tabelaHashSemListaEncadeada;

import java.util.Arrays;

public class TabelaHash {
    private Aluno[] tabela;
    private static final Aluno REMOVIDO = new Aluno(-1, null);
    private int capacidade;
    private int count;

    public TabelaHash(int capacidade){
        this.capacidade = capacidade;
        this.count = 0;
        this.tabela = new Aluno[capacidade];
    }

    public int calculoHash(int matricula){
        return matricula % capacidade;
    }

    public String pegarValor(int matricula){
        int hash = calculoHash(matricula);
        for (int i = hash; i < capacidade; i++){
            if(tabela[i] != null && tabela[i].getMatricula() == matricula){
                return tabela[i].getNome();
            }
        }
        return null;
    }

    public void redimensionar(){
        int novaCapacidade = capacidade * 2;
        Aluno[] novaTabela = new Aluno[novaCapacidade];                                                            
        for(Aluno aluno : tabela){
            if(aluno != null){
                int hash = aluno.getMatricula() % novaCapacidade;
                while (novaTabela[hash] != null){
                    hash = (hash + 1) % novaCapacidade;
                }
                novaTabela[hash] = aluno;
            }
        }
        tabela = novaTabela;
        capacidade = novaCapacidade;
    }

    public void inserirValor(int matricula, String nome){
        if(count >= capacidade * 0.75){
            redimensionar();
        }

        int hash = calculoHash(matricula);

        while(tabela[hash] != null && tabela[hash].getMatricula() != matricula){
            hash = (hash + 1) % capacidade;
        }

        tabela[hash] = new Aluno(matricula, nome);
        count++;
    }

    public void removerValor(int matricula){
        int hash = calculoHash(matricula);
        for(int i = hash; i < capacidade; i++){
            if(tabela[i] == null){
                return;
            }

            if(tabela[i] != null && tabela[i].getMatricula() == matricula){
                tabela[i] = REMOVIDO;
                count--;
                return;
            }
        }

        for(int i = 0; i < hash; i++){
            if(tabela[i] == null){
                return;
            }

            if (tabela[i] != null && tabela[i].getMatricula() == matricula) {
                tabela[i] = REMOVIDO;
                count--; 
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "TabelaHash [tabela=" + Arrays.toString(tabela) + "]";
    }
}

