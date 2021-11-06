package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_producto;
    private String descripcion;
    private String serie;
    private float cantidad;
    private String unidad;
    private Date producto_creado;
    private Date producto_editado;

    @OneToMany(mappedBy = "producto")
    private List<Actividad_producto> actividad_productos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_departamento", nullable = false)
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_operador", nullable = false)
    private Operador operador;
}
