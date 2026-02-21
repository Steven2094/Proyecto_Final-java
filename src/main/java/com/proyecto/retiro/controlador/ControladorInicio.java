package com.proyecto.retiro.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorInicio {

    @GetMapping("/")
    public String home() {
        return "redirect:/retiros";
    }
}