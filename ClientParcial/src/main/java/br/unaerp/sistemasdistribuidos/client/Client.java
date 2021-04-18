package br.unaerp.sistemasdistribuidos.client;

public class Client {
    public static void main(String[] args) {
        Chamadas chamadas = new Chamadas();
        Menu menu = new Menu(chamadas);
    }
}
