package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "actividad_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actividad_producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo;
    private float numero_activo;
    private float cantidad;
    private Date fecha;
    private String detalle;
    private String nombre_persona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_producto", nullable = false)
    private Producto producto;



}
