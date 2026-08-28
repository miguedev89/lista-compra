package com.example.listaCompra.service;

import com.example.listaCompra.model.ItemLista;
import com.example.listaCompra.model.ListaCompra;
import com.example.listaCompra.repository.ItemListaRepository;
import com.example.listaCompra.repository.ListaCompraRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemListaService {

    private final ItemListaRepository repository;
    private final ListaCompraRepository listaCompraRepository;

    public ItemListaService(ItemListaRepository repository, ListaCompraRepository listaCompraRepository) {
        this.repository = repository;
        this.listaCompraRepository = listaCompraRepository;
    }

    public List<ItemLista> listarItems() {
        return repository.findAll();
    }

    public ItemLista crearItem(Long listaId, ItemLista item) {
        ListaCompra lista = listaCompraRepository.findById(listaId)
                .orElseThrow(() -> new RuntimeException("Lista no encontrada"));
        item.setListaCompra(lista);
        return repository.save(item);
    }

    public void borrarItem(Long id) {
        repository.deleteById(id);
    }

    public ItemLista actualizarItem(Long id, ItemLista itemActualizado) {
        ItemLista item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));
        item.setNombre(itemActualizado.getNombre());
        item.setComprado(itemActualizado.isComprado());
        return repository.save(item);
    }

    public ItemLista marcarComprado(Long id, ItemLista cambios) {
        ItemLista item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));
        if (cambios.getNombre() != null) {
            item.setNombre(cambios.getNombre());
        }
        item.setComprado(cambios.isComprado());
        return repository.save(item);
    }
}