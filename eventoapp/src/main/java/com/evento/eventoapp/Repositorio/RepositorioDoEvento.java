package com.evento.eventoapp.Repositorio;

import org.springframework.data.repository.CrudRepository;

import com.evento.eventoapp.Modelos.Evento;

public interface RepositorioDoEvento extends CrudRepository<Evento, String>{

}
