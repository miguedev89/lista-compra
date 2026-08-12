package com.example.listaCompra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.listaCompra.model.Usuario;
import com.example.listaCompra.repository.UsuarioRepository;

// @RestController le dice a Spring que esta clase expone endpoints REST
// (las respuestas se devuelven como JSON automáticamente, sin necesidad
// de vistas HTML)
@RestController

// Prefijo común para todas las rutas de este controller.
// Cada método de abajo se añade a continuación de esta ruta base.
@RequestMapping("/api/usuarios")
public class UsuarioController {

    // Spring inyecta automáticamente una instancia de UsuarioRepository
    // aquí, sin que tengamos que hacer "new UsuarioRepository()" a mano
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Responde a GET /api/usuarios
    // Devuelve la lista completa de usuarios guardados en la base de datos
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Responde a GET /api/usuarios/{id}, por ejemplo /api/usuarios/3
    // @PathVariable coge el valor {id} de la URL y lo pasa como parámetro
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        // findById devuelve un Optional<Usuario> (puede que no exista ese id)
        // .orElse(null) dice: si no lo encuentra, devuelve null en vez de fallar
        return usuarioRepository.findById(id).orElse(null);
    }

    // Responde a POST /api/usuarios
    // @RequestBody convierte el JSON que llega en el cuerpo de la petición
    // en un objeto Usuario automáticamente (Spring lo mapea por los nombres
    // de los campos: "nombre", "email", etc.)
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        // save() guarda el usuario en la base de datos (INSERT) y
        // devuelve el mismo objeto ya con el id generado
        return usuarioRepository.save(usuario);
    }
}

