package br.edu.univille;

import br.edu.univille.dao.ListaDao;
import br.edu.univille.dao.TarefaDao;
import br.edu.univille.service.ListaService;
import br.edu.univille.service.TarefaService;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        TarefaService tarefaService = new TarefaService(new TarefaDao(), new ListaDao());
        ListaService listaService = new ListaService(new ListaDao());



    }
}
