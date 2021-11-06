package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_departamento;
    private String nombre_departamento;
    private String direccion_departamento;
    private String telefono_departamento;

    @OneToMany(mappedBy = "departamento")
    private List<Actividad_producto> actividad_productos;

    @OneToMany(mappedBy = "departamento")
    private List<Producto> productos;

    @OneToMany(mappedBy = "departamento")
    private List<Empleado> empleados;

}
