public class ListaContatos {
    Nodo inicio;
    Nodo fim;

    private class Nodo {
        Contato contato;
        Nodo proximo;
        Nodo anterior;
    }
    
    public ListaContatos() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarContato(Contato contato) {
        Nodo novo = new Nodo();
        novo.contato = contato;

        if (this.inicio == null) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            Nodo nodoAtual = this.inicio;

            while (nodoAtual != null && contato.getNome().compareToIgnoreCase(nodoAtual.contato.getNome()) > 0) {
                nodoAtual = nodoAtual.proximo;
            }

            if (nodoAtual == null) {
                novo.anterior = this.fim;
                this.fim.proximo = novo;
                this.fim = novo;
            } else if (nodoAtual.anterior == null) {
                novo.proximo = this.inicio;
                this.inicio.anterior = novo;
                this.inicio = novo;
            } else {
                novo.proximo = nodoAtual;
                novo.anterior = nodoAtual.anterior;
                nodoAtual.anterior.proximo = novo;
                nodoAtual.anterior = novo;
            }
        }
    }

    public void removerContato(String nomeContato) {
        Nodo nodoAtual = this.inicio;

        while (nodoAtual != null && !nodoAtual.contato.getNome().equalsIgnoreCase(nomeContato)) {
            nodoAtual = nodoAtual.proximo;
        }

        if (nodoAtual != null) {
            if (nodoAtual == this.inicio && nodoAtual == this.fim) {
                this.inicio = null;
                this.fim = null;
            } else if (nodoAtual == this.inicio) {
                this.inicio = this.inicio.proximo;
                this.inicio.anterior = null;
            } else if (nodoAtual == this.fim) {
                this.fim = this.fim.anterior;
                this.fim.proximo = null;
            } else {
                nodoAtual.anterior.proximo = nodoAtual.proximo;
                nodoAtual.proximo.anterior = nodoAtual.anterior;
            }
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public void buscarContato(String nomeContato) {
        Nodo nodoAtual = this.inicio;

        while (nodoAtual != null && !nodoAtual.contato.getNome().equalsIgnoreCase(nomeContato)) {
            nodoAtual = nodoAtual.proximo;
        }

        if (nodoAtual != null) {
            System.out.println("Nome: " + nodoAtual.contato.getNome() + " | Telefone: " + nodoAtual.contato.getTelefone());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public void imprimirContatos() {
        Nodo nodoAtual = this.inicio;

        while (nodoAtual != null) {
            System.out.println("Nome: " + nodoAtual.contato.getNome() + " | Telefone: "  + nodoAtual.contato.getTelefone());
            nodoAtual = nodoAtual.proximo;
        }
    }

}
