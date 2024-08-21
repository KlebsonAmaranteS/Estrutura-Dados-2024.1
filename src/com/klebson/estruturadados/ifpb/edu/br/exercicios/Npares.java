package com.klebson.estruturadados.ifpb.edu.br.exercicios;

import java.util.Scanner;

public class Npares {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite um número: ");
		int n = sc.nextInt();
		
		imprimirPares(n);
		sc.close();
	}
	
	public static void imprimirPares(int n) {
		if(n < 0) {
			return;
		}else if(n % 2 == 0) {
			imprimirPares(n - 2);
			System.out.println(n);
		}else {
			imprimirPares(n - 1);
		}
	}
}
