package com.practica.internet.controllers;

import com.practica.internet.entities.Asignacion_actividad;
import com.practica.internet.entities.Cliente;
import com.practica.internet.services.ServicioAsignacion_actividad;
import com.practica.internet.services.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class controladorAsignarActividad {

    @Autowired
    private ServicioAsignacion_actividad svcAsignacion_actividad;

    @GetMapping("/clientes")
    public String listarAsignaciones(Model model){
        try {
            List<Asignacion_actividad> asignacion_actividad = this.svcAsignacion_actividad.findAll();
            model.addAttribute("asignacion_actividad",asignacion_actividad);
            return "views/listado_asignaciones";
        }catch(Exception e){
            //model.addAttribute("error", e.getMessage());
            return "views/inicio";
        }
    }
    @GetMapping("/cliente/{id}")
    public String formularioAsignaciones(Model model,@PathVariable("id")long id){
        try {
            if(id==0){
                model.addAttribute("asignacion_actividad",new Asignacion_actividad());
            }else{
                model.addAttribute("asignacion_actividad",this.svcAsignacion_actividad.findById(id));
            }
            return "views/registrar_asignacion";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "views/error";
        }
    }


    @PostMapping("/asignacion/{id}")
    public String guardarAsignacion(
            @ModelAttribute("asignacion_actividad") Asignacion_actividad asignacion_actividad,
            Model model,@PathVariable("id")long id
    ) {

        try {
            if(id==0){

                this.svcAsignacion_actividad.saveOne(asignacion_actividad);
            }else{

                this.svcAsignacion_actividad.updateOne(asignacion_actividad,id);
            }
            return "views/listado_asignaciones";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());

            return "error";
        }
    }

}
