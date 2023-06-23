package Novo;
import java.io.*;
import java.util.*;

public class BuscaLargura {
    private Grafo grafo;

    public BuscaLargura(Grafo grafo) {
        this.grafo = grafo;
    }

    public List<Integer> buscar(int origem) {
        List<Integer> resultado = new ArrayList<>();
        boolean[] visitado = new boolean[grafo.getNumVertices()];
        FilaEncadeada fila = new FilaEncadeada();

        visitado[origem] = true;
        fila.enfileirar(origem);

        while (!fila.estaVazia()) {
            int vertice = fila.desenfileirar();
            resultado.add(vertice);

            ListaEncadeada vizinhos = grafo.getListaAdjacencia(vertice);

            No vizinhoAtual = vizinhos.getPrimeiro();
            while (vizinhoAtual != null) {
                int vizinho = vizinhoAtual.getValor();
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila.enfileirar(vizinho);
                }
                vizinhoAtual = vizinhoAtual.getProximo();
            }
        }

        return resultado;
    }
}