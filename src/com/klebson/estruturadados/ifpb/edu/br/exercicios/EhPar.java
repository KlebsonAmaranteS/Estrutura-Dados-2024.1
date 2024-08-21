package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class EhPar {
    public static void main(String[] args) {
        int n = 20;

        // USANDO MOD
//        for(int n = 1; n <= 10; ++n) {
//            if (n % 2 == 0) {
//                System.out.println("eh par");
//            } else {
//                System.out.println("eh impar");
//            }
//        }

//         USANDO FOR
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= i; j += 2) {
                System.out.println(j + " eh impar");
            }
            i++;
            System.out.println(i + " eh par");
        }

        // USANDO SWITCH
//        for(int i = 1; i <= 10; i++){
//            switch (i){
//                case 2:
//                    System.out.println(i + " eh par");
//                    break;
//                case 4:
//                    System.out.println(i + " eh par");
//                    break;
//                case 6:
//                    System.out.println(i + " eh par");
//                    break;
//                case 8:
//                    System.out.println(i + " eh par");
//                    break;
//                case 10:
//                    System.out.println(i + " eh par");
//                    break;
//                default:
//                    System.out.println(i + " eh impar");
//                    break;
//            }
//    }
    }
}