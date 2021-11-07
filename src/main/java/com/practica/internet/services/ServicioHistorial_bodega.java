package com.practica.internet.services;

import com.practica.internet.entities.Historial_bodega;

import com.practica.internet.repositories.RepositorioHistorial_Bodega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class ServicioHistorial_bodega  implements  ServicioBase<Historial_bodega> {
    @Autowired
    private RepositorioHistorial_Bodega repositorio;
    @Override
    @Transactional
    public List<Historial_bodega> findAll() throws Exception {
        try {
            List<Historial_bodega> historial_bodega = this.repositorio.findAll();
            return historial_bodega;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Historial_bodega findById(long id) throws Exception {
        try {
            Optional<Historial_bodega> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Historial_bodega saveOne(Historial_bodega entity) throws Exception {
        try {
            Historial_bodega historial_bodega = this.repositorio.save(entity);
            return historial_bodega;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Historial_bodega updateOne(Historial_bodega entity, long id) throws Exception {
        try {
            Optional<Historial_bodega> opt = this.repositorio.findById(id);
            Historial_bodega historial_bodega = opt.get();
            historial_bodega = this.repositorio.save(entity);
            return historial_bodega;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Historial_bodega> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Historial_bodega historial_bodega = opt.get();
                // actividad_producto.setActivo(!actividad_producto.isActivo());
                this.repositorio.save(historial_bodega);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
