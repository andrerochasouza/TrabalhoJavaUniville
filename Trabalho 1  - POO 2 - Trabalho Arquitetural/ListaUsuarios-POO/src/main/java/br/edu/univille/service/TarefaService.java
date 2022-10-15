package br.edu.univille.service;

import br.edu.univille.dao.ListaDao;
import br.edu.univille.dao.TarefaDao;
import br.edu.univille.model.Tarefa;

import java.time.LocalDate;
import java.util.Scanner;

public class TarefaService {

    private final TarefaDao tarefaDao;
    private final ListaDao listaDao;
    private final Scanner scan = new Scanner(System.in);

    public TarefaService (TarefaDao tarefaDao, ListaDao listaDao) {
        this.tarefaDao = tarefaDao;
        this.listaDao = listaDao;
    }

    public void adicionarTarefaEmUmaLista() {
        Tarefa tarefa = new Tarefa();
        System.out.println("-------------------");
        System.out.print("Digite o título da tarefa: ");
        tarefa.setTitulo(scan.nextLine());
        System.out.print("Digite o texto da tarefa: ");
        tarefa.setTexto(scan.nextLine());
        System.out.print("Digite o ID da lista que deseja adicionar a tarefa: ");
        tarefa.setLista(listaDao.readOne(scan.nextInt()));
        tarefaDao.create(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
        System.out.println("-------------------");
    }

    public void concluirTarefa() {
        System.out.println("-------------------");
        System.out.print("Digite o ID da tarefa que deseja concluir: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Concluindo a tarefa " + tarefa.getTitulo());
        tarefa.setConcluida(true);
        tarefa.setDataConclusao(LocalDate.now());
        tarefaDao.update(tarefa);
        System.out.println("Tarefa concluída com sucesso!");
        System.out.println("-------------------");
    }

    public void desfazerTarefa() {
        System.out.println("-------------------");
        System.out.print("Digite o ID da tarefa que deseja desfazer: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Desfazendo a tarefa " + tarefa.getTitulo());
        tarefa.setConcluida(false);
        tarefa.setDataConclusao(null);
        tarefaDao.update(tarefa);
        System.out.println("Tarefa desfeita com sucesso!");
        System.out.println("-------------------");
    }

    public void excluirTarefa() {
        System.out.println("-------------------");
        System.out.print("Digite o ID da tarefa que deseja excluir: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Excluindo a tarefa " + tarefa.getTitulo());
        tarefaDao.delete(tarefa.getId());
        System.out.println("Tarefa excluída com sucesso!");
        System.out.println("-------------------");
    }

    public void atualizarTarefa() {
        System.out.println("-------------------");
        System.out.print("Digite o ID da tarefa que deseja atualizar: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Atualizando a tarefa " + tarefa.getTitulo());
        tarefaDao.update(tarefa);
        System.out.println("Tarefa atualizada com sucesso!");
        System.out.println("-------------------");
    }

    public Tarefa listarUmaTarefa() {
        System.out.println("-------------------");
        System.out.print("Digite o ID da tarefa: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        System.out.println("Buscando a tarefa " + idTarefa);
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Tarefa encontrada com sucesso!");
        System.out.println("-------------------");
        return tarefa;
    }
}
