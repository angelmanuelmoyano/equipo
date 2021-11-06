package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "operador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_operador;
    private String operador;
    private String ruc;
    private String direccion;
    private String telefono;
    private Date operador_creado;
    private Date operador_editado;

    @OneToMany(mappedBy = "operador")
    private List<Asignacion_actividad> asignacion_actividads;

    @OneToMany(mappedBy = "operador")
    private List<Producto> productos;
}
