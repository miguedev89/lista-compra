package com.example.listaCompra.controller;

import com.example.listaCompra.model.ListaCompra;
import com.example.listaCompra.service.ListaCompraService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/listas")
public class ListaCompraController {

    private final ListaCompraService service;

    public ListaCompraController(ListaCompraService service) {
        this.service = service;
    }

    @GetMapping
    public List<ListaCompra> listarListas() {
        return service.listarListas();
    }

    @PostMapping
    public ListaCompra crearLista(@RequestBody ListaCompra lista) {
        return service.crearLista(lista);
    }

    @GetMapping("/{id}")
    public ListaCompra obtenerLista(@PathVariable Long id) {
        return service.obtenerLista(id);
    }

    @PatchMapping("/{listaId}/miembros/{usuarioId}")
    public ListaCompra anadirMiembro(@PathVariable Long listaId, @PathVariable Long usuarioId) {
        return service.anadirMiembro(listaId, usuarioId);
    }
}