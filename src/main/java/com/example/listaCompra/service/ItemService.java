package com.example.listaCompra.service;
import com.example.listaCompra.model.ItemLista;
import com.example.listaCompra.repository.ItemListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemListaRepository itemRepository;

    public List<ItemLista> listarItems() {
        return itemRepository.findAll();
    }
}

