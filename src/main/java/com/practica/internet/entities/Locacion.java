package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Locacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_locacion;
    private String sector;
    private String calle_principal;
    private String calle_secundaria;
    private String numero;
    private String referencia_cliente;
    private String nombre_edificio;
    private int piso;
    private String oficina;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_cantones", nullable = false)
    private Cantones cantones;

    @OneToMany(mappedBy = "locacion")
    private List<Asignacion_actividad> asignacion_actividads;
}
