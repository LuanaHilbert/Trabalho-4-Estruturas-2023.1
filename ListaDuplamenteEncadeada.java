public class ListaDuplamenteEncadeada {
    
    Nodo ultimo;
    Nodo inicio;
    
    private class Nodo{
        int dado;
        Nodo proximo;
        Nodo anterior;
    }
    
    ListaDuplamenteEncadeada(){
        this.ultimo = null;
        this.inicio = null;
    }
    public void insereFinal(int n){
        Nodo novo = new Nodo();
        novo.dado = n;
        novo.anterior = ultimo;
        novo.proximo = null;
        //verificar se está vazia
        if (inicio == null && ultimo == null) {
            inicio = novo; ultimo = novo;
        }
        else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }
    
    public Integer retiraFinal(){
        if (inicio == null && ultimo == null) return null;
        int retirado = ultimo.dado;
        if (inicio == ultimo) inicio = ultimo = null;
        else {
            ultimo = ultimo.anterior;
            ultimo.proximo = null;
            //ultimo.anterior.proximo = null
            //ultimo = ultimo.anterior
        } 
        return retirado;
    }
    public boolean vazia(){
        if (inicio == null && ultimo == null) return true;
        return false;
    }
    
    public Integer retiraInicio(){
        if (inicio == null && ultimo == null) return null;
        int retirado = inicio.dado;
        if (inicio == ultimo) 
               inicio = ultimo = null;
        else {
            inicio.proximo.anterior = null;
            inicio = inicio.proximo; 
            
            //inicio = inicio.proximo;
            //inicio.anterior = null;
        }
        return retirado;
    }
    
    public void insereInicio(int n){
        Nodo novo = new Nodo();
        novo.dado = n;
        novo.anterior = null;
        novo.proximo = inicio;
        //verificar se está vazia
        if (inicio == null && ultimo == null) {
            inicio = novo; ultimo = novo;
        }
        else {
            inicio.anterior = novo;
            inicio = novo;
        }
    }
    public void imprimeInverso(){
        for (Nodo temp = ultimo; temp !=null; temp = temp.anterior){
            System.out.print(temp.dado + "->");
        }
        System.out.println();
    }

    public void imprimeLista(){
        for (Nodo temp = inicio; temp != null; temp = temp.proximo){
            System.out.print(temp.dado + "->");
        }
        System.out.println();
    }
    
    Integer removeNodo(int n){
        Nodo temp = inicio;
        while (temp != null && temp.dado != n){
            temp = temp.proximo;
        }
        
        if (temp == null) return null;
       
        if (temp == inicio) { //está no inicio
            return this.retiraInicio();
        }
        if (temp == ultimo) {
            return this.retiraFinal();
        }
        
        temp.anterior.proximo = temp.proximo;
        temp.proximo.anterior = temp.anterior;
        return temp.dado;
   }
           
}    
    

