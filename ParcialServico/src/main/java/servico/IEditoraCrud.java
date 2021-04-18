package servico;

import models.Editora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEditoraCrud extends Remote {
    int PORT = 1099;
    String SERVICE_NAME = "editora_service";
    String SERVICE_HOST = "192.168.1.35";

    void inserir(Editora editora) throws RemoteException;

    void atualizar(int id, Editora editora) throws RemoteException;

    Editora pesquisarPorNome(String nome) throws RemoteException;
}
