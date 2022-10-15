package br.edu.univille.dao;

import br.edu.univille.factory.ConnectionFactory;
import br.edu.univille.model.Lista;
import br.edu.univille.model.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TarefaDao {

    private Connection connection;

    public TarefaDao(){
        try{
            this.connection = ConnectionFactory.getInstance().getConnection();
            this.createTableIfExists();
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private void createTableIfExists(){
        String sql = "CREATE TABLE IF NOT EXISTS tarefa(     " +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "titulo TEXT NOT NULL,                 " +
                     "texto TEXT,            " +
                     "dataCriacao TEXT NOT NULL,                    " +
                     "dataConclusao TEXT,                       " +
                     "concluida INTEGER NOT NULL DEFAULT 0,                       " +
                     "idLista INTEGER NOT NULL,                       " +
                     "FOREIGN KEY (idLista) REFERENCES lista(id) " +
                     ");                                    ";
        try {
            this.connection.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Falha ao criar tabela: " + e.getMessage());
        }
    }

    public void create(Tarefa tarefa) {
        String sql = "INSERT INTO tarefa VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getTexto());
            stmt.setString(3, tarefa.getDataCriacao().toString());
            stmt.setString(4, tarefa.getDataConclusao().toString());
            stmt.setInt(5, tarefa.isConcluida() ? 1 : 0);
            stmt.setInt(6, tarefa.getLista().getId());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Tarefa readOne(int idTarefa){
        String sql = "SELECT * FROM tarefa WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idTarefa);
            ResultSet rs = stmt.executeQuery();

            Tarefa tarefa = new Tarefa();
            tarefa.setId(rs.getInt("id"));
            tarefa.setTitulo(rs.getString("titulo"));
            tarefa.setTexto(rs.getString("texto"));
            tarefa.setDataCriacao(rs.getDate("dataCriacao"));
            tarefa.setDataConclusao(rs.getDate("dataConclusao"));
            tarefa.setConcluida(rs.getInt("concluida") == 1 ? true : false);
            tarefa.setLista(new ListaDao().readOne(rs.getInt("idLista")));
            stmt.close();
            return tarefa;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    ArrayList<Tarefa> readAllByIdLista(int idLista){
        String sql = "SELECT * FROM tarefa WHERE idLista = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idLista);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Tarefa> tarefas = new ArrayList<>();
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("id"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setTexto(rs.getString("texto"));
                tarefa.setDataCriacao(rs.getDate("dataCriacao"));
                tarefa.setDataConclusao(rs.getDate("dataConclusao"));
                tarefa.setConcluida(rs.getInt("concluida") == 1 ? true : false);
                tarefas.add(tarefa);
            }

            stmt.close();
            return tarefas;

        } catch (SQLException e) {
            System.out.println("Falha ao ler tarefas: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void update(Tarefa tarefa) {
        String sql = "UPDATE tarefa SET titulo = ?, texto = ?, dataConclusao = ?, concluida = ?, idLista = ? WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getTexto());
            stmt.setString(3, tarefa.getDataConclusao().toString());
            stmt.setInt(4, tarefa.isConcluida() ? 1 : 0);
            stmt.setInt(5, tarefa.getLista().getId());
            stmt.setInt(6, tarefa.getId());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int idTarefa) {
        String sql = "DELETE FROM tarefa WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idTarefa);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
