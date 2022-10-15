package br.edu.univille.dao;

import br.edu.univille.factory.ConnectionFactory;
import br.edu.univille.model.Lista;
import br.edu.univille.model.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public void create(Lista lista) {
        String sql = "INSERT INTO lista VALUES (?, ?);";
        try {
            var stmt = connection.prepareStatement(sql);
            stmt.setString(1, lista.getTitulo());
            stmt.setString(2, lista.getDataCriacao().toString());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Lista readOne(int idLista){
        String sql = "SELECT * FROM lista WHERE id = ?;";
        try {
            var stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idLista);
            ResultSet rs = stmt.executeQuery();

            Lista lista = new Lista();
            if (rs.next()) {
                lista.setId(rs.getInt("id"));
                lista.setTitulo(rs.getString("titulo"));
                lista.setDataCriacao(rs.getDate("dataCriacao"));
                lista.setDataExclusao(rs.getDate("dataExclusao"));
                lista.setExcluida(rs.getInt("excluida") == 1 ? true : false);
                lista.setTarefas(new TarefaDao().readAllByIdLista(lista.getId()));
                lista.getTarefas().stream().forEach(t -> t.setLista(lista));
            }

            stmt.close();
            return lista;
        } catch (Exception e) {
            System.out.println("Falha ao buscar lista: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Lista> readAll() {
        String sql = "SELECT * FROM lista;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Lista> listas = new ArrayList<>();
            while (rs.next()) {
                Lista lista = new Lista();
                lista.setId(rs.getInt("id"));
                lista.setTitulo(rs.getString("titulo"));
                lista.setDataCriacao(rs.getDate("dataCriacao"));
                lista.setDataExclusao(rs.getDate("dataExclusao"));
                lista.setExcluida(rs.getBoolean("excluida"));
                lista.setTarefas(new TarefaDao().readAllByIdLista(lista.getId()));
                lista.getTarefas().stream().forEach(t -> t.setLista(lista));
                listas.add(lista);
            }

            stmt.close();
            return listas;

        } catch (SQLException e) {
            System.out.println("Falha ao ler lista: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void update(Lista lista) {
        String sql = "UPDATE lista SET titulo = ?, dataExclusao = ?, excluida = ? WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lista.getTitulo());
            stmt.setString(2, lista.getDataExclusao().toString());
            stmt.setBoolean(3, lista.isExcluida());
            stmt.setInt(4, lista.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Falha ao atualizar lista: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void delete(int idLista) {
        String sql = "DELETE FROM lista WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idLista);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Falha ao deletar lista: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void createTableIfExists(){
        String sql = "CREATE TABLE IF NOT EXISTS lista(      " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,  " +
                "titulo TEXT NOT NULL,                  " +
                "dataCriacao INTEGER NOT NULL DEFAULT 0," +
                "dataExclusao TEXT,                     " +
                "excluida TEXT                        " +
                ");                                     ";
        try {
            this.connection.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Falha ao criar tabela: " + e.getMessage());
        }
    }

}
