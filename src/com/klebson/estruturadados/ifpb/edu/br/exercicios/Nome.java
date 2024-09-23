package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class Nome {
    public String nome;

    public Nome(String nome){
        this.nome = nome;
    }

    public String retorna(){
        return this.nome;
    }

    public static void main(String[] args) {
        Nome nome1 = new Nome("Klebson");
        nome1.retorna();
    }
}


