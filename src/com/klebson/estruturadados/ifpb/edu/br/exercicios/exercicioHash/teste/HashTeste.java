package com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioHash.teste;
import com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioHash.Aluno;
import com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioHash.TabelaHash;

public class HashTeste {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(10);

        Aluno aluno1 = new Aluno(20232114, "Alice");
        Aluno aluno2 = new Aluno(20221134, "Bob");
        Aluno aluno3 = new Aluno(20212345, "Charlie");

        tabelaHash.inserirValor(aluno1);
        tabelaHash.inserirValor(aluno2);
        tabelaHash.inserirValor(aluno3);

        System.out.println("Pegando aluno com matrícula 20232114: " + tabelaHash.pegarValor(20232114));
        System.out.println("Pegando aluno com matrícula 20212345: " + tabelaHash.pegarValor(20221134));

        tabelaHash.removerValor(1);
        System.out.println("Pegando aluno com matrícula 20232114 (após remoção): " + tabelaHash.pegarValor(20232114));
    }
}
