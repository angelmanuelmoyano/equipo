package com.practica.internet.controllers;

import com.practica.internet.services.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controladorEmpleado {
    //@Autowired
    //private ServicioEmpleado svcEmpleado;

    @GetMapping
    public String inicio(Model model) {
        try {
            return "views/inicio";
        } catch (Exception e) {
            return "error";
        }
    }
}
