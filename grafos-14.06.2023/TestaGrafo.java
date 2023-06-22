public class TestaGrafo {
    public static void main(String[] args){
    
        Grafo g = new Grafo(5);
        g.imprime();
        g.adicionaAresta(0, 1);
        g.adicionaAresta(1, 2);
        g.adicionaAresta(2, 4);
        System.out.println();
        g.imprime();
        
    
    }
    
}
