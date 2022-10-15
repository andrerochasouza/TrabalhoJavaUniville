package br.edu.univille.model;

import java.util.Date;

public class Tarefa {

    private int id;
    private String titulo;
    private String texto;
    private Date dataCriacao;
    private Date dataConclusao;
    private boolean concluida;
    private Lista lista;

    public Tarefa() {}

    public Tarefa(int id, String titulo, String texto, Date dataConclusao, boolean concluida, Lista lista) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.dataCriacao = new Date();
        this.dataConclusao = dataConclusao;
        this.concluida = concluida;
        this.lista = lista;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
