package com.evento.eventoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evento.eventoapp.Modelos.Evento;
import com.evento.eventoapp.Repositorio.RepositorioDoEvento;

@Controller
public class ControladorDoEvento {

    @Autowired
    private RepositorioDoEvento er;

    @RequestMapping(value="/cadastroDoEvento", method=RequestMethod.GET)
	public String form(){
		return "Evento/formularioDoEvento";
	}

    @RequestMapping(value="/cadastroDoEvento", method=RequestMethod.POST)
    public String form(Evento evento){
        er.save(evento);
        return "redirect:/cadastroDoEvento";
    }
   @RequestMapping ("/eventos")
   public ModelAndView listaEventos(){
    ModelAndView mv = new ModelAndView("index");
    Iterable<Evento> eventos = er.findAll();
    mv.addObject("eventos", eventos);
    return mv;
   }
}
