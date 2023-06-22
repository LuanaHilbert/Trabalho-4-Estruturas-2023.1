public class FilaEncadeada {
    
    private ListaDuplamenteEncadeada lista;
    
    FilaEncadeada(){
        lista = new ListaDuplamenteEncadeada();
    }
    
    void insereFinal(int n){
        lista.insereFinal(n);
    }
    Integer retiraInicio(){
        return lista.retiraInicio();
    }
    
    void imprimeFila(){
        lista.imprimeLista();
    }
    
    boolean vazia(){
        return lista.vazia();
    }
}
