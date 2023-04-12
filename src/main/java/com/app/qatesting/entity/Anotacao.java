package com.app.qatesting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "anotacao")
public class Anotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ant_id")
    private Long id;

    @Column(name = "ant_text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private Usuario usuario;
    
    public Anotacao(){}

    public Anotacao( String text, Usuario usuario){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
