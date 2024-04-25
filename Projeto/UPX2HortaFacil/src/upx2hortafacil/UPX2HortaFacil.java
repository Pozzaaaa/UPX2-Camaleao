/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package upx2hortafacil;

import java.util.Scanner;

public class UPX2HortaFacil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println();
            System.out.println("Bem-Vindo(a) ao Horta Facil");
            System.out.println("---------------------");
            System.out.println("Aqui voce pode cadastrar sua horta comunitaria!");
            System.out.println("Digite 1 para saber mais!");
            System.out.println("Voce pode se tornar um voluntario ");
            System.out.println("Digite 2 para saber mais!");
            System.out.println("Digite 3 para criar seu usuario!");
            System.out.println("Digite 4 para sair do sistema");
            opcao = scanner.nextInt();
            

            switch (opcao) {
                case 1:
                    
                    System.out.println("Nao sei o que colocar aqui.");
                    // Código para saber mais sobre cadastro de horta
                    break;
                case 2:
                    System.out.println("-------------------------------------");
                    System.out.println("Na horta comunitaria, os voluntarios sao como abelhas em meio as flores:");
                    System.out.println("Maos que semeiam, coracoes que cuidam e sorrisos que colhem.");
                    System.out.println("Trabalho na horta: Plantam, regam, capinam, colhem... Tudo com carinho e dedicacao.");
                    System.out.println("Compartilhando conhecimento: Ensinam e aprendem sobre o cultivo de hortalicas e a importancia da agricultura urbana.");
                    System.out.println("Eventos e oficinas: Organizam atividades para a comunidade, como feiras de mudas e momentos de confraternizacao.");
                    System.out.println("");
                    System.out.println("Se voce quer fazer a diferenca, junte-se a nos! A horta de bracos abertos te espera!");
                    break;
                case 3:
                    
                   new Menu();
                   
                    break;
                case 4:
                    
                    System.out.println("Obrigado por usar o Horta Facil. Ate logo!");
                    break;
                default:
                    
                    System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }
    
}

