package com.example.listaCompra.controller;

import com.example.listaCompra.model.ItemLista;
import com.example.listaCompra.service.ItemListaService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemListaController {

    private final ItemListaService service;

    public ItemListaController(ItemListaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ItemLista> listarItems() {
        return service.listarItems();
    }

    @PostMapping("/lista/{listaId}")
    public ItemLista crearItem(@PathVariable Long listaId, @RequestBody ItemLista item) {
        return service.crearItem(listaId, item);
    }

    @DeleteMapping("/{id}")
    public void borrarItem(@PathVariable Long id) {
        service.borrarItem(id);
    }

    @PutMapping("/{id}")
    public ItemLista actualizarItem(@PathVariable Long id, @RequestBody ItemLista itemActualizado) {
        return service.actualizarItem(id, itemActualizado);
    }

    @PatchMapping("/{id}")
    public ItemLista marcarComprado(@PathVariable Long id, @RequestBody ItemLista cambios) {
        return service.marcarComprado(id, cambios);
    }
}