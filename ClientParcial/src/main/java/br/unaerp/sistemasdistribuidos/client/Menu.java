package br.unaerp.sistemasdistribuidos.client;

import models.Editora;
import models.Livro;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Menu {
    private final Chamadas chamadas;

    public Menu(Chamadas chamadas) {
        this.chamadas = chamadas;
        geral();
    }

    private void geral() {
        System.out.println("--= Menu =--");
        System.out.println("1.. Livro");
        System.out.println("2.. Editora");

        Scanner scannerOp = new Scanner(System.in);
        switch (scannerOp.nextInt()) {
            case 1:
                menuLivro();
                break;
            case 2:
                menuEditora();
                break;
            default:
                geral();
        }
    }

    private void menuLivro() {
        System.out.println("--= Menu Livro =--");
        System.out.println("1.. Inserir");
        System.out.println("2.. Atualizar");
        System.out.println("3.. Pesquisar por titulo");
        System.out.println("4.. Voltar");


        switch (new Scanner(System.in).nextInt()) {
            case 1:
                inserirLivro(false);
                break;
            case 2:
                inserirLivro(true);
                break;
            case 3:
                buscarLivroPorTitulo();
                break;
            case 4:
                geral();
                break;
            default:
                menuLivro();
        }
    }

    private void menuEditora() {
        System.out.println("--= Menu Editora =--");
        System.out.println("1.. Inserir");
        System.out.println("2.. Atualizar");
        System.out.println("3.. Pesquisar por nome");
        System.out.println("4.. Voltar");

        switch (new Scanner(System.in).nextInt()) {
            case 1:
                inserirEditora(false);
                break;
            case 2:
                inserirEditora(true);
                break;
            case 3:
                buscarPorNome();
                break;
            case 4:
                geral();
                break;
            default:
                menuLivro();
        }
    }

    private void inserirLivro(boolean isUpdate) {
        int id = 0;
        if (isUpdate) {
            System.out.println("Qual id do livro que deseja atualizar?");
            Scanner idScanner = new Scanner(System.in);
            id = idScanner.nextInt();
        }

        System.out.println("Titulo: ");
        Scanner tituloScanner = new Scanner(System.in);
        String titulo = tituloScanner.next();

        System.out.println("Autor: ");
        Scanner autorScanner = new Scanner(System.in);
        String autor = autorScanner.next();

        System.out.println("Ano: ");
        Scanner anoScanner = new Scanner(System.in);
        int ano = anoScanner.nextInt();

        System.out.println("Preço: ");
        Scanner precoScanner = new Scanner(System.in);
        double preco = precoScanner.nextDouble();

        System.out.println("Quantidade: ");
        Scanner quantidadeScanner = new Scanner(System.in);
        int quantidade = quantidadeScanner.nextInt();

        System.out.println("Id editora: ");
        Scanner idEditoraScanner = new Scanner(System.in);
        int idEditora = idEditoraScanner.nextInt();

        Livro livro = new Livro();
        livro.setIdEditora(idEditora);
        livro.setTitulo(titulo);
        livro.setQuantidade(quantidade);
        livro.setAutor(autor);
        livro.setPreco(preco);
        livro.setAno(ano);

        try {
            if (isUpdate) {
                livro.setId(id);
                chamadas.getLivroCrudOp().atualizar(id, livro);
                System.out.println("Livro atualizado com sucesso!");
            } else {
                chamadas.getLivroCrudOp().inserir(livro);
                System.out.println("Livro inserido com sucesso!");
            }

        } catch (RemoteException e) {
            System.out.println("Ocorreu um erro ao salvar o livro: " + e.getMessage());
            System.out.println("Voltando ao menu");
        }
        geral();
    }

    private void buscarLivroPorTitulo() {
        System.out.println("Informe o titulo do livro desejado: ");
        String titulo = new Scanner(System.in).next();

        try {
            Livro livro = chamadas.getLivroCrudOp().pesquisarPorTitulo(titulo);
            if (livro != null) {
                System.out.println(livro.toString());
            } else {
                System.out.println("Nenhum resutado encontrado com o termo: '" + titulo + "'");
            }

        } catch (RemoteException e) {
            System.out.println("Ocorreu algum erro: " + e.getMessage());
        }

        geral();
    }

    private void inserirEditora(boolean isUpdate) {
        int id = 0;
        if (isUpdate) {
            System.out.println("Qual id da editora que deseja atualizar?");
            Scanner idScanner = new Scanner(System.in);
            id = idScanner.nextInt();
        }

        System.out.println("Nome: ");
        String nome = new Scanner(System.in).next();

        Editora editora = new Editora();
        editora.setNome(nome);


        try {
            if (isUpdate) {
                editora.setId(id);
                chamadas.getEditoraCrudOp().atualizar(id, editora);
                System.out.println("Livro atualizado com sucesso!");
            } else {
                chamadas.getEditoraCrudOp().inserir(editora);
                System.out.println("Livro inserido com sucesso!");
            }

        } catch (RemoteException e) {
            System.out.println("Ocorreu um erro ao salvar o livro: " + e.getMessage());
            System.out.println("Voltando ao menu");
        }
        geral();
    }

    private void buscarPorNome() {
        System.out.println("Informe o nome da editora desejado: ");
        String nome = new Scanner(System.in).next();

        try {
            Editora ret = chamadas.getEditoraCrudOp().pesquisarPorNome(nome);
            if (ret != null) {
                System.out.println(ret.toString());
            } else {
                System.out.println("Nenhum resutado encontrado com o termo: '" + nome + "'");
            }
        } catch (RemoteException e) {
            System.out.println("Ocorreu algum erro: " + e.getMessage());
        }
        geral();
    }

}

