package br.edu.univille.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Lista {

    private int id;
    private String titulo;
    private LocalDate dataCriacao;

    private boolean excluida;
    private ArrayList<Tarefa> tarefas;

    public Lista() {}

    public Lista(int id, String titulo, boolean excluida, ArrayList<Tarefa> tarefas) {
        this.id = Objects.isNull(id) ? 0 : id;
        this.titulo = Objects.isNull(titulo) ? "" : titulo;
        this.dataCriacao = LocalDate.now();
        this.excluida = Objects.isNull(excluida) ? false : excluida;
        this.tarefas = Objects.isNull(tarefas) ? new ArrayList<Tarefa>() : tarefas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isExcluida() {
        return excluida;
    }

    public void setExcluida(boolean excluida) {
        this.excluida = excluida;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
