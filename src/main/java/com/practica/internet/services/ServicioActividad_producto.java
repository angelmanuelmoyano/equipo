package com.practica.internet.services;
import com.practica.internet.entities.Actividad_producto;
import com.practica.internet.repositories.RepositorioActividad_producto;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ServicioActividad_producto  implements ServicioBase<Actividad_producto>{

    @Autowired
    private RepositorioActividad_producto repositorio;

    @Override
    @Transactional
    public List<Actividad_producto> findAll() throws Exception {
        try {
            List<Actividad_producto> actividad_producto = this.repositorio.findAll();
            return actividad_producto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Actividad_producto findById(long id) throws Exception {
        try {
            Optional<Actividad_producto> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Actividad_producto saveOne(Actividad_producto entity) throws Exception {
        try {
            Actividad_producto actividad_producto = this.repositorio.save(entity);
            return actividad_producto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Actividad_producto updateOne(Actividad_producto entity, long id) throws Exception {
        try {
            Optional<Actividad_producto> opt = this.repositorio.findById(id);
            Actividad_producto actividad_producto = opt.get();
            actividad_producto = this.repositorio.save(entity);
            return actividad_producto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Actividad_producto> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Actividad_producto actividad_producto = opt.get();
               // actividad_producto.setActivo(!actividad_producto.isActivo());
                this.repositorio.save(actividad_producto);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
