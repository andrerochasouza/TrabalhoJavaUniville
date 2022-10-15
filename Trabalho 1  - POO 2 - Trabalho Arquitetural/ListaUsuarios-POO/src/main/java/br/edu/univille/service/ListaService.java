package br.edu.univille.service;

import br.edu.univille.dao.ListaDao;
import br.edu.univille.model.Lista;
import br.edu.univille.model.Tarefa;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaService {

    private final ListaDao listaDao;
    private final Scanner scan = new Scanner(System.in);

    public ListaService (ListaDao listaDao) {
        this.listaDao = listaDao;
    }

    public void criarLista() {
        Lista lista = new Lista();
        System.out.println("-------------------");
        System.out.println("Digite o título da lista:");
        lista.setTitulo(scan.nextLine());
        listaDao.create(lista);
        System.out.println("Lista criada com sucesso!");
        System.out.println("-------------------");
    }

    public void excluirLista(Lista lista) {
        System.out.println("-------------------");
        System.out.println("Excluindo a lista " + lista.getTitulo() + " (vai excluir todas as tarefas também)");
        listaDao.delete(lista.getId());
        System.out.println("Lista e tarefas excluída com sucesso!");
        System.out.println("-------------------");
    }

    public void atualizarLista(Lista lista) {
        System.out.println("-------------------");
        System.out.println("Atualizando a lista " + lista.getTitulo());
        listaDao.update(lista);
        System.out.println("Lista atualizada com sucesso!");
        System.out.println("-------------------");
    }

    public void listarTodasAsListas() {
        System.out.println("------------------------------");
        System.out.println("Listando todas as listas");
        ArrayList<Lista> listas = listaDao.readAll();
        for (Lista lista : listas) {
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("Lista ID: " + lista.getId());
            System.out.println("Título: " + lista.getTitulo());
            if(lista.getTarefas() != null) {
                for (Tarefa tarefa : lista.getTarefas()) {
                    System.out.println("=========");
                    System.out.println("Tarefa ID: " + tarefa.getId());
                    System.out.println("Título: " + tarefa.getTitulo());
                    System.out.println("Texto: " + tarefa.getTexto());
                    System.out.println("Data de criação: " + tarefa.getDataCriacao());
                    System.out.println("Data de conclusão: " + tarefa.getDataConclusao());
                    System.out.println("Concluída: " + tarefa.isConcluida());
                    System.out.println("=========");
                }
            } else {
                System.out.println("Tarefas: 0");
            }
            System.out.println("++++++++++++++++++++++++++++++");
        }
        System.out.println("------------------------------");
    }

    public void listarUmaListaPeloId(int idLista){
        System.out.println("------------------------------");
        System.out.println("Listando a lista " + idLista);
        Lista lista = listaDao.readOne(idLista);
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Lista ID: " + lista.getId());
        System.out.println("Título: " + lista.getTitulo());
        if(lista.getTarefas() != null) {
            for (Tarefa tarefa : lista.getTarefas()) {
                System.out.println("=========");
                System.out.println("Tarefa ID: " + tarefa.getId());
                System.out.println("Título: " + tarefa.getTitulo());
                System.out.println("Texto: " + tarefa.getTexto());
                System.out.println("Data de criação: " + tarefa.getDataCriacao());
                System.out.println("Data de conclusão: " + tarefa.getDataConclusao());
                System.out.println("Concluída: " + tarefa.isConcluida());
                System.out.println("=========");
            }
        } else {
            System.out.println("Tarefas: 0");
        }
        System.out.println("++++++++++++++++++++++++++++++");
    }

}