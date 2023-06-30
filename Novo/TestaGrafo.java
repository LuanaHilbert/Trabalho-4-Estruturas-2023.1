package Novo;

import java.util.List;
import java.util.Scanner;

public class TestaGrafo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = null;

        while (true) {
            System.out.println("MENU:");
            System.out.println("1) Criar um grafo");
            System.out.println("2) Abrir grafo já existente");
            System.out.println("3) Adicionar Aresta");
            System.out.println("4) Remover Aresta");
            System.out.println("5) Adicionar Vértice");
            System.out.println("6) Remover Vértice");
            System.out.println("7) Imprimir Matriz de Adjacência");
            System.out.println("8) Realizar Busca em Largura e Imprimir Resultado");
            System.out.println("9) Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número de vértices do grafo: ");
                    int numVertices = scanner.nextInt();
                    grafo = new Grafo(numVertices);
                    System.out.println("Grafo criado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o nome do arquivo que contém o grafo: ");
                    String arquivo = scanner.next();
                    grafo = Grafo.carregarGrafo(arquivo);
                    break;
                case 3:
                    if (grafo != null) {
                        System.out.print("Digite o vértice de origem: ");
                        int origem = scanner.nextInt();
                        System.out.print("Digite o vértice de destino: ");
                        int destino = scanner.nextInt();
                        grafo.adicionarAresta(origem, destino);
                        System.out.println("Aresta adicionada com sucesso.");
                    } else {
                        System.out.println("Crie ou abra um grafo primeiro.");
                    }
                    break;
                case 4:
                    if (grafo != null) {
                        System.out.print("Digite o vértice de origem: ");
                        int origem = scanner.nextInt();
                        System.out.print("Digite o vértice de destino: ");
                        int destino = scanner.nextInt();
                        grafo.removerAresta(origem, destino);
                        System.out.println("Aresta removida com sucesso.");
                    } else {
                        System.out.println("Crie ou abra um grafo primeiro.");
                    }
                    break;
                case 5:
                    if (grafo != null) {
                        grafo.adicionarVertice();
                        System.out.println("Vértice adicionado com sucesso.");
                    } else {
                        System.out.println("Crie ou abra um grafo primeiro.");
                    }
                    break;
                case 6:
                    if (grafo != null) {
                        System.out.print("Digite o vértice a ser removido: ");
                        int vertice = scanner.nextInt();
                        grafo.removerVertice(vertice);
                        System.out.println("Vértice removido com sucesso.");
                    } else {
                        System.out.println("Crie ou abra um grafo primeiro.");
                    }
                    break;
                case 7:
                    if (grafo != null) {
                        grafo.imprimirMatrizAdjacencia();
                    } else {
                        System.out.println("Crie ou abra um grafo primeiro.");
                    }
                    break;
                case 8:
                    if (grafo != null) {
                        System.out.print("Digite o vértice de origem: ");
                        int origem = scanner.nextInt();
                        BuscaLargura buscaLargura = new BuscaLargura(grafo);
                        List<Integer> resultado = buscaLargura.buscar(origem);
                        System.out.println("Resultado da Busca em Largura: " + resultado);
                    } else {
                        System.out.println("Crie ou abra um grafo primeiro.");
                    }
                    break;
                case 9:
                    if (grafo != null) {
                        System.out.print("Digite o nome do arquivo para salvar o grafo: ");
                        String nomeArquivo = scanner.next();
                        grafo.salvarGrafo(nomeArquivo);
                    }
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
