package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_empleado;
    private String nombre_empleado;
    private String apellido_empleado;
    private String email_empleado;
    private String username;
    private String password;
    private String role;
    private int is_active;
    private Date fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String celular;
    private String cedula;
    private String estado_civil;
    private String tipo_sangre;
    private String cuenta_bancaria;
    private String entidad_financiera;
    private String contrasena_temporal;
    private String nombre_contacto_emergencia;
    private String telefono_contacto_emergencia;
    private String celular_contacto_emergencia;
    private Date usuario_creado;
    private Date usuario_editado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_departamento", nullable = false)
    private Departamento departamento;

    @OneToMany(mappedBy = "empleado")
    private List<Asignacion_actividad> asignacion_actividads;





}
