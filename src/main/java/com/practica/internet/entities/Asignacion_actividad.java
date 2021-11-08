package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "asignacion_actividad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asignacion_actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date start;
    private Date end;
    private String cumplimiento;
    private int editar;
    private String observaciones;
    private String extras;
    private String empleadoSecundario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_actividad", nullable = false)
    private Actividad actividad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "asignacion_actividad")
    private List<Contacto_sitio> contacto_sitio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_empleado", nullable = false)
    private Empleado empleado;

}
