public class Grafo {
    private int V;
    private int mat[][];//matriz de adjacencia
    
    Grafo(int v){
        this.V = v;//verificar se não é maior que zero
        mat = new int[v][v];
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++){
                mat[i][j] = 0; //inicializando a matriz com zero - sem arestas
            }
    }
    
    int getV(){
        return this.V;
    }
    
    void adicionaAresta(int v1, int v2){
        if (v1 < this.V && v2 < this.V && v1 >=0 && v2 >=0){
            mat[v1][v2] = 1;
            mat[v2][v1] = 1;
        }
    }
    
    boolean isAresta(int v1, int v2){
        if (v1 < this.V && v2 < this.V && v1 >=0 && v2 >=0)
            return false;//vertices não existem
        return mat[v1][v2] == 1;
    
    }
    
    void imprime(){
        for (int i = 0; i < this.V; i++){
            for (int j = 0; j< this.V; j++)
                System.out.print(mat[i][j] + "|");
            System.out.println();
        }
     }
}
