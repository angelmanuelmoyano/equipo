package com.practica.internet.services;

import com.practica.internet.repositories.RepositorioLocacion;
import org.springframework.beans.factory.annotation.Autowired;
import com.practica.internet.entities.Locacion;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ServicioLocacion  implements ServicioBase<Locacion>{

    @Autowired
    private RepositorioLocacion repositorio;
    @Override
    @Transactional
    public List<Locacion> findAll() throws Exception {
        try {
            List<Locacion> locacion = this.repositorio.findAll();
            return locacion;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Locacion findById(long id) throws Exception {
        try {
            Optional<Locacion> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Locacion saveOne(Locacion entity) throws Exception {
        try {
            Locacion locacion = this.repositorio.save(entity);
            return locacion;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Locacion updateOne(Locacion entity, long id) throws Exception {
        try {
            Optional<Locacion> opt = this.repositorio.findById(id);
            Locacion locacion = opt.get();
            locacion = this.repositorio.save(entity);
            return locacion;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Locacion> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Locacion locacion = opt.get();
                // actividad_producto.setActivo(!actividad_producto.isActivo());
                this.repositorio.save(locacion);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

