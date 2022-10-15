package br.edu.univille;

import br.edu.univille.dao.ListaDao;
import br.edu.univille.dao.TarefaDao;
import br.edu.univille.service.ListaService;
import br.edu.univille.service.TarefaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ListaDao listaDao = new ListaDao();
        TarefaDao tarefaDao = new TarefaDao();
        final Scanner scan = new Scanner(System.in);
        TarefaService tarefaService = new TarefaService(tarefaDao, listaDao);
        ListaService listaService = new ListaService(listaDao);

        int aux = 0;

        while(true){

            System.out.println("-------------------------------------");
            System.out.println("| 1  - Criar Lista                  |");
            System.out.println("| 2  - Criar Tarefa em uma Lista    |");
            System.out.println("| 3  - Ver uma Lista pelo ID        |");
            System.out.println("| 4  - Ver todas as listas          |");
            System.out.println("| 5  - Ver uma tarefa pelo ID       |");
            System.out.println("| 6  - Concluir uma tarefa pelo ID  |");
            System.out.println("| 7  - Desfazer uma tarefa pelo ID  |");
            System.out.println("| 8  - Atualizar uma lista pelo ID  |");
            System.out.println("| 9  - Atualizar uma tarefa pelo ID |");
            System.out.println("| 10 - Excluir uma lista pelo ID    |");
            System.out.println("| 11 - Excluir uma tarefa pelo ID   |");
            System.out.println("| 12 - Excluir todas as listas      |");
            System.out.println("| 13 - Sair do programa             |");
            System.out.println("-------------------------------------");
            System.out.print("Digite a opção desejada: ");
            aux = scan.nextInt();
            scan.nextLine();

            switch (aux){
                case 1:
                    listaService.criarLista();
                    break;
                case 2:
                    tarefaService.adicionarTarefaEmUmaLista();
                    break;
                case 3:
                    listaService.listarUmaListaPeloId();
                    break;
                case 4:
                    listaService.listarTodasAsListas();
                    break;
                case 5:
                    tarefaService.listarUmaTarefa();
                    break;
                case 6:
                    tarefaService.concluirTarefa();
                    break;
                case 7:
                    tarefaService.desfazerTarefa();
                    break;
                case 8:
                    listaService.atualizarLista();
                    break;
                case 9:
                    tarefaService.atualizarTarefa();
                    break;
                case 10:
                    listaService.excluirLista();
                    break;
                case 11:
                    tarefaService.excluirTarefa();
                    break;
                case 12:
                    listaService.excluirTodasAsListas();
                    break;
                case 13:
                    scan.close();
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
