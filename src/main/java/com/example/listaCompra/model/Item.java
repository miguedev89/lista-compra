package com.example.listaCompra.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String cantidad;

    private boolean comprado = false;

    private Long compradoPorId;

    private LocalDateTime fechaMarcado;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCantidad() { return cantidad; }
    public void setCantidad(String cantidad) { this.cantidad = cantidad; }
    public boolean isComprado() { return comprado; }
    public void setComprado(boolean comprado) { this.comprado = comprado; }
    public Long getCompradoPorId() { return compradoPorId; }
    public void setCompradoPorId(Long compradoPorId) { this.compradoPorId = compradoPorId; }
    public LocalDateTime getFechaMarcado() { return fechaMarcado; }
    public void setFechaMarcado(LocalDateTime fechaMarcado) { this.fechaMarcado = fechaMarcado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }}
