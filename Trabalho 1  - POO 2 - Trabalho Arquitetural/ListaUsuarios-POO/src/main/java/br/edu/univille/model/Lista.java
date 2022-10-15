package br.edu.univille.model;

import java.util.ArrayList;
import java.util.Date;

public class Lista {

    private int id;
    private String titulo;
    private Date dataCriacao;
    private Date dataExclusao;
    private boolean excluida;
    private ArrayList<Tarefa> tarefas;

    public Lista() {}

    public Lista(int id, String titulo, Date dataExclusao, boolean excluida, ArrayList<Tarefa> tarefas) {
        this.id = id;
        this.titulo = titulo;
        this.dataCriacao = new Date();
        this.dataExclusao = dataExclusao;
        this.excluida = excluida;
        this.tarefas = tarefas;
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
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
