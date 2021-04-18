package br.unaerp.sistemasdistribuidos.dao;

import models.Livro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDao {
    public void inserir(Livro livro) {
        try {
            String newPlayer = "INSERT INTO tb_livro(id_editora,titulo,autor,ano,preco,quantidade) VALUES (?,?,?,?,?,?)";

            ConnectionDao.connect();
            PreparedStatement preparedStatement = ConnectionDao.getConnection().prepareStatement(newPlayer);
            preparedStatement.setInt(1, livro.getIdEditora());
            preparedStatement.setString(2, livro.getTitulo());
            preparedStatement.setString(3, livro.getAutor());
            preparedStatement.setInt(4, livro.getAno());
            preparedStatement.setDouble(5, livro.getPreco());
            preparedStatement.setInt(6, livro.getQuantidade());
            preparedStatement.execute();

            ConnectionDao.disconnect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(int id, Livro livro) {
        try {
            String update = "UPDATE tb_livro set id_editora = ?,titulo = ?,autor = ?,ano = ?,preco = ?,quantidade = ? where id = " + id;
            ConnectionDao.connect();
            PreparedStatement preparedStatement = ConnectionDao.getConnection().prepareStatement(update);
            preparedStatement.setInt(1, livro.getIdEditora());
            preparedStatement.setString(2, livro.getTitulo());
            preparedStatement.setString(3, livro.getAutor());
            preparedStatement.setInt(4, livro.getAno());
            preparedStatement.setDouble(5, livro.getPreco());
            preparedStatement.setInt(6, livro.getQuantidade());
            preparedStatement.execute();

            ConnectionDao.disconnect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Livro pesquisarPorTitulo(String titulo) {
        try {
            String query = "SELECT * FROM tb_livro where titulo = ?";
            ConnectionDao.connect();
            PreparedStatement sets = ConnectionDao.getConnection().prepareStatement(query);
            sets.setString(1, titulo);



            ResultSet results = sets.executeQuery();
            Livro livro = null;

            while (results.next()) {
                livro = new Livro(results.getInt("id"));
                livro.setAno(results.getInt("ano"));
                livro.setTitulo(results.getString("titulo"));
                livro.setPreco(results.getDouble("preco"));
                livro.setQuantidade(results.getInt("quantidade"));
                livro.setIdEditora(results.getInt("id_editora"));
            }

            ConnectionDao.disconnect();
            return livro;
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        }


    }
}
