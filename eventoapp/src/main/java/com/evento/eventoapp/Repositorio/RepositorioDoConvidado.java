package com.evento.eventoapp.Repositorio;

import org.springframework.data.repository.CrudRepository;

import com.evento.eventoapp.Modelos.Convidado;
import com.evento.eventoapp.Modelos.Evento;

public interface RepositorioDoConvidado extends CrudRepository <Convidado, String>{
    Iterable <Convidado> findByEvento(Evento evento);
}
