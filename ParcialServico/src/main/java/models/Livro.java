package models;

import java.io.Serializable;

public class Livro implements Serializable {
    private int id;
    private int idEditora;
    private String titulo;
    private String autor;
    private int ano;
    private double preco;
    private int quantidade;

    public Livro() {
    }

    public Livro(int id) {
        this.id = id;
    }

    public Livro(int idEditora, String titulo, String autor, int ano, double preco, int quantidade) {
        this.idEditora = idEditora;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Livro(int id, int idEditora, String titulo, String autor, int ano, double preco, int quantidade) {
        this.id = id;
        this.idEditora = idEditora;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Livro {" +
                "\nid: " + id +
                "\nidEditora: " + idEditora +
                "\ntitulo: '" + titulo + '\'' +
                "\nautor: '" + autor + '\'' +
                "\nano: " + ano +
                "\npreco: " + preco +
                "\nquantidade: " + quantidade +
                "\n}";
    }
}
