package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial_bodega")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Historial_bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_historial;
    private String usuario;
    private String num_serie;
    private String nombte_producto;
    private String num_activo;
    private float cantidad;
    private Date fecha_accion;
    private String tipo_transaccion;
    private String accion;
}
