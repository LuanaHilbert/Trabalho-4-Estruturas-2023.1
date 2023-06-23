package Novo;

import java.util.NoSuchElementException;

public class FilaEncadeada {
    private No primeiro;
    private No ultimo;

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void enfileirar(int valor) {
        No novoNo = new No(valor);

        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        }
    }

    public int desenfileirar() {
        if (estaVazia()) {
            throw new NoSuchElementException("A fila está vazia.");
        }

        int valor = primeiro.valor;
        primeiro = primeiro.proximo;

        if (primeiro == null) {
            ultimo = null;
        }

        return valor;
    }

    private class No {
        private int valor;
        private No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
}

