package com.practica.internet.services;


import com.practica.internet.entities.Provincias;
import com.practica.internet.repositories.RepositorioProvincias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class ServicioProvincias implements ServicioBase<Provincias> {

    @Autowired
    private RepositorioProvincias repositorio;
    @Override
    @Transactional
    public List<Provincias> findAll() throws Exception {
        try {
            List<Provincias> provincias = this.repositorio.findAll();
            return provincias;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provincias findById(long id) throws Exception {
        try {
            Optional<Provincias> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provincias saveOne(Provincias entity) throws Exception {
        try {
            Provincias provincias = this.repositorio.save(entity);
            return provincias;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provincias updateOne(Provincias entity, long id) throws Exception {
        try {
            Optional<Provincias> opt = this.repositorio.findById(id);
            Provincias provincias = opt.get();
            provincias = this.repositorio.save(entity);
            return provincias;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Provincias> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Provincias provincias = opt.get();
                // actividad_producto.setActivo(!actividad_producto.isActivo());
                this.repositorio.save(provincias);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
