package com.example.listaCompra.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class ListaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "listaCompra", cascade = CascadeType.ALL)
    private List<ItemLista> items;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ItemLista> getItems() {
        return items;
    }

    public void setItems(List<ItemLista> items) {
        this.items = items;
    }
}