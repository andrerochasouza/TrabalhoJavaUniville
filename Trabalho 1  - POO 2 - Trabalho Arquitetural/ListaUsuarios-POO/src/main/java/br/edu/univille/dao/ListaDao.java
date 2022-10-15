package br.edu.univille.dao;

import br.edu.univille.factory.ConnectionFactory;
import br.edu.univille.model.Lista;

import java.sql.Connection;

public class ListaDao {

    private Connection connection;

    public ListaDao() {
        try {
            this.connection = ConnectionFactory.getInstance().getConnection();
            this.createTableIfExists();
        } catch (Exception e) {
            System.out.println("Falha ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private void createTableIfExists(){
        String sql = "CREATE TABLE IF NOT EXISTS lista(     " +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "titulo TEXT NOT NULL,                 " +
                     "dataCriacao TEXT NOT NULL,            " +
                     "dataExclusao TEXT,                    " +
                     "excluida TEXT ,                       " +
                     ");                                    ";
        try {
            this.connection.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Falha ao criar tabela: " + e.getMessage());
        }
    }

    public void create(Lista lista) throws Exception {
        String sql = "INSERT INTO lista VALUES (?, ?);";
        try {
            var stmt = connection.prepareStatement(sql);
            stmt.setString(lista.getTitulo(), lista.getDataCriacao());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new Exception("Falha ao inserir lista: " + e.getMessage());
        }
    }

    public void read(int idLista) {

    }

    public void update(Lista lista) {

    }

    public void delete(int idLista) {

    }

}
