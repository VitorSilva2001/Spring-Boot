package com.evento.eventoapp.Modelos;

public class Evento { //Criaçao dos Get/Set que seram usados para receber dados do usuario

    private String nome;
    private String local;
    private String data;
    private String horarioDeInicio;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHorarioDeInicio() {
        return horarioDeInicio;
    }
    public void setHorarioDeInicio(String horarioDeInicio) {
        this.horarioDeInicio = horarioDeInicio;
    }

    
}
