package Novo;

public class ListaEncadeada {
    private No primeiro;
    private No ultimo;

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);

        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        }
    }

    public void remover(int valor) {
        No atual = primeiro;
        No anterior = null;

        while (atual != null) {
            if (atual.valor == valor) {
                if (atual == primeiro) {
                    primeiro = atual.proximo;
                } else if (atual == ultimo) {
                    ultimo = anterior;
                    ultimo.proximo = null;
                } else {
                    anterior.proximo = atual.proximo;
                }

                break;
            }

            anterior = atual;
            atual = atual.proximo;
        }
    }

    public boolean contem(int valor) {
        No atual = primeiro;

        while (atual != null) {
            if (atual.valor == valor) {
                return true;
            }

            atual = atual.proximo;
        }

        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        No atual = primeiro;

        while (atual != null) {
            sb.append(atual.valor).append(" ");
            atual = atual.proximo;
        }

        return sb.toString().trim();
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
