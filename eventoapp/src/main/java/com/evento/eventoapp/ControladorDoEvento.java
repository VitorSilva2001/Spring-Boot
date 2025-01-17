package com.evento.eventoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evento.eventoapp.Modelos.Convidado;
import com.evento.eventoapp.Modelos.Evento;
import com.evento.eventoapp.Repositorio.RepositorioDoConvidado;
import com.evento.eventoapp.Repositorio.RepositorioDoEvento;

@Controller
public class ControladorDoEvento {

    @Autowired
    private RepositorioDoEvento er;
    @Autowired
    private RepositorioDoConvidado cr;
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
   @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
   public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);
        return mv;
   }
   @RequestMapping(value="/{codigo}", method=RequestMethod.POST)
   public String detalhesEventoPost(@PathVariable("codigo") long codigo, Convidado convidado){
        Evento evento = er.findByCodigo(codigo);
        convidado.setEvento(evento);
        cr.save(convidado);
        return "redirect:/{codigo}";
   }
}
