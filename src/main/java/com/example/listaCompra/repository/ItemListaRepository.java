package com.example.listaCompra.repository;

import com.example.listaCompra.model.ItemLista;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemListaRepository extends JpaRepository<ItemLista, Long> {
}
