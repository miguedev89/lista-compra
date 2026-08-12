package com.example.listaCompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.listaCompra.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}