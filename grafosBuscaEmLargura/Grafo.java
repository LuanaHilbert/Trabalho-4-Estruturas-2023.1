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
