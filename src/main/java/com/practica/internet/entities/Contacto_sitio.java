package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contacto_sitio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contacto_sitio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_contacto_sitio;

    private String contacto_sitio;
    private String celular_contacto_sitio;
    private String telefono_contacto_sitio;
    private String email_contacto_sitio;
    private String email_contacto_sitio_2;
    private String email_contacto_sitio_3;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_asignacion_actividad")
    private Asignacion_actividad asignacion_actividad;
}
