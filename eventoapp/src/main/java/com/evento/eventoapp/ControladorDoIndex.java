package com.evento.eventoapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Controlador
public class ControladorDoIndex {

    @RequestMapping("/") // Usar / ira trazer o index da pagina
    public String index(){
        return "index";
    }
}
