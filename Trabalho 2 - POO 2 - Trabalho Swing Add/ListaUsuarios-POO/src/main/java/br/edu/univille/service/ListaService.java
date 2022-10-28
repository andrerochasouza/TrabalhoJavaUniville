package br.edu.univille.service;

import br.edu.univille.dao.ListaDao;
import br.edu.univille.model.Lista;

import java.util.ArrayList;

public class ListaService {

    private final ListaDao listaDao;

    public ListaService (ListaDao listaDao) {
        this.listaDao = listaDao;
    }

    public void criarLista(Lista lista) {
        listaDao.create(lista);
    }

    public void excluirLista(int idLista) {
        Lista lista = listaDao.readOne(idLista);
        listaDao.delete(lista.getId());
    }

    public void excluirTodasAsListas(){
        listaDao.deleteAll();
    }

    public void atualizarLista(Lista listaNew) {
        listaDao.update(listaNew);
    }

    public void listarTodasAsListas() {
        ArrayList<Lista> listas = listaDao.readAll();
    }

    public void listarUmaListaPeloId(int idLista){
        Lista lista = listaDao.readOne(idLista);
    }

}
