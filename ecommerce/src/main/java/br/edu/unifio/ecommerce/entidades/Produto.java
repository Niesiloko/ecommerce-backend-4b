package br.edu.unifio.ecommerce.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
public class Produto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descricao;

    private Short estoque;

    private double preco;

    @ManyToOne
    private Categoria categoria;

    public void setPreco(double d) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setPreco'");
    } 
}
public Produto() {
    // Construtor vazio obrigatório
}

public Produto(String nome, double preco, Categoria categoria) {
    this.nome = nome;
    this.preco = preco;
    this.categoria = categoria;
}
