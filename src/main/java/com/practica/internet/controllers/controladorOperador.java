package com.practica.internet.controllers;

import com.practica.internet.entities.Operador;
import com.practica.internet.services.ServicioOperador;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class controladorOperador {
    @Autowired
    private ServicioOperador svcOperador;

    @GetMapping("/operadores")
    public String listarOperadores(Model model){
        try {
            List<Operador> operadores = this.svcOperador.findAll();
            model.addAttribute("operadores",operadores);
            return "views/listado_operadores";
        }catch(Exception e){
            //model.addAttribute("error", e.getMessage());
            return "views/inicio";
        }
    }
    @GetMapping("/formularios/operador/{id}")
    public String formularioOperador(Model model,@PathVariable("id")long id){
        try {
            if(id==0){
                model.addAttribute("operador",new Operador());
            }else{
                model.addAttribute("operador",this.svcOperador.findById(id));
            }
            return "views/formularios/operador";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "views/error";
        }
    }


    @PostMapping("/formularios/operador/{id}")
    public String guardarOperador(
            @ModelAttribute("operador") Operador operador,
            Model model,@PathVariable("id")long id
    ) {

        try {
           if(id==0){

                this.svcOperador.saveOne(operador);
            }else{

                this.svcOperador.updateOne(operador,id);
            }
            return "redirect:/views/listado_operadores";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "views/error";
        }
    }


}
