package com.practica.internet.services;

import com.practica.internet.entities.Actividad;
import com.practica.internet.entities.Contacto_cliente;
import com.practica.internet.repositories.RepositorioContacto_cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioContacto_cliente implements ServicioBase<Contacto_cliente> {
    @Autowired
    private RepositorioContacto_cliente repositorio;

    @Override
    @Transactional
    public List<Contacto_cliente> findAll() throws Exception {
        try {
            List<Contacto_cliente> contacto_clientes = this.repositorio.findAll();
            return contacto_clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Contacto_cliente findById(long id) throws Exception {
        try {
            Optional<Contacto_cliente> opt =this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Contacto_cliente saveOne(Contacto_cliente entity) throws Exception {
        try {
            Contacto_cliente contacto_cliente = this.repositorio.save(entity);
            return contacto_cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Contacto_cliente updateOne(Contacto_cliente entity, long id) throws Exception {
        try {
            Optional<Contacto_cliente> opt = this.repositorio.findById(id);
            Contacto_cliente contacto_cliente = opt.get();
            contacto_cliente =this.repositorio.save(entity);
            return contacto_cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Contacto_cliente> opt =this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Contacto_cliente contacto_cliente = opt.get();
                //actividad.setActivo(!actividad.isActivo());
                this.repositorio.save(contacto_cliente);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
