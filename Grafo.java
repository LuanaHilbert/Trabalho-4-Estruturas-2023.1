import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Grafo {

    private int V; //número de vertices
    private int A; //número de arestas. 
    private int matriz[][];//m=triz de adjacencia;
    
    public void setVertice(int v){
        if (v > 0) this.V = v;
        else this.V = 1;
    }
    public void setAresta(int a){
        if (a > 0) this.A = a;
        else this.A = 1;
    }
    public Grafo (int v){
        setVertice(v);
       // setAresta(a);
        matriz = new int[V][V];
        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++){
                matriz[i][j] = 0;
            }
        }
    }
    public void adicionaAresta(int i, int j){
        if (i != j) {
            this.matriz[i][j] = 1;
            this.matriz[j][i] = 1;
        }
    }
    public int getV(){
        return this.V;
    }

    private void abrirGrafo() {
        try (Scanner fileScanner = new Scanner(new File("grafo.txt"))) {
            V = fileScanner.nextInt();
            matriz = new int[V][V];

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    matriz[i][j] = fileScanner.nextInt();
                }
            }

            System.out.println("Grafo aberto com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo grafo.txt não encontrado.");
        }
    }

    private void salvarGrafo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("grafo.txt"))) {
            writer.println(V);
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    writer.print(matriz[i][j] + " ");
                }
                writer.println();
            }
            System.out.println("Grafo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o grafo.");
        }
    }
        
    @Override
    public String toString(){
        String aux = "";
        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++){
                aux += matriz[i][j] + " | ";
            }
            aux += "\n";
        }
        return aux;
    }
    
    public boolean isAdjacente(int i, int j){
        return matriz[i][j] == 1;
    }
    
}
