package com.practica.internet.services;

import com.practica.internet.entities.Contacto_sitio;
import com.practica.internet.entities.Departamento;
import com.practica.internet.repositories.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioDepartamento implements ServicioBase<Departamento> {
    @Autowired
    private RepositorioDepartamento repositorio;

    @Override
    @Transactional
    public List<Departamento> findAll() throws Exception {
        try {
            List<Departamento> departamentos = this.repositorio.findAll();
            return departamentos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Departamento findById(long id) throws Exception {
        try {
            Optional<Departamento> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Departamento saveOne(Departamento entity) throws Exception {
        try {
            Departamento departamento = this.repositorio.save(entity);
            return departamento;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Departamento updateOne(Departamento entity, long id) throws Exception {
        try {
            Optional<Departamento> opt = this.repositorio.findById(id);
            Departamento departamento = opt.get();
            departamento = this.repositorio.save(entity);
            return departamento;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Departamento> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Departamento departamento = opt.get();
                //cliente.setActivo(!cliente.isActivo());
                this.repositorio.save(departamento);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
