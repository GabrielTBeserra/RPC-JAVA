package br.unaerp.sistemasdistribuidos.dao;

import models.Editora;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditoraDao {
    public void inserir(Editora editora) {
        try {
            String newPlayer = "INSERT INTO tb_editora(nome) VALUES (?)";

            ConnectionDao.connect();
            PreparedStatement preparedStatement = ConnectionDao.getConnection().prepareStatement(newPlayer);
            preparedStatement.setString(1, editora.getNome());

            preparedStatement.execute();

            ConnectionDao.disconnect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(int id, Editora editora) {
        try {
            String update = "UPDATE tb_editora set nome = ? where id = " + id;
            ConnectionDao.connect();
            PreparedStatement preparedStatement = ConnectionDao.getConnection().prepareStatement(update);
            preparedStatement.setString(1, editora.getNome());
            preparedStatement.execute();

            ConnectionDao.disconnect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Editora pesquisarPorNome(String nome) {
        try {
            String query = "SELECT * FROM tb_editora where nome = '" + nome + "'";

            ConnectionDao.connect();
            PreparedStatement sets = ConnectionDao.getConnection().prepareStatement(query);

            ResultSet results = sets.executeQuery();
            Editora editora = null;

            while (results.next()) {
                editora = new Editora(results.getInt("id"), results.getString("nome"));
            }
            ConnectionDao.disconnect();
            return editora;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
