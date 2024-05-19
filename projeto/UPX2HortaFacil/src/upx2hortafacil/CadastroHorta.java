/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upx2hortafacil;

public class CadastroHorta {
    private String estado;
    private String cidade;
    private String nome;
    private String prop;
    private int membros;
    private int tamanho;
    private String descri;
    
    public CadastroHorta () {}
    
    public CadastroHorta(String estado, String cidade, String nome, String prop, int membros, int tamanho, String descri)
    {
     this.estado=estado;
     this.cidade=cidade;
     this.membros=membros;
     this.nome=nome;
     this.prop=prop;
     this.tamanho=tamanho;
     this.descri=descri;
    
    }
    public String toString() {
       return String.format("| Estado: %s | Cidade: %s | Membros: %d | Nome: %s | Prop: %s | Tamanho: %d | Descrição: %s |",
                this.estado, this.cidade, this.membros, this.nome, this.prop, this.tamanho, this.descri);
  }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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
