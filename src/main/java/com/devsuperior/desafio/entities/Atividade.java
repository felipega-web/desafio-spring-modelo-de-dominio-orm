package com.devsuperior.desafio.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;

    @OneToMany(mappedBy = "atividade")
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToMany(mappedBy = "atividades")
    private Set<Participante> participantes = new HashSet<>();
    
    @OneToMany(mappedBy = "atividade")
    private Set<Bloco> blocos = new HashSet<>();

    public Atividade() {}

    public Atividade(Long id, String nome, String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Double getPreco() {
        return preco;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public Set<Categoria> getCategorias() {
        return categorias;
    }
    
    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }
    
    public Set<Bloco> getBlocos() {
        return blocos;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atividade)) return false;
        Atividade that = (Atividade) o;
        return id != null && id.equals(that.getId());
    }
    
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
    
}
