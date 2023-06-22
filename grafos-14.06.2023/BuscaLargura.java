public class BuscaLargura {
    private static final int BRANCO = 0;
    private static final int CINZA = 1;
    private static final int PRETO = 2;
 
    private int cor[];
    private int dist[];
    private int pai[];
    private int origem;
    private Grafo grafo;
    
    //construtor
    public BuscaLargura(Grafo g, int origem){
        this.grafo = g;
        this.origem = origem;
        cor = new int[grafo.getV()];
        dist = new int[grafo.getV()];
        pai = new int[grafo.getV()];
        for (int i = 0; i < grafo.getV(); i++){
            cor[i] = BRANCO;
            dist[i] = -1;
            pai[i] = -1;
        }
    }
    
    public void busca(){
        cor[origem] = CINZA;
        dist[origem] = 0;
        
        FilaEncadeada fila = new FilaEncadeada();
        fila.insereFila(origem);
        
        while (!fila.filaVazia()){
            int u = fila.removeFila();
            //laço para verificar cada um dos adjacentes de u;
            for (int v = 0; v < grafo.getV(); v++){
                if (grafo.isAresta(u, v)){                  
                    if (cor[v] == BRANCO){
                        cor[v] = CINZA;
                        dist[v] = dist[u] + 1;
                        pai[v]= u;
                        fila.insereFila(v);
                    }
                }
            cor[u] = PRETO;
            }
        }
    }
    
    
    
    
}
