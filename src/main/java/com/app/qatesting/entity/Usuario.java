package com.app.qatesting.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_nome")
    private String name;

    @Column(name = "usr_senha")
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Anotacao> anotacaos;

    public Usuario(){}

    public Usuario(String name,String password){
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Anotacao> getAnotacaos() {
        return anotacaos;
    }

    public void setAnotacaos(List<Anotacao> anotacaos) {
        this.anotacaos = anotacaos;
    }

}
