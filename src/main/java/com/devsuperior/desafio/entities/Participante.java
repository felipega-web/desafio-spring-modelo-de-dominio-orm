package com.devsuperior.desafio.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "tb_participante")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @ManyToMany
    @JoinTable(name = "tb_participante_atividade",
            joinColumns = @JoinColumn(name = "participante_id"),
            inverseJoinColumns = @JoinColumn(name = "atividade_id"))
    private Set<Atividade> atividades = new HashSet<>();

    public Participante() {}

    public Participante(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participante)) return false;
        Participante that = (Participante) o;
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
