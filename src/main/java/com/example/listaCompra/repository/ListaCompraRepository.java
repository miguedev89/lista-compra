package com.example.listaCompra.repository;


import com.example.listaCompra.model.ListaCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaCompraRepository extends JpaRepository<ListaCompra, Long> {
}