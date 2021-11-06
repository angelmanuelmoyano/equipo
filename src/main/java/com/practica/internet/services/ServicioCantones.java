package com.practica.internet.services;

import com.practica.internet.entities.Cantones;

import com.practica.internet.repositories.RepositorioCantones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCantones implements ServicioBase<Cantones> {
    @Autowired
    private RepositorioCantones repositorio;

    @Override
    @Transactional
    public List<Cantones> findAll() throws Exception {
        try {
            List<Cantones> cantones = this.repositorio.findAll();
            return cantones;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Cantones findById(long id) throws Exception {
        try {
            Optional<Cantones> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override

    public Cantones saveOne(Cantones entity) throws Exception {
        try {
            Cantones cantones = this.repositorio.save(entity);
            return cantones;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cantones updateOne(Cantones entity, long id) throws Exception {
        try {
            Optional<Cantones> opt =this.repositorio.findById(id);
            Cantones cantones = opt.get();
            return cantones;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Cantones> opt = this.repositorio.findById(id);
            if(!opt.isEmpty()) {
                Cantones cantones = opt.get();
                //cantones.setActivo(!cantones.isActvo());
                this.repositorio.save(cantones);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
