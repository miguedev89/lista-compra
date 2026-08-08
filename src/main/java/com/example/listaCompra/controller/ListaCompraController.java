package com.example.listaCompra.controller;

import com.example.listaCompra.model.ListaCompra;
import com.example.listaCompra.repository.ListaCompraRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class ListaCompraController {

    private final ListaCompraRepository repository;

    public ListaCompraController(ListaCompraRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ListaCompra> listarListas() {
        return repository.findAll();
    }

    @PostMapping
    public ListaCompra crearLista(@RequestBody ListaCompra lista) {
        return repository.save(lista);
    }
}