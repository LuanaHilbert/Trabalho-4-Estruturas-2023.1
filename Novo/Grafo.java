package Novo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Grafo {
    private int numVertices;
    private ListaEncadeada[] listaAdjacencia;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        listaAdjacencia = new ListaEncadeada[numVertices];

        for (int i = 0; i < numVertices; i++) {
            listaAdjacencia[i] = new ListaEncadeada();
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void adicionarAresta(int origem, int destino) {
        if (origem >= 0 && origem < numVertices && destino >= 0 && destino < numVertices) {
            listaAdjacencia[origem].inserir(destino);
            listaAdjacencia[destino].inserir(origem);
        } else {
            throw new IllegalArgumentException("Vértices inválidos.");
        }
    }

    public void removerAresta(int origem, int destino) {
        if (origem >= 0 && origem < numVertices && destino >= 0 && destino < numVertices) {
            listaAdjacencia[origem].remover(destino);
            listaAdjacencia[destino].remover(origem);
        } else {
            throw new IllegalArgumentException("Vértices inválidos.");
        }
    }

    public void adicionarVertice() {
        numVertices++;
        ListaEncadeada[] novaListaAdjacencia = new ListaEncadeada[numVertices];

        for (int i = 0; i < numVertices - 1; i++) {
            novaListaAdjacencia[i] = listaAdjacencia[i];
        }

        novaListaAdjacencia[numVertices - 1] = new ListaEncadeada();
        listaAdjacencia = novaListaAdjacencia;
    }

    public void removerVertice(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            numVertices--;
            ListaEncadeada[] novaListaAdjacencia = new ListaEncadeada[numVertices];

            int novaListaIndex = 0;
            for (int i = 0; i < numVertices + 1; i++) {
                if (i != vertice) {
                    novaListaAdjacencia[novaListaIndex] = listaAdjacencia[i];
                    novaListaIndex++;
                }
            }

            listaAdjacencia = novaListaAdjacencia;

            for (int i = 0; i < numVertices; i++) {
                listaAdjacencia[i].remover(vertice);
            }
        } else {
            throw new IllegalArgumentException("Vértice inválido.");
        }
    }

    public ListaEncadeada getListaAdjacencia(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            return listaAdjacencia[vertice];
        } else {
            throw new IllegalArgumentException("Vértice inválido.");
        }
    }

    public void imprimirMatrizAdjacencia() {
        int[][] matrizAdjacencia = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            ListaEncadeada vizinhos = listaAdjacencia[i];
            No vizinhoAtual = vizinhos.getPrimeiro();

            while (vizinhoAtual != null) {
                int vizinho = vizinhoAtual.getValor();
                matrizAdjacencia[i][vizinho] = 1;
                vizinhoAtual = vizinhoAtual.getProximo();
            }
        }

        System.out.println("Matriz de Adjacência:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void salvarGrafo(String arquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            writer.println(numVertices);

            for (int i = 0; i < numVertices; i++) {
                ListaEncadeada vizinhos = listaAdjacencia[i];
                writer.println(vizinhos.toString());
            }

            System.out.println("Grafo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o grafo.");
        }
    }

    public static Grafo carregarGrafo(String arquivo) {
        try (Scanner scanner = new Scanner(new File(arquivo))) {
            int numVertices = scanner.nextInt();
            Grafo grafo = new Grafo(numVertices);

            scanner.nextLine();
            for (int i = 0; i < numVertices; i++) {
                String[] vizinhos = scanner.nextLine().split(" ");
                for (String vizinho : vizinhos) {
                    int vertice = Integer.parseInt(vizinho);
                    grafo.adicionarAresta(i, vertice);
                }
            }

            System.out.println("Grafo carregado com sucesso.");
            return grafo;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }

        return null;
    }
}