package com.example.listaCompra.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String email;

    @OneToMany(mappedBy = "usuarioPropietario")
    @JsonIgnore
    private List<ListaCompra> listas;

    @ManyToMany(mappedBy = "miembros")
    @JsonIgnore
    private List<ListaCompra> listasCompartidas;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ListaCompra> getListas() {
        return listas;
    }

    public void setListas(List<ListaCompra> listas) {
        this.listas = listas;
    }

    public List<ListaCompra> getListasCompartidas() {
        return listasCompartidas;
    }

    public void setListasCompartidas(List<ListaCompra> listasCompartidas) {
        this.listasCompartidas = listasCompartidas;
    }

    



    
}
