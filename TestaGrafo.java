import java.util.Scanner;

public class TestaGrafo {
    
    public static void main(String[] args){
    
        Grafo g = new Grafo(4);
        System.out.println(g);
        g.adicionaAresta(0, 1);
        g.adicionaAresta(0, 2);
        g.adicionaAresta(0, 3);
        g.adicionaAresta(3, 2);
        System.out.println();
        System.out.println(g);
        System.out.println(g.isAdjacente(1, 2));

        Scanner entrada = new Scanner(System.in);
        int choice;
        boolean graphCreated = false;

        do {
            System.out.println("Menu:");
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
            choice = entrada.nextInt();

            switch (choice) {
                case 1:
                    if (!graphCreated) {
                        System.out.print("Digite o número de vértices do grafo: ");
                        int v = entrada.nextInt();
                        Grafo grafo = new Grafo(v);
                        System.out.println("Grafo criado com sucesso.");
                        graphCreated = true;
                    } else {
                        System.out.println("Um grafo já foi criado. Escolha outra opção.");
                    }
                    break;
                case 2:
                    if (graphCreated) {
                        grafo.abrirGrafo();
                    } else {
                        System.out.println("Não há um grafo criado. Escolha outra opção.");
                    }
                    break;
                case 3:
                    if (graphCreated) {
                        System.out.println("Digite o primeiro vertice:");
                        int v1 = entrada.nextInt();
                        if(v1 >= 0 && v1 < grafo.getV){
                            System.out.println("Digite o segundo vertice");
                            int v2 = entrada.nextInt();
                            if(v2 >= 0 && v2 < grafo.getV){
                                grafo.adicionaAresta(v1, v2);
                                System.out.println("Aresta adicionada com sucesso!");
                            }
                            else
                                System.out.println("Vertice invalido.");
                        }
                        else
                            System.out.println("Vertice invalido.");
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 4:
                    if (graphCreated) {
                        removeEdge(entrada);
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 5:
                    if (graphCreated) {
                        addVertex(entrada);
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 6:
                    if (graphCreated) {
                        removeVertex(entrada);
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 7:
                    if (graphCreated) {
                        printAdjacencyMatrix();
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 8:
                    if (graphCreated) {
                        performBFS(entrada);
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 9:
                    grafo.salvarGrafo();
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }

            System.out.println();
        } while (choice != 9);
    }
    }
    
}
/* 
import java.io.*;
import java.util.*;

public class GraphBFS {
    private int[][] adjacencyMatrix;
    private int numVertices;
    private boolean[] visited;

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();
        graph.run();
    }

    public void run() {
        Scanner entrada = new Scanner(System.in);
        int choice;
        boolean graphCreated = false;

        do {
            System.out.println("Menu:");
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
            choice = entrada.nextInt();

            switch (choice) {
                case 1:
                    if (!graphCreated) {
                        createGraph(entrada);
                        graphCreated = true;
                    } else {
                        System.out.println("Um grafo já foi criado. Escolha outra opção.");
                    }
                    break;
                case 2:
                    if (!graphCreated) {
                        openGraph();
                        graphCreated = true;
                    } else {
                        System.out.println("Um grafo já foi criado. Escolha outra opção.");
                    }
                    break;
                case 3:
                    if (graphCreated) {
                        addEdge(entrada);
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 4:
                    if (graphCreated) {
                        removeEdge(entrada);
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 5:
                    if (graphCreated) {
                        addVertex(entrada);
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 6:
                    if (graphCreated) {
                        removeVertex(entrada);
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 7:
                    if (graphCreated) {
                        printAdjacencyMatrix();
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 8:
                    if (graphCreated) {
                        performBFS(entrada);
                    } else {
                        System.out.println("Crie um grafo primeiro.");
                    }
                    break;
                case 9:
                    saveGraph();
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }

            System.out.println();
        } while (choice != 9);
    }

    private void createGraph(Scanner scanner) {
        System.out.print("Digite o número de vértices do grafo: ");
        numVertices = scanner.nextInt();
        adjacencyMatrix = new int[numVertices][numVertices];
        visited = new boolean[numVertices];

        System.out.println("Grafo criado com sucesso.");
    }

    private void openGraph() {
        try (Scanner fileScanner = new Scanner(new File("grafo.txt"))) {
            numVertices = fileScanner.nextInt();
            adjacencyMatrix = new int[numVertices][numVertices];
            visited = new boolean[numVertices];

            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    adjacencyMatrix[i][j] = fileScanner.nextInt();
                }
            }

            System.out.println("Grafo aberto com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo grafo.txt não encontrado.");
        }
    }

    private void addEdge(Scanner scanner) {
        System.out.print("Digite o vértice de origem: ");
        int source = scanner.nextInt();
        System.out.print("Digite o vértice de destino: ");
        int destination = scanner.nextInt();

        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjacencyMatrix[source][destination] = 1;
            adjacencyMatrix[destination][source] = 1;
            System.out.println("Aresta adicionada com sucesso.");
        } else {
            System.out.println("Vértices inválidos.");
        }
    }

    private void removeEdge(Scanner scanner) {
        System.out.print("Digite o vértice de origem: ");
        int source = scanner.nextInt();
        System.out.print("Digite o vértice de destino: ");
        int destination = scanner.nextInt();

        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjacencyMatrix[source][destination] = 0;
            adjacencyMatrix[destination][source] = 0;
            System.out.println("Aresta removida com sucesso.");
        } else {
            System.out.println("Vértices inválidos.");
        }
    }

    private void addVertex(Scanner scanner) {
        numVertices++;
        int[][] newAdjacencyMatrix = new int[numVertices][numVertices];
        boolean[] newVisited = new boolean[numVertices];

        for (int i = 0; i < numVertices - 1; i++) {
            System.arraycopy(adjacencyMatrix[i], 0, newAdjacencyMatrix[i], 0, numVertices - 1);
            newVisited[i] = visited[i];
        }

        adjacencyMatrix = newAdjacencyMatrix;
        visited = newVisited;

        System.out.println("Vértice adicionado com sucesso.");
    }

    private void removeVertex(Scanner scanner) {
        System.out.print("Digite o vértice a ser removido: ");
        int vertex = scanner.nextInt();

        if (vertex >= 0 && vertex < numVertices) {
            numVertices--;
            int[][] newAdjacencyMatrix = new int[numVertices][numVertices];
            boolean[] newVisited = new boolean[numVertices];

            int newRow = 0;
            for (int i = 0; i < numVertices + 1; i++) {
                if (i != vertex) {
                    System.arraycopy(adjacencyMatrix[i], 0, newAdjacencyMatrix[newRow], 0, numVertices + 1);
                    newVisited[newRow] = visited[i];
                    newRow++;
                }
            }

            adjacencyMatrix = newAdjacencyMatrix;
            visited = newVisited;

            for (int i = 0; i < numVertices; i++) {
                for (int j = vertex; j < numVertices; j++) {
                    adjacencyMatrix[i][j] = adjacencyMatrix[i][j + 1];
                }
            }

            for (int i = vertex; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    adjacencyMatrix[i][j] = adjacencyMatrix[i + 1][j];
                }
            }

            System.out.println("Vértice removido com sucesso.");
        } else {
            System.out.println("Vértice inválido.");
        }
    }

    private void printAdjacencyMatrix() {
        System.out.println("Matriz de Adjacência:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void performBFS(Scanner scanner) {
        System.out.print("Digite o vértice de origem: ");
        int source = scanner.nextInt();

        if (source >= 0 && source < numVertices) {
            Arrays.fill(visited, false);

            List<Integer> result = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(source);
            visited[source] = true;

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                result.add(vertex);

                for (int i = 0; i < numVertices; i++) {
                    if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }

            System.out.print("Busca em Largura: ");
            for (int vertex : result) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        } else {
            System.out.println("Vértice inválido.");
        }
    }

    private void saveGraph() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("grafo.txt"))) {
            writer.println(numVertices);
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    writer.print(adjacencyMatrix[i][j] + " ");
                }
                writer.println();
            }
            System.out.println("Grafo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o grafo.");
        }
    }
}
*/
