package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provincias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Provincias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String provincia;

    @OneToMany(mappedBy = "provincias")
    private List<Departamento> departamentos;
}
