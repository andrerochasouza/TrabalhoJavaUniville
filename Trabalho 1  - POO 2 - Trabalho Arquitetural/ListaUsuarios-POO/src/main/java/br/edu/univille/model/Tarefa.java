package br.edu.univille.model;

import java.util.Date;

public class Tarefa {

    private int id;
    private String titulo;
    private String texto;
    private final Date dataCriacao = new Date();
    private Date dataConclusao;
    private boolean concluida;
    private Lista lista;

    private Tarefa() {}

    public Tarefa(int id, String titulo, String texto, Lista lista) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.lista = lista;
    }
}
