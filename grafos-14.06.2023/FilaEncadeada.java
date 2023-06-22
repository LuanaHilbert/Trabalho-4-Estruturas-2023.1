import encadeamento.*;

public class FilaEncadeada {
    ListaEncadeada02 lista;
    
    FilaEncadeada(){
        lista = new ListaEncadeada02();
    }
    
    boolean filaVazia(){
        return lista.vazia();
    }
    void insereFila(Integer valor){
        lista.insereFinal(valor);
    }
    
    Integer removeFila(){
        return lista.removeInicio();
    }
    
    void imprime(){
        lista.imprimeLista();
    }
}
