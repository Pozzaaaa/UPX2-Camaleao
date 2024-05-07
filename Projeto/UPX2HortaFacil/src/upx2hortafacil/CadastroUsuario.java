/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upx2hortafacil;

import java.util.Scanner;

public class CadastroUsuario {

    public CadastroUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de usuario");
        System.out.println("-----------------");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: "); // Adicionei ":" após "CPF"
        String cpf = scanner.nextLine(); // Alterei "prop" para "cpf" para refletir a entrada do CPF

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine(); // Alterei para String, pois geralmente os números de telefone podem conter caracteres especiais

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine(); // Alterei para String para aceitar endereços completos

        System.out.print("Estado: ");
        String estado = scanner.nextLine(); // Alterei para String para aceitar nomes de estados completos

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        
        
        /*System.out.println("\nInformações do usuário cadastrado:");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.println("Estado: " + estado);
        System.out.println("Cidade: " + cidade);*/
        
        System.out.println("Cadastro de usuário");
        System.out.println("-----------------");

        System.out.println("1. Gostaria de me voluntariar");
        System.out.println("2. Gostaria de cadastrar uma horta");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("-----------------");
                System.out.println("Por que voce gostaria de ser voluntario (a)?");
                scanner.nextLine(); // Limpar o buffer do scanner antes de ler a string
                String razao = scanner.nextLine();
                // Faça o que precisar com a variável razao
                break;
            case 2:
                new Menu(); // Supondo que a classe Menu tenha um construtor padrão
                break;
            default:
                System.out.println("Opção invalida.");
                break;
        }
    }

    
}
