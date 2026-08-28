package com.example.listaCompra.service;

import com.example.listaCompra.model.ListaCompra;
import com.example.listaCompra.model.Usuario;
import com.example.listaCompra.repository.ListaCompraRepository;
import com.example.listaCompra.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaCompraService {

    private final ListaCompraRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ListaCompraService(ListaCompraRepository repository) {
        this.repository = repository;
    }

    public List<ListaCompra> listarListas() {
        return repository.findAll();
    }

    public ListaCompra crearLista(ListaCompra lista) {
        return repository.save(lista);
    }

    public ListaCompra obtenerLista(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ListaCompra anadirMiembro(Long listaId, Long usuarioId) {
        ListaCompra lista = repository.findById(listaId).orElse(null);
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (lista != null && usuario != null) {
            lista.getMiembros().add(usuario);
            return repository.save(lista);
        }
        return null;
    }
}