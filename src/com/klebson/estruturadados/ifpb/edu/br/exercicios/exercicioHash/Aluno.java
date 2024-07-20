package com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioHash;

public class Aluno {
    private String nome;
    private int matricula;

    public Aluno(int matricula, String nome) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
