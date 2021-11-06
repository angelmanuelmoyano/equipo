package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contacto_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contacto_cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_contacto_cliente;
    private String nombre_contacto;
    private String celular_contacto;
    private String telefono_contacto_cliente;
    private String email_contacto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_cliente", nullable = false)
    private Cliente cliente;
}
