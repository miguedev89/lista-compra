package com.example.listaCompra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class ItemLista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private boolean comprado = false;

    // getters y setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    @ManyToOne
    @JoinColumn(name = "lista_compra_id")
    @JsonIgnore
    private ListaCompra listaCompra;

    public ListaCompra getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(ListaCompra listaCompra) {
        this.listaCompra = listaCompra;
    }

}