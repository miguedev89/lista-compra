package com.example.listaCompra.controller;

import com.example.listaCompra.model.ItemLista;
import com.example.listaCompra.model.ListaCompra;

import java.util.List;

import com.example.listaCompra.repository.ItemListaRepository;
import com.example.listaCompra.repository.ListaCompraRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemListaController {

    private final ItemListaRepository repository;
    private final ListaCompraRepository listaCompraRepository;

    public ItemListaController(ItemListaRepository repository, ListaCompraRepository listaCompraRepository) {
        this.repository = repository;
        this.listaCompraRepository = listaCompraRepository;
    }

    @GetMapping
    public List<ItemLista> listarItems() {
        return repository.findAll();
    }

    @PostMapping("/lista/{listaId}")
    public ItemLista crearItem(@PathVariable Long listaId, @RequestBody ItemLista item) {
        ListaCompra lista = listaCompraRepository.findById(listaId)
                .orElseThrow(() -> new RuntimeException("Lista no encontrada"));

        item.setListaCompra(lista);
        return repository.save(item);
    }

    @DeleteMapping("/{id}")
    public void borrarItem(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ItemLista actualizarItem(@PathVariable Long id, @RequestBody ItemLista itemActualizado) {
        ItemLista item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));

        item.setNombre(itemActualizado.getNombre());
        item.setComprado(itemActualizado.isComprado());

        return repository.save(item);
    }

    @PatchMapping("/{id}")
    public ItemLista marcarComprado(@PathVariable Long id, @RequestBody ItemLista cambios) {
        ItemLista item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));

        if (cambios.getNombre() != null) {
            item.setNombre(cambios.getNombre());
        }
        item.setComprado(cambios.isComprado());

        return repository.save(item);
    }

}