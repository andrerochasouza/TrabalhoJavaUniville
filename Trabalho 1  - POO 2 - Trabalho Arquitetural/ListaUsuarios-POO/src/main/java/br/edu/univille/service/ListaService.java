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
        System.out.print("Digite o título da lista: ");
        lista.setTitulo(scan.nextLine());
        listaDao.create(lista);
        int id = listaDao.getIdByTitulo(lista.getTitulo());
        System.out.println("Lista ID " + id + " criada com sucesso!");
        System.out.println("-------------------");
    }

    public void excluirLista() {
        System.out.println("-------------------");
        System.out.print("Digite o ID da tarefa que deseja excluir: ");
        int idLista = scan.nextInt();
        scan.nextLine();
        Lista lista = listaDao.readOne(idLista);
        System.out.println("Excluindo a lista " + lista.getTitulo() + " (vai excluir todas as tarefas também)");
        listaDao.delete(lista.getId());
        int id = lista.getId();
        System.out.println("Lista ID " + id + " e tarefas excluída com sucesso!");
        System.out.println("-------------------");
    }

    public void excluirTodasAsListas(){
        System.out.println("-------------------");
        System.out.println("Excluindo todas as listas (vai excluir todas as tarefas também)");
        listaDao.deleteAll();
        System.out.println("Todas as listas e tarefas excluídas com sucesso!");
        System.out.println("-------------------");
    }

    public void atualizarLista() {
        System.out.println("-------------------");
        System.out.print("Digite o ID da lista que deseja atualizar: ");
        int idLista = scan.nextInt();
        scan.nextLine();
        Lista lista = listaDao.readOne(idLista);
        System.out.println("Atualizando a lista " + lista.getTitulo());
        listaDao.update(lista);
        int id = lista.getId();
        System.out.println("Lista ID " + id + " atualizada com sucesso!");
        System.out.println("-------------------");
    }

    public void listarTodasAsListas() {
        System.out.println("|------------------------------");
        System.out.println("| Listando todas as listas");
        ArrayList<Lista> listas = listaDao.readAll();
        for (Lista lista : listas) {
            System.out.println("| ++++++++++++++++++++++++++++++");
            System.out.println("| Lista ID: " + lista.getId());
            System.out.println("| Título: " + lista.getTitulo());
            if(lista.getTarefas() != null) {
                for (Tarefa tarefa : lista.getTarefas()) {
                    System.out.println("|=========");
                    System.out.println("| Tarefa ID: " + tarefa.getId());
                    System.out.println("| Título: " + tarefa.getTitulo());
                    System.out.println("| Texto: " + tarefa.getTexto());
                    System.out.println("| Data de criação: " + tarefa.getDataCriacao());
                    System.out.println("| Data de conclusão: " + tarefa.getDataConclusao());
                    System.out.println("| Concluída: " + tarefa.isConcluida());
                    System.out.println("| =========");
                }
            } else {
                System.out.println("| Tarefas: 0");
            }
            System.out.println("| ++++++++++++++++++++++++++++++");
        }
        System.out.println("| ------------------------------");
    }

    public void listarUmaListaPeloId(){
        System.out.println("| ------------------------------");
        System.out.print("| Digite o ID da lista:");
        int idLista = scan.nextInt();
        scan.nextLine();
        System.out.println("| Listando a lista " + idLista);
        Lista lista = listaDao.readOne(idLista);
        System.out.println("| ++++++++++++++++++++++++++++++");
        System.out.println("| Lista ID: " + lista.getId());
        System.out.println("| Título: " + lista.getTitulo());
        if(lista.getTarefas() != null) {
            for (Tarefa tarefa : lista.getTarefas()) {
                System.out.println("| =========");
                System.out.println("| Tarefa ID: " + tarefa.getId());
                System.out.println("| Título: " + tarefa.getTitulo());
                System.out.println("| Texto: " + tarefa.getTexto());
                System.out.println("| Data de criação: " + tarefa.getDataCriacao());
                System.out.println("| Data de conclusão: " + tarefa.getDataConclusao());
                System.out.println("| Concluída: " + tarefa.isConcluida());
                System.out.println("| =========");
            }
        } else {
            System.out.println("| Tarefas: 0");
        }
        System.out.println("| ++++++++++++++++++++++++++++++");
    }

}
