package com.example.listaCompra.controller;

import com.example.listaCompra.model.ListaCompra;
import com.example.listaCompra.model.Usuario;
import com.example.listaCompra.repository.ListaCompraRepository;
import com.example.listaCompra.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class ListaCompraController {

    // Repositorio para acceder a las listas de compra (CRUD básico)
    private final ListaCompraRepository repository;

    // Repositorio para acceder a los usuarios, necesario para poder
    // buscar un usuario cuando lo vayamos a añadir como miembro de una lista
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Constructor: Spring inyecta automáticamente ListaCompraRepository aquí
    public ListaCompraController(ListaCompraRepository repository) {
        this.repository = repository;
    }

    // Responde a GET /api/listas
    // Devuelve todas las listas de compra guardadas
    @GetMapping
    public List<ListaCompra> listarListas() {
        return repository.findAll();
    }

    // Responde a POST /api/listas
    // Crea una nueva lista de compra a partir del JSON recibido
    // (puede incluir "usuarioPropietario": {"id": X} para asignar dueño)
    @PostMapping
    public ListaCompra crearLista(@RequestBody ListaCompra lista) {
        return repository.save(lista);
    }

    // Responde a GET /api/listas/{id}
    // Devuelve una lista de compra concreta, con sus items y datos del propietario
    @GetMapping("/{id}")
    public ListaCompra obtenerLista(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Responde a PATCH /api/listas/{listaId}/miembros/{usuarioId}
    // Añade un usuario existente como miembro de una lista existente
    // (relación @ManyToMany entre ListaCompra y Usuario)
    @PatchMapping("/{listaId}/miembros/{usuarioId}")
    public ListaCompra anadirMiembro(@PathVariable Long listaId, @PathVariable Long usuarioId) {
        // Buscamos la lista por su id (repository = ListaCompraRepository)
        ListaCompra lista = repository.findById(listaId).orElse(null);

        // Buscamos el usuario por su id (usuarioRepository = UsuarioRepository)
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        // Solo añadimos el miembro si ambos existen realmente en la base de datos
        if (lista != null && usuario != null) {
            lista.getMiembros().add(usuario);
            // save() actualiza la lista en la base de datos con el nuevo miembro
            return repository.save(lista);
        }

        // Si la lista o el usuario no existen, no hacemos nada
        return null;
    }
}
