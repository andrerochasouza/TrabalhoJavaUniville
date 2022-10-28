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

        TarefaService tarefaService = new TarefaService(tarefaDao);
        ListaService listaService = new ListaService(listaDao);


    }
}
