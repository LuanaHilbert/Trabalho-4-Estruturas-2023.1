public class TestaGrafo02 {
    
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
    }
    
}
