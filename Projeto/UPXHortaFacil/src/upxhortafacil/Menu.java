/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upxhortafacil;

import java.util.Scanner;

/**
 *
 * @author jujub
 */
public class Menu {
    public Menu()
    { 
            Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Horta");
        System.out.println("-----------------");

        System.out.print("Estado: ");
        char estado = scanner.nextLine().charAt(0);

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Nome da Horta: ");
        String nome = scanner.nextLine();

        System.out.print("Proprietario da Horta: ");
        String prop = scanner.nextLine();

        System.out.print("Numero de Membros: ");
        int membros = scanner.nextInt();

        System.out.print("Tamanho da Horta (em metros quadrados): ");
        int tamanho = scanner.nextInt();

        CadastroHorta horta = new CadastroHorta(estado, cidade, nome, prop, membros, tamanho);

        System.out.println("\nInformacoes da Horta cadastrada:");
        System.out.println("Estado: " + horta.getEstado());
        System.out.println("Cidade: " + horta.getCidade());
        System.out.println("Nome da Horta: " + horta.getNome());
        System.out.println("Proprietario da Horta: " + horta.getProp());
        System.out.println("Numero de Membros: " + horta.getMembros());
        System.out.println("Tamanho da Horta: " + horta.getTamanho() + " metros quadrados");

        
            
    }
}
