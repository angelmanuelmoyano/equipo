package com.practica.internet.controllers;
import com.practica.internet.entities.Producto;
import com.practica.internet.services.ServicioProducto;
import com.practica.internet.services.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario svcUsuario;

    @PostMapping("/validar_username/{username}/{password}")
    public String validarUsuario(Model model ,@PathVariable("username")String username,@PathVariable("password")String password){
        try {
            Usuario usuario = this.svcUsuario.validarUsername(username,password);
            model.addAttribute("usuario",usuario);
            return "views/inicio";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
