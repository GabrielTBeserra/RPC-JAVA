package models;

import java.io.Serializable;

public class Editora implements Serializable {
    private int id;
    private String nome;

    public Editora() {
    }

    public Editora(String nome) {
        this.nome = nome;
    }

    public Editora(int id) {
        this.id = id;
    }

    public Editora(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Editora {\n" +
                "id: " + id +
                "\nnome: '" + nome + '\'' +
                "\n}";
    }
}
