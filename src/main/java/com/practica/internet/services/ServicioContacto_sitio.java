package com.practica.internet.services;

import com.practica.internet.entities.Cliente;
import com.practica.internet.entities.Contacto_sitio;
import com.practica.internet.repositories.RepositorioContacto_sitio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioContacto_sitio implements ServicioBase<Contacto_sitio> {
    @Autowired
    private RepositorioContacto_sitio repositorio;

    @Override
    @Transactional
    public List<Contacto_sitio> findAll() throws Exception {
        try {
            List<Contacto_sitio> contacto_sitios = this.repositorio.findAll();
            return contacto_sitios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Contacto_sitio findById(long id) throws Exception {
        try {
            Optional<Contacto_sitio> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Contacto_sitio saveOne(Contacto_sitio entity) throws Exception {
        try {
            Contacto_sitio contacto_sitio = this.repositorio.save(entity);
            return contacto_sitio;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Contacto_sitio updateOne(Contacto_sitio entity, long id) throws Exception {
        try {
            Optional<Contacto_sitio> opt = this.repositorio.findById(id);
            Contacto_sitio contacto_sitio = opt.get();
            contacto_sitio = this.repositorio.save(entity);
            return contacto_sitio;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Contacto_sitio> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Contacto_sitio contacto_sitio = opt.get();
                //cliente.setActivo(!cliente.isActivo());
                this.repositorio.save(contacto_sitio);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
