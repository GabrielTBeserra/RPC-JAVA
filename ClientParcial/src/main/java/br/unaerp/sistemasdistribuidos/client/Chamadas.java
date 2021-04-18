package br.unaerp.sistemasdistribuidos.client;

import servico.IEditoraCrud;
import servico.ILivroCrud;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Chamadas {
    private IEditoraCrud editoraCrudOp;
    private ILivroCrud livroCrudOp;

    public Chamadas() {
        try {
            // Registro dos serviços
            Registry srvEditora = LocateRegistry.getRegistry(IEditoraCrud.SERVICE_HOST, IEditoraCrud.PORT);
            Registry srvLivro = LocateRegistry.getRegistry(ILivroCrud.SERVICE_HOST, ILivroCrud.PORT);

            // Operações disponiveis no servidor
            this.editoraCrudOp = (IEditoraCrud) srvEditora.lookup(IEditoraCrud.SERVICE_NAME);
            this.livroCrudOp = (ILivroCrud) srvLivro.lookup(ILivroCrud.SERVICE_NAME);

            System.out.println("Metodos remotos carregados com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    public IEditoraCrud getEditoraCrudOp() {
        return editoraCrudOp;
    }

    public ILivroCrud getLivroCrudOp() {
        return livroCrudOp;
    }
}
