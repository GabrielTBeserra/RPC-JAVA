package servico;

import models.Livro;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILivroCrud extends Remote {
    int PORT = 1098;
    String SERVICE_NAME = "livro_service";
    String SERVICE_HOST = "192.168.1.35";

    void inserir(Livro livro) throws RemoteException;

    void atualizar(int id , Livro livro) throws RemoteException;

    Livro pesquisarPorTitulo(String nome) throws RemoteException;
}
