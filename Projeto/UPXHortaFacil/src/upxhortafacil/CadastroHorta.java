/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upxhortafacil;

/**
 *
 * @author jujub
 */
public class CadastroHorta {
    private char estado;
    private String cidade;
    private String nome;
    private String prop;
    private int membros;
    private int tamanho;
    
    public CadastroHorta(char estado, String cidade, String nome, String prop, int membros, int tamanho)
    {
     this.estado=estado;
     this.cidade=cidade;
     this.membros=membros;
     this.nome=nome;
     this.prop=prop;
     this.tamanho=tamanho;
    
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public int getMembros() {
        return membros;
    }

    public void setMembros(int membros) {
        this.membros = membros;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    
}
