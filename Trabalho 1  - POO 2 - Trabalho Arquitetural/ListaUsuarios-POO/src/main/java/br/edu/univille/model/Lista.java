package br.edu.univille.model;

import java.util.ArrayList;
import java.util.Date;

public class Lista {

    private int id;
    private String nome;
    private final Date dataCriacao = new Date();
    private Date dataExclusao;
    private boolean excluida;
    private ArrayList<Tarefa> tarefas;

    private Lista() {}

    public Lista(int id, String nome, Date dataExclusao, boolean excluida) {
        this.id = id;
        this.nome = nome;
        this.dataExclusao = dataExclusao;
        this.excluida = excluida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCriacao() {
        return dataCriacao;
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
