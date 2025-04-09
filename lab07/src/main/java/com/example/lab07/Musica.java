package com.example.lab07;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Musica {
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String compositor;
    private int ano;

    public Musica() {}
    public Musica(String t,String c, int a) {
        titulo =t;
        ano = a;
        compositor=c;

    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setTitulo(String t) {
        titulo = t;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setAno(int a) {
        ano= a;
    }
    public int getAno() {
        return ano;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String c) {
        compositor = c;
    }
} 