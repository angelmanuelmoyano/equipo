package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "canton")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cantones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_canton;
    private String canton;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kf_provincias", nullable = false)
    private Provincias provincias;

    @OneToMany(mappedBy = "cantones")
    private List<Locacion> locacions;
}
