public class TestaGrafo {
    
    public static void main(String[] args){
    
        Grafo g = new Grafo(8);
        g.adicionaAresta(0, 1);
        g.adicionaAresta(0, 3);
        g.adicionaAresta(1, 2);
        g.adicionaAresta(2, 5);
        g.adicionaAresta(2, 4);
        g.adicionaAresta(5, 6);
        g.adicionaAresta(4, 6);
        g.adicionaAresta(4, 7);
        g.adicionaAresta(6, 7);
        System.out.println(g);
        BuscaLargura bl = new BuscaLargura(g);
        bl.busca(1);
        System.out.println(bl);
        bl.getPath(5);
        bl.getAllPaths();
        System.out.println(g.isAdjacente(1, 2));
    
    }
    
}
