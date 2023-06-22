import java.util.ArrayList;
import java.util.Collections;

public class BuscaLargura {
    
    private static final int BRANCO = 0;
    private static final int CINZA = 1;
    private static final int PRETO = 2;
    
    private int origem;
    private Grafo grafo;
    private int cor[];
    private int distancia[];
    private int predecessor[];
    
    public BuscaLargura(Grafo g){
        this.grafo = g;
        this.cor = new int[g.getV()];
        this.distancia = new int[g.getV()];
        this.predecessor = new int[g.getV()];
    }
    
    public void busca(int o){
        this.origem = o;
        FilaEncadeada fila = new FilaEncadeada();
        for (int i = 0; i < grafo.getV(); i++){
            this.cor[i] = BRANCO;
            this.distancia[i] = 0;
            this.predecessor[i] = -1;
        }
       
        fila.insereFinal(origem);
        System.out.println("inseriu origem "+ origem);
        while (!fila.vazia()){
            int atual = fila.retiraInicio();
            System.out.println("atual "+ atual);

            for (int i = 0; i < grafo.getV(); i++){
                if (grafo.isAdjacente(atual, i)){
                    if (cor[i] == BRANCO){
                        cor[i] = CINZA;
                        predecessor[i] = atual;
                        distancia [i] = distancia[atual] + 1;
                        fila.insereFinal(i);
                    }
                }
            }
            cor[atual] = PRETO;
        }    
    }
    
    public void getPath(int i){
        int temp = i;
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(temp);
        while (predecessor[temp] != - 1){
            temp = predecessor[temp];
            lista.add(temp);
        }
        System.out.print("Origem = "+ this.origem + " Destino = "+ i + "| distancia = " + distancia[i] + " | caminho = ");
        Collections.reverse(lista);
        for (int j: lista){
            System.out.print(j + "->");
        }
        System.out.println();
    
    }
    
    void getAllPaths(){
        for (int i = 0 ; i < grafo.getV(); i++)
            getPath(i);
    }
    
    @Override
    public String toString(){
        String aux = "cores\n";
        for (int i = 0; i < grafo.getV(); i++){
            aux += cor[i] + " ";
        }
        aux += "\npredecessores\n";
        for (int i = 0; i < grafo.getV(); i++){
            aux += predecessor[i] + " ";
        }
        aux += "\ndistancia\n";
        for (int i = 0; i < grafo.getV(); i++){
            aux += distancia[i] + " ";
        }
        aux+= "\n";
        return aux;
    }
}
