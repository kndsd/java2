package br.com.example.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity 
public class Pessoa {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer coInteger;
    private String nome;
    private int idade;
    private int codigo; // Adicione o campo 'codigo'
    public Pessoa(){}

    public Integer getCoInteger() {
        return coInteger;
    }

    public void setCoInteger(Integer coInteger) {
        this.coInteger = coInteger;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
  public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
