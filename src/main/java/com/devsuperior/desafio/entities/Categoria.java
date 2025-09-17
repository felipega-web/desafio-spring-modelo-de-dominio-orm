package com.devsuperior.desafio.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Objects;
import java.util.ArrayList;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;
    

    public Categoria() {}

    public Categoria(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Atividade getAtividade() {
         return atividade;
    }
    
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria that = (Categoria) o;
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

}