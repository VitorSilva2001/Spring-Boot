package com.evento.eventoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.evento.eventoapp.Modelos.Convidado;
import com.evento.eventoapp.Modelos.Evento;
import com.evento.eventoapp.Repositorio.RepositorioDoConvidado;
import com.evento.eventoapp.Repositorio.RepositorioDoEvento;

import jakarta.validation.Valid;

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
        Iterable<Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados", convidados);
        return mv;
   }
   @RequestMapping(value="/{codigo}", method=RequestMethod.POST)
   public String detalhesEventoPost(@PathVariable("codigo") long codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verificar campos obrigatorios");
            return "redirect:/{codigo}";       
        }
        Evento evento = er.findByCodigo(codigo);
        convidado.setEvento(evento);
        cr.save(convidado);
        attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso");
        return "redirect:/{codigo}";
   }
}
