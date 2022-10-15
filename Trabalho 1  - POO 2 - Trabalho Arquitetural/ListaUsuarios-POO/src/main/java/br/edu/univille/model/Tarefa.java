package br.edu.univille.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Tarefa {

    private int id;
    private String titulo;
    private String texto;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    private boolean concluida;
    private Lista lista;

    public Tarefa() {}

    public Tarefa(int id, String titulo, String texto, LocalDate dataConclusao, boolean concluida, Lista lista) {
        this.id = Objects.isNull(id) ? 0 : id;
        this.titulo = Objects.isNull(titulo) ? "" : titulo;
        this.texto = Objects.isNull(texto) ? "" : texto;
        this.dataCriacao = LocalDate.now();;
        this.dataConclusao = dataConclusao;
        this.concluida = Objects.isNull(concluida) ? false : concluida;
        this.lista = Objects.isNull(lista) ? new Lista() : lista;
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
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
