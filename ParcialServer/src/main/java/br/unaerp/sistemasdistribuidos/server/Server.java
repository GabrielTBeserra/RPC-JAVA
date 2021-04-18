package br.unaerp.sistemasdistribuidos.server;

import br.unaerp.sistemasdistribuidos.dao.EditoraDao;
import br.unaerp.sistemasdistribuidos.dao.LivroDao;
import models.Editora;
import models.Livro;
import servico.IEditoraCrud;
import servico.ILivroCrud;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ILivroCrud, IEditoraCrud {
    protected Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            ILivroCrud iLivroCrud = new Server();
            IEditoraCrud iEditoraCrud = new Server();

            Registry livro = LocateRegistry.createRegistry(ILivroCrud.PORT);
            Registry editora = LocateRegistry.createRegistry(IEditoraCrud.PORT);

            livro.bind(ILivroCrud.SERVICE_NAME, iLivroCrud);
            editora.bind(IEditoraCrud.SERVICE_NAME, iEditoraCrud);

            System.out.println("-- Servidor em execução --");
            System.out.println("Portas do serviço: ");
            System.out.println("Editora: " + IEditoraCrud.SERVICE_HOST + ":" + IEditoraCrud.PORT);
            System.out.println("Livro: " + ILivroCrud.SERVICE_HOST + ":" + ILivroCrud.PORT);
        } catch (AlreadyBoundException | RemoteException e) {
            System.err.println("ERRO: " + e.getMessage());
        }

    }

    @Override
    public void inserir(Livro livro) throws RemoteException {
        LivroDao livroDao = new LivroDao();
        livroDao.inserir(livro);
    }

    @Override
    public void atualizar(int i, Livro livro) throws RemoteException {
        LivroDao livroDao = new LivroDao();
        livroDao.atualizar(i, livro);
    }

    @Override
    public Livro pesquisarPorTitulo(String s) throws RemoteException {

        LivroDao livroDao = new LivroDao();
        return livroDao.pesquisarPorTitulo(s);
    }

    @Override
    public void inserir(Editora editora) throws RemoteException {
        EditoraDao editoraDao = new EditoraDao();
        editoraDao.inserir(editora);
    }

    @Override
    public void atualizar(int i, Editora editora) throws RemoteException {
        EditoraDao editoraDao = new EditoraDao();
        editoraDao.atualizar(i, editora);
    }

    @Override
    public Editora pesquisarPorNome(String s) throws RemoteException {
        EditoraDao editoraDao = new EditoraDao();
        return editoraDao.pesquisarPorNome(s);
    }
}
