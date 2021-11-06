package com.practica.internet.services;

import com.practica.internet.entities.Operador;
import com.practica.internet.repositories.RepositorioOperador;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ServicioOperador  implements  ServicioBase<Operador>{
    @Autowired
    private RepositorioOperador repositorio;
    @Override
    @Transactional
    public List<Operador> findAll() throws Exception {
        try {
            List<Operador> operador = this.repositorio.findAll();
            return operador;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Operador findById(long id) throws Exception {
        try {
            Optional<Operador> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Operador saveOne(Operador entity) throws Exception {
        try {
            Operador operador = this.repositorio.save(entity);
            return operador;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Operador updateOne(Operador entity, long id) throws Exception {
        try {
            Optional<Operador> opt = this.repositorio.findById(id);
            Operador operador = opt.get();
            operador = this.repositorio.save(entity);
            return operador;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Operador> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Operador operador = opt.get();
                // actividad_producto.setActivo(!actividad_producto.isActivo());
                this.repositorio.save(operador);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
